package com.benbenlaw.strainers.recipe;

import com.benbenlaw.strainers.Strainers;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class SummoningRecipe implements Recipe<NoInventoryRecipe> {

    private final ResourceLocation id;
    private final String blockBelow;
    private final NonNullList<Ingredient> inputItem;
    private final String summonedMob;

    public SummoningRecipe(ResourceLocation id, String blockBelow, NonNullList<Ingredient> inputItem, String summonedMob) {
        this.id = id;
        this.blockBelow = blockBelow;
        this.inputItem = inputItem;
        this.summonedMob = summonedMob;
    }

    public String getBlockBelow() {
        return blockBelow;
    }

    public String getSummonedMob() {
        return summonedMob;
    }

    public NonNullList<Ingredient> getInputItem() {
        return inputItem;
    }

    @Override
    public boolean matches(NoInventoryRecipe p_44002_, Level level) {
        return true;
    }

    @Override
    public ItemStack assemble(NoInventoryRecipe p_44001_, RegistryAccess p_267165_) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return ItemStack.EMPTY;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<SummoningRecipe> {
        private Type() {}
        public static final SummoningRecipe.Type INSTANCE = new SummoningRecipe.Type();
    }

    public static class Serializer implements RecipeSerializer<SummoningRecipe> {
        public static final SummoningRecipe.Serializer INSTANCE = new SummoningRecipe.Serializer();
        public static final ResourceLocation ID = new ResourceLocation(Strainers.MOD_ID, "summoning");

        @Override
        public SummoningRecipe fromJson(ResourceLocation id, JsonObject json) {

            String blockBelow = GsonHelper.getAsString(json, "blockBelow");

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);
            for (int i = 0; i < ingredients.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            String summonedMob = GsonHelper.getAsString(json, "summonedMob");


            return new SummoningRecipe(id, blockBelow, inputs, summonedMob);
        }

        @Override
        public @Nullable SummoningRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {

            String blockBelow = buf.readUtf();

            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }
            String summonedMob = buf.readUtf();


            return new SummoningRecipe (id, blockBelow, inputs, summonedMob);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, SummoningRecipe recipe) {

            buf.writeUtf(recipe.blockBelow, Short.MAX_VALUE);
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeUtf(recipe.summonedMob, Short.MAX_VALUE);

        }
    }

}
