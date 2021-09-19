package net.Sanix.Expansions.fluids;

import net.Sanix.Expansions.SanixExpansions;
import net.Sanix.Expansions.registries.ModFluids;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public abstract class HyperAcid extends HyperAcidFluid {

    @Override
    public Fluid getFlowing() {
        return ModFluids.HYPER_ACID_FLOWING;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.HYPER_ACID_STILL;
    }

    @Override
    public Item getBucketItem() {
        return ModFluids.HYPER_ACID_BUCKET;
    }


    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModFluids.HYPER_ACID.getDefaultState().with(FluidBlock.LEVEL, getBlockStateLevel(state));
    }

    public static class Flowing extends HyperAcid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }
    }

    public static class Still extends HyperAcid {
        @Override
        public boolean isStill(FluidState state) {
            return true;
        }

        @Override
        public int getLevel(FluidState state) {
            return 0;
        }
    }


}
