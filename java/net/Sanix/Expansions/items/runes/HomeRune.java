package net.Sanix.Expansions.items.runes;

import net.Sanix.Expansions.registries.ModItemGroups;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;

import java.util.List;

public class HomeRune extends Item{
	private NbtCompound compoundTag;
	private ItemStack item;
	public HomeRune() {
		super(new Item.Settings().group(ModItemGroups.RUNES).maxCount(1));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		int ticks = 0;
		MinecraftServer server = world.getServer();
		item = user.getStackInHand(hand);
		compoundTag = item.getOrCreateSubTag("homerune");
		if(compoundTag.getDouble("x") == 0.00 && compoundTag.getDouble("y") == 0.00 && compoundTag.getDouble("z") == 0.00) {
			compoundTag.putDouble("x", user.getX());
			compoundTag.putDouble("y", user.getY());
			compoundTag.putDouble("z", user.getZ());
			compoundTag.putFloat("yaw", user.getYaw(1f));
			compoundTag.putFloat("pitch", user.getPitch(1f));

			if (world.getDimension().isBedWorking()) {
				compoundTag.putString("dimension", "Overworld");
			} else if (world.getDimension().isRespawnAnchorWorking()) {
				compoundTag.putString("dimension", "Nether");
			} else {
				compoundTag.putString("dimension", "The End");
			}

			user.sendMessage(new TranslatableText("Home point set! Your home is set at: %s, %s, %s", compoundTag.getDouble("x"), compoundTag.getDouble("y"), compoundTag.getDouble("z")), false);
		}

		if (user.isSneaking()) {
			compoundTag.putDouble("x", user.getX());
			compoundTag.putDouble("y", user.getY());
			compoundTag.putDouble("z", user.getZ());
			compoundTag.putFloat("yaw", user.getYaw());
			compoundTag.putFloat("pitch", user.getPitch());

			if (world.getDimension().isBedWorking()) {
				compoundTag.putString("dimension", "Overworld");
			} else if (world.getDimension().isRespawnAnchorWorking()) {
				compoundTag.putString("dimension", "Nether");
			} else {
				compoundTag.putString("dimension", "The End");
			}

			user.sendMessage(new TranslatableText("Home point set! Your home is set at: %s, %s, %s", compoundTag.getDouble("x"), compoundTag.getDouble("y"), compoundTag.getDouble("z")), false);
		} else {

			if (!world.isClient) {
				assert server != null;
				String dimension = compoundTag.getString("dimension");
				RegistryKey<World> key = dimension.equals("Overworld") ? World.OVERWORLD: dimension.equals("Nether") ? World.NETHER: World.END;
				ServerWorld serverworld = server.getWorld(key);

				((ServerPlayerEntity)user).teleport(serverworld, compoundTag.getDouble("x"), compoundTag.getDouble("y"), compoundTag.getDouble("z"), compoundTag.getFloat("yaw"), compoundTag.getFloat("pitch"));
				world.sendEntityStatus(user, (byte)46);
			}

		}

		/*
		 {
			if (!(user.dimension == dimensionType)) {
				user.changeDimension(dimensionType);
			} else {
				user.teleport(compoundTag.getDouble("x"), compoundTag.getDouble("y"), compoundTag.getDouble("z"), true);
			}
		}
		*/

		return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
	}



	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		compoundTag = stack.getOrCreateSubTag("homerune");
		tooltip.add(new TranslatableText("item.sanixexpansions.home_rune.tooltip", Math.floor(compoundTag.getDouble("x")), Math.floor(compoundTag.getDouble("y")), Math.floor(compoundTag.getDouble("z"))));
		switch (compoundTag.getString("dimension")) {
			case "The End" -> tooltip.add(new TranslatableText("item.sanixexpansions.home_rune.tooltip_2", "The End"));
			case "Nether" -> tooltip.add(new TranslatableText("item.sanixexpansions.home_rune.tooltip_2", "The Nether"));
			case "Overworld" -> tooltip.add(new TranslatableText("item.sanixexpansions.home_rune.tooltip_2", "Overworld"));
		}

	}



}
