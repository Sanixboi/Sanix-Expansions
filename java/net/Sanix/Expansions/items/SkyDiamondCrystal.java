package net.Sanix.Expansions.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.item.EndCrystalItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class SkyDiamondCrystal extends Item {
    public SkyDiamondCrystal(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        BlockPos blockPos2 = blockPos.up();
        if (!world.isAir(blockPos2)) {
            return ActionResult.FAIL;
        } else {
            double d = (double) blockPos2.getX();
            double e = (double) blockPos2.getY();
            double f = (double) blockPos2.getZ();
            List<Entity> list = world.getOtherEntities((Entity) null, new Box(d, e, f, d + 1.0D, e + 2.0D, f + 1.0D));
            if (!list.isEmpty()) {
                return ActionResult.FAIL;
            } else {
                if (world instanceof ServerWorld) {
                    EndCrystalEntity endCrystalEntity = new EndCrystalEntity(world, d + 0.5D, e, f + 0.5D);
                    world.spawnEntity(endCrystalEntity);
                }

                context.getStack().decrement(1);
                return ActionResult.success(world.isClient);
            }
        }
    }
}
