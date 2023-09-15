package com.benbenlaw.strainers.item.custom;

import com.benbenlaw.strainers.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class PurifyingSaltMulchItem extends Item {
    public PurifyingSaltMulchItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        assert player != null;
        InteractionHand hand = player.getUsedItemHand();

        if (player.getItemInHand(hand).is(this) && state.is(ModBlocks.MULCH.get()) && !level.isClientSide) {
            level.setBlockAndUpdate(pos, ModBlocks.PURIFIED_WATER_BLOCK.get().defaultBlockState());
            player.getItemInHand(hand).shrink(1);
            return InteractionResult.SUCCESS;
        }
        return super.useOn(context);
    }
}
