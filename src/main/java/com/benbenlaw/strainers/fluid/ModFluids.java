package com.benbenlaw.strainers.fluid;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.fluid.eroding.ErodingWaterFluid;
import com.benbenlaw.strainers.fluid.eroding.ErodingWaterFluidBlock;
import com.benbenlaw.strainers.fluid.eroding.ErodingWaterFluidType;
import com.benbenlaw.strainers.fluid.purifed.PurifyingWaterFluid;
import com.benbenlaw.strainers.fluid.purifed.PurifyingWaterFluidBlock;
import com.benbenlaw.strainers.fluid.purifed.PurifyingWaterFluidType;
import net.minecraft.client.renderer.RenderType;
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

    public static final DeferredHolder<FluidType, FluidType> ERODING_WATER_FLUID_TYPE = FLUID_TYPES.register("eroding_water_fluid",
            ErodingWaterFluidType::new);
    public static final DeferredHolder<Fluid, ErodingWaterFluid> ERODING_WATER_FLUID_FLOWING = FLUIDS.register("eroding_water_fluid_flowing",
            ErodingWaterFluid.Flowing::new);
    public static final DeferredHolder<Fluid, ErodingWaterFluid> ERODING_WATER_FLUID_SOURCE = FLUIDS.register("eroding_water_fluid",
            ErodingWaterFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> ERODING_WATER_FLUID_BLOCK = FLUID_BLOCKS.register("eroding_water_fluid_block",
            ErodingWaterFluidBlock::new);

    //Purifying Water

    public static final DeferredHolder<FluidType, FluidType> PURIFYING_WATER_FLUID_TYPE = FLUID_TYPES.register("purifying_water_fluid",
            PurifyingWaterFluidType::new);
    public static final DeferredHolder<Fluid, PurifyingWaterFluid> PURIFYING_WATER_FLUID_FLOWING = FLUIDS.register("purifying_water_fluid_flowing",
            PurifyingWaterFluid.Flowing::new);
    public static final DeferredHolder<Fluid, PurifyingWaterFluid> PURIFYING_WATER_FLUID_SOURCE = FLUIDS.register("purifying_water_fluid",
            PurifyingWaterFluid.Source::new);
    public static final DeferredHolder<Block, LiquidBlock> PURIFYING_WATER_FLUID_BLOCK = FLUID_BLOCKS.register("purifying_water_fluid_block",
            PurifyingWaterFluidBlock::new);



    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
        FLUID_BLOCKS.register(eventBus);
        FLUID_TYPES.register(eventBus);
    }
}