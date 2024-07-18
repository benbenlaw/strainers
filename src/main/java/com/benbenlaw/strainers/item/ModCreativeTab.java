package com.benbenlaw.strainers.item;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.fluid.StrainersFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Strainers.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> STRAINERS_TAB = CREATIVE_MODE_TABS.register("strainers", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItems.LEAFY_MESH.get().getDefaultInstance())
            .title(Component.translatable("itemGroup.strainers"))
            .displayItems((parameters, output) -> {

                output.accept(ModBlocks.WOODEN_STRAINER.get());
                output.accept(ModBlocks.STRAINER_TANK.get());

                output.accept(StrainersFluids.PURIFYING_WATER.getBucket());
                output.accept(StrainersFluids.ERODING_WATER.getBucket());

                output.accept(ModItems.WOODEN_MESH);
                output.accept(ModItems.BONE_MESH);
                output.accept(ModItems.BAMBOO_MESH);
                output.accept(ModItems.STRING_MESH);
                output.accept(ModItems.LEAFY_MESH);

                output.accept(ModItems.BLAZE_MESH);
                output.accept(ModItems.BREEZE_MESH);
                output.accept(ModItems.BRONZE_MESH);
                output.accept(ModItems.COPPER_MESH);
                output.accept(ModItems.DIAMOND_MESH);
                output.accept(ModItems.ECHO_MESH);
                output.accept(ModItems.EMERALD_MESH);
                output.accept(ModItems.FLINT_MESH);
                output.accept(ModItems.GOLD_MESH);
                output.accept(ModItems.IRON_MESH);
                output.accept(ModItems.LAPIS_MESH);
                output.accept(ModItems.REDSTONE_MESH);
                output.accept(ModItems.TIN_MESH);
                output.accept(ModItems.AMETHYST_MESH);
                output.accept(ModItems.QUARTZ_MESH);

                output.accept(ModItems.ALUMINUM_ORE_PIECE);
                output.accept(ModItems.COPPER_ORE_PIECE);
                output.accept(ModItems.DIAMOND_ORE_PIECE);
                output.accept(ModItems.EMERALD_ORE_PIECE);
                output.accept(ModItems.GOLD_ORE_PIECE);
                output.accept(ModItems.IRON_ORE_PIECE);
                output.accept(ModItems.LAPIS_ORE_PIECE);
                output.accept(ModItems.REDSTONE_ORE_PIECE);
                output.accept(ModItems.TIN_ORE_PIECE);
                output.accept(ModItems.COAL_ORE_PIECE);
                output.accept(ModItems.QUARTZ_ORE_PIECE);
                output.accept(ModItems.SILVER_ORE_PIECE);
                output.accept(ModItems.ZINC_ORE_PIECE);
                output.accept(ModItems.PLATINUM_ORE_PIECE);
                output.accept(ModItems.OSMIUM_ORE_PIECE);
                output.accept(ModItems.URANIUM_ORE_PIECE);
                output.accept(ModItems.DEBRIS_ORE_PIECE);


                output.accept(ModBlocks.MULCH.get());
                output.accept(ModBlocks.ORE_MULCH.get());
                output.accept(ModItems.STONE_PEBBLE.get());
                output.accept(ModItems.PURIFYING_SALT_MULCH.get());
                output.accept(ModItems.ERODING_SALT_MULCH.get());



            }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }


}
