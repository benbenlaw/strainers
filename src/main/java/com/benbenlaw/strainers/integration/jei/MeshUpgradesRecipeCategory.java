package com.benbenlaw.strainers.integration.jei;

import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.opolisutilities.integration.jei.JEIOpolisUtilitiesPlugin;
import com.benbenlaw.opolisutilities.recipe.SpeedUpgradesRecipe;
import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.recipe.MeshUpgradesRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotTooltipCallback;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeshUpgradesRecipeCategory implements IRecipeCategory<MeshUpgradesRecipe> {
    public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "mesh_upgrade");
    public final static ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(OpolisUtilities.MOD_ID, "textures/gui/jei_dynamic.png");

    public static final RecipeType<MeshUpgradesRecipe> RECIPE_TYPE = RecipeType.create(Strainers.MOD_ID, "mesh_upgrade",
            MeshUpgradesRecipe.class);

    private IDrawable background;
    private final IDrawable icon;
    private final IGuiHelper helper;
    private int tabs_used = 0;

    public MeshUpgradesRecipeCategory(IGuiHelper helper) {
        this.helper = helper;
        this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 114);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.WOODEN_STRAINER.get()));
    }

    @Override
    public @NotNull RecipeType<MeshUpgradesRecipe> getRecipeType() {
        return JEIStrainersPlugin.MESH_UPGRADES;
    }

    @Override
    public boolean isHandled(MeshUpgradesRecipe recipe) {
        return tabs_used == 0;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Mesh Upgrades");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MeshUpgradesRecipe recipe, IFocusGroup focusGroup) {
        tabs_used++;

        List<MeshUpgradesRecipe> recipes = new ArrayList<>(Minecraft.getInstance().level.getRecipeManager().getAllRecipesFor(MeshUpgradesRecipe.Type.INSTANCE)).stream().map(RecipeHolder::value).toList();

        List<MeshUpgradesRecipe> mutableRecipes = new ArrayList<>(recipes);

        mutableRecipes.sort(Comparator.comparingDouble(MeshUpgradesRecipe::meshDamageChance));

        // Background Size
        int numRows = (int) Math.ceil((double) mutableRecipes.size() / 9);
        int numCols = Math.min(9, mutableRecipes.size()); // Maximum of 9 columns
        int backgroundWidth = 4 + numCols * 19;
        int backgroundHeight = 2 + numRows * 19;

        background = helper.createDrawable(TEXTURE, 0, 0, backgroundWidth, backgroundHeight);

        for (int i = 0; i < mutableRecipes.size(); i++) {
            final int slotX = 4 + (i % 9 * 19);
            final int slotY = 2 + i / 9 * 19;

            int damageChance = (int) (mutableRecipes.get(i).meshDamageChance() * 100);

            builder.addSlot(RecipeIngredientRole.INPUT, slotX, slotY).addIngredients(mutableRecipes.get(i).input()).addTooltipCallback(durationTime(damageChance));
            builder.addSlot(RecipeIngredientRole.OUTPUT, slotX, slotY).addIngredients(mutableRecipes.get(i).input()).addTooltipCallback(durationTime(damageChance))
                    .setBackground(JEIOpolisUtilitiesPlugin.slotDrawable, slotX - (i % 9 * 19) - 5, slotY - (2 + i / 9 * 19) - 1);

        }
    }

    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback durationTime(int duration) {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Mesh Damage Chance: " + duration + " %"));
        };
    }
}



