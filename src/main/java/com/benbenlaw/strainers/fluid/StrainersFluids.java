package com.benbenlaw.strainers.fluid;

import com.benbenlaw.opolisutilities.fluid.FluidDeferredRegister;
import com.benbenlaw.opolisutilities.fluid.FluidRegistryObject;
import com.benbenlaw.strainers.Strainers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BucketItem;
 import net.minecraft.world.level.block.LiquidBlock;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;


public class StrainersFluids {
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(Strainers.MOD_ID);

    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> ERODING_WATER;


    public static final FluidRegistryObject<FluidDeferredRegister.OpolisUtilitiesFluidTypes, BaseFlowingFluid.Source,
            BaseFlowingFluid.Flowing, LiquidBlock, BucketItem> PURIFYING_WATER;

    private StrainersFluids() {
    }

    static {
        ERODING_WATER = FLUIDS.register("eroding_water", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "block/eroding_water_still"),
                        ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "block/eroding_water_flow")));

        PURIFYING_WATER = FLUIDS.register("purifying_water", (renderProperties) ->
                renderProperties.texture(ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "block/purifying_water_still"),
                        ResourceLocation.fromNamespaceAndPath(Strainers.MOD_ID, "block/purifying_water_flow")));


    }
}