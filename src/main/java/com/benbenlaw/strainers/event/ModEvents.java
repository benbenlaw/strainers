package com.benbenlaw.strainers.event;

import com.benbenlaw.strainers.Strainers;
import com.benbenlaw.strainers.fluid.ModFluids;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = Strainers.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void isInModdedWater(PlayerTickEvent.Post event) {

        Player player = event.getEntity();

        /*

        if (!player.level().isClientSide()) {

            if (player.isInFluidType(ModFluids.ERODING_WATER_FLUID_TYPE.get())) {
                player.re();
            }
            if (player.isInFluidType(ModFluids.ERODING_WATER_FLUID_TYPE.get())) {
                player.resetFallDistance();
            }
            if (player.isInWater()) {
                player.resetFallDistance();
            }
        }
        
         */
    }

}
