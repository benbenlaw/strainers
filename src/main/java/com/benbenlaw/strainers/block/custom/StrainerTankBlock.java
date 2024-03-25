package com.benbenlaw.strainers.block.custom;

import com.benbenlaw.strainers.block.entity.ModBlockEntities;
import com.benbenlaw.strainers.block.entity.StrainerTankBlockEntity;
import com.benbenlaw.strainers.block.entity.WoodenStrainerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
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