package com.benbenlaw.strainers.datagen;


import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.opolisutilities.datagen.OpolisUtilitiesBlockTags;
import com.benbenlaw.opolisutilities.datagen.OpolisUtilitiesItemTags;
import com.benbenlaw.opolisutilities.datagen.OpolisUtilitiesRecipes;
import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.datagen.recipes.StrainersItemModelProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Strainers.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new StrainersRecipes(packOutput, event.getLookupProvider()));

        StrainersBlockTags blockTags = new StrainersBlockTags(packOutput, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);

        StrainersItemTags itemTags = new StrainersItemTags(packOutput, lookupProvider, blockTags, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), itemTags);

        generator.addProvider(event.includeClient(), new StrainersItemModelProvider(packOutput, event.getExistingFileHelper()));




    }


}
