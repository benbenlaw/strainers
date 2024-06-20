package com.benbenlaw.strainers.datagen.recipes;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.recipe.MeshUpgradesRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MeshUpgradesRecipeBuilder implements RecipeBuilder {

    protected String group;
    protected Ingredient input;
    protected double meshDamageChance;
    protected final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public MeshUpgradesRecipeBuilder(Ingredient input, double meshDamageChance) {
        this.input = input;
        this.meshDamageChance = meshDamageChance;
    }

    public static MeshUpgradesRecipeBuilder MeshUpgradesRecipeBuilder(Ingredient input, double meshDamageChance) {
        return new MeshUpgradesRecipeBuilder(input, meshDamageChance);
    }

    @Override
    public @NotNull RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public @NotNull RecipeBuilder group(@Nullable String groupName) {
        this.group = groupName;
        return this;
    }

    @Override
    public @NotNull Item getResult() {
        return ItemStack.EMPTY.getItem();
    }

    public void save(@NotNull RecipeOutput recipeOutput) {
        this.save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "mesh_upgrades/" +
                BuiltInRegistries.ITEM.getKey(Objects.requireNonNull(this.input.getItems()[0].getItem())).getPath()));
    }


    @Override
    public void save(@NotNull RecipeOutput recipeOutput, @NotNull ResourceLocation id) {
        Advancement.Builder builder = Advancement.Builder.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        MeshUpgradesRecipe meshUpgradesRecipe = new MeshUpgradesRecipe(this.input, this.meshDamageChance);
        recipeOutput.accept(id, meshUpgradesRecipe, builder.build(id.withPrefix("recipes/mesh_upgrades/")));

    }
}
