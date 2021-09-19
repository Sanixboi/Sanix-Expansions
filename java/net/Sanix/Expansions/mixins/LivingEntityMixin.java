package net.Sanix.Expansions.mixins;

import net.Sanix.Expansions.registries.ModTools;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.Random;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Shadow public abstract ItemStack getActiveItem();

    @Shadow public abstract ItemStack getMainHandStack();

    @Shadow public abstract ItemStack getOffHandStack();

    @Inject(at = @At("HEAD"), method = "onDeath")
    public void onDeath(DamageSource source, CallbackInfo info) {
        /*
        Entity entity = source.getAttacker();
        assert entity != null;
        if (entity.isLiving()) {
            LivingEntity livingEntity = (LivingEntity) entity;
            if (livingEntity.getMainHandStack().getItem().equals(ModTools.SOULIUS_DAGGER)) {
                CompoundTag tag = livingEntity.getMainHandStack().getOrCreateSubTag("souliusdagger");


                int i = tag.getInt("mobcount");
                tag.putInt("mobcount", i + 1);
            }
        }

         */
    }

    private Random r = new Random();
    @Inject(at = @At("HEAD"), method = "damage")
    public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (source.getAttacker() instanceof LivingEntity) {
            LivingEntity attacker = ((LivingEntity)source.getAttacker());
            if (attacker.getMainHandStack().getItem().equals(ModTools.SUPERICIO_SWORD)) {
                int level = attacker.getStatusEffect(StatusEffects.STRENGTH) != null ? !(Objects.requireNonNull(attacker.getStatusEffect(StatusEffects.STRENGTH)).getAmplifier() > 10) ? Objects.requireNonNull(attacker.getStatusEffect(StatusEffects.STRENGTH)).getAmplifier() + 1: 10: 0;
                attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 10, level, false, false, false));
            }

            if (attacker.getMainHandStack().getItem().equals(ModTools.SUPREVICIO_SWORD)) {
                int level = attacker.getStatusEffect(StatusEffects.STRENGTH) != null ? !(Objects.requireNonNull(attacker.getStatusEffect(StatusEffects.STRENGTH)).getAmplifier() > 25) ? Objects.requireNonNull(attacker.getStatusEffect(StatusEffects.STRENGTH)).getAmplifier() + 1: 25: 0;
                attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 15, level, false, false, false));
            }

            if (attacker.getMainHandStack().getItem().equals(ModTools.SANISANIUM_SWORD)) {
                int level = attacker.getStatusEffect(StatusEffects.STRENGTH) != null ? !(Objects.requireNonNull(attacker.getStatusEffect(StatusEffects.STRENGTH)).getAmplifier() > 50) ? Objects.requireNonNull(attacker.getStatusEffect(StatusEffects.STRENGTH)).getAmplifier() + 1: 50: 0;
                attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 30, level, false, false, false));
            }

            if (attacker.getMainHandStack().getItem().equals(ModTools.EMPOWERED_SOULIUS_SWORD)) {
                int level = attacker.getStatusEffect(StatusEffects.STRENGTH) != null ? !(Objects.requireNonNull(attacker.getStatusEffect(StatusEffects.STRENGTH)).getAmplifier() > 150) ? Objects.requireNonNull(attacker.getStatusEffect(StatusEffects.STRENGTH)).getAmplifier() + 2: 150: 1;
                attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 30, level, false, false, false));
                attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 10, 1, false, false, false));
            }

            if (attacker.getMainHandStack().getItem().equals(ModTools.SUPERICIO_AXE)) {
                if (getActiveItem().getItem().equals(Items.SHIELD)) {
                    getActiveItem().damage((int) (Items.SHIELD.getMaxDamage() * 0.5), r, null);
                }
            }

            if (attacker.getMainHandStack().getItem().equals(ModTools.SUPREVICIO_AXE)) {
                if (getActiveItem().getItem().equals(Items.SHIELD)) {
                    getActiveItem().damage((int) (Items.SHIELD.getMaxDamage() * 0.8), r, null);
                }
            }

            if (attacker.getMainHandStack().getItem().equals(ModTools.SANISANIUM_AXE)) {
                if (getActiveItem().getItem().equals(Items.SHIELD)) {
                    getActiveItem().damage(Items.SHIELD.getMaxDamage(), r, null);
                }
            }

            if (attacker.getMainHandStack().getItem().equals(ModTools.EMPOWERED_SOULIUS_AXE)) {
                if (getActiveItem().getItem().equals(Items.SHIELD)) {
                    getActiveItem().damage(Items.SHIELD.getMaxDamage(), r, null);
                } else if (getActiveItem().getItem() instanceof SwordItem) {
                    getActiveItem().damage(750, r, null);
                } else {
                    getMainHandStack().damage(450, r, null);
                    getOffHandStack().damage(300, r, null);
                }
            }

        }
    }
}
