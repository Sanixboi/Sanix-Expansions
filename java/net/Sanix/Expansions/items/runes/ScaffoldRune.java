package net.Sanix.Expansions.items.runes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class ScaffoldRune extends Item {
    public ScaffoldRune(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        NbtCompound scaffold = stack.getOrCreateSubTag("scaffold");
        return scaffold.getInt("enablescaffold") == 1;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        NbtCompound scaffold = user.getStackInHand(hand).getOrCreateSubTag("scaffold");
        if (scaffold.getInt("enablescaffold") == 1) scaffold.putInt("enablescaffold", 0); else scaffold.putInt("enablescaffold", 1);

        user.sendMessage(new TranslatableText("Scaffolding " + (scaffold.getInt("enablescaffold") == 1 ? "enabled": "disabled")), true);
        return super.use(world, user, hand);
    }
}
