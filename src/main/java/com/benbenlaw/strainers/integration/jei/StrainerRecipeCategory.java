package com.benbenlaw.strainers.integration.jei;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.recipe.ModRecipes;
import com.benbenlaw.strainers.recipe.StrainerRecipe;
import com.mojang.blaze3d.vertex.PoseStack;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotTooltipCallback;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class StrainerRecipeCategory implements IRecipeCategory<StrainerRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Strainers.MOD_ID, "strainer");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Strainers.MOD_ID, "textures/gui/jei_strainer.png");

    static final RecipeType<StrainerRecipe> RECIPE_TYPE = RecipeType.create(Strainers.MOD_ID, "strainer",
            StrainerRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public StrainerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 83);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.WOODEN_STRAINER.get()));
    }

    @Override
    public RecipeType<StrainerRecipe> getRecipeType() {
        return JEIStrainersPlugin.STRAINER;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Strainers");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, StrainerRecipe recipe, IFocusGroup focusGroup) {

        /*

        builder.addSlot(RecipeIngredientRole.INPUT, 44, 35).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 35).addIngredients(recipe.getIngredients().get(1));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 116, 17).addItemStack(recipe.getOutput())
                .addTooltipCallback(getChance1(recipe));



        Block blockInRecipe = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(recipe.getBlockAbove()));

        builder.addSlot(RecipeIngredientRole.CATALYST, 44, 17).addItemStack(blockInRecipe.asItem().getDefaultInstance())
                .addTooltipCallback(getPlaceAbove());

        Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(recipe.getFluidAbove()));

        builder.addSlot(RecipeIngredientRole.INPUT, 44, 17).addFluidStack(fluid, 1000).setFluidRenderer(1000, true, 16,16);

         */

    }

    private IRecipeSlotTooltipCallback getChance1(StrainerRecipe recipe) {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
        };
    }
    private IRecipeSlotTooltipCallback getPlaceAbove() {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Place above the strainer"));
        };
    }
    private IRecipeSlotTooltipCallback getPlaceWaterCauldronAbove() {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Place a cauldron with water inside above the strainer"));
        };
    }
    private IRecipeSlotTooltipCallback getPlaceLavaCauldronAbove() {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Place a cauldron with lava inside above the strainer"));
        };
    }



    @Override
    public void draw(StrainerRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {


        /*

        @Nonnull final Minecraft minecraft = Minecraft.getInstance();

        if (!recipe.getBlockAbove().isEmpty()) {

            guiGraphics.drawString(minecraft.font.self(), Component.translatable("jei.strainer.place_block"), 5, 7, Color.WHITE.getRGB());
        }

        if (!recipe.getFluidAbove().isEmpty()) {
            guiGraphics.drawString(minecraft.font.self(), Component.translatable("jei.strainer.place_fluid"), 5, 7, Color.WHITE.getRGB());
        }

        int duration = recipe.getDuration();

        guiGraphics.drawString(minecraft.font.self(), Component.literal(duration + " ticks"), 45, 64, Color.WHITE.getRGB());

         */
    }
}
