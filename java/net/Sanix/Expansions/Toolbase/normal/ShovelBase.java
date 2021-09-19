package net.Sanix.Expansions.Toolbase.normal;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class ShovelBase extends ShovelItem {
	private boolean glint;
	public ShovelBase(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings, boolean isglinted) {
		super(material, attackDamage, attackSpeed, settings);
		this.glint = isglinted;
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		if (glint) {
			return true;
		}
		return super.hasGlint(stack);
	}
}
