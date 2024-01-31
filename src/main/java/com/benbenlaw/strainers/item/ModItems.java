package com.benbenlaw.strainers.item;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.fluid.ModFluids;
import com.benbenlaw.strainers.item.custom.*;
import com.benbenlaw.strainers.item.custom.specialized.SpecializedInputUpgrade;
import com.benbenlaw.strainers.item.custom.specialized.SpecializedMeshUpgrade;
import com.benbenlaw.strainers.item.custom.specialized.SpecializedOutputUpgrade;
import com.benbenlaw.strainers.item.custom.specialized.SpecializedSpeedUpgrade;
import com.benbenlaw.strainers.item.custom.standard.*;
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
            () -> new Mesh(new Item.Properties().durability(96)));

    public static final RegistryObject<Item> BAMBOO_MESH = ITEMS.register("bamboo_mesh",
            () -> new Mesh(new Item.Properties().durability(320)));

    public static final RegistryObject<Item> STRING_MESH = ITEMS.register("string_mesh",
            () -> new Mesh(new Item.Properties().durability(160)));

    //TIER 2 MESHES

    public static final RegistryObject<Item> FLINT_MESH = ITEMS.register("flint_mesh",
            () -> new Mesh(new Item.Properties().durability(192)));

    public static final RegistryObject<Item> COPPER_MESH = ITEMS.register("copper_mesh",
            () -> new Mesh(new Item.Properties().durability(384)));

    //TIER 3 MESHES

    public static final RegistryObject<Item> IRON_MESH = ITEMS.register("iron_mesh",
            () -> new Mesh(new Item.Properties().durability(526)));

    public static final RegistryObject<Item> AMETHYST_MESH = ITEMS.register("amethyst_mesh",
            () -> new Mesh(new Item.Properties().durability(640)));

    //TIER 4 MESHES

    public static final RegistryObject<Item> GOLD_MESH = ITEMS.register("gold_mesh",
            () -> new Mesh(new Item.Properties().durability(128)));

    public static final RegistryObject<Item> QUARTZ_MESH = ITEMS.register("quartz_mesh",
            () -> new Mesh(new Item.Properties().durability(640)));

    //TIER 5 MESHES

    public static final RegistryObject<Item> DIAMOND_MESH = ITEMS.register("diamond_mesh",
            () -> new Mesh(new Item.Properties().durability(1536)));

    public static final RegistryObject<Item> ECHO_MESH = ITEMS.register("echo_mesh",
            () -> new Mesh(new Item.Properties().durability(768)));

    //TIER 6 MESHES

    public static final RegistryObject<Item> EMERALD_MESH = ITEMS.register("emerald_mesh",
            () -> new Mesh(new Item.Properties().durability(1536)));

    public static final RegistryObject<Item> NETHERITE_MESH = ITEMS.register("netherite_mesh",
            () -> new Mesh(new Item.Properties().durability(2048)));

    //UPGRADES

    public static final RegistryObject<Item> IMPROVED_MESH_UPGRADE = ITEMS.register("improved_mesh_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> STURDY_MESH_UPGRADE = ITEMS.register("sturdy_mesh_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> REINFORCED_MESH_UPGRADE = ITEMS.register("reinforced_mesh_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EVERLASTING_MESH_UPGRADE = ITEMS.register("everlasting_mesh_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> IMPROVED_INPUT_UPGRADE = ITEMS.register("improved_input_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> STURDY_INPUT_UPGRADE = ITEMS.register("sturdy_input_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> REINFORCED_INPUT_UPGRADE = ITEMS.register("reinforced_input_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EVERLASTING_INPUT_UPGRADE = ITEMS.register("everlasting_input_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> IMPROVED_DURATION_UPGRADE = ITEMS.register("improved_duration_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> STURDY_DURATION_UPGRADE = ITEMS.register("sturdy_duration_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> REINFORCED_DURATION_UPGRADE = ITEMS.register("reinforced_duration_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EVERLASTING_DURATION_UPGRADE = ITEMS.register("everlasting_duration_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> IMPROVED_OUTPUT_UPGRADE = ITEMS.register("improved_output_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> STURDY_OUTPUT_UPGRADE = ITEMS.register("sturdy_output_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> REINFORCED_OUTPUT_UPGRADE = ITEMS.register("reinforced_output_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EVERLASTING_OUTPUT_UPGRADE = ITEMS.register("everlasting_output_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));



    public static final RegistryObject<Item> IMPROVED_EVERYTHING_UPGRADE = ITEMS.register("improved_everything_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> STURDY_EVERYTHING_UPGRADE = ITEMS.register("sturdy_everything_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> REINFORCED_EVERYTHING_UPGRADE = ITEMS.register("reinforced_everything_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> EVERLASTING_EVERYTHING_UPGRADE = ITEMS.register("everlasting_everything_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    //Specialized Upgrades

    public static final RegistryObject<Item> SPECIALIZED_OUTPUT_UPGRADE = ITEMS.register("specialized_output_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SPECIALIZED_SPEED_UPGRADE = ITEMS.register("specialized_speed_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SPECIALIZED_MESH_UPGRADE = ITEMS.register("specialized_mesh_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SPECIALIZED_INPUT_UPGRADE = ITEMS.register("specialized_input_upgrade",
            () -> new Item(new Item.Properties().stacksTo(1)));

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
