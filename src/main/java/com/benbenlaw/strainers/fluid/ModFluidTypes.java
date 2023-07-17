package com.benbenlaw.strainers.fluid;

import com.benbenlaw.strainers.Strainers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation LIGHTNING_OVERLAY_RL = new ResourceLocation(Strainers.MOD_ID, "misc/in_eroding_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Strainers.MOD_ID);

    public static final RegistryObject<FluidType> LIGHTNING_WATER_FLUID_TYPE = register("lightning_water_fluid",
            FluidType.Properties.create().lightLevel(0).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK).sound(SoundAction.get("pick_up"), SoundEvents.BUCKET_FILL));

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, LIGHTNING_OVERLAY_RL,
                0XBFB2B6DA, new Vector3f(254.0f / 255.0f, 208.0f / 255.0f, 208.0f / 255.0f), properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }



}
