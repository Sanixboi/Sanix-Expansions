package net.Sanix.Expansions.misc;

import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;

public interface ModdedFertilizable {
    boolean isMagicFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient);

    boolean isMysticalFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient);

    boolean isCrystallizedFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient);

    boolean canGrow(World world, Random random, BlockPos pos, BlockState state);

    void grow(ServerWorld world, Random random, BlockPos pos, BlockState state);
}
