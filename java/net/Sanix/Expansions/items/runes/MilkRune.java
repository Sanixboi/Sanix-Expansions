package net.Sanix.Expansions.items.runes;

import net.Sanix.Expansions.registries.ModItemGroups;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MilkRune extends Item{
	
	public MilkRune() {
		super(new Item.Settings().group(ModItemGroups.RUNES).maxCount(1));
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		user.clearStatusEffects();
		user.playSound(getDrinkSound(), 1f, 1f);
		return super.use(world, user, hand);
	}
}
