package com.benbenlaw.strainers.block.entity;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Strainers.MOD_ID);

    public static final RegistryObject<BlockEntityType<WoodenStrainerBlockEntity>> WOODEN_STRAINER_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("wooden_strainer_block_entity", () ->
                    BlockEntityType.Builder.of(WoodenStrainerBlockEntity::new,
                            ModBlocks.WOODEN_STRAINER.get()).build(null));




    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
