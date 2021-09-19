package net.Sanix.Expansions.Toolbase.normal;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

public class SwordBase extends SwordItem {
	private final boolean glint;
	public SwordBase(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings, boolean isglinted) {
		super(material, attackDamage, attackSpeed, settings);
		FabricModelPredicateProviderRegistry.register(this, new Identifier("blocking"),(itemStack, clientWorld, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
		});
		this.glint = isglinted;
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		if (glint) return true;

		return super.hasGlint(stack);
	}

}
