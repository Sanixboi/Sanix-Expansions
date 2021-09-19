package net.Sanix.Expansions.items.runes;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SaturationRune extends Item {
    public SaturationRune(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        StatusEffectInstance instance = new StatusEffectInstance(StatusEffects.SATURATION, 20 * 5, 1);
        user.addStatusEffect(instance);
        return TypedActionResult.success(user.getStackInHand(hand));
    }


}
