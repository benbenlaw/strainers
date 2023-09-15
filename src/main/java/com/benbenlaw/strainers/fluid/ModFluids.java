package com.benbenlaw.strainers.fluid;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.block.ModBlocks;
import com.benbenlaw.strainers.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Strainers.MOD_ID);

    //Eroding Water

    public static final RegistryObject<FlowingFluid> SOURCE_ERODING_WATER = FLUIDS.register("eroding_water_fluid",
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
    }
}