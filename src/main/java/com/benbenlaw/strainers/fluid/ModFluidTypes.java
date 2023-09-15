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

import java.awt.*;

public class ModFluidTypes {

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation ERODING_OVERLAY_RL = new ResourceLocation(Strainers.MOD_ID, "misc/in_eroding_water");
    public static final ResourceLocation PURIFIED_OVERLAY_RL = new ResourceLocation(Strainers.MOD_ID, "misc/in_purified_water");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Strainers.MOD_ID);


    //Eroding Water

    public static final RegistryObject<FluidType> ERODING_WATER_FLUID_TYPE = register("eroding_water_fluid",
            0XBFB2B6DA,
            FluidType.Properties.create().lightLevel(0).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK).sound(SoundAction.get("pick_up"), SoundEvents.BUCKET_FILL), ERODING_OVERLAY_RL);

    //Purified Water

    public static final RegistryObject<FluidType> PURIFIED_WATER_FLUID_TYPE = register("purified_water_fluid",
            0XA1E038D0,
            FluidType.Properties.create().lightLevel(0).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.HONEY_DRINK).sound(SoundAction.get("pick_up"), SoundEvents.BUCKET_FILL), PURIFIED_OVERLAY_RL);

















    private static RegistryObject<FluidType> register(String name, int color, FluidType.Properties properties, ResourceLocation overlay) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, overlay,
                color, new Vector3f(254.0f / 255.0f, 208.0f / 255.0f, 208.0f / 255.0f), properties));
    }





    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
