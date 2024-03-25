package com.benbenlaw.strainers.integration.kubejs;

import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.item.OutputItem;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.component.StringComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Locale;

public interface StrainerRecipeJS {


    RecipeKey<String> FLUID_ABOVE = StringComponent.ANY.key("aboveFluid").optional("").alwaysWrite();
    RecipeKey<String> BLOCK_ABOVE = StringComponent.ANY.key("aboveBlock").optional("").alwaysWrite();
    RecipeKey<Double> CHANCE = NumberComponent.DOUBLE.key("chance");
    RecipeKey<Double> CHANCE_INCREASE_PER_TIER = NumberComponent.DOUBLE.key("chanceIncreasePerTier");
    RecipeKey<Integer> DURATION = NumberComponent.INT.key("duration");
    RecipeKey<InputItem[]> INGREDIENT = ItemComponents.INPUT_ARRAY.key("ingredients");
    RecipeKey<Integer> MIN_MESH_TIER = NumberComponent.INT.key("minMeshTier");
    RecipeKey<OutputItem> OUTPUT = ItemComponents.OUTPUT.key("output");


/*
    RecipeSchema SCHEMA = new RecipeSchema(StrainerRecipeJSHelper.class, StrainerRecipeJSHelper::new,
            FLUID_ABOVE, BLOCK_ABOVE, INGREDIENT, OUTPUT, CHANCE, CHANCE_INCREASE_PER_TIER, DURATION, MIN_MESH_TIER);

 */
    RecipeSchema SCHEMA = new RecipeSchema(StrainerRecipeJSHelper.class, StrainerRecipeJSHelper::new,
            INGREDIENT, OUTPUT, CHANCE, CHANCE_INCREASE_PER_TIER, DURATION, MIN_MESH_TIER, FLUID_ABOVE, BLOCK_ABOVE);

    class StrainerRecipeJSHelper extends RecipeJS {
        public StrainerRecipeJSHelper aboveBlock(String string) {
            setValue(BLOCK_ABOVE, string);
            return this;
        }
        public StrainerRecipeJSHelper aboveFluid(String string) {
            setValue(FLUID_ABOVE, string);
            return this;
        }
    }
}






