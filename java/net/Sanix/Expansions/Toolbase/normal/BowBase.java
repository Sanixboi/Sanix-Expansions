package net.Sanix.Expansions.Toolbase.normal;

import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.minecraft.item.BowItem;
import net.minecraft.util.Identifier;

public class BowBase extends BowItem {

	public BowBase(Settings settings) {
		super(settings);
		FabricModelPredicateProviderRegistry.register(this, new Identifier("pull"), (itemStack, clientWorld, livingEntity, seed) -> {
			if (livingEntity == null) {
				return 0.0F;
			} else {
				return livingEntity.getActiveItem() != itemStack ? 0.0F : (float)(itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / 20.0F;
			}
		});
		FabricModelPredicateProviderRegistry.register(this, new Identifier("pulling"), (itemStack, clientWorld, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
		});
	}

}
