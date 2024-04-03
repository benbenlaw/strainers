package com.benbenlaw.strainers.client;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber(modid = Strainers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ItemTooltipEventHandler {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();



        if (stack.is(ModTags.Items.MESHES)) {

            List<Component> components = event.getToolTip();

            if (!Screen.hasShiftDown()) {
                components.add(Component.translatable("tooltips.strainers.upgrade"));
            }

            if (Screen.hasShiftDown()) {

                int damage = stack.getMaxDamage();
                MutableComponent tier = null;


                if (stack.is(ModTags.Items.TIER_1_MESHES)) {
                    tier = Component.translatable("tooltips.strainers.tier_1_mesh");
                } else if (stack.is(ModTags.Items.TIER_2_MESHES)) {
                    tier = Component.translatable("tooltips.strainers.tier_2_mesh");
                } else if (stack.is(ModTags.Items.TIER_3_MESHES)) {
                    tier = Component.translatable("tooltips.strainers.tier_3_mesh");
                } else if (stack.is(ModTags.Items.TIER_4_MESHES)) {
                    tier = Component.translatable("tooltips.strainers.tier_4_mesh");
                } else if (stack.is(ModTags.Items.TIER_5_MESHES)) {
                    tier = Component.translatable("tooltips.strainers.tier_5_mesh");
                } else if (stack.is(ModTags.Items.TIER_6_MESHES)) {
                    tier = Component.translatable("tooltips.strainers.tier_6_mesh");
                }

                if (tier != null) {
                    components.add(tier);
                }
                components.add(Component.literal("Max Uses: " + damage));

            }


        }
    }
}