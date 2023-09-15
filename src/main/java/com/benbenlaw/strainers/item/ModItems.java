package com.benbenlaw.strainers.item;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.fluid.ModFluids;
import com.benbenlaw.strainers.item.custom.*;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Strainers.MOD_ID);

    public static final RegistryObject<Item> STONE_PEBBLE = ITEMS.register("stone_pebble",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DEEPSLATE_PEBBLE = ITEMS.register("deepslate_pebble",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PURIFYING_SALT_MULCH = ITEMS.register("purifying_salt_mulch",
            () -> new PurifyingSaltMulchItem(new Item.Properties()));

    public static final RegistryObject<Item> ERODING_SALT_MULCH = ITEMS.register("eroding_salt_mulch",
            () -> new ErodingSaltMulchItem(new Item.Properties()));

    //TIER 1 MESHES

    public static final RegistryObject<Item> LEAFY_MESH = ITEMS.register("leafy_mesh",
            () -> new Item(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> BAMBOO_MESH = ITEMS.register("bamboo_mesh",
            () -> new Item(new Item.Properties().durability(256)));

    public static final RegistryObject<Item> STRING_MESH = ITEMS.register("string_mesh",
            () -> new Item(new Item.Properties().durability(128)));

    //TIER 2 MESHES

    public static final RegistryObject<Item> FLINT_MESH = ITEMS.register("flint_mesh",
            () -> new Item(new Item.Properties().durability(128)));

    public static final RegistryObject<Item> COPPER_MESH = ITEMS.register("copper_mesh",
            () -> new Item(new Item.Properties().durability(192)));

    //TIER 3 MESHES

    public static final RegistryObject<Item> IRON_MESH = ITEMS.register("iron_mesh",
            () -> new Item(new Item.Properties().durability(256)));

    public static final RegistryObject<Item> AMETHYST_MESH = ITEMS.register("amethyst_mesh",
            () -> new Item(new Item.Properties().durability(320)));

    //TIER 4 MESHES

    public static final RegistryObject<Item> GOLD_MESH = ITEMS.register("gold_mesh",
            () -> new Item(new Item.Properties().durability(128)));

    public static final RegistryObject<Item> QUARTZ_MESH = ITEMS.register("quartz_mesh",
            () -> new Item(new Item.Properties().durability(320)));

    //TIER 5 MESHES

    public static final RegistryObject<Item> DIAMOND_MESH = ITEMS.register("diamond_mesh",
            () -> new Item(new Item.Properties().durability(768)));

    public static final RegistryObject<Item> ECHO_MESH = ITEMS.register("echo_mesh",
            () -> new Item(new Item.Properties().durability(512)));

    //TIER 6 MESHES

    public static final RegistryObject<Item> EMERALD_MESH = ITEMS.register("emerald_mesh",
            () -> new Item(new Item.Properties().durability(768)));

    public static final RegistryObject<Item> NETHERITE_MESH = ITEMS.register("netherite_mesh",
            () -> new Item(new Item.Properties().durability(1024)));

    //UPGRADES

    public static final RegistryObject<Item> IMPROVED_MESH_UPGRADE = ITEMS.register("improved_mesh_upgrade",
            () -> new ImprovedMeshUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> STURDY_MESH_UPGRADE = ITEMS.register("sturdy_mesh_upgrade",
            () -> new SturdyMeshUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> REINFORCED_MESH_UPGRADE = ITEMS.register("reinforced_mesh_upgrade",
            () -> new ReinforcedMeshUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EVERLASTING_MESH_UPGRADE = ITEMS.register("everlasting_mesh_upgrade",
            () -> new EverlastingMeshUpgrade(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> IMPROVED_INPUT_UPGRADE = ITEMS.register("improved_input_upgrade",
            () -> new ImprovedInputUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> STURDY_INPUT_UPGRADE = ITEMS.register("sturdy_input_upgrade",
            () -> new SturdyInputUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> REINFORCED_INPUT_UPGRADE = ITEMS.register("reinforced_input_upgrade",
            () -> new ReinforcedInputUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EVERLASTING_INPUT_UPGRADE = ITEMS.register("everlasting_input_upgrade",
            () -> new EverlastingInputUpgrade(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> IMPROVED_DURATION_UPGRADE = ITEMS.register("improved_duration_upgrade",
            () -> new ImprovedDurationUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> STURDY_DURATION_UPGRADE = ITEMS.register("sturdy_duration_upgrade",
            () -> new SturdyDurationUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> REINFORCED_DURATION_UPGRADE = ITEMS.register("reinforced_duration_upgrade",
            () -> new ReinforcedDurationUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EVERLASTING_DURATION_UPGRADE = ITEMS.register("everlasting_duration_upgrade",
            () -> new EverlastingDurationUpgrade(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> IMPROVED_OUTPUT_UPGRADE = ITEMS.register("improved_output_upgrade",
            () -> new ImprovedOutputUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> STURDY_OUTPUT_UPGRADE = ITEMS.register("sturdy_output_upgrade",
            () -> new SturdyOutputUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> REINFORCED_OUTPUT_UPGRADE = ITEMS.register("reinforced_output_upgrade",
            () -> new ReinforcedOutputUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EVERLASTING_OUTPUT_UPGRADE = ITEMS.register("everlasting_output_upgrade",
            () -> new EverlastingOutputUpgrade(new Item.Properties().stacksTo(1)));



    public static final RegistryObject<Item> IMPROVED_EVERYTHING_UPGRADE = ITEMS.register("improved_everything_upgrade",
            () -> new ImprovedEverythingUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> STURDY_EVERYTHING_UPGRADE = ITEMS.register("sturdy_everything_upgrade",
            () -> new SturdyEverythingUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> REINFORCED_EVERYTHING_UPGRADE = ITEMS.register("reinforced_everything_upgrade",
            () -> new ReinforcedEverythingUpgrade(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EVERLASTING_EVERYTHING_UPGRADE = ITEMS.register("everlasting_everything_upgrade",
            () -> new EverlastingEverythingUpgrade(new Item.Properties().stacksTo(1)));


    //BUCKETS

    public static final RegistryObject<BucketItem> ERODING_WATER_BUCKET = ITEMS.register("eroding_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_ERODING_WATER.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final RegistryObject<BucketItem> PURIFIED_WATER_BUCKET = ITEMS.register("purified_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_PURIFIED_WATER.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
