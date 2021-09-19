package net.Sanix.Expansions.mixins;

import net.Sanix.Expansions.materials.ModdedArmorMaterials;
import net.Sanix.Expansions.materials.ModdedToolMaterials;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Shadow public abstract Item getItem();

    //huh this looks simular to how there's a 2% chance to break when damaged(Hell Difficulty) but it's an inject instead...
    @Inject(at = @At("HEAD"), method = "damage(ILjava/util/Random;Lnet/minecraft/server/network/ServerPlayerEntity;)Z", cancellable = true)
    public void damage(int amount, Random random, ServerPlayerEntity player, CallbackInfoReturnable<Boolean> info) {
        if (getItem() instanceof ToolItem) {
            if(((ToolItem)getItem()).getMaterial().equals(ModdedToolMaterials.SUPREVICIO) || ((ToolItem) getItem()).getMaterial().equals(ModdedToolMaterials.SANISANIUM) || ((ToolItem) getItem()).getMaterial().equals(ModdedToolMaterials.EMPOWERED_SOULIUS)) {
                info.cancel();
            }
        }

        if (getItem() instanceof ArmorItem) {
            if (((ArmorItem)getItem()).getMaterial().equals(ModdedArmorMaterials.SANISANIUM) || ((ArmorItem)getItem()).getMaterial().equals(ModdedArmorMaterials.EMPOWERED_SOULIUS)) {
                info.cancel();
            }
        }

    }
}
