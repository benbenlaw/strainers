package com.benbenlaw.strainers.item.custom;

import com.benbenlaw.strainers.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class ErodingSaltMulchItem extends Item {
    public ErodingSaltMulchItem(Properties properties) {
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
            level.setBlockAndUpdate(pos, ModBlocks.ERODING_WATER_BLOCK.get().defaultBlockState());
            player.getItemInHand(hand).shrink(1);
            return InteractionResult.SUCCESS;
        }
        return super.useOn(context);
    }
}
