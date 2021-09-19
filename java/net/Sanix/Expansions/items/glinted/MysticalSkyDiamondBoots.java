package net.Sanix.Expansions.items.glinted;

import net.Sanix.Expansions.materials.ModdedArmorMaterials;
import net.Sanix.Expansions.registries.ModItemGroups;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

public class MysticalSkyDiamondBoots extends ArmorItem{

	public MysticalSkyDiamondBoots() {
		super(ModdedArmorMaterials.MYSTICAL_SKY_DIAMOND, EquipmentSlot.FEET, new Item.Settings().rarity(Rarity.EPIC).group(ModItemGroups.ARMOR));
	}

	public boolean hasGlint(ItemStack stack) {
	      return true;
	}
}
