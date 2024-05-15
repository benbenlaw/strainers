package com.benbenlaw.strainers.data;

import com.benbenlaw.opolisutilities.recipe.ModRecipes;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.data.custom.*;
import com.benbenlaw.strainers.item.ModItems;
import com.benbenlaw.strainers.util.ModTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {


    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput p_254020_) {
        return super.run(p_254020_);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        //AEROPOLIS STRAINERS RECIPES
        /*


        //VALUES
        int dirtDuration = 200;
        int packedMudDuration = 200;
        int sandDuration = 160;
        int gravelDuration = 120;
        int cobblestoneDuration = 220;
        int leavesDuration = 60;
        int netherrackDuration = 200;
        int soulSandDuration = 200;


        //Saplings Sieving

        new StrainerRecipeFluidBuilder(Items.DIRT, //IN
                Items.ACACIA_SAPLING,1, //OUT
                0.2, 0.05, 1,
                dirtDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.DIRT, //IN
                Items.OAK_SAPLING,1, //OUT
                0.2, 0.05, 1,
                dirtDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.DIRT, //IN
                Items.BIRCH_SAPLING,1, //OUT
                0.2, 0.05, 1,
                dirtDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.DIRT, //IN
                Items.JUNGLE_SAPLING,1, //OUT
                0.2, 0.05, 1,
                dirtDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.DIRT, //IN
                Items.DARK_OAK_SAPLING,1, //OUT
                0.2, 0.05, 1,
                dirtDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.DIRT, //IN
                Items.CHERRY_SAPLING,1, //OUT
                0.2, 0.05, 1,
                dirtDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.DIRT, //IN
                Items.MANGROVE_PROPAGULE,1, //OUT
                0.2, 0.05, 1,
                dirtDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.DIRT, //IN
                Items.SPRUCE_SAPLING,1, //OUT
                0.2, 0.05, 1,
                dirtDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //Packed Mud Sieving

        new StrainerRecipeFluidBuilder(Items.PACKED_MUD, //IN
                Items.BEETROOT,1, //OUT
                0.25, 0.05, 2,
                packedMudDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.PACKED_MUD, //IN
                Items.CARROT,1, //OUT
                0.25, 0.05, 2,
                packedMudDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.PACKED_MUD, //IN
                Items.POTATO,1, //OUT
                0.25, 0.05, 2,
                packedMudDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.PACKED_MUD, //IN
                Items.WHEAT,1, //OUT
                0.25, 0.05, 2,
                packedMudDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.PACKED_MUD, //IN
                Items.CLAY_BALL,1, //OUT
                0.5, 0.1, 2,
                packedMudDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.PACKED_MUD, //IN
                Items.CLAY_BALL,3, //OUT
                0.5, 0.1, 2,
                packedMudDuration,"strainers:eroding_water_fluid" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //Sand Sieving

        new StrainerRecipeFluidBuilder(Items.SAND, //IN
                Items.BAMBOO,1, //OUT
                0.3, 0.1, 1,
                sandDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.SAND, //IN
                Items.SUGAR_CANE,1, //OUT
                0.3, 0.1, 1,
                sandDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.SAND, //IN
                Items.CACTUS,1, //OUT
                0.3, 0.1, 1,
                sandDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //Gravel Sieving

        new StrainerRecipeFluidBuilder(Items.GRAVEL, //IN
                Items.SAND,1, //OUT
                0.5, 0.1, 2,
                gravelDuration,"strainers:eroding_water_fluid" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.GRAVEL, //IN
                Items.FLINT,1, //OUT
                0.5, 0.1, 1,
                gravelDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.GRAVEL, //IN
                ModItems.MINI_COAL.get(),1, //OUT
                0.2, 0.1, 1,
                gravelDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.GRAVEL, //IN
                ModItems.COPPER_NUGGET.get(),1, //OUT
                0.2, 0.1, 1,
                gravelDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //Gravel

        new StrainerRecipeFluidTagBuilder(Tags.Items.COBBLESTONE, //IN
                Items.GRAVEL,1, //OUT
                0.5, 0.1, 1,
                cobblestoneDuration,"strainers:eroding_water_fluid" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //Apples

        new StrainerRecipeFluidTagBuilder(ItemTags.LEAVES, //IN
                Items.APPLE,1, //OUT
                0.2, 0.1, 1,
                leavesDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //Mycelium

        new StrainerRecipeFluidBuilder(Items.MYCELIUM, //IN
                Items.BROWN_MUSHROOM,1, //OUT
                0.3, 0.1, 2,
                dirtDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.MYCELIUM, //IN
                Items.RED_MUSHROOM,1, //OUT
                0.3, 0.1, 2,
                dirtDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //Soul Sand Sieving

        new StrainerRecipeFluidBuilder(Items.SOUL_SAND, //IN
                Items.NETHER_WART,1, //OUT
                0.3, 0.2, 4,
                soulSandDuration,"minecraft:lava" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.SOUL_SAND, //IN
                Items.QUARTZ,1, //OUT
                0.4, 0.2, 4,
                soulSandDuration,"minecraft:lava" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.SOUL_SAND, //IN
                Items.GLOWSTONE_DUST,1, //OUT
                0.3, 0.15, 4,
                soulSandDuration,"minecraft:lava" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);


        //Netherrack Sieving

        new StrainerRecipeFluidBuilder(Items.NETHERRACK, //IN
                Items.CRIMSON_NYLIUM,1, //OUT
                0.1, 0.1, 4,
                soulSandDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.NETHERRACK, //IN
                Items.WARPED_NYLIUM,1, //OUT
                0.1, 0.1, 4,
                soulSandDuration,"minecraft:water" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.NETHERRACK, //IN
                Items.QUARTZ,1, //OUT
                0.4, 0.2, 4,
                soulSandDuration,"minecraft:lava" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //Fungus

        new StrainerRecipeFluidBuilder(Items.WARPED_NYLIUM, //IN
                Items.WARPED_FUNGUS,1, //OUT
                0.5, 0.25, 4,
                soulSandDuration,"minecraft:lava" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.CRIMSON_NYLIUM, //IN
                Items.CRIMSON_FUNGUS,1, //OUT
                0.5, 0.25, 4,
                soulSandDuration,"minecraft:lava" )
                .unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

         */

    //STRAINERS MAINSTREAM (SKYBLOCK RECIPES)

        //DURATIONS FOR BLOCKS

        int leavesDuration = 100;
        int dirtDuration = 200;
        int mulchDuration = 140;
        int gravelDuration = 220;
        int sandDuration = 180;
        int soulsandDuration = 260;
        int stoneDuration = 240;
        int deepslateDuration = 300;
        int netherrackDuration = 280;
        int lavaBucketDuration = 440;
        int waterBucketDuration = 400;
        int obsidianDuration = 1000;

        //LEAVES SIEVING

        new StrainerRecipeBlockTagBuilder(ItemTags.LEAVES, Items.ACACIA_SAPLING,1,0.2, 0.05, 1, leavesDuration,"minecraft:air" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockTagBuilder(ItemTags.LEAVES, Items.OAK_SAPLING,1,0.2, 0.05, 1, leavesDuration,"minecraft:air" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockTagBuilder(ItemTags.LEAVES, Items.BIRCH_SAPLING,1,0.2, 0.05, 1, leavesDuration,"minecraft:air" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockTagBuilder(ItemTags.LEAVES, Items.JUNGLE_SAPLING,1,0.2, 0.05, 1, leavesDuration,"minecraft:air" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockTagBuilder(ItemTags.LEAVES, Items.DARK_OAK_SAPLING,1,0.2, 0.05, 1, leavesDuration,"minecraft:air" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockTagBuilder(ItemTags.LEAVES, Items.CHERRY_SAPLING,1,0.2, 0.05, 1, leavesDuration,"minecraft:air" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockTagBuilder(ItemTags.LEAVES, Items.MANGROVE_PROPAGULE,1,0.2, 0.05, 1, leavesDuration,"minecraft:air" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockTagBuilder(ItemTags.LEAVES, Items.SPRUCE_SAPLING,1,0.2, 0.05, 1, leavesDuration,"minecraft:air" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //DIRT SIEVING

        new StrainerRecipeFluidBuilder(Items.DIRT, ModItems.STONE_PEBBLE.get(),1,0.75, 0.05, 1, dirtDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.DIRT, Items.CLAY_BALL,1,0.5, 0.1, 1, dirtDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.DIRT, ModItems.DEEPSLATE_PEBBLE.get(),1,0.75, 0.05, 3, dirtDuration,"minecraft:lava" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.DIRT, Items.MUD,1,0.5, 0.1, 1, dirtDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.DIRT, Items.TUFF,1,0.5, 0.1, 1, dirtDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.DIRT, Items.SOUL_SOIL, 1,1, 0.00, 5, sandDuration,"minecraft:lava" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);


        //MULCH SIEVING

        new StrainerRecipeFluidBuilder(ModBlocks.MULCH.get(), Items.WHEAT_SEEDS,1,0.3, 0.1, 1, mulchDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(ModBlocks.MULCH.get(), Items.BEETROOT_SEEDS,1,0.3, 0.1, 1, mulchDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(ModBlocks.MULCH.get(), Items.MELON_SEEDS,1,0.3, 0.1, 2, mulchDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(ModBlocks.MULCH.get(), Items.PUMPKIN_SEEDS,1,0.3, 0.1, 2, mulchDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(ModBlocks.MULCH.get(), Items.POTATO,1,0.3, 0.1, 3, mulchDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(ModBlocks.MULCH.get(), Items.CARROT,1,0.3, 0.1, 3, mulchDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(ModBlocks.MULCH.get(), Items.SWEET_BERRIES,1,0.3, 0.1, 4, mulchDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(ModBlocks.MULCH.get(), Items.GLOW_BERRIES,1,0.3, 0.1, 4, mulchDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(ModBlocks.MULCH.get(), Items.TORCHFLOWER_SEEDS,1,0.3, 0.1, 5, mulchDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //TALL GRASS

        new StrainerRecipeFluidBuilder(Items.TALL_GRASS, Items.SUNFLOWER,1,0.3, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.TALL_GRASS, Items.PEONY,1,0.3, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.TALL_GRASS, Items.ROSE_BUSH,1,0.3, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.TALL_GRASS, Items.LILAC,1,0.3, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.GRASS, Items.LILY_OF_THE_VALLEY,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS, Items.CORNFLOWER,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS, Items.OXEYE_DAISY,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS, Items.PINK_TULIP,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS, Items.WHITE_TULIP,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS, Items.ORANGE_TULIP,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS, Items.RED_TULIP,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS, Items.AZURE_BLUET,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS, Items.ALLIUM,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS, Items.BLUE_ORCHID,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS, Items.POPPY,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS, Items.DANDELION,1,0.2, 0.1, 3, mulchDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);


        //SAND SIEVING

        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.PRISMARINE_SHARD,1,0.25, 0.1, 3, sandDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.PRISMARINE_CRYSTALS,1,0.25, 0.1, 3, sandDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.TUBE_CORAL,1,0.2, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.TUBE_CORAL_FAN,1,0.2, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.BRAIN_CORAL,1,0.2, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.BRAIN_CORAL_FAN,1,0.2, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.BUBBLE_CORAL,1,0.2, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.BUBBLE_CORAL_FAN,1,0.2, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.FIRE_CORAL,1,0.2, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.FIRE_CORAL_FAN,1,0.2, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.HORN_CORAL,1,0.2, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.HORN_CORAL_FAN,1,0.2, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.SOUL_SAND, 1,1, 0.00, 5, sandDuration,"minecraft:lava" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.KELP, 1,0.3, 0.01, 3, sandDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.SEA_PICKLE, 1,0.3, 0.01, 3, sandDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.SEAGRASS, 1,0.3, 0.01, 3, sandDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.LILY_PAD, 1,0.2, 0.01, 3, sandDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.SMALL_DRIPLEAF, 1,0.2, 0.01, 3, sandDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.BIG_DRIPLEAF, 1,0.1, 0.01, 3, sandDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.CACTUS, 1,0.3, 0.01, 1, sandDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.SUGAR_CANE, 1,0.3, 0.01, 1, sandDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.SAND, Items.BAMBOO, 1,0.3, 0.01, 1, sandDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //CORAL
        new StrainerRecipeFluidBuilder(Items.TUBE_CORAL, Items.TUBE_CORAL_BLOCK,1,0.2, 0.1, 3, sandDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.BRAIN_CORAL, Items.BRAIN_CORAL_BLOCK,1,0.2, 0.1, 3, sandDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.BUBBLE_CORAL, Items.BUBBLE_CORAL_BLOCK,1,0.2, 0.1, 3, sandDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.FIRE_CORAL, Items.FIRE_CORAL_BLOCK,1,0.2, 0.1, 3, sandDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.HORN_CORAL, Items.HORN_CORAL_BLOCK,1,0.2, 0.1, 3, sandDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //GRAVEL SIEVING
        new StrainerRecipeFluidBuilder(Items.GRAVEL, com.benbenlaw.opolisutilities.item.ModItems.MINI_CHARCOAL.get(),1,0.75, 0.05, 1, gravelDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRAVEL, com.benbenlaw.opolisutilities.item.ModItems.COPPER_NUGGET.get(), 1,0.75, 0.05, 1, gravelDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRAVEL, Items.FLINT, 1,0.75, 0.05, 1, gravelDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.GRAVEL, Items.IRON_NUGGET, 1,0.75, 0.05, 2, gravelDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.GRAVEL, Items.GOLD_NUGGET, 1,0.75, 0.05, 3, gravelDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //STONE SIEVING
        new StrainerRecipeFluidTagBuilder(Tags.Items.STONE, Items.ANDESITE,1,0.2, 0.05, 1, stoneDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.STONE, Items.GRANITE,1,0.2, 0.05, 1, stoneDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidTagBuilder(Tags.Items.STONE, Items.DIORITE,1,0.2, 0.05, 1, stoneDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.STONE, Items.SAND, 1,1, 0.0, 1, stoneDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.STONE, Items.NETHERRACK, 1,1, 0.0, 5, stoneDuration,"minecraft:lava" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.STONE, Items.POINTED_DRIPSTONE, 1,0.5, 0.0, 3, stoneDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //GRANITE SIEVING
        new StrainerRecipeFluidBuilder(Items.GRANITE, Items.REDSTONE, 1,0.25, 0.05, 3, stoneDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRANITE, Items.RED_SAND, 1,1, 0.0, 1, stoneDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //ANDESITE SIEVING
        new StrainerRecipeFluidBuilder(Items.ANDESITE, Items.GRAVEL,1,0.75, 0.05, 1, stoneDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.ANDESITE, Items.LAPIS_LAZULI, 1,0.25, 0.05, 3, stoneDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //DIORITE SIEVING
        new StrainerRecipeFluidBuilder(Items.DIORITE, Items.AMETHYST_SHARD, 1,0.25, 0.05, 3, stoneDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.DIORITE, Items.CALCITE, 1,1, 0.00, 3, stoneDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //DEEPSLATE
        new StrainerRecipeFluidBuilder(Items.DEEPSLATE, Items.DIAMOND, 1,0.1, 0.05, 4, deepslateDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.DEEPSLATE, Items.EMERALD, 1,0.1, 0.05, 5, deepslateDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.DEEPSLATE, Items.BASALT, 1,0.5, 0.0, 4, deepslateDuration,"minecraft:lava" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.DEEPSLATE, Items.BLACKSTONE, 1,0.5, 0.0, 4, deepslateDuration,"minecraft:lava" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //MOSS COBBLESTONE
        new StrainerRecipeFluidBuilder(Items.MOSSY_COBBLESTONE, Items.MOSS_BLOCK, 1,0.75, 0.05, 3, stoneDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //NETHERRACK SIEVING
        new StrainerRecipeFluidBuilder(Items.NETHERRACK, Items.NETHER_WART, 1,0.25, 0.05, 3, netherrackDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.NETHERRACK, Items.ANCIENT_DEBRIS, 1,0.04, 0.03, 6, netherrackDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.NETHERRACK, Items.END_STONE, 1,1, 0.00, 6, netherrackDuration,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //SOUL_SAND SIEVING
        new StrainerRecipeFluidBuilder(Items.SOUL_SAND, Items.QUARTZ, 1,0.25, 0.05, 4, soulsandDuration,"minecraft:lava" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //LAVA BUCKET SIEVING
        new StrainerRecipeFluidBuilder(Items.LAVA_BUCKET, Items.OBSIDIAN, 1,1, 0.0, 4, lavaBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.LAVA_BUCKET, Items.BUCKET, 1,1, 0.0, 4, lavaBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //WATER BUCKET SIEVING
        new StrainerRecipeFluidBuilder(Items.WATER_BUCKET, Items.ICE, 1,1, 0.0, 4, waterBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.WATER_BUCKET, Items.BUCKET, 1,1, 0.0, 4, waterBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockBuilder(Items.WATER_BUCKET, Items.POWDER_SNOW_BUCKET, 1,1, 0.0, 5, waterBucketDuration,"minecraft:blue_ice" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockBuilder(Items.WATER_BUCKET, Items.SNOWBALL, 1,0.2, 0.1, 2, waterBucketDuration,"minecraft:ice" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //FISHING
        new StrainerRecipeFluidBuilder(Items.FISHING_ROD, Items.COD, 1,0.35, 0.1, 1, waterBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.FISHING_ROD, Items.SALMON, 1,0.3, 0.1, 1, waterBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.FISHING_ROD, Items.SADDLE, 1,0.15, 0.05, 1, waterBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.FISHING_ROD, Items.TROPICAL_FISH, 1,0.15, 0.05, 1, waterBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.FISHING_ROD, Items.PUFFERFISH, 1,0.15, 0.05, 1, waterBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.FISHING_ROD, Items.LEATHER, 1,0.15, 0.05, 1, waterBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.FISHING_ROD, Items.NAUTILUS_SHELL, 1,0.01, 0.01, 1, waterBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.FISHING_ROD, Items.HEART_OF_THE_SEA, 1,0.01, 0.01, 1, waterBucketDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //OBSIDIAN SIEVING
        new StrainerRecipeFluidBuilder(Items.OBSIDIAN, Items.CRYING_OBSIDIAN, 1,0.0, 0.0, 6, obsidianDuration,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        //SUSPICIOUS SAND

        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.ARMS_UP_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.ANGLER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.ARCHER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.BLADE_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.BREWER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.BURN_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.DANGER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.EXPLORER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.FRIEND_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.HEART_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.HEARTBREAK_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.HOWL_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.MINER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.MOURNER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.PLENTY_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.PRIZE_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.SHEAF_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.SHELTER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.SKULL_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.SNORT_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_SAND, Items.SNIFFER_EGG, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);


        //SUSPICIOUS GRAVEL
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.ARMS_UP_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.ANGLER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.ARCHER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.BLADE_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.BREWER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.BURN_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.DANGER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.EXPLORER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.FRIEND_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.HEART_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.HEARTBREAK_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.HOWL_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.MINER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.MOURNER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.PLENTY_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.PRIZE_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.SHEAF_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.SHELTER_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.SKULL_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.SNORT_POTTERY_SHERD, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.SUSPICIOUS_GRAVEL, Items.SNIFFER_EGG, 1,0.1, 0.1, 3, sandDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);


        //END STONE

        //MISC
        new StrainerRecipeFluidBuilder(Items.YELLOW_WOOL, Items.SPONGE, 1,0.1, 0.1, 2, 300,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.PURPUR_BLOCK, Items.SHULKER_SHELL, 1,0.25, 0.1, 4, 200,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GREEN_DYE, Items.SLIME_BALL, 1,0.25, 0.1, 3, 200,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.BONE_BLOCK, Items.SKELETON_SKULL, 1,0.4, 0.2, 3, 460,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.SKELETON_SKULL, Items.WITHER_SKELETON_SKULL, 1,0.5, 0.1, 5, 500,"minecraft:lava" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SKELETON_SKULL, Items.CREEPER_HEAD, 1,0.5, 0.1, 5, 500,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SKELETON_SKULL, Items.ZOMBIE_HEAD, 1,0.5, 0.1, 5, 500,"strainers:eroding_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SKELETON_SKULL, Items.PIGLIN_HEAD, 1,0.5, 0.1, 5, 500,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockBuilder(Items.SKELETON_SKULL, Items.DRAGON_HEAD, 1,0.5, 0.1, 5, 1000,"minecraft:dragon_egg" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.SCULK, Items.ECHO_SHARD, 1,0.25, 0.15, 4, 200,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.EGG, Items.TURTLE_EGG, 1,0.20, 0.1, 3, 200,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockBuilder(Items.SUSPICIOUS_STEW, Items.SUSPICIOUS_SAND, 1,0.6, 0.15, 3, 200,"minecraft:sand" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeBlockBuilder(Items.SUSPICIOUS_STEW, Items.SUSPICIOUS_GRAVEL, 1,0.6, 0.15, 3, 200,"minecraft:gravel" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS_BLOCK, Items.PODZOL, 1,1, 0.0, 5, 300,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.GRASS_BLOCK, Items.MYCELIUM, 1,1, 0.0, 5, 300,"strainers:purified_water_fluid" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeFluidBuilder(Items.MYCELIUM, Items.RED_MUSHROOM, 1,0.3, 0.1, 3, dirtDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);
        new StrainerRecipeFluidBuilder(Items.MYCELIUM, Items.BROWN_MUSHROOM, 1,0.3, 0.1, 3, dirtDuration,"minecraft:water" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        new StrainerRecipeBlockBuilder(Items.GLASS_BOTTLE, Items.DRAGON_BREATH, 1,0.3, 0.1, 6, 500,"minecraft:dragon_head" ).unlockedBy("has_strainer", has(ModBlocks.WOODEN_STRAINER.get())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MULCH.get())
                .pattern("LLL")
                .pattern("LDL")
                .pattern("LLL")
                .define('L', ItemTags.LEAVES)
                .define('D', Items.DIRT)
                .unlockedBy("has_leaves", inventoryTrigger(ItemPredicate.Builder.item().of(ItemTags.LEAVES).build())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.PURIFYING_SALT_MULCH.get())
                .pattern("LCL")
                .pattern("LML")
                .pattern("LCL")
                .define('L', ItemTags.LEAVES)
                .define('M', ModBlocks.MULCH.get())
                .define('C', Items.CHARCOAL)
                .unlockedBy("has_charcoal", inventoryTrigger(ItemPredicate.Builder.item().of(Items.CHARCOAL).build())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ERODING_SALT_MULCH.get())
                .pattern("AGD")
                .pattern("LML")
                .pattern("AGD")
                .define('L', ModItems.STONE_PEBBLE.get())
                .define('M', ModBlocks.MULCH.get())
                .define('A', Blocks.ANDESITE)
                .define('G', Blocks.GRANITE)
                .define('D', Blocks.DIORITE)
                .unlockedBy("has_stone", inventoryTrigger(ItemPredicate.Builder.item().of(Tags.Items.STONE).build())).save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SUMMONING_BLOCK.get())
                .pattern("WWW")
                .pattern("SHS")
                .pattern("SSS")
                .define('S', Items.STONE)
                .define('H', Items.HAY_BLOCK)
                .define('W', Items.WHEAT)
                .unlockedBy("has_stone", inventoryTrigger(ItemPredicate.Builder.item().of(Items.WHEAT).build())).save(pWriter);



    }

}
