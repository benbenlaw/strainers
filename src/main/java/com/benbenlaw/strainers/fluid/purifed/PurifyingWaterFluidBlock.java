package com.benbenlaw.strainers.fluid.purifed;

import com.benbenlaw.strainers.fluid.ModFluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class PurifyingWaterFluidBlock extends LiquidBlock {

    public PurifyingWaterFluidBlock() {
        super(ModFluids.PURIFYING_WATER_FLUID_SOURCE.get(), Properties.of()
                .mapColor(MapColor.COLOR_PINK)
                .replaceable()
                .noCollission()
                .strength(100.0F)
                .pushReaction(PushReaction.DESTROY)
                .noLootTable()
                .liquid()
                .sound(SoundType.EMPTY)
        );
    }
}
