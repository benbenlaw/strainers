package com.benbenlaw.strainers.item;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.fluid.ModFluids;
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
            () -> new Item(new Item.Properties().durability(256)));

    //TIER 3 MESHES

    public static final RegistryObject<Item> IRON_MESH = ITEMS.register("iron_mesh",
            () -> new Item(new Item.Properties().durability(128)));

    public static final RegistryObject<Item> AMETHYST_MESH = ITEMS.register("amethyst_mesh",
            () -> new Item(new Item.Properties().durability(256)));

    //TIER 4 MESHES

    public static final RegistryObject<Item> GOLD_MESH = ITEMS.register("gold_mesh",
            () -> new Item(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> QUARTZ_MESH = ITEMS.register("quartz_mesh",
            () -> new Item(new Item.Properties().durability(256)));

    //TIER 5 MESHES

    public static final RegistryObject<Item> DIAMOND_MESH = ITEMS.register("diamond_mesh",
            () -> new Item(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> ECHO_MESH = ITEMS.register("echo_mesh",
            () -> new Item(new Item.Properties().durability(256)));

    //TIER 6 MESHES

    public static final RegistryObject<Item> EMERALD_MESH = ITEMS.register("emerald_mesh",
            () -> new Item(new Item.Properties().durability(256)));

    public static final RegistryObject<Item> NETHERITE_MESH = ITEMS.register("netherite_mesh",
            () -> new Item(new Item.Properties().durability(512)));


    //BUCKETS

    public static final RegistryObject<BucketItem> ERODING_WATER_BUCKET = ITEMS.register("eroding_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_ERODING_WATER.get(),
                    new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
