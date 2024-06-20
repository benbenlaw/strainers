package com.benbenlaw.strainers.fluid.eroding;

import com.benbenlaw.strainers.fluid.ModFluids;
import com.benbenlaw.strainers.item.ModItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import org.jetbrains.annotations.NotNull;

public class ErodingWaterFluid extends BaseFlowingFluid {

    public static final Properties PROPERTIES = new Properties(
            ModFluids.ERODING_WATER_FLUID_TYPE,
            ModFluids.ERODING_WATER_FLUID_FLOWING,
            ModFluids.ERODING_WATER_FLUID_SOURCE).bucket(ModItems.ERODING_WATER_BUCKET).block(ModFluids.ERODING_WATER_FLUID_BLOCK)


    ;

    protected ErodingWaterFluid(Properties properties) {
        super(properties);
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.ERODING_WATER_FLUID_FLOWING.get();
    }

    @Override
    public Fluid getSource() {
        return ModFluids.ERODING_WATER_FLUID_SOURCE.get();
    }

    @Override
    public Item getBucket() {
        return ModItems.ERODING_WATER_BUCKET.get();
    }

    @Override
    public boolean isSource(FluidState p_76140_) {
        return false;
    }

    @Override
    protected boolean canConvertToSource(Level pLevel) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_164509_) {
        return 0;
    }

    public static class Flowing extends ErodingWaterFluid {
        public Flowing() {
            super(PROPERTIES);
        }

        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> pBuilder) {
            super.createFluidStateDefinition(pBuilder);
            pBuilder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState pState) {
            return pState.getValue(LEVEL);
        }

        @Override
        public boolean isSource(@NotNull FluidState pState) {
            return false;
        }


    }

    public static class Source extends ErodingWaterFluid {
        public Source() {
            super(PROPERTIES);
        }

        @Override
        public int getAmount(FluidState pState) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState pState) {
            return true;
        }
    }
}
