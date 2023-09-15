package com.benbenlaw.strainers.data.custom;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.recipe.StrainerRecipe;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.function.Consumer;

public class StrainerRecipeBlockTagBuilder implements RecipeBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final int count;
    private final double outputChance;
    private final double chanceIncreasePerTier;
    private final int meshTier;
    private final int duration;
    private final String blockAbove;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public StrainerRecipeBlockTagBuilder(TagKey<Item> ingredient, ItemLike result, int count, double outputChance, double chanceIncreasePerTier, int meshTier, int duration, String blockAbove) {
        this.ingredient = Ingredient.of(ingredient);
        this.result = result.asItem();
        this.count = count;
        this.outputChance = outputChance;
        this.chanceIncreasePerTier = chanceIncreasePerTier;
        this.meshTier = meshTier;
        this.duration = duration;
        this.blockAbove = blockAbove;
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    public double getChanceIncreasePerTier() {
        return chanceIncreasePerTier;
    }

    public double getOutputChance() {
        return outputChance;
    }

    public int getMeshTier() {
        return meshTier;
    }

    public int getDuration() {
        return duration;
    }

    public String getBlockAbove() {
        return blockAbove;
    }



    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.advancement.parent(new ResourceLocation("recipes/root"))
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pRecipeId))
                .rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);

        pFinishedRecipeConsumer.accept(new Result(pRecipeId, this.result, this.count, this.ingredient,
                outputChance, chanceIncreasePerTier, meshTier, duration, blockAbove, this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/"
                + pRecipeId.getPath())));

    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final Ingredient ingredient;
        private final int count;
        private final double outputChance;
        private final double chanceIncreasePerTier;
        private final int meshTier;
        private final int duration;
        private final String blockAbove;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation pId, Item pResult, int pCount, Ingredient ingredient, double outputChance, double chanceIncreasePerTier, int meshTier, int duration, String blockAbove, Advancement.Builder pAdvancement,
                      ResourceLocation pAdvancementId) {
            this.id = pId;
            this.result = pResult;
            this.count = pCount;
            this.ingredient = ingredient;
            this.outputChance = outputChance;
            this.chanceIncreasePerTier = chanceIncreasePerTier;
            this.meshTier = meshTier;
            this.duration = duration;
            this.blockAbove = blockAbove;
            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
        }

        @Override
        public void serializeRecipeData(JsonObject pJson) {

            JsonObject outputJSON = new JsonObject();
            outputJSON.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            if (this.count > 1) {
                outputJSON.addProperty("count", this.count);
            }
            pJson.add("output", outputJSON);

            JsonArray jsonarray = new JsonArray();
            jsonarray.add(ingredient.toJson());
            pJson.add("ingredients", jsonarray);

            pJson.addProperty("chance", this.outputChance);
            pJson.addProperty("minMeshTier", this.meshTier);
            pJson.addProperty("chanceIncreasePerTier", this.chanceIncreasePerTier);
            pJson.addProperty("duration", this.duration);
            pJson.addProperty("aboveBlock", this.blockAbove);

        }

        @Override
        public ResourceLocation getId() {
            return new ResourceLocation(Strainers.MOD_ID,
                    ForgeRegistries.ITEMS.getKey(this.result).getPath() + "_from_straining_" + ingredient.getItems()[0].getItem() + "_in_" + blockAbove.replace(":", "_"));
        }

        @Override
        public RecipeSerializer<?> getType() {
            return StrainerRecipe.Serializer.INSTANCE;
        }

        @javax.annotation.Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @javax.annotation.Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}