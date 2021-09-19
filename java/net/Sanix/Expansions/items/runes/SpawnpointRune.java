package net.Sanix.Expansions.items.runes;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SpawnpointRune extends Item {
    public SpawnpointRune(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ((ServerPlayerEntity)user).setSpawnPoint(world.getRegistryKey(), user.getBlockPos(), ((ServerPlayerEntity) user).getSpawnAngle(), true, false);
        user.sendMessage(new TranslatableText("You set your spawnpoint to " + Math.floor(user.getX()) + " : " + Math.floor(user.getY()) + " : " + Math.floor(user.getZ())), true);
        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }
}
