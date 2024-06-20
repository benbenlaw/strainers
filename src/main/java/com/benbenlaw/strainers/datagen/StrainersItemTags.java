package com.benbenlaw.strainers.datagen;

import com.benbenlaw.opolisutilities.OpolisUtilities;
import com.benbenlaw.opolisutilities.item.ModItems;
import com.benbenlaw.opolisutilities.util.ModTags;
import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class StrainersItemTags extends ItemTagsProvider {

    StrainersItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags.contentsGetter(), Strainers.MOD_ID, existingFileHelper);
    }
    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {

        //Enchantments

        //Banned In Block Placer
        tag(ModTags.Items.BANNED_IN_BLOCK_PLACER)
                .add(ModBlocks.WOODEN_STRAINER.asItem())
                .add(ModBlocks.STRAINER_TANK.asItem())
       ;
    }

    @Override
    public @NotNull String getName() {
        return Strainers.MOD_ID + " Item Tags";
    }
}
