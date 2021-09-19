package net.Sanix.Expansions.mixins;

import net.Sanix.Expansions.items.CraftingDamagableItem;
import net.Sanix.Expansions.registries.ModItems;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.Random;


@Mixin(Recipe.class)
public interface RecipeMixin<C extends Inventory> {

    /**
     * @author Sanixboi
     * @reason Inject didn't work :|
     * **/
    @Overwrite
    default DefaultedList<ItemStack> getRemainder(C inventory) {
        Random r = new Random();
        DefaultedList<ItemStack> defaultedList = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);

        for(int i = 0; i < defaultedList.size(); ++i) {
            Item item = inventory.getStack(i).getItem();
            ItemStack stack = inventory.getStack(i);
            if (item.hasRecipeRemainder()) {
                defaultedList.set(i, new ItemStack(item.getRecipeRemainder()));
            }

            if (item.equals(ModItems.ULTIMATE_ESSENCE_CRYSTAL)) {
                defaultedList.set(i, new ItemStack(ModItems.ULTIMATE_ESSENCE_CRYSTAL));
            }

            if(item instanceof CraftingDamagableItem) {
                ItemStack stack2 = new ItemStack(item);
                stack2.setDamage(stack.getDamage());
                stack2.damage(1, r, null);
                if (stack2.getDamage() > stack.getMaxDamage()) {
                    defaultedList.set(i, ItemStack.EMPTY);
                } else defaultedList.set(i, stack2);
            }
        }

        return defaultedList;
    }
}
