package com.benbenlaw.strainers.item.custom;

import com.benbenlaw.strainers.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Mesh extends Item {
    public Mesh(Properties properties) {
        super(properties);
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

        if(Screen.hasShiftDown()) {

            int damage = stack.getMaxDamage();
            MutableComponent tier = null;

            if (stack.is(ModTags.Items.TIER_1_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_1_mesh");
            }
            if (stack.is(ModTags.Items.TIER_2_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_2_mesh");
            }
            if (stack.is(ModTags.Items.TIER_3_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_3_mesh");
            }
            if (stack.is(ModTags.Items.TIER_4_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_4_mesh");
            }
            if (stack.is(ModTags.Items.TIER_5_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_5_mesh");
            }
            if (stack.is(ModTags.Items.TIER_6_MESHES)) {
                tier = Component.translatable("tooltips.strainers.tier_6_mesh");
            }

            components.add(tier);
            components.add(Component.literal("Max Uses: "+ damage));

        } else {
            components.add(Component.translatable("tooltips.strainers.upgrade"));
        }

        super.appendHoverText(stack, level, components, tooltipFlag);
    }

}
