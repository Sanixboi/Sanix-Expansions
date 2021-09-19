package net.Sanix.Expansions.items.glinted;

import net.Sanix.Expansions.materials.ModdedArmorMaterials;
import net.Sanix.Expansions.registries.ModItemGroups;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

public class MysticalSkyDiamondLeggings extends ArmorItem{

	public MysticalSkyDiamondLeggings() {
		super(ModdedArmorMaterials.MYSTICAL_SKY_DIAMOND, EquipmentSlot.LEGS, new Item.Settings().rarity(Rarity.EPIC).group(ModItemGroups.ARMOR));
	}

	public boolean hasGlint(ItemStack stack) {
	      return true;
	}
}
