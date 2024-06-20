package com.benbenlaw.strainers.datagen.recipes;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.recipe.OutputUpgradesRecipe;
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

public class OutputUpgradesRecipeBuilder implements RecipeBuilder {

    protected String group;
    protected Ingredient input;
    protected double outputAdd;
    protected final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public OutputUpgradesRecipeBuilder(Ingredient input, double outputAdd) {
        this.input = input;
        this.outputAdd = outputAdd;
    }

    public static OutputUpgradesRecipeBuilder OutputUpgradesRecipeBuilder(Ingredient input, double outputAdd) {
        return new OutputUpgradesRecipeBuilder(input, outputAdd);
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
        this.save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "output_upgrades/" +
                BuiltInRegistries.ITEM.getKey(Objects.requireNonNull(this.input.getItems()[0].getItem())).getPath()));
    }


    @Override
    public void save(@NotNull RecipeOutput recipeOutput, @NotNull ResourceLocation id) {
        Advancement.Builder builder = Advancement.Builder.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(builder::addCriterion);
        OutputUpgradesRecipe outputUpgradesRecipe = new OutputUpgradesRecipe(this.input, this.outputAdd);
        recipeOutput.accept(id, outputUpgradesRecipe, builder.build(id.withPrefix("recipes/output_upgrades/")));

    }
}
