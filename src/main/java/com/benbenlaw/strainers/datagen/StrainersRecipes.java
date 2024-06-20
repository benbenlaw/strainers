package com.benbenlaw.strainers.datagen;

import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.opolisutilities.block.ModBlocks;
import com.benbenlaw.opolisutilities.datagen.recipes.*;
import com.benbenlaw.opolisutilities.item.ModItems;
import com.benbenlaw.strainers.datagen.recipes.MeshUpgradesRecipeBuilder;
import com.benbenlaw.strainers.datagen.recipes.OutputUpgradesRecipeBuilder;
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

        //Mesh Upgrades

        MeshUpgradesRecipeBuilder.MeshUpgradesRecipeBuilder(Ingredient.of(Items.DIAMOND), 0.9)
                .unlockedBy("has_item", hasItems(Items.DIAMOND))
                .save(consumer);

        //Output Upgrades

        OutputUpgradesRecipeBuilder.OutputUpgradesRecipeBuilder(Ingredient.of(Items.EMERALD), 0.1)
                .unlockedBy("has_item", hasItems(Items.DIAMOND))
                .save(consumer);




    }

}
