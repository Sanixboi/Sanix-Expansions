package net.Sanix.Expansions.Toolbase.normal;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class HoeBase extends HoeItem {
	private boolean glint;
	public HoeBase(ToolMaterial material, float attackSpeed, Settings settings, boolean isglinted) {
		super(material, 0, attackSpeed, settings);
		this.glint = isglinted;
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		if (glint) return true;

		return super.hasGlint(stack);
	}
}
