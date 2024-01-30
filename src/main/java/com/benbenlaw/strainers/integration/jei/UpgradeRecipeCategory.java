package com.benbenlaw.strainers.integration.jei;

import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.opolisutilities.block.ModBlocks;
import com.benbenlaw.opolisutilities.integration.jei.JEIOpolisUtilitiesPlugin;
import com.benbenlaw.opolisutilities.recipe.CatalogueRecipe;
import com.benbenlaw.opolisutilities.recipe.UpgradeRecipeUtil;
import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.recipe.StrainerRecipe;
import com.benbenlaw.strainers.recipe.SummoningRecipe;
import com.benbenlaw.strainers.util.ModTags;
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
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.awt.*;

public class UpgradeRecipeCategory implements IRecipeCategory<UpgradeRecipeUtil> {

    public final static ResourceLocation UID = new ResourceLocation(OpolisUtilities.MOD_ID, "upgrades");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Strainers.MOD_ID, "textures/gui/jei_upgrades.png");

    static final RecipeType<CatalogueRecipe> RECIPE_TYPE = RecipeType.create(OpolisUtilities.MOD_ID, "upgrades",
            CatalogueRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public UpgradeRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 70, 19);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CATALOGUE.get()));
    }

    @Override
    public RecipeType<UpgradeRecipeUtil> getRecipeType() {
        return JEIOpolisUtilitiesPlugin.UPGRADE_RECIPE_UTIL;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Upgrades");
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
    public void setRecipe(IRecipeLayoutBuilder builder, UpgradeRecipeUtil recipe, IFocusGroup focusGroup) {

        builder.addSlot(RecipeIngredientRole.INPUT, 4, 2).addItemStack(recipe.getUpgradeItem()).addTooltipCallback(informationTooltip(recipe));

    }

    private IRecipeSlotTooltipCallback informationTooltip(UpgradeRecipeUtil recipe) {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal(recipe.getUpgradeItem().getDisplayName().getString()));
            addTooltip.add(Component.literal("Duration Modifier: " + recipe.getDurationMultiplier() + ""));
            addTooltip.add(Component.literal("Duration Set Amount: " + recipe.getDurationSetAmount() + ""));
            addTooltip.add(Component.literal("Output Chance: " + recipe.getOutputIncreaseChance() + ""));
            addTooltip.add(Component.literal("Output Amount: " + recipe.getOutputIncreaseAmount() + ""));
            addTooltip.add(Component.literal("Input Consume Chance: " + recipe.getInputItemConsumeChance() + ""));
            addTooltip.add(Component.literal("Input Consume Amount: " + recipe.getOutputIncreaseAmount() + ""));
            addTooltip.add(Component.literal("RFPer Tick Multiplier: " + recipe.getRFPerTick() + ""));
            addTooltip.add(Component.literal("RFPer Tick Amount: " + recipe.getRfPerTickAmount() + ""));
            addTooltip.add(Component.literal("Mesh Extra Damage: " + recipe.getMeshExtraDamage() + ""));
            addTooltip.add(Component.literal("Mesh Damage chance: " + recipe.getMeshUseChance() + ""));
        };
    }




}
