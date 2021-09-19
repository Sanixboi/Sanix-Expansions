package net.Sanix.Expansions.blocks.crops;

import net.Sanix.Expansions.misc.ModdedFertilizable;
import net.Sanix.Expansions.registries.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class SuprevicioSeedCrop extends CropBlock implements ModdedFertilizable {

    public SuprevicioSeedCrop(Settings settings) {
        super(settings);
    }

    @Environment(EnvType.CLIENT)
    protected ItemConvertible getSeedsItem() {
        return ModItems.SUPREVICIO_SEEDS;
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    public boolean isMagicFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean isMysticalFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }

    @Override
    public boolean isCrystallizedFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }
}
