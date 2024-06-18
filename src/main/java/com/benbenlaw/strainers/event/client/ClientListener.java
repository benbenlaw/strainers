package com.benbenlaw.strainers.event.client;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.entity.ModBlockEntities;
import com.benbenlaw.strainers.block.entity.client.StrainerMeshEntityRenderer;
import com.benbenlaw.strainers.block.entity.client.StrainerTankBlockEntityRenderer;
import com.benbenlaw.strainers.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

import java.util.List;

@EventBusSubscriber(modid = Strainers.MOD_ID, bus = EventBusSubscriber.Bus.MOD ,value = Dist.CLIENT)
public class ClientListener {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {


        event.registerBlockEntityRenderer(ModBlockEntities.STRAINER_TANK_BLOCK_ENTITY.get(),
                StrainerTankBlockEntityRenderer::new);

        event.registerBlockEntityRenderer(ModBlockEntities.WOODEN_STRAINER_BLOCK_ENTITY.get(),
                StrainerMeshEntityRenderer::new);

    }

}
