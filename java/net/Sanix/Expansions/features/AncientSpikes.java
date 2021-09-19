package net.Sanix.Expansions.features;

import com.mojang.serialization.Codec;
import net.Sanix.Expansions.registries.ModBlocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class AncientSpikes extends Feature<DefaultFeatureConfig> {
    public AncientSpikes(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos topPos = context.getWorld().getTopPosition(Heightmap.Type.WORLD_SURFACE, context.getOrigin());

        for (int i = 0; i < 3; i++) {
            context.getWorld().setBlockState(topPos.offset(Direction.NORTH, i), ModBlocks.ANCIENT_ICE.getDefaultState(), 3);
            context.getWorld().setBlockState(topPos.offset(Direction.EAST, i), ModBlocks.ANCIENT_ICE.getDefaultState(), 3);
            context.getWorld().setBlockState(topPos.offset(Direction.SOUTH, i), ModBlocks.ANCIENT_ICE.getDefaultState(), 3);
            context.getWorld().setBlockState(topPos.offset(Direction.WEST, i), ModBlocks.ANCIENT_ICE.getDefaultState(), 3);
            context.getWorld().setBlockState(topPos.offset(Direction.NORTH, i).offset(Direction.EAST, 1), ModBlocks.ANCIENT_ICE.getDefaultState(), 3);
            context.getWorld().setBlockState(topPos.offset(Direction.EAST, i).offset(Direction.NORTH, 1), ModBlocks.ANCIENT_ICE.getDefaultState(), 3);
            context.getWorld().setBlockState(topPos.offset(Direction.SOUTH, i).offset(Direction.WEST, 1), ModBlocks.ANCIENT_ICE.getDefaultState(), 3);
            context.getWorld().setBlockState(topPos.offset(Direction.WEST, i).offset(Direction.SOUTH, 1), ModBlocks.ANCIENT_ICE.getDefaultState(), 3);
        }

        return true;
    }
}
