package com.benbenlaw.strainers.block.custom;

import com.benbenlaw.strainers.block.entity.ModBlockEntities;
import com.benbenlaw.strainers.block.entity.StrainerTankBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StrainerTankBlock extends BaseEntityBlock {

    public static final MapCodec<StrainerTankBlock> CODEC = simpleCodec(StrainerTankBlock::new);
    public StrainerTankBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull BlockHitResult hit) {

        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        StrainerTankBlockEntity entity = (StrainerTankBlockEntity) level.getBlockEntity(blockPos);


        //FILL BUCKET//

        if (player.getItemInHand(InteractionHand.MAIN_HAND).getItem().equals(Items.BUCKET)) {
                assert entity != null;
            StrainerTankBlockEntity strainerTankBlockEntity = (StrainerTankBlockEntity) level.getBlockEntity(blockPos);
                if (strainerTankBlockEntity != null && strainerTankBlockEntity.onPlayerUse(player, InteractionHand.MAIN_HAND)) {
                    return InteractionResult.SUCCESS;
                }

            return InteractionResult.FAIL;
        }
        return InteractionResult.PASS;
    }

    @Override
    public void onPlace(BlockState tankState, Level level, BlockPos pos, BlockState currentState, boolean allow) {

        if (!currentState.isAir()) {

            FluidState fluidState = currentState.getFluidState();

            if (!fluidState.getFluidType().isAir()){
                FluidType fluid = fluidState.getFluidType();
                String fluidAsString = fluid.toString();
                level.setBlockAndUpdate(pos, this.defaultBlockState());
                BlockEntity entity = level.getBlockEntity(pos);
                if (entity instanceof StrainerTankBlockEntity) {
                    StrainerTankBlockEntity tankEntity = (StrainerTankBlockEntity) entity;
                    Fluid finalFluid = BuiltInRegistries.FLUID.get(ResourceLocation.parse(fluidAsString));
                    tankEntity.setFluid(new FluidStack(finalFluid, 1000));
                }
            }
        }
        super.onPlace(tankState, level, pos, currentState, allow);
    }


    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity entity, ItemStack stack) {
        if (entity instanceof StrainerTankBlockEntity) {
            StrainerTankBlockEntity tankEntity = (StrainerTankBlockEntity) entity;
            FluidStack fluidStack = tankEntity.getFluidStack();
            if (!fluidStack.isEmpty()) {
                Fluid fluid = fluidStack.getFluid();
                BlockPos fluidPos = pos;
                if (level.isEmptyBlock(fluidPos)) {
                    level.setBlockAndUpdate(fluidPos, fluid.defaultFluidState().createLegacyBlock());
                }
            }
        }
        super.playerDestroy(level, player, pos, state, entity, stack);
    }

    //BLOCK ENTITY


    @SuppressWarnings("deprecation")
    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState blockState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, BlockState newBlockState, boolean isMoving) {
        blockState.getBlock();
        newBlockState.getBlock();
        super.onRemove(blockState, level, blockPos, newBlockState, isMoving);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new StrainerTankBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(@NotNull Level level, @NotNull BlockState blockState, @NotNull BlockEntityType<T> blockEntityType) {
        return createTickerHelper(blockEntityType, ModBlockEntities.STRAINER_TANK_BLOCK_ENTITY.get(),
                (world, blockPos, thisBlockState, blockEntity) -> blockEntity.tick());
    }

}