package com.benbenlaw.strainers.recipe;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.util.ModTags;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class StrainerRecipe implements Recipe<SimpleContainer> {

    private final ResourceLocation id;
    private final ItemStack output;
    private final double outputChance;
    private final double chanceIncreasePerTier;
    private final NonNullList<Ingredient> inputItem;
    private final int meshTier;
    private final int duration;
    private final String blockAbove;
    private final String fluidAbove;


    public StrainerRecipe(ResourceLocation id, ItemStack output, double outputChance,
                          double chanceIncreasePerTier,
                          NonNullList<Ingredient> inputItem, int meshTier, int duration, String blockAbove, String fluidAbove) {

        this.id = id;
        this.output = output;
        this.outputChance = outputChance;
        this.chanceIncreasePerTier = chanceIncreasePerTier;
        this.inputItem = inputItem;
        this.meshTier = meshTier;
        this.duration = duration;
        this.blockAbove = blockAbove;
        this.fluidAbove = fluidAbove;

    }

    @Override
    public boolean matches(@NotNull SimpleContainer pContainer, @NotNull Level pLevel) {
        if (pLevel.isClientSide()) {
            return false;
        }

        if(inputItem.get(0).test(pContainer.getItem(2))) {

            ItemStack meshItem = pContainer.getItem(1);
            return switch (meshTier) {
                case 1 -> meshItem.is(ModTags.Items.TIER_1_MESHES) || meshItem.is(ModTags.Items.TIER_2_MESHES) || meshItem.is(ModTags.Items.TIER_3_MESHES) || meshItem.is(ModTags.Items.TIER_4_MESHES) || meshItem.is(ModTags.Items.TIER_5_MESHES) || meshItem.is(ModTags.Items.TIER_6_MESHES);
                case 2 -> meshItem.is(ModTags.Items.TIER_2_MESHES) || meshItem.is(ModTags.Items.TIER_3_MESHES) || meshItem.is(ModTags.Items.TIER_4_MESHES) || meshItem.is(ModTags.Items.TIER_5_MESHES) || meshItem.is(ModTags.Items.TIER_6_MESHES);
                case 3 -> meshItem.is(ModTags.Items.TIER_3_MESHES) || meshItem.is(ModTags.Items.TIER_4_MESHES) || meshItem.is(ModTags.Items.TIER_5_MESHES) || meshItem.is(ModTags.Items.TIER_6_MESHES);
                case 4 -> meshItem.is(ModTags.Items.TIER_4_MESHES) || meshItem.is(ModTags.Items.TIER_5_MESHES) || meshItem.is(ModTags.Items.TIER_6_MESHES);
                case 5 -> meshItem.is(ModTags.Items.TIER_5_MESHES) || meshItem.is(ModTags.Items.TIER_6_MESHES);
                case 6 -> meshItem.is(ModTags.Items.TIER_6_MESHES);
                default -> false;
            };
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

    public double getOutputChance() {
        return outputChance;
    }

    public ItemStack getOutput() {
        return output;
    }

    public double getChanceIncreasePerTier() {
        return chanceIncreasePerTier;
    }

    public int getMeshTier() {
        return meshTier;
    }

    public int getDuration() {
        return duration;
    }
    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItem;
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
            ItemStack output = json.has("output") ? ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output")) : ItemStack.EMPTY;

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);
            for (int i = 0; i < ingredients.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            double chance = GsonHelper.getAsDouble(json, "chance");
            double chanceIncreasePerTier = GsonHelper.getAsDouble(json, "chanceIncreasePerTier");
            int duration = GsonHelper.getAsInt(json, "duration", 120);
            int minMeshTier = GsonHelper.getAsInt(json, "minMeshTier");
            String blockAbove = GsonHelper.getAsString(json, "aboveBlock", "");
            String fluidAbove = GsonHelper.getAsString(json, "aboveFluid", "");

            return new StrainerRecipe(id, output, chance, chanceIncreasePerTier, inputs, minMeshTier, duration, blockAbove, fluidAbove);

        }

        @Override
        public StrainerRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            ItemStack output = buf.readItem();

            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            double chance = buf.readDouble();
            double chanceIncreasePerTier = buf.readDouble();
            int duration = buf.readInt();
            int minMeshTier = buf.readInt();
            String blockAbove = buf.readUtf(Short.MAX_VALUE);
            String fluidAbove = buf.readUtf(Short.MAX_VALUE);

            return new StrainerRecipe(id, output,chance, chanceIncreasePerTier,
                    inputs, minMeshTier, duration, blockAbove, fluidAbove);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, StrainerRecipe recipe) {
            buf.writeItem(recipe.getOutput());

            buf.writeInt(recipe.getIngredients().size());

            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }

            buf.writeDouble(recipe.getOutputChance());
            buf.writeDouble(recipe.getChanceIncreasePerTier());
            buf.writeInt(recipe.getDuration());
            buf.writeInt(recipe.getMeshTier());
            buf.writeUtf(recipe.getBlockAbove(), Short.MAX_VALUE);
            buf.writeUtf(recipe.getFluidAbove(), Short.MAX_VALUE);
        }
    }

}