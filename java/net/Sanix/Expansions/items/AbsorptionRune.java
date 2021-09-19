package net.Sanix.Expansions.items;

import net.Sanix.Expansions.registries.ModItemGroups;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AbsorptionRune extends Item{
	
	public AbsorptionRune() {
		super(new Item.Settings().group(ModItemGroups.RUNES).maxCount(1));
	}
	
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 30, 2);
		user.addStatusEffect(effect);
		return super.use(world, user, hand);
	}
}
