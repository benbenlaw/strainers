package com.benbenlaw.strainers.block.custom;

import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.block.entity.ModBlockEntities;
import com.benbenlaw.strainers.block.entity.StrainerTankBlockEntity;
import com.benbenlaw.strainers.block.entity.WoodenStrainerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.IFluidBlock;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StrainerTankBlock extends BaseEntityBlock {

    public StrainerTankBlock(Properties props) {
        super(props);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {
        if (super.use(state, level, pos, player, hand, hit) == InteractionResult.PASS) {
            StrainerTankBlockEntity be = (StrainerTankBlockEntity) level.getBlockEntity(pos);
            if (be != null && be.onPlayerUse(player, hand)) {
                return InteractionResult.sidedSuccess(level.isClientSide());
            }

        }
        return InteractionResult.PASS;
    }

    @Override
    public void onPlace(BlockState tankState, Level level, BlockPos pos, BlockState currentState, boolean allow) {

        if (!currentState.isAir()) {
            if (!currentState.getBlock().getFluidState(currentState).isEmpty()){
                FluidType fluid = currentState.getBlock().getFluidState(currentState).getFluidType();
                String fluidAsString = fluid.toString();
                level.setBlockAndUpdate(pos, this.defaultBlockState());
                BlockEntity entity = level.getBlockEntity(pos);
                if (entity instanceof StrainerTankBlockEntity) {
                    StrainerTankBlockEntity tankEntity = (StrainerTankBlockEntity) entity;
                    Fluid finalFluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(fluidAsString));
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
                } else {
                    // Handle the case where there's already a block at the fluid position
                    // For example, you might want to spill the fluid or merge it with the existing block
                }
            }
        }
        super.playerDestroy(level, player, pos, state, entity, stack);
    }

    //BLOCK ENTITY
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pPos, @NotNull BlockState pState) {
        return new StrainerTankBlockEntity(pPos, pState);
    }

}