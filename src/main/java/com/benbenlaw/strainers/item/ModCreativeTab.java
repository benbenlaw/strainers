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
                
                output.accept(ModItems.IMPROVED_MESH_UPGRADE.get());
                output.accept(ModItems.IMPROVED_INPUT_UPGRADE.get());
                output.accept(ModItems.IMPROVED_OUTPUT_UPGRADE.get());
                output.accept(ModItems.IMPROVED_DURATION_UPGRADE.get());
                output.accept(ModItems.IMPROVED_EVERYTHING_UPGRADE.get());
                
                output.accept(ModItems.STURDY_MESH_UPGRADE.get());
                output.accept(ModItems.STURDY_INPUT_UPGRADE.get());
                output.accept(ModItems.STURDY_OUTPUT_UPGRADE.get());
                output.accept(ModItems.STURDY_DURATION_UPGRADE.get());
                output.accept(ModItems.STURDY_EVERYTHING_UPGRADE.get());
                
                output.accept(ModItems.REINFORCED_MESH_UPGRADE.get());
                output.accept(ModItems.REINFORCED_INPUT_UPGRADE.get());
                output.accept(ModItems.REINFORCED_OUTPUT_UPGRADE.get());
                output.accept(ModItems.REINFORCED_DURATION_UPGRADE.get());
                output.accept(ModItems.REINFORCED_EVERYTHING_UPGRADE.get());
                
                output.accept(ModItems.EVERLASTING_MESH_UPGRADE.get());
                output.accept(ModItems.EVERLASTING_INPUT_UPGRADE.get());
                output.accept(ModItems.EVERLASTING_OUTPUT_UPGRADE.get());
                output.accept(ModItems.EVERLASTING_DURATION_UPGRADE.get());
                output.accept(ModItems.EVERLASTING_EVERYTHING_UPGRADE.get());

                output.accept(ModItems.ERODING_WATER_BUCKET.get());

                output.accept(ModBlocks.WOODEN_STRAINER.get());

            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
