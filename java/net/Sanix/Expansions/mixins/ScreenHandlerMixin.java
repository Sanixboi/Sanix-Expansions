package net.Sanix.Expansions.mixins;

import net.Sanix.Expansions.registries.ModRunes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ScreenHandler.class)
public class ScreenHandlerMixin {

    @Inject(at = @At("HEAD"), method = "canUse(Lnet/minecraft/screen/ScreenHandlerContext;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/block/Block;)Z", cancellable = true)
    private static void canUse(ScreenHandlerContext context, PlayerEntity player, Block block, CallbackInfoReturnable<Boolean> cir) {
        if (player.getInventory().contains(new ItemStack(ModRunes.CRAFTING_RUNE))) cir.setReturnValue(true);
        if (player.getInventory().contains(new ItemStack(ModRunes.ENDER_CHEST_RUNE))) cir.setReturnValue(true);
        if (player.getInventory().contains(new ItemStack(ModRunes.GRINDSTONE_RUNE))) cir.setReturnValue(true);
        if (player.getInventory().contains(new ItemStack(ModRunes.SMITHING_RUNE))) cir.setReturnValue(true);
        if (player.getInventory().contains(new ItemStack(ModRunes.ENCHANTING_RUNE))) cir.setReturnValue(true);
        if (player.getInventory().contains(new ItemStack(ModRunes.LOOM_RUNE))) cir.setReturnValue(true);
    }
}
