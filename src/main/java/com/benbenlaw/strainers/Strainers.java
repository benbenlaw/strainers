package com.benbenlaw.strainers;

import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.block.entity.ModBlockEntities;
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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(Strainers.MOD_ID)
public class Strainers {

    public static final String MOD_ID = "strainers";
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

    //    ModConfiguredFeatures.register(eventBus);
    //    ModPlacedFeatures.register(eventBus);

    //=    eventBus.addListener(this::setup);
    //    eventBus.addListener(this::enqueueIMC);
    //    eventBus.addListener(this::processIMC);
    //    eventBus.addListener(this::setup);
    //    eventBus.addListener(this::doClientStuff);
        eventBus.addListener(this::onClientRegister);

        eventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModMessages::register);

    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void onClientRegister(FMLClientSetupEvent event) {
        MenuScreens.register(ModMenuTypes.WOODEN_STRAINER_MENU.get(), WoodenStrainerScreen::new);

        ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_ERODING_WATER.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_ERODING_WATER.get(), RenderType.translucent());

    }


/*
    @SubscribeEvent
    public static void addItemsToTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ModItems.LEAFY_MESH);
            event.accept(ModBlocks.WOODEN_STRAINER);
        }
    }

 */
}
