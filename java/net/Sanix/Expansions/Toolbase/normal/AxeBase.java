package net.Sanix.Expansions.Toolbase.normal;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;

public class AxeBase extends AxeItem {
	private boolean glint;
	public AxeBase(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings, boolean isglinted) {
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
