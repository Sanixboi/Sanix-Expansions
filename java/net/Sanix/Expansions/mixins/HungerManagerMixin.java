package net.Sanix.Expansions.mixins;

import net.Sanix.Expansions.registries.ModArmor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HungerManager.class)
public abstract class HungerManagerMixin {

    @Shadow private int foodTickTimer;

    @Shadow private float foodSaturationLevel;

    @Shadow private int foodLevel;

    @Shadow public abstract void addExhaustion(float exhaustion);

    @Shadow private float exhaustion;

    @Shadow private int prevFoodLevel;

    @Inject(at = @At("HEAD"), method = "update", cancellable = true)
    public void update(PlayerEntity player, CallbackInfo info){
        Difficulty difficulty = player.world.getDifficulty();
        this.prevFoodLevel = this.foodLevel;
        if (this.exhaustion > 4.0F) {
            this.exhaustion -= 4.0F;
            if (this.foodSaturationLevel > 0.0F) {
                this.foodSaturationLevel = Math.max(this.foodSaturationLevel - 1.0F, 0.0F);
            } else if (difficulty != Difficulty.PEACEFUL) {
                this.foodLevel = Math.max(this.foodLevel - 1, 0);
            }
        }

        boolean bl = player.world.getGameRules().getBoolean(GameRules.NATURAL_REGENERATION);

        if (bl && this.foodLevel >= 10 && player.canFoodHeal()) {
            Item hi = player.getEquippedStack(EquipmentSlot.HEAD).getItem();
            Item ci = player.getEquippedStack(EquipmentSlot.CHEST).getItem();
            Item li = player.getEquippedStack(EquipmentSlot.LEGS).getItem();
            Item bi = player.getEquippedStack(EquipmentSlot.FEET).getItem();
            boolean empoweredsouliusarmor = hi.equals(ModArmor.EMPOWERED_SOULIUS_HELMET) && ci.equals(ModArmor.EMPOWERED_SOULIUS_CHESTPLATE) && li.equals(ModArmor.EMPOWERED_SOULIUS_LEGGINGS) && bi.equals(ModArmor.EMPOWERED_SOULIUS_BOOTS);
            ++this.foodTickTimer;
            if (empoweredsouliusarmor) {
                if (player.getHealth() < 25f) {
                    if (this.foodTickTimer >= 10) {
                        player.heal(1.0F);
                        this.addExhaustion(4.0F);
                        this.foodTickTimer = 0;
                    }
                } else {
                    if (this.foodTickTimer >= 20) {
                        player.heal(1.0F);
                        this.addExhaustion(4.0F);
                        this.foodTickTimer = 0;
                    }
                }
            } else {
                if (this.foodTickTimer >= 40) {
                    player.heal(1.0F);
                    this.addExhaustion(4.0F);
                    this.foodTickTimer = 0;
                }
            }

        } else if (this.foodLevel <= 0) {
            ++this.foodTickTimer;
            if (this.foodTickTimer >= 80) {
                if (player.getHealth() > 10.0F || difficulty == Difficulty.HARD || player.getHealth() > 1.0F && difficulty == Difficulty.NORMAL) {
                    player.damage(DamageSource.STARVE, 1.0F);
                }

                this.foodTickTimer = 0;
            }
        } else {
            this.foodTickTimer = 0;
        }
        info.cancel();
    }
}
