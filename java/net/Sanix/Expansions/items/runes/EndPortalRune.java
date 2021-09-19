package net.Sanix.Expansions.items.runes;

import net.Sanix.Expansions.registries.ModItemGroups;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EndPortalRune extends Item {

	public EndPortalRune() {
		super(new Item.Settings().group(ModItemGroups.RUNES).maxCount(1));
	}
	

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

		System.out.println(world.getDimension());
		//this is so people can't use this in the end to break bedrock/portal frames but it allows you to go down without regenerating the platform. Interesting...
		if (!world.isClient && world.getServer() != null) {
			if (!world.getDimension().isBedWorking() && !world.getDimension().isRespawnAnchorWorking()) {
				//public static final RegistryKey<World> field_25179; overworld
				//public static final RegistryKey<World> field_25180; the nether
				//public static final RegistryKey<World> field_25181; end
				//Mojang will probably change this...
				//and they did -_-
				//it's fine actually now fine since I learned things from Hell Difficulty
				// and it helped me implement this
				//changedimension is now movetoWorld, makes more sense



				user.moveToWorld(world.getServer().getWorld(World.OVERWORLD));
				} else {
					user.moveToWorld(world.getServer().getWorld(World.END));
				}
			}

		return super.use(world, user, hand);
		}



}

