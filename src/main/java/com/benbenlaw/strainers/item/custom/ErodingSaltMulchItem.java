package com.benbenlaw.strainers.item.custom;

import com.benbenlaw.strainers.block.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

        if(Screen.hasShiftDown()) {
            components.add(Component.translatable("jei.strainers.eroding_water"));
        } else {
            components.add(Component.translatable("tooltips.strainers.upgrade"));
        }

        super.appendHoverText(stack, level, components, tooltipFlag);
    }
}
