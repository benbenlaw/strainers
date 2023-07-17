package com.benbenlaw.strainers.recipe;

import com.benbenlaw.strainers.Strainers;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER=
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Strainers.MOD_ID);

    public static final RegistryObject<RecipeSerializer<StrainerRecipe>> STRAINERS_SERIALIZER =
            SERIALIZER.register("strainer", () -> StrainerRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZER.register(eventBus);
    }


}