package com.benbenlaw.strainers.integration.jei;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.fluid.StrainersFluids;
import com.benbenlaw.strainers.item.ModItems;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

@JeiPlugin
public class InformationJEI implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "information");
    }

    @Override
    public void registerRecipes(IRecipeRegistration reg) {

        ItemStack[] purifyingItems = new ItemStack[] {
                ModItems.PURIFYING_SALT_MULCH.get().asItem().getDefaultInstance(),
          //      ModItems.PURIFIED_WATER_BUCKET.get().asItem().getDefaultInstance()
        };

        for (ItemStack item : purifyingItems) {
            reg.addIngredientInfo(item, VanillaTypes.ITEM_STACK, Component.translatable("jei.strainers.purified_water")
            );
        }

        ItemStack[] erodingItems = new ItemStack[] {
                ModItems.ERODING_SALT_MULCH.get().asItem().getDefaultInstance(),
                StrainersFluids.ERODING_WATER.getBucket().asItem().getDefaultInstance()
        };

        for (ItemStack item : erodingItems) {
            reg.addIngredientInfo(item, VanillaTypes.ITEM_STACK, Component.translatable("jei.strainers.eroding_water")
            );
        }

        reg.addIngredientInfo(ModBlocks.MULCH.get().asItem().getDefaultInstance(), VanillaTypes.ITEM_STACK,
                Component.translatable("jei.strainers.mulch_block"));




    }
}
