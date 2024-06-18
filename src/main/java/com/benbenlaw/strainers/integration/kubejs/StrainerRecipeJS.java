package com.benbenlaw.strainers.integration.kubejs;

public interface StrainerRecipeJS {} /* {


    RecipeKey<String> FLUID_ABOVE = StringComponent.ANY.key("aboveFluid").optional("").alwaysWrite();
    RecipeKey<String> BLOCK_ABOVE = StringComponent.ANY.key("aboveBlock").optional("").alwaysWrite();
    RecipeKey<Double> CHANCE = NumberComponent.DOUBLE.key("chance");
    RecipeKey<Double> CHANCE_INCREASE_PER_TIER = NumberComponent.DOUBLE.key("chanceIncreasePerTier");
    RecipeKey<Integer> DURATION = NumberComponent.INT.key("duration");
    RecipeKey<InputItem[]> INGREDIENT = ItemComponents.INPUT_ARRAY.key("ingredients");
    RecipeKey<Integer> MIN_MESH_TIER = NumberComponent.INT.key("minMeshTier");
    RecipeKey<OutputItem> OUTPUT = ItemComponents.OUTPUT.key("output");


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
*/






