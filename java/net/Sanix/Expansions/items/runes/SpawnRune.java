package net.Sanix.Expansions.items.runes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class SpawnRune extends Item {
    public SpawnRune(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            MinecraftServer server = world.getServer();
            assert server != null;
            if (!world.getDimension().isBedWorking()) {
                user.moveToWorld(server.getWorld(World.OVERWORLD));
            }
            BlockPos pos = ((ServerWorld)world).getSpawnPos();
            user.teleport(pos.getX(), pos.getY(), pos.getZ(), true);
            return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
        }
        return new TypedActionResult<>(ActionResult.PASS, user.getStackInHand(hand));
    }
}
