package net.Sanix.Expansions.items.runes;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class MultiDimensionalRune extends Item {
    public MultiDimensionalRune(Settings settings) {
        super(settings);
    }



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        MinecraftServer server = world.getServer();
        ItemStack item = user.getStackInHand(hand);
        NbtCompound ct = item.getOrCreateSubTag("selecteddim");

        if (ct.getInt("dim") == 0) {
            ct.putInt("dim", 1);
        }
        if (user.isSneaking()) {
            if (!(ct.getInt("dim") == 3)) {
                ct.putInt("dim", ct.getInt("dim") + 1);
                if (ct.getInt("dim") == 2) {
                    user.sendMessage(new TranslatableText("Multi-Dimensional rune set to: The Nether"), true);
                } else if (ct.getInt("dim") == 3) {
                    user.sendMessage(new TranslatableText("Multi-Dimensional rune set to: The End"), true);
                }
            } else {
                ct.putInt("dim", 1);
                user.sendMessage(new TranslatableText("Multi-Dimensional rune set to: Overworld"), true);
            }
            return super.use(world, user, hand);
        }

        if (ct.getInt("dim") == 1) {
            if (world.getDimension().isBedWorking()) {
                user.sendMessage(new TranslatableText("You are currently in the Overworld"), true);
                return TypedActionResult.pass(user.getStackInHand(hand));
            }


            if (!world.isClient && server != null) {
                user.moveToWorld(server.getWorld(World.OVERWORLD));
            }

            return TypedActionResult.success(user.getStackInHand(hand));
        } else if (ct.getInt("dim") == 2) {
            if (world.getDimension().isRespawnAnchorWorking()) {
                user.sendMessage(new TranslatableText("You are currently in the Nether"), true);
                return TypedActionResult.pass(user.getStackInHand(hand));
            }

            if (!world.isClient && server != null) {
                user.moveToWorld(server.getWorld(World.NETHER));
            }
            return TypedActionResult.success(user.getStackInHand(hand));
        } else if (ct.getInt("dim") == 3) {
            if (!world.getDimension().isBedWorking() && !world.getDimension().isRespawnAnchorWorking()) {
                user.sendMessage(new TranslatableText("You are currently in the End"), true);
                return TypedActionResult.pass(user.getStackInHand(hand));
            }


            if (!world.isClient && server != null) {
                user.moveToWorld(server.getWorld(World.END));
            }
            return TypedActionResult.success(user.getStackInHand(hand));
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        NbtCompound ct = stack.getOrCreateSubTag("selecteddim");
        if (ct.getInt("dim") == 0) {
            ct.putInt("dim", 1);
        }
        if (ct.getInt("dim") == 1) {
            tooltip.add(new TranslatableText("Current Set Dimension: Overworld"));
        } else if (ct.getInt("dim") == 2) {
            tooltip.add(new TranslatableText("Current Set Dimension: The Nether"));
        } else if (ct.getInt("dim") == 3) {
            tooltip.add(new TranslatableText("Current Set Dimension: The End"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
