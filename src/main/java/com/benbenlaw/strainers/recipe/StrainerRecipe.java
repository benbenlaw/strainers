package com.benbenlaw.strainers.recipe;

import com.benbenlaw.strainers.Strainers;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraftforge.fluids.FluidStack;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jetbrains.annotations.NotNull;


public class StrainerRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack output1;
    private final double outputChance1;
    private final ItemStack output2;
    private final double outputChance2;
    private final ItemStack output3;
    private final double outputChance3;
    private final ItemStack output4;
    private final double outputChance4;
    private final ItemStack output5;
    private final double outputChance5;
    private final ItemStack output6;
    private final double outputChance6;
    private final ItemStack output7;
    private final double outputChance7;
    private final ItemStack output8;
    private final double outputChance8;
    private final ItemStack output9;
    private final double outputChance9;
    private final NonNullList<Ingredient> recipeItems;
    private final int duration;
    private final String blockAbove;
    private final String fluidAbove;


    public StrainerRecipe(ResourceLocation id, ItemStack output1, double outputChance1,
                          ItemStack output2, double outputChance2,
                          ItemStack output3, double outputChance3,
                          ItemStack output4, double outputChance4,
                          ItemStack output5, double outputChance5,
                          ItemStack output6, double outputChance6,
                          ItemStack output7, double outputChance7,
                          ItemStack output8, double outputChance8,
                          ItemStack output9, double outputChance9,
                          NonNullList<Ingredient> recipeItems, int duration, String blockAbove, String fluidAbove) {

        this.id = id;
        this.output1 = output1;
        this.outputChance1 = outputChance1;
        this.output2 = output2;
        this.outputChance2 = outputChance2;
        this.output3 = output3;
        this.outputChance3 = outputChance3;
        this.output4 = output4;
        this.outputChance4 = outputChance4;
        this.output5 = output5;
        this.outputChance5 = outputChance5;
        this.output6 = output6;
        this.outputChance6 = outputChance6;
        this.output7 = output7;
        this.outputChance7 = outputChance7;
        this.output8 = output8;
        this.outputChance8 = outputChance8;
        this.output9 = output9;
        this.outputChance9 = outputChance9;
        this.recipeItems = recipeItems;
        this.duration = duration;
        this.blockAbove = blockAbove;
        this.fluidAbove = fluidAbove;

    }

    @Override
    public boolean matches(@NotNull SimpleContainer pContainer, @NotNull Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }
        ItemStack[] meshItems = recipeItems.get(0).getItems();
        ItemStack[] inputItems = recipeItems.get(1).getItems();
        ItemStack slotItem1 = pContainer.getItem(1);
        ItemStack slotItem2 = pContainer.getItem(2);

        for (ItemStack mesh : meshItems) {
            if (ItemStack.isSameItem(mesh, slotItem1)) {
                for (ItemStack input : inputItems) {
                    if (ItemStack.isSameItem(input, slotItem2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public @NotNull ItemStack getResultItem(RegistryAccess p_267052_) {
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack assemble(SimpleContainer p_44001_, RegistryAccess p_267165_) {
        return ItemStack.EMPTY;
    }


    public ItemStack getOutput1() {
        return output1;
    }
    public double getOutputChance1() {
        return outputChance1;
    }
    public ItemStack getOutput2() {
        return output2;
    }
    public double getOutputChance2() {
        return outputChance2;
    }
    public ItemStack getOutput3() {
        return output3;
    }
    public double getOutputChance3() {
        return outputChance3;
    }
    public ItemStack getOutput4() {
        return output4;
    }
    public double getOutputChance4() {
        return outputChance4;
    }
    public ItemStack getOutput5() {
        return output5;
    }
    public double getOutputChance5() {
        return outputChance5;
    }
    public ItemStack getOutput6() {
        return output6;
    }
    public double getOutputChance6() {
        return outputChance6;
    }
    public ItemStack getOutput7() {
        return output7;
    }
    public double getOutputChance7() {
        return outputChance7;
    }
    public ItemStack getOutput8() {
        return output8;
    }
    public double getOutputChance8() {
        return outputChance8;
    }
    public ItemStack getOutput9() {
        return output9;
    }
    public double getOutputChance9() {
        return outputChance9;
    }

    public int getDuration() {
        return duration;
    }
    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }
    public String getBlockAbove() {
        return blockAbove;
    }
    public String getFluidAbove() {
        return fluidAbove;
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

    @Override
    public boolean isSpecial() {
        return true;
    }

    public static class Type implements RecipeType<StrainerRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "strainer";
    }

    public static class Serializer implements RecipeSerializer<StrainerRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(Strainers.MOD_ID, "strainer");

        @Override
        public StrainerRecipe fromJson(ResourceLocation id, JsonObject json) {

            ItemStack output1;
            if (json.has("output1")) {
                output1 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output1"));
            } else {
                output1 = ItemStack.EMPTY;
            }

            ItemStack output2;
            if (json.has("output2")) {
                output2 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output2"));
            } else {
                output2 = ItemStack.EMPTY;
            }

            ItemStack output3;
            if (json.has("output3")) {
                output3 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output3"));
            } else {
                output3 = ItemStack.EMPTY;
            }

            ItemStack output4;
            if (json.has("output4")) {
                output4 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output4"));
            } else {
                output4 = ItemStack.EMPTY;
            }

            ItemStack output5;
            if (json.has("output5")) {
                output5 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output5"));
            } else {
                output5 = ItemStack.EMPTY;
            }

            ItemStack output6;
            if (json.has("output6")) {
                output6 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output6"));
            } else {
                output6 = ItemStack.EMPTY;
            }

            ItemStack output7;
            if (json.has("output7")) {
                output7 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output7"));
            } else {
                output7 = ItemStack.EMPTY;
            }

            ItemStack output8;
            if (json.has("output8")) {
                output8 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output8"));
            } else {
                output8 = ItemStack.EMPTY;
            }

            ItemStack output9;
            if (json.has("output9")) {
                output9 = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output9"));
            } else {
                output9 = ItemStack.EMPTY;
            }


            double outputChance1 = GsonHelper.getAsDouble(json, "outputChance1", 0.0);
            double outputChance2 = GsonHelper.getAsDouble(json, "outputChance2", 0.0);
            double outputChance3 = GsonHelper.getAsDouble(json, "outputChance3", 0.0);
            double outputChance4 = GsonHelper.getAsDouble(json, "outputChance4", 0.0);
            double outputChance5 = GsonHelper.getAsDouble(json, "outputChance5", 0.0);
            double outputChance6 = GsonHelper.getAsDouble(json, "outputChance6", 0.0);
            double outputChance7 = GsonHelper.getAsDouble(json, "outputChance7", 0.0);
            double outputChance8 = GsonHelper.getAsDouble(json, "outputChance8", 0.0);
            double outputChance9 = GsonHelper.getAsDouble(json, "outputChance9", 0.0);

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            String blockAbove;
            if (json.has("blockAbove")) {
                blockAbove = GsonHelper.getAsString(json, "fluidAbove");
            } else {
                blockAbove = "";
            }

            String fluidAbove;
            if (json.has("fluidAbove")) {
                fluidAbove = GsonHelper.getAsString(json, "fluidAbove");
            } else {
                fluidAbove = "";
            }

            int duration = GsonHelper.getAsInt(json, "duration");

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new StrainerRecipe(id,
                    output1, outputChance1, output2, outputChance2, output3, outputChance3,
                    output4, outputChance4, output5, outputChance5, output6, outputChance6,
                    output7, outputChance7, output8, outputChance8, output9, outputChance9,
                    inputs, duration, blockAbove, fluidAbove);
        }

        @Override
        public StrainerRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {

            ItemStack output1 = buf.readItem();
            ItemStack output2 = buf.readItem();
            ItemStack output3 = buf.readItem();
            ItemStack output4 = buf.readItem();
            ItemStack output5 = buf.readItem();
            ItemStack output6 = buf.readItem();
            ItemStack output7 = buf.readItem();
            ItemStack output8 = buf.readItem();
            ItemStack output9 = buf.readItem();

            double outputChance1 = buf.readInt();
            double outputChance2 = buf.readInt();
            double outputChance3 = buf.readInt();
            double outputChance4 = buf.readInt();
            double outputChance5 = buf.readInt();
            double outputChance6 = buf.readInt();
            double outputChance7 = buf.readInt();
            double outputChance8 = buf.readInt();
            double outputChance9 = buf.readInt();

            String blockAbove = buf.readUtf();
            String fluidAbove = buf.readUtf();


            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            int duration = buf.readInt();

            return new StrainerRecipe(id,
                    output1, outputChance1, output2, outputChance2, output3, outputChance3,
                    output4, outputChance4, output5, outputChance5, output6, outputChance6,
                    output7, outputChance7, output8, outputChance8, output9, outputChance9,
                   inputs, duration, blockAbove, fluidAbove);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, StrainerRecipe recipe) {

            buf.writeItemStack(recipe.getOutput1(), false);
            buf.writeItemStack(recipe.getOutput2(), false);
            buf.writeItemStack(recipe.getOutput3(), false);
            buf.writeItemStack(recipe.getOutput4(), false);
            buf.writeItemStack(recipe.getOutput5(), false);
            buf.writeItemStack(recipe.getOutput6(), false);
            buf.writeItemStack(recipe.getOutput7(), false);
            buf.writeItemStack(recipe.getOutput8(), false);
            buf.writeItemStack(recipe.getOutput9(), false);

            buf.writeDouble(recipe.getOutputChance1());
            buf.writeDouble(recipe.getOutputChance2());
            buf.writeDouble(recipe.getOutputChance3());
            buf.writeDouble(recipe.getOutputChance4());
            buf.writeDouble(recipe.getOutputChance5());
            buf.writeDouble(recipe.getOutputChance6());
            buf.writeDouble(recipe.getOutputChance7());
            buf.writeDouble(recipe.getOutputChance8());
            buf.writeDouble(recipe.getOutputChance9());

            buf.writeInt(recipe.getIngredients().size());

            buf.writeUtf(recipe.getBlockAbove(), Short.MAX_VALUE);
            buf.writeUtf(recipe.getFluidAbove(), Short.MAX_VALUE);

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }

            buf.writeInt(recipe.getDuration());

        }
    }
}