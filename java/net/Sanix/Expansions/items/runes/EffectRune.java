package net.Sanix.Expansions.items.runes;

import net.Sanix.Expansions.registries.ModArmor;
import net.Sanix.Expansions.registries.ModItems;
import net.Sanix.Expansions.registries.ModRunes;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EffectRune extends Item {
    public EffectRune(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack hs = user.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack cs = user.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack ls = user.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack boots = user.getEquippedStack(EquipmentSlot.FEET);
        boolean containsskydiamondarmor = hs.getItem().equals(ModArmor.SKY_DIAMOND_HELMET) && cs.getItem().equals(ModArmor.SKY_DIAMOND_CHESTPLATE) && ls.getItem().equals(ModArmor.SKY_DIAMOND_LEGGINGS) && boots.getItem().equals(ModArmor.SKY_DIAMOND_BOOTS);
        if (hs.getItem().equals(ModArmor.SKY_DIAMOND_HELMET) && cs.getItem().equals(ModArmor.SKY_DIAMOND_CHESTPLATE) && ls.getItem().equals(ModArmor.SKY_DIAMOND_LEGGINGS) && boots.getItem().equals(ModArmor.SKY_DIAMOND_BOOTS)) {
            if (user.getStackInHand(hand).getItem().equals(ModRunes.SLOWNESS_RUNE_TIER_1)) {
                user.removeStatusEffect(StatusEffects.SLOWNESS);
            } else if (user.getStackInHand(hand).getItem().equals(ModRunes.NAUSEA_RUNE_TIER_1)) {
                user.removeStatusEffect(StatusEffects.NAUSEA);
            } else if (user.getStackInHand(hand).getItem().equals(ModRunes.POISON_RUNE_TIER_1)) {
                user.removeStatusEffect(StatusEffects.POISON);
            } else if (user.getStackInHand(hand).getItem().equals(ModRunes.BAD_OMEN_RUNE_TIER_1)) {
                user.removeStatusEffect(StatusEffects.BAD_OMEN);
            } else if (user.getStackInHand(hand).getItem().equals(ModRunes.GLOWING_RUNE_TIER_1)) {
                user.removeStatusEffect(StatusEffects.GLOWING);
            } else if (user.getStackInHand(hand).getItem().equals(ModRunes.BLINDNESS_RUNE_TIER_1)) {
                user.removeStatusEffect(StatusEffects.BLINDNESS);
            } else if (user.getStackInHand(hand).getItem().equals(ModRunes.MINING_FATIGUE_RUNE_TIER_1)) {
                user.removeStatusEffect(StatusEffects.MINING_FATIGUE);
            } else if (user.getStackInHand(hand).getItem().equals(ModRunes.HUNGER_RUNE_TIER_1)) {
                user.removeStatusEffect(StatusEffects.HUNGER);
            } else if (user.getStackInHand(hand).getItem().equals(ModRunes.WEAKNESS_RUNE_TIER_1)) {
                user.removeStatusEffect(StatusEffects.WEAKNESS);
            } else if (user.getStackInHand(hand).getItem().equals(ModRunes.WITHER_RUNE_TIER_1)) {
                user.removeStatusEffect(StatusEffects.WITHER);
            }

            return TypedActionResult.success(user.getStackInHand(hand));
        }
        return super.use(world, user, hand);
    }
}
