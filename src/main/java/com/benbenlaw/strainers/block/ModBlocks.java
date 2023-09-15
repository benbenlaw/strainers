package com.benbenlaw.strainers.block;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.custom.MulchBlock;
import com.benbenlaw.strainers.block.custom.SummoningBlock;
import com.benbenlaw.strainers.block.custom.WoodenStrainerBlock;
import com.benbenlaw.strainers.fluid.ModFluids;
import com.benbenlaw.strainers.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Strainers.MOD_ID);

    //New Blocks

    public static final RegistryObject<Block> WOODEN_STRAINER = registerBlock("wooden_strainer",
            () -> new WoodenStrainerBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE).strength(0.5f).sound(SoundType.WOOD)
                    .noOcclusion()));

    public static final RegistryObject<Block> MULCH = registerBlock("mulch",
            () -> new MulchBlock(BlockBehaviour.Properties.copy(Blocks.MOSS_BLOCK).strength(0.5f).sound(SoundType.PACKED_MUD)));

    public static final RegistryObject<Block> SUMMONING_BLOCK = registerBlock("summoning_block",
            () -> new SummoningBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(0.5f).sound(SoundType.NETHERRACK)));



    //New Fluid Blocks

    public static final RegistryObject<LiquidBlock> ERODING_WATER_BLOCK = BLOCKS.register("eroding_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_ERODING_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));
    
    public static final RegistryObject<LiquidBlock> PURIFIED_WATER_BLOCK = BLOCKS.register("purified_water_block",
            () -> new LiquidBlock(ModFluids.SOURCE_PURIFIED_WATER, BlockBehaviour.Properties.copy(Blocks.WATER)));












    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, String tooltipKey) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(Component.literal(tooltipKey));
            }
        });

    }

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
