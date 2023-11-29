package com.benbenlaw.strainers.integration.jei;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
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

public class SummoningRecipeCategory implements IRecipeCategory<SummoningRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(Strainers.MOD_ID, "summoning");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(Strainers.MOD_ID, "textures/gui/jei_summoning_block.png");

    static final RecipeType<SummoningRecipe> RECIPE_TYPE = RecipeType.create(Strainers.MOD_ID, "summoning",
            SummoningRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SummoningRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 103, 40);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.SUMMONING_BLOCK.get()));
    }

    @Override
    public RecipeType<SummoningRecipe> getRecipeType() {
        return JEIStrainersPlugin.SUMMONING;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Summoning");
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
    public void setRecipe(IRecipeLayoutBuilder builder, SummoningRecipe recipe, @NotNull IFocusGroup focusGroup) {

        builder.addSlot(RecipeIngredientRole.INPUT, 40, 13).addIngredients(recipe.getInputItem().get(0));

       String blockBelow = recipe.getBlockBelow();
       Block blockBelowAsBlock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(blockBelow));

       assert blockBelowAsBlock != null;
       if (!blockBelowAsBlock.asItem().equals(Items.AIR)) {
           builder.addSlot(RecipeIngredientRole.CATALYST, 4, 23).addItemStack(new ItemStack(blockBelowAsBlock));
       }


       Fluid fluid = ForgeRegistries.FLUIDS.getValue(new ResourceLocation(recipe.getFluidBelow()));
       assert fluid != null;
       builder.addSlot(RecipeIngredientRole.CATALYST, 4, 23).addFluidStack(fluid
               , 1000).setFluidRenderer(1000, true, 16,16);



       builder.addSlot(RecipeIngredientRole.INPUT, 4, 3).addItemStack(new ItemStack(ModBlocks.SUMMONING_BLOCK.get()));

       @Nullable EntityType<?> entity = ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(recipe.getSummonedMob()));
       assert entity != null;
       builder.addSlot(RecipeIngredientRole.OUTPUT, 84, 13).addItemStack(new ItemStack(recipe.getInputItem().get(1).getItems()[0].getItem())
               .setHoverName(Component.literal("Summon " + entity.getDescription().getString())));

    }

}
