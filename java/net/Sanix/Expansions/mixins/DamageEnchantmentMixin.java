package net.Sanix.Expansions.mixins;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin extends Enchantment {
    public final int typeIndex;

    protected DamageEnchantmentMixin(Rarity weight, int typeindex, EquipmentSlot[] slotTypes) {
        super(weight, EnchantmentTarget.WEAPON, slotTypes);
        this.typeIndex = typeindex;
    }

    //used to be an overwrite but this is better... might be part of a rune if possible (prob not)
    @Inject(at = @At(value = "HEAD"), method = "getAttackDamage", cancellable = true)
    public void getAttackDamage(int level, EntityGroup group, CallbackInfoReturnable<Float> cir) {
        if (this.typeIndex == 0) {
            cir.setReturnValue((float)Math.max(0, level) * 1.25F);
        } else if (this.typeIndex == 1 && group == EntityGroup.UNDEAD) {
            cir.setReturnValue((float)level * 2.5F);
        } else {
            cir.setReturnValue(this.typeIndex == 2 && group == EntityGroup.ARTHROPOD ? (float)level * 2.5F : 0.0F);
        }

    }

}
