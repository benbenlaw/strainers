package com.benbenlaw.strainers.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Objects;

public class MulchBlock extends Block {


    public MulchBlock(Properties properties) {
        super(properties);
    }


    @Override
    protected ItemInteractionResult useItemOn(ItemStack state, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        if (player.getItemInHand(hand).is(ItemTags.HOES))
            level.setBlockAndUpdate(blockPos, Blocks.WATER.defaultBlockState());
        player.getItemInHand(hand).hurtAndBreak(1, player, Objects.requireNonNull(player.getItemInHand(hand).getEquipmentSlot()));

        return super.useItemOn(state, blockState, level, blockPos, player, hand, blockHitResult);
    }

}
