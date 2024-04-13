package com.benbenlaw.strainers;

import com.benbenlaw.opolisutilities.screen.*;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.block.entity.ModBlockEntities;
import com.benbenlaw.strainers.config.StrainersConfigFile;
import com.benbenlaw.strainers.fluid.ModFluidTypes;
import com.benbenlaw.strainers.fluid.ModFluids;
import com.benbenlaw.strainers.item.ModCreativeTab;
import com.benbenlaw.strainers.item.ModItems;
import com.benbenlaw.strainers.networking.ModMessages;
import com.benbenlaw.strainers.recipe.ModRecipes;
import com.benbenlaw.strainers.screen.ModMenuTypes;
import com.benbenlaw.strainers.screen.WoodenStrainerScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

import static com.benbenlaw.strainers.Strainers.MOD_ID;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(MOD_ID)
public class Strainers {

    public static final String MOD_ID = "strainers";
    private static final Logger LOGGER = LogManager.getLogger();


    public Strainers() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModCreativeTab.register(eventBus);
        ModBlockEntities.register(eventBus);
        ModMenuTypes.register(eventBus);
        ModRecipes.register(eventBus);

        ModFluids.register(eventBus);
        ModFluidTypes.register(eventBus);

        eventBus.addListener(this::commonSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, StrainersConfigFile.SPEC, "strainers.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModMessages::register);

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            event.enqueueWork(() -> {

                MenuScreens.register(ModMenuTypes.WOODEN_STRAINER_MENU.get(), WoodenStrainerScreen::new);

                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_ERODING_WATER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_ERODING_WATER.get(), RenderType.translucent());

                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_PURIFIED_WATER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_PURIFIED_WATER.get(), RenderType.translucent());

            });
        }
    }
}

