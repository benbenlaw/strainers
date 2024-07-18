package com.benbenlaw.strainers.datagen;

import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.opolisutilities.datagen.recipes.*;
import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.datagen.recipes.MeshUpgradesRecipeBuilder;
import com.benbenlaw.strainers.datagen.recipes.OutputUpgradesRecipeBuilder;
import com.benbenlaw.strainers.datagen.recipes.StrainerRecipeBuilder;
import com.benbenlaw.strainers.item.ModItems;
import com.benbenlaw.strainers.util.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.NotCondition;
import net.neoforged.neoforge.common.conditions.TagEmptyCondition;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class StrainersRecipes extends RecipeProvider {

    public StrainersRecipes(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void buildRecipes(RecipeOutput consumer) {

        // Tags Checks //

        TagKey<Item> aluminumIngotTag = ItemTags.create(
                Objects.requireNonNull(ResourceLocation.tryParse(String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/aluminum")))));
        TagKey<Item> zincIngotTag = ItemTags.create(
                Objects.requireNonNull(ResourceLocation.tryParse(String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/zinc")))));
        TagKey<Item> silverIngotTag = ItemTags.create(
                Objects.requireNonNull(ResourceLocation.tryParse(String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/silver")))));
        TagKey<Item> osmiumIngotTag = ItemTags.create(
                Objects.requireNonNull(ResourceLocation.tryParse(String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/osmium")))));
        TagKey<Item> uraniumIngotTag = ItemTags.create(
                Objects.requireNonNull(ResourceLocation.tryParse(String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/uranium")))));
        TagKey<Item> platinumIngotTag = ItemTags.create(
                Objects.requireNonNull(ResourceLocation.tryParse(String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/platinum")))));
        TagKey<Item> bronzeIngotTag = ItemTags.create(
                Objects.requireNonNull(ResourceLocation.tryParse(String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/bronze")))));
        TagKey<Item> tinIngotTag = ItemTags.create(
                Objects.requireNonNull(ResourceLocation.tryParse(String.valueOf(ResourceLocation.fromNamespaceAndPath("c", "ingots/tin")))));


        // ********** Vanilla Recipes ********** //

        //Eroding Salt Mulch
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ERODING_SALT_MULCH)
                .pattern("SSS")
                .pattern("SMS")
                .pattern("SSS")
                .define('S', Items.CHARCOAL)
                .define('M', ModBlocks.MULCH)
                .group("strainers")
                .unlockedBy("has_item", has(Items.CHARCOAL))
                .save(consumer);

        //Purifying Salt Mulch
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURIFYING_SALT_MULCH)
                .pattern("SSS")
                .pattern("SMS")
                .pattern("SSS")
                .define('S', ItemTags.SAND)
                .define('M', ModBlocks.MULCH)
                .group("strainers")
                .unlockedBy("has_item", has(ItemTags.SAND))
                .save(consumer);

        //Tank
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRAINER_TANK)
                .pattern("GGG")
                .pattern("GSG")
                .pattern("GGG")
                .define('G', Tags.Items.GLASS_BLOCKS)
                .define('S', ModBlocks.WOODEN_STRAINER)
                .group("strainers")
                .unlockedBy("has_item", has(Blocks.GLASS))
                .save(consumer);

        //Mulch
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MULCH)
                .pattern(" L ")
                .pattern("LSL")
                .pattern(" L ")
                .define('L', ItemTags.LEAVES)
                .define('S', ItemTags.SAPLINGS)
                .group("strainers")
                .unlockedBy("has_item", has(ItemTags.LEAVES))
                .save(consumer);

        //Dirt
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.DIRT)
                .pattern(" L ")
                .pattern("LML")
                .pattern(" L ")
                .define('L', ItemTags.LEAVES)
                .define('M', ModBlocks.MULCH)
                .group("strainers")
                .unlockedBy("has_item", has(ModItems.STONE_PEBBLE))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "dirt_from_mulch"));

        //Leafy Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LEAFY_MESH)
                .pattern("SLS")
                .pattern("LLL")
                .pattern("SLS")
                .define('L', com.benbenlaw.opolisutilities.item.ModItems.LEAFY_STRING)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(com.benbenlaw.opolisutilities.item.ModItems.LEAFY_STRING))
                .save(consumer);

        //Wooden Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.WOODEN_MESH)
                .pattern("SSS")
                .pattern("S S")
                .pattern("SSS")
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(Tags.Items.RODS_WOODEN))
                .save(consumer);

        //Bone mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BONE_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Items.BONE)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", hasItems(Items.BONE))
                .save(consumer);

        //Blaze Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BLAZE_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Items.BLAZE_ROD)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", hasItems(Items.BLAZE_ROD))
                .save(consumer);

        //Breeze Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BREEZE_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Items.BREEZE_ROD)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", hasItems(Items.BREEZE_ROD))
                .save(consumer);

        //Bronze Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BRONZE_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', bronzeIngotTag)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(bronzeIngotTag))
                .save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeIngotTag))));

        //Copper Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Tags.Items.INGOTS_COPPER)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(Tags.Items.INGOTS_COPPER))
                .save(consumer);

        //Diamond Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Items.DIAMOND)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", hasItems(Items.DIAMOND))
                .save(consumer);

        //Echo Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ECHO_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Items.ECHO_SHARD)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(Items.ECHO_SHARD))
                .save(consumer);

        //Emerald Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EMERALD_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Items.EMERALD)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", hasItems(Items.EMERALD))
                .save(consumer);

        //Flint Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FLINT_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Items.FLINT)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", hasItems(Items.FLINT))
                .save(consumer);

        //Gold Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Tags.Items.INGOTS_GOLD)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(Tags.Items.INGOTS_GOLD))
                .save(consumer);

        //Iron Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Tags.Items.INGOTS_IRON)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(Tags.Items.INGOTS_IRON))
                .save(consumer);

        //lapis Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LAPIS_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Tags.Items.GEMS_LAPIS)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(Tags.Items.GEMS_LAPIS))
                .save(consumer);

        //Redstone Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.REDSTONE_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Tags.Items.DUSTS_REDSTONE)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(Tags.Items.DUSTS_REDSTONE))
                .save(consumer);

        //Tin Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TIN_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', tinIngotTag)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(tinIngotTag))
                .save(consumer.withConditions(new NotCondition(new TagEmptyCondition(bronzeIngotTag))));

        //Amethyst Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AMETHYST_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Tags.Items.GEMS_AMETHYST)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(Tags.Items.GEMS_AMETHYST))
                .save(consumer);

        //Quartz Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.QUARTZ_MESH)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Tags.Items.GEMS_QUARTZ)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(Tags.Items.GEMS_QUARTZ))
                .save(consumer);

        //String Mesh
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STRING)
                .pattern("SBS")
                .pattern("BBB")
                .pattern("SBS")
                .define('B', Items.STRING)
                .define('S', Tags.Items.RODS_WOODEN)
                .group("strainers")
                .unlockedBy("has_item", has(Items.STRING))
                .save(consumer);

        //Strainer
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WOODEN_STRAINER)
                .pattern("SMS")
                .pattern("SMS")
                .pattern("LLL")
                .define('S', Tags.Items.RODS_WOODEN)
                .define('L', ItemTags.LOGS)
                .define('M', ModTags.Items.MESHES)
                .group("strainers")
                .unlockedBy("has_item", has(Tags.Items.RODS_WOODEN))
                .save(consumer);

        //STONE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Blocks.STONE)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModItems.STONE_PEBBLE)
                .group("strainers")
                .unlockedBy("has_item", has(Tags.Items.RODS_WOODEN))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "stone_from_pebble"));

        //Ore Mulch
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORE_MULCH)
                .pattern("SGS")
                .pattern("GMG")
                .pattern("SGS")
                .define('S', ItemTags.SAND)
                .define('G', Blocks.GRAVEL)
                .define('M', ModBlocks.MULCH)
                .group("strainers")
                .unlockedBy("has_item", has(Blocks.GRAVEL))
                .save(consumer);

        //

        //

        // ********** Mesh Upgrades ********** //

        MeshUpgradesRecipeBuilder.MeshUpgradesRecipeBuilder(Ingredient.of(Items.DIAMOND), 0.9)
                .unlockedBy("has_item", hasItems(Items.DIAMOND))
                .save(consumer);


        // ********** Output Upgrades ********** //

        OutputUpgradesRecipeBuilder.OutputUpgradesRecipeBuilder(Ingredient.of(Items.EMERALD), 0.1)
                .unlockedBy("has_item", hasItems(Items.DIAMOND))
                .save(consumer);

        // ********** Strainer Recipes ********** //

        // Leaves //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ItemTags.LEAVES), "minecraft:air", new ItemStack(Items.OAK_SAPLING), 1, 0.1)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ItemTags.LEAVES), "minecraft:air", new ItemStack(Items.SPRUCE_SAPLING), 1, 0.1)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ItemTags.LEAVES), "minecraft:air", new ItemStack(Items.BIRCH_SAPLING), 1, 0.1)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ItemTags.LEAVES), "minecraft:air", new ItemStack(Items.JUNGLE_SAPLING), 1, 0.1)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ItemTags.LEAVES), "minecraft:air", new ItemStack(Items.ACACIA_SAPLING), 1, 0.1)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ItemTags.LEAVES), "minecraft:air", new ItemStack(Items.DARK_OAK_SAPLING), 1, 0.1)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ItemTags.LEAVES), "minecraft:air", new ItemStack(Items.CHERRY_SAPLING), 1, 0.1)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ItemTags.LEAVES), "minecraft:air", new ItemStack(Items.MANGROVE_PROPAGULE), 1, 0.1)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ItemTags.LEAVES), "minecraft:air", new ItemStack(Items.BAMBOO), 1, 0.05)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // MUD (WATER) //
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.MUD), "minecraft:water", new ItemStack(Items.CLAY_BALL), 2, 0.70)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);


        // MYCELIUM  (LAVA) //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.GRASS_BLOCK), "minecraft:lava", new ItemStack(Blocks.CRIMSON_NYLIUM), 4, 0.25)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.GRASS_BLOCK), "minecraft:lava", new ItemStack(Blocks.WARPED_NYLIUM), 4, 0.25)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // MYCELIUM  (EROD) //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.GRASS_BLOCK), "strainers:eroding_water", new ItemStack(Blocks.BROWN_MUSHROOM), 3, 0.20)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.GRASS_BLOCK), "strainers:eroding_water", new ItemStack(Blocks.RED_MUSHROOM), 3, 0.20)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // GRASS BLOCK (EROD) //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.GRASS_BLOCK), "strainers:eroding_water", new ItemStack(Blocks.MYCELIUM), 1, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // DIRT (PURE)

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.DIRT), "minecraft:water", new ItemStack(Items.GRASS_BLOCK), 4, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // DIRT (WATER) //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.DIRT), "minecraft:water", new ItemStack(ModItems.STONE_PEBBLE.get()), 1, 0.2)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // DIRT (LAVA)

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.DIRT), "minecraft:lava", new ItemStack(Blocks.SOUL_SOIL), 4, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        //STONE (PURE) //
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "strainers:purifying_water", new ItemStack(Blocks.GRANITE), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "strainers:purifying_water", new ItemStack(Blocks.ANDESITE), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "strainers:purifying_water", new ItemStack(Blocks.DIORITE), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "strainers:purifying_water", new ItemStack(Blocks.CALCITE), 2, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "strainers:purifying_water", new ItemStack(Blocks.DRIPSTONE_BLOCK), 2, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "strainers:purifying_water", new ItemStack(Blocks.TUFF), 2, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "strainers:purifying_water", new ItemStack(Blocks.DEEPSLATE), 3, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // DEEPSLATE (WATER) //
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "minecraft:water", new ItemStack(Items.ECHO_SHARD), 4, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // NETHERRACK (LAVA) //
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "minecraft:lava", new ItemStack(Blocks.BASALT), 3, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "minecraft:lava", new ItemStack(Blocks.BLACKSTONE), 4, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "minecraft:lava", new ItemStack(Blocks.GILDED_BLACKSTONE), 5, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // STONE (EROD) //
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "strainers:eroding_water", new ItemStack(Blocks.COBBLESTONE), 1, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // STONE (LAVA) //
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.STONE), "minecraft:lava", new ItemStack(Blocks.NETHERRACK), 4, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // COBBLESTONE //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.COBBLESTONE), "strainers:eroding_water", new ItemStack(Blocks.GRAVEL), 1, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // GRAVEL //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.GRAVEL), "strainers:eroding_water", new ItemStack(Blocks.SAND), 1, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // Mulch (WATER) //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.MULCH), "minecraft:water", new ItemStack(Items.WHEAT_SEEDS), 1, 0.20)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.MULCH), "minecraft:water", new ItemStack(Items.BEETROOT_SEEDS), 2, 0.20)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.MULCH), "minecraft:water", new ItemStack(Items.MELON_SEEDS), 3, 0.20)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.MULCH), "minecraft:water", new ItemStack(Items.PUMPKIN_SEEDS), 3, 0.20)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // Mulch (PURE) //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.MULCH), "strainers:purifying_water", new ItemStack(Items.CARROT), 3, 0.20)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.MULCH), "strainers:purifying_water", new ItemStack(Items.POTION), 3, 0.20)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.MULCH), "strainers:purifying_water", new ItemStack(Items.COCOA_BEANS), 4, 0.20)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.MULCH), "strainers:purifying_water", new ItemStack(Items.TORCHFLOWER_SEEDS), 6, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.MULCH), "strainers:purifying_water", new ItemStack(Items.PITCHER_POD), 6, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // GRASS (PURE) //
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.POPPY), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.DANDELION), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.BLUE_ORCHID), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.ALLIUM), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.AZURE_BLUET), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.ORANGE_TULIP), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.PINK_TULIP), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.RED_TULIP), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.WHITE_TULIP), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.CORNFLOWER), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.LILY_OF_THE_VALLEY), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.TORCHFLOWER), 6, 0.05)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SHORT_GRASS), "strainers:purifying_water", new ItemStack(Items.WITHER_ROSE), 6, 0.01)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // TALL GRASS (PURE) //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.TALL_GRASS), "strainers:purifying_water", new ItemStack(Items.SUNFLOWER), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.TALL_GRASS), "strainers:purifying_water", new ItemStack(Items.LILAC), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.TALL_GRASS), "strainers:purifying_water", new ItemStack(Items.ROSE_BUSH), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.TALL_GRASS), "strainers:purifying_water", new ItemStack(Items.PEONY), 1, 0.10)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.TALL_GRASS), "strainers:purifying_water", new ItemStack(Items.PITCHER_PLANT), 6, 0.05)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        //SOUL SAND (WATER) //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SOUL_SAND), "minecraft:lava", new ItemStack(Blocks.NETHER_WART), 3, 0.3)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SOUL_SAND), "minecraft:lava", new ItemStack(Blocks.WARPED_FUNGUS), 4, 0.2)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SOUL_SAND), "minecraft:lava", new ItemStack(Blocks.CRIMSON_FUNGUS), 4, 0.2)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // SAND (LAVA) //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "minecraft:lava", new ItemStack(Blocks.SOUL_SAND), 4, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);


        // SAND (WATER) //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "minecraft:water", new ItemStack(Items.SUGAR_CANE), 2, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "minecraft:water", new ItemStack(Items.CACTUS), 2, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "minecraft:water", new ItemStack(Items.LILY_PAD), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "minecraft:water", new ItemStack(Items.KELP), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // SAND (PURE) //
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "strainers:purifying_water", new ItemStack(Items.TUBE_CORAL_FAN), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "strainers:purifying_water", new ItemStack(Items.TUBE_CORAL), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "strainers:purifying_water", new ItemStack(Items.HORN_CORAL_FAN), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "strainers:purifying_water", new ItemStack(Items.HORN_CORAL), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "strainers:purifying_water", new ItemStack(Items.FIRE_CORAL_FAN), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "strainers:purifying_water", new ItemStack(Items.FIRE_CORAL), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "strainers:purifying_water", new ItemStack(Items.BUBBLE_CORAL_FAN), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "strainers:purifying_water", new ItemStack(Items.BUBBLE_CORAL), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "strainers:purifying_water", new ItemStack(Items.BRAIN_CORAL_FAN), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Blocks.SAND), "strainers:purifying_water", new ItemStack(Items.BRAIN_CORAL), 3, 0.15)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // CORAL BLOCKS (PURE) //

        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Items.BRAIN_CORAL_FAN), "strainers:purifying_water", new ItemStack(Items.BRAIN_CORAL_BLOCK), 4, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Items.BUBBLE_CORAL_FAN), "strainers:purifying_water", new ItemStack(Items.BUBBLE_CORAL_BLOCK), 4, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Items.FIRE_CORAL_FAN), "strainers:purifying_water", new ItemStack(Items.FIRE_CORAL_BLOCK), 4, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Items.HORN_CORAL_FAN), "strainers:purifying_water", new ItemStack(Items.HORN_CORAL_BLOCK), 4, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(Items.TUBE_CORAL_FAN), "strainers:purifying_water", new ItemStack(Items.TUBE_CORAL_BLOCK), 4, 0.8)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // ORE MULCH T1//
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.COAL_ORE_PIECE.get()), 1, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // ORE MULCH T2
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.COPPER_ORE_PIECE.get()), 2, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.TIN_ORE_PIECE.get()), 2, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.ALUMINUM_ORE_PIECE.get()), 2, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer.withConditions(new NotCondition(new TagEmptyCondition(aluminumIngotTag))));
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.ZINC_ORE_PIECE.get()), 2, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer.withConditions(new NotCondition(new TagEmptyCondition(zincIngotTag))));


        // ORE MULCH T3
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.IRON_ORE_PIECE.get()), 3, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.LAPIS_ORE_PIECE.get()), 3, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // ORE MULCH T4
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.GOLD_ORE_PIECE.get()), 4, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.SILVER_ORE_PIECE.get()), 4, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer.withConditions(new NotCondition(new TagEmptyCondition(silverIngotTag))));
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.REDSTONE_ORE_PIECE.get()), 4, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.OSMIUM_ORE_PIECE.get()), 4, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer.withConditions(new NotCondition(new TagEmptyCondition(osmiumIngotTag))));
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:lava", new ItemStack(ModItems.QUARTZ_ORE_PIECE.get()), 4, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);

        // ORE MULCH T5
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.DIAMOND_ORE_PIECE.get()), 5, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.EMERALD_ORE_PIECE.get()), 5, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.URANIUM_ORE_PIECE.get()), 5, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer.withConditions(new NotCondition(new TagEmptyCondition(uraniumIngotTag))));

        // ORE MULCH T6
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:lava", new ItemStack(ModItems.DEBRIS_ORE_PIECE.get()), 6, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer);
        StrainerRecipeBuilder.strainerRecipe(Ingredient.of(ModBlocks.ORE_MULCH), "minecraft:water", new ItemStack(ModItems.PLATINUM_ORE_PIECE.get()), 6, 0.35)
                .unlockedBy("has_item", hasItems(ModBlocks.WOODEN_STRAINER))
                .save(consumer.withConditions(new NotCondition(new TagEmptyCondition(platinumIngotTag))));






    }

}
