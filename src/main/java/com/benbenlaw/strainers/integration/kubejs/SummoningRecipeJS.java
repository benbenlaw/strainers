package com.benbenlaw.strainers.integration.kubejs;

import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.component.StringComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;

public interface SummoningRecipeJS {

    RecipeKey<String> FLUID_BELOW = StringComponent.ANY.key("fluidBelow").optional("").alwaysWrite();
    RecipeKey<String> BLOCK_BELOW = StringComponent.ANY.key("blockBelow").optional("").alwaysWrite();
    RecipeKey<InputItem[]> INGREDIENT = ItemComponents.INPUT_ARRAY.key("ingredients");
    RecipeKey<String> SUMMONED_MOB = StringComponent.ANY.key("summonedMob");


    RecipeSchema SCHEMA = new RecipeSchema(SummoningRecipeJSHelper.class, SummoningRecipeJSHelper::new,
            INGREDIENT, SUMMONED_MOB, FLUID_BELOW, BLOCK_BELOW);

    class SummoningRecipeJSHelper extends RecipeJS {
        public SummoningRecipeJSHelper blockBelow(String string) {
            setValue(BLOCK_BELOW, string);
            return this;
        }
        public SummoningRecipeJSHelper fluidBelow(String string) {
            setValue(FLUID_BELOW, string);
            return this;
        }
    }
}






