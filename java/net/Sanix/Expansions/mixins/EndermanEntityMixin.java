package net.Sanix.Expansions.mixins;

import net.Sanix.Expansions.registries.ModArmor;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin {

    @Inject(at = @At("HEAD"), method = "isPlayerStaring", cancellable = true)
    public void isstaredat(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        Item hs = player.getEquippedStack(EquipmentSlot.HEAD).getItem();
        if (hs.equals(ModArmor.CRUDEMEDIUM_HELMET) || hs.equals(ModArmor.SUPERICIO_HELMET) || hs.equals(ModArmor.SUPREVICIO_HELMET) || hs.equals(ModArmor.SANISANIUM_HELMET) || hs.equals(ModArmor.EMPOWERED_SOULIUS_HELMET)) cir.setReturnValue(false);
    }
}
