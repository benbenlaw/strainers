package com.benbenlaw.strainers.fluid;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.fluid.eroding.ErodingWaterFluid;
import com.benbenlaw.strainers.fluid.eroding.ErodingWaterFluidBlock;
import com.benbenlaw.strainers.fluid.eroding.ErodingWaterFluidType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(BuiltInRegistries.FLUID, Strainers.MOD_ID);

    public static final DeferredRegister.Blocks FLUID_BLOCKS =
            DeferredRegister.createBlocks(Strainers.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(NeoForgeRegistries.Keys.FLUID_TYPES, Strainers.MOD_ID);




    //Eroding Water

    public static final DeferredHolder<FluidType, FluidType> ERODING_WATER_FLUID_TYPE = FLUID_TYPES.register("eroding_water_fluid_type",
            ErodingWaterFluidType::new);
    public static final DeferredHolder<Fluid, ErodingWaterFluid> ERODING_WATER_FLUID_FLOWING = FLUIDS.register("eroding_water_fluid_flowing",
            ErodingWaterFluid.Flowing::new);
    public static final DeferredHolder<Fluid, ErodingWaterFluid> ERODING_WATER_FLUID_SOURCE = FLUIDS.register("eroding_water_fluid_source",
            ErodingWaterFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> ERODING_WATER_FLUID_BLOCK = FLUID_BLOCKS.register("eroding_water_fluid_block",
            ErodingWaterFluidBlock::new);


    /*
    public static final DeferredHolder<FlowingFluid, FlowingFluid> SOURCE_ERODING_WATER = FLUIDS.register("eroding_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.ERODING_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_ERODING_WATER = FLUIDS.register("flowing_eroding_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.ERODING_WATER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties ERODING_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.ERODING_WATER_FLUID_TYPE, SOURCE_ERODING_WATER, FLOWING_ERODING_WATER)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2)
            .block(ModBlocks.ERODING_WATER_BLOCK)
            .bucket(ModItems.ERODING_WATER_BUCKET);
    
    //Purified Water

    public static final RegistryObject<FlowingFluid> SOURCE_PURIFIED_WATER = FLUIDS.register("purified_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.PURIFIED_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_PURIFIED_WATER = FLUIDS.register("flowing_purified_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.PURIFIED_WATER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties PURIFIED_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.PURIFIED_WATER_FLUID_TYPE, SOURCE_PURIFIED_WATER, FLOWING_PURIFIED_WATER)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2)
            .block(ModBlocks.PURIFIED_WATER_BLOCK)
            .bucket(ModItems.PURIFIED_WATER_BUCKET);


    //Purified Water
    /*

    public static final RegistryObject<FlowingFluid> SOURCE_PURIFIED_WATER = FLUIDS.register("purified_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.PURIFIED_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_PURIFIED_WATER = FLUIDS.register("flowing_purified_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.PURIFIED_WATER_FLUID_PROPERTIES));

    public static final ForgeFlowingFluid.Properties PURIFIED_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.LIGHTNING_WATER_FLUID_TYPE, SOURCE_PURIFIED_WATER, FLOWING_PURIFIED_WATER)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(2)
            .block(ModBlocks.PURIFIED_WATER_BLOCK)
            .bucket(ModItems.PURIFIED_WATER_BUCKET);

     */


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
        FLUID_BLOCKS.register(eventBus);
        FLUID_TYPES.register(eventBus);
    }
}