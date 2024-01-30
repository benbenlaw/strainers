package com.benbenlaw.strainers.integration.jei;

import com.benbenlaw.opolisutilities.integration.jei.UpgradeRecipeUtilCategory;
import com.benbenlaw.opolisutilities.recipe.UpgradeRecipeUtil;
import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.recipe.StrainerRecipe;
import com.benbenlaw.strainers.recipe.SummoningRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIStrainersPlugin implements IModPlugin {

    public static RecipeType<StrainerRecipe> STRAINER =
            new RecipeType<>(StrainerRecipeCategory.UID, StrainerRecipe.class);

    public static RecipeType<SummoningRecipe> SUMMONING =
            new RecipeType<>(SummoningRecipeCategory.UID, SummoningRecipe.class);

    /*
    public static RecipeType<UpgradeRecipeUtil> UPGRADES =
            new RecipeType<>(UpgradeRecipeCategory.UID, UpgradeRecipeUtil.class);

     */

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Strainers.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.WOODEN_STRAINER.get()), StrainerRecipeCategory.RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.SUMMONING_BLOCK.get()), SummoningRecipeCategory.RECIPE_TYPE);

    ///    registration.addRecipeCatalyst(new ItemStack(ModBlocks.MULCH.get()), UpgradeRecipeCategory.RECIPE_TYPE);

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {

        registration.addRecipeCategories(new
                StrainerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new
                SummoningRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

    //    registration.addRecipeCategories(new
     //           UpgradeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));

    }
    @Override
    public void registerRecipes(IRecipeRegistration registration) {

        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        List<StrainerRecipe> recipes = rm.getAllRecipesFor(StrainerRecipe.Type.INSTANCE);
        registration.addRecipes(STRAINER, recipes);

        List<SummoningRecipe> recipes1 = rm.getAllRecipesFor(SummoningRecipe.Type.INSTANCE);
        registration.addRecipes(SUMMONING, recipes1);

   //     List<UpgradeRecipeUtil> recipes2 = rm.getAllRecipesFor(UpgradeRecipeUtil.Type.INSTANCE);
    //    registration.addRecipes(UPGRADES, recipes2);

    }
}
