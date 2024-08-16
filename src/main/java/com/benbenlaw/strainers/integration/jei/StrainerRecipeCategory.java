package com.benbenlaw.strainers.integration.jei;

import com.benbenlaw.opolisutilities.integration.jei.OpolisIRecipeSlotTooltipCallback;
import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.recipe.StrainerRecipe;
import com.benbenlaw.strainers.util.ModTags;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotTooltipCallback;
import mezz.jei.api.gui.ingredient.IRecipeSlotView;
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
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.awt.*;

public class StrainerRecipeCategory implements IRecipeCategory<StrainerRecipe> {
    public final static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "strainer");
    public final static ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "textures/gui/jei_strainer.png");

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

        if (recipe.getMinMeshTier() == 1) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_1_MESHES))

                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Minimum Mesh Tier 1"));
                        }
                    });
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())

                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                            iTooltipBuilder.add(Component.literal("Press §eSHIFT§r for more Information"));
                        }
                    });
        }
        if (recipe.getMinMeshTier() == 2) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_2_MESHES))
                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Minimum Mesh Tier 2"));
                        }
                    });
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())
                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                            iTooltipBuilder.add(Component.literal("Press §eSHIFT§r for more Information"));
                        }
                    });
        }
        if (recipe.getMinMeshTier() == 3) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_3_MESHES))
                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Minimum Mesh Tier 3"));
                        }
                    });
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())
                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                            iTooltipBuilder.add(Component.literal("Press §eSHIFT§r for more Information"));
                        }
                    });
        }
        if (recipe.getMinMeshTier() == 4) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_4_MESHES))
                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Minimum Mesh Tier 4"));
                        }
                    });
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())
                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                            iTooltipBuilder.add(Component.literal("Press §eSHIFT§r for more Information"));
                        }
                    });
        }
        if (recipe.getMinMeshTier() == 5) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_5_MESHES))
                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Minimum Mesh Tier 5"));
                        }
                    });
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())
                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                            iTooltipBuilder.add(Component.literal("Press §eSHIFT§r for more Information"));
                        }
                    });
        }
        if (recipe.getMinMeshTier() == 6) {
            builder.addSlot(RecipeIngredientRole.INPUT, 25, 23).addIngredients(Ingredient.of(ModTags.Items.TIER_6_MESHES))
                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Minimum Mesh Tier 6"));
                        }
                    });
            builder.addSlot(RecipeIngredientRole.OUTPUT, 161, 23).addItemStack(recipe.getOutput())
                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Default Chance: " +  ((int) (recipe.getOutputChance() * 100)) + "%"));
                            iTooltipBuilder.add(Component.literal("Press §eSHIFT§r for more Information"));
                        }
                    });
        }

        Block blockInRecipe = recipe.getBlockAbove();

        if(!blockInRecipe.asItem().equals(Items.AIR)) {
            builder.addSlot(RecipeIngredientRole.CATALYST, 4, 3).addItemStack(blockInRecipe.asItem().getDefaultInstance())
                    .addTooltipCallback(new OpolisIRecipeSlotTooltipCallback() {
                        @Override
                        public void onRichTooltip(IRecipeSlotView iRecipeSlotView, ITooltipBuilder iTooltipBuilder) {
                            iTooltipBuilder.add(Component.literal("Place above the strainer"));
                        }
                    });
        }

        Fluid fluid = recipe.getFluidAbove();
        builder.addSlot(RecipeIngredientRole.INPUT, 4, 3).addFluidStack(fluid
                , 1000).setFluidRenderer(1000, true, 16,16);

    }

    @Override
    public void draw(StrainerRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {

        @Nonnull final Minecraft minecraft = Minecraft.getInstance();

        if (!recipe.getBlockAbove().isEmpty(Blocks.AIR.defaultBlockState())) {
            guiGraphics.drawString(minecraft.font.self(), Component.translatable("jei.strainer.place_block"), 25, 6, Color.WHITE.getRGB());
        }

        if (!recipe.getFluidAbove().isSame(recipe.getFluidAbove())) {
            guiGraphics.drawString(minecraft.font.self(), Component.translatable("jei.strainer.place_fluid"), 25, 6, Color.WHITE.getRGB());
        }

        int duration = 220;
        guiGraphics.drawString(minecraft.font.self(), Component.literal(duration + " ticks"), 77, 26, Color.WHITE.getRGB());
    }
}
