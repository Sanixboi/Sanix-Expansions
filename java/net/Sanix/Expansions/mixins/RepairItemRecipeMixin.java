package net.Sanix.Expansions.mixins;

import net.Sanix.Expansions.items.CraftingDamagableItem;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.recipe.RepairItemRecipe;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RepairItemRecipe.class)
public class RepairItemRecipeMixin {

    @Inject(at = @At("HEAD"), method = "matches", cancellable = true)
    public void cancelRecipe(CraftingInventory craftingInventory, World world, CallbackInfoReturnable<Boolean> cir){
        for (int i = 0; i < craftingInventory.size(); i++) {
            if (craftingInventory.getStack(i).getItem() instanceof CraftingDamagableItem) {
                cir.setReturnValue(false);
            }
        }
    }

}
