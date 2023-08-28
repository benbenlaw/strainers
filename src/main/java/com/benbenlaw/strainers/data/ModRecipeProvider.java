package com.benbenlaw.strainers.data;

import com.benbenlaw.opolisutilities.item.ModItems;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.data.custom.StrainerRecipeBlockBuilder;
import com.benbenlaw.strainers.data.custom.StrainerRecipeFluidBuilder;
import com.benbenlaw.strainers.data.custom.StrainerRecipeFluidTagBuilder;
import com.benbenlaw.strainers.util.ModTags;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
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

    }
}
