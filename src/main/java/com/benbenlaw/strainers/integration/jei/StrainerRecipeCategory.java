package com.benbenlaw.strainers.integration.jei;

import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.opolisutilities.item.ModItems;
import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.recipe.ModRecipes;
import com.benbenlaw.strainers.recipe.StrainerRecipe;
import com.benbenlaw.strainers.util.ModTags;
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
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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
        this.background = helper.createDrawable(TEXTURE, 0, 0, 180, 40);
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

        builder.addSlot(RecipeIngredientRole.INPUT, 4, 23).addIngredients(recipe.getIngredients().get(0));

        if (recipe.getMeshTier() == 1) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_1_MESHES))
                    .addTooltipCallback(tier1Mesh());
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())
                    .addTooltipCallback(tier1MeshStats(recipe));
        }
        if (recipe.getMeshTier() == 2) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_2_MESHES))
                    .addTooltipCallback(tier2Mesh());
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())
                    .addTooltipCallback(tier2MeshStats(recipe));
        }
        if (recipe.getMeshTier() == 3) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_3_MESHES))
                    .addTooltipCallback(tier3Mesh());
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())
                    .addTooltipCallback(tier3MeshStats(recipe));
        }
        if (recipe.getMeshTier() == 4) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_4_MESHES))
                    .addTooltipCallback(tier4Mesh());
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())
                    .addTooltipCallback(tier4MeshStats(recipe));
        }
        if (recipe.getMeshTier() == 5) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_5_MESHES))
                    .addTooltipCallback(tier5Mesh());
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())
                    .addTooltipCallback(tier5MeshStats(recipe));
        }
        if (recipe.getMeshTier() == 6) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_6_MESHES))
                    .addTooltipCallback(tier6Mesh());
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())
                    .addTooltipCallback(tier6MeshStats(recipe));
        }

        Block blockInRecipe = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(recipe.getBlockAbove()));

        if(!blockInRecipe.asItem().equals(Items.AIR)) {
            builder.addSlot(RecipeIngredientRole.CATALYST, 4, 3).addItemStack(blockInRecipe.asItem().getDefaultInstance())
                    .addTooltipCallback(getPlaceAbove());
        }

        Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(recipe.getFluidAbove()));
        builder.addSlot(RecipeIngredientRole.INPUT, 4, 3).addFluidStack(fluid
                , 1000).setFluidRenderer(1000, true, 16,16);

    }

    private IRecipeSlotTooltipCallback getPlaceAbove() {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Place above the strainer"));
        };
    }

    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier1Mesh() {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Minimum Mesh Tier 1"));
        };
    }
    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier2Mesh() {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Minimum Mesh Tier 2"));
        };
    }
    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier3Mesh() {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Minimum Mesh Tier 3"));
        };
    }
    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier4Mesh() {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Minimum Mesh Tier 4"));
        };
    }
    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier5Mesh() {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Minimum Mesh Tier 5"));
        };
    }
    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier6Mesh() {
        return (chance, addTooltip) -> {
            addTooltip.add(Component.literal("Minimum Mesh Tier 6"));
        };
    }

    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier1MeshStats(StrainerRecipe recipe) {
        return (chance, addTooltip) -> {

            if(!Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                addTooltip.add(Component.literal("Press §eSHIFT§r for more Information"));

            }
            if(Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Tier 1 Mesh: " + ((int) (recipe.getOutputChance() * 100)) + "%"));
                addTooltip.add(Component.literal("Tier 2 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 1) + recipe.getOutputChance()) * 100) + "%"));
                addTooltip.add(Component.literal("Tier 3 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 2) + recipe.getOutputChance()) * 100) + "%"));
                addTooltip.add(Component.literal("Tier 4 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 3) + recipe.getOutputChance()) * 100) + "%"));
                addTooltip.add(Component.literal("Tier 5 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 4) + recipe.getOutputChance()) * 100) + "%"));
                addTooltip.add(Component.literal("Tier 6 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 5) + recipe.getOutputChance()) * 100) + "%"));
            }
        };
    }
    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier2MeshStats(StrainerRecipe recipe) {
        return (chance, addTooltip) -> {

            if(!Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                addTooltip.add(Component.literal("Press §eSHIFT§r for more Information"));

            }
            if(Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Tier 2 Mesh: " + ((int) (recipe.getOutputChance() * 100)) + "%"));
                addTooltip.add(Component.literal("Tier 3 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 1) + recipe.getOutputChance()) * 100) + "%"));
                addTooltip.add(Component.literal("Tier 4 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 2) + recipe.getOutputChance()) * 100) + "%"));
                addTooltip.add(Component.literal("Tier 5 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 3) + recipe.getOutputChance()) * 100) + "%"));
                addTooltip.add(Component.literal("Tier 6 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 4) + recipe.getOutputChance()) * 100) + "%"));
            }
        };
    }
    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier3MeshStats(StrainerRecipe recipe) {
        return (chance, addTooltip) -> {

            if(!Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                addTooltip.add(Component.literal("Press §eSHIFT§r for more Information"));

            }
            if(Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Tier 3 Mesh: " + ((int) (recipe.getOutputChance() * 100)) + "%"));
                addTooltip.add(Component.literal("Tier 4 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 1) + recipe.getOutputChance()) * 100) + "%"));
                addTooltip.add(Component.literal("Tier 5 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 2) + recipe.getOutputChance()) * 100) + "%"));
                addTooltip.add(Component.literal("Tier 6 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 3) + recipe.getOutputChance()) * 100) + "%"));
            }
        };
    }
    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier4MeshStats(StrainerRecipe recipe) {
        return (chance, addTooltip) -> {

            if(!Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                addTooltip.add(Component.literal("Press §eSHIFT§r for more Information"));

            }
            if(Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Tier 4 Mesh: " + ((int) (recipe.getOutputChance() * 100)) + "%"));
                addTooltip.add(Component.literal("Tier 5 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 1) + recipe.getOutputChance()) * 100) + "%"));
                addTooltip.add(Component.literal("Tier 6 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 2) + recipe.getOutputChance()) * 100) + "%"));
            }
        };
    }
    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier5MeshStats(StrainerRecipe recipe) {
        return (chance, addTooltip) -> {

            if(!Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                addTooltip.add(Component.literal("Press §eSHIFT§r for more Information"));

            }
            if(Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Tier 5 Mesh: " + ((int) (recipe.getOutputChance() * 100)) + "%"));
                addTooltip.add(Component.literal("Tier 6 Mesh: " + (int) (((recipe.getChanceIncreasePerTier() * 1) + recipe.getOutputChance()) * 100) + "%"));
           }
        };
    }
    @Contract(pure = true)
    private @NotNull IRecipeSlotTooltipCallback tier6MeshStats(StrainerRecipe recipe) {
        return (chance, addTooltip) -> {

            if(!Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                addTooltip.add(Component.literal("Press §eSHIFT§r for more Information"));

            }
            if(Screen.hasShiftDown()) {
                addTooltip.add(Component.literal("Tier 6 Mesh: " + ((int) (recipe.getOutputChance() * 100)) + "%"));}
        };
    }


    @Override
    public void draw(StrainerRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        @Nonnull final Minecraft minecraft = Minecraft.getInstance();

        if (!recipe.getBlockAbove().isEmpty()) {
            guiGraphics.drawString(minecraft.font.self(), Component.translatable("jei.strainer.place_block"), 25, 6, Color.WHITE.getRGB());
        }

        if (!recipe.getFluidAbove().isEmpty()) {
            guiGraphics.drawString(minecraft.font.self(), Component.translatable("jei.strainer.place_fluid"), 25, 6, Color.WHITE.getRGB());
        }

        int duration = recipe.getDuration();
        guiGraphics.drawString(minecraft.font.self(), Component.literal(duration + " ticks"), 77, 26, Color.WHITE.getRGB());
    }
}
