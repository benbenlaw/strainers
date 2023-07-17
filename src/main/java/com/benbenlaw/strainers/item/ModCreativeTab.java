package com.benbenlaw.strainers.item;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Strainers.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STRAINERS_TAB = CREATIVE_MODE_TABS.register("strainers", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.LEAFY_MESH.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.strainers"))
            .displayItems((parameters, output) -> {

                output.accept(ModItems.LEAFY_MESH.get());
                output.accept(ModItems.BAMBOO_MESH.get());
                output.accept(ModItems.STRING_MESH.get());
                output.accept(ModItems.FLINT_MESH.get());
                output.accept(ModItems.COPPER_MESH.get());
                output.accept(ModItems.IRON_MESH.get());
                output.accept(ModItems.AMETHYST_MESH.get());
                output.accept(ModItems.GOLD_MESH.get());
                output.accept(ModItems.QUARTZ_MESH.get());
                output.accept(ModItems.DIAMOND_MESH.get());
                output.accept(ModItems.ECHO_MESH.get());
                output.accept(ModItems.EMERALD_MESH.get());
                output.accept(ModItems.NETHERITE_MESH.get());

                output.accept(ModItems.ERODING_WATER_BUCKET.get());

                output.accept(ModBlocks.WOODEN_STRAINER.get());

            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
