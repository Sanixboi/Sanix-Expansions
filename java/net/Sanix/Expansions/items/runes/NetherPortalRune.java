package net.Sanix.Expansions.items.runes;

import net.Sanix.Expansions.registries.ModItemGroups;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class NetherPortalRune extends Item{
	
	public NetherPortalRune() {
		super(new Item.Settings().group(ModItemGroups.RUNES).maxCount(1));
	}



	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (world.getDimension().isRespawnAnchorWorking()) {
			if (!world.isClient && world.getServer() != null) {
				user.moveToWorld(world.getServer().getWorld(World.OVERWORLD));
			}
		} else if (world.getDimension().isBedWorking()) {
			if (!world.isClient && world.getServer() != null) {
				user.moveToWorld(world.getServer().getWorld(World.NETHER));
			}
		}

		return super.use(world, user, hand);
	}
}
