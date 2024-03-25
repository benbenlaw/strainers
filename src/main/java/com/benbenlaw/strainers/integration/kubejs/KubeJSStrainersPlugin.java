package com.benbenlaw.strainers.integration.kubejs;

import com.benbenlaw.strainers.Strainers;
import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import net.minecraft.resources.ResourceLocation;

public class KubeJSStrainersPlugin extends KubeJSPlugin {

    public static EventGroup GROUP = EventGroup.of("StrainersEvents");

    @Override
    public void registerRecipeSchemas(RegisterRecipeSchemasEvent event) {
        event.register(new ResourceLocation(Strainers.MOD_ID, "strainer"), StrainerRecipeJS.SCHEMA);
        event.register(new ResourceLocation(Strainers.MOD_ID, "summoning"), SummoningRecipeJS.SCHEMA);
    }

    @Override
    public void registerEvents() {
        GROUP.register();
    }
}


