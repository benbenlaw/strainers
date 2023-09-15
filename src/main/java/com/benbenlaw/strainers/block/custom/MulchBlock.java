package com.benbenlaw.strainers.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.Tags;

public class MulchBlock extends Block {


    public MulchBlock(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (player.getItemInHand(hand).is(ItemTags.HOES))
            level.setBlockAndUpdate(pos, Blocks.WATER.defaultBlockState());
            player.getItemInHand(hand).hurtAndBreak(1, player, (player1) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.use(state, level, pos, player, hand, hitResult);
    }


/*


    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {

        if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ItemTags.HOES))
            level.setBlockAndUpdate(pos, Blocks.WATER.defaultBlockState());

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

 */
}
