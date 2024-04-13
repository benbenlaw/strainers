package com.benbenlaw.strainers.client;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.entity.ModBlockEntities;
import com.benbenlaw.strainers.block.entity.client.StrainerMeshEntityRenderer;
import com.benbenlaw.strainers.block.entity.client.StrainerTankBlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Strainers.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientListener {

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {


        event.registerBlockEntityRenderer(ModBlockEntities.STRAINER_TANK_BLOCK_ENTITY.get(),
                StrainerTankBlockEntityRenderer::new);

        event.registerBlockEntityRenderer(ModBlockEntities.WOODEN_STRAINER_BLOCK_ENTITY.get(),
                StrainerMeshEntityRenderer::new);

    }
}
