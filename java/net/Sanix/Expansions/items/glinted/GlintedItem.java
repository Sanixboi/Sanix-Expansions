package net.Sanix.Expansions.items.glinted;

import net.minecraft.block.NetherPortalBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GlintedItem extends Item{

	public GlintedItem(Settings settings) {
		super(settings);
	}


	public boolean hasGlint(ItemStack stack) {
	      return true;
	}

}
