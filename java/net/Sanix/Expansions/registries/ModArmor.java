package net.Sanix.Expansions.registries;

import net.Sanix.Expansions.SanixExpansions;
import net.Sanix.Expansions.items.glinted.MysticalSkyDiamondBoots;
import net.Sanix.Expansions.items.glinted.MysticalSkyDiamondChestplate;
import net.Sanix.Expansions.items.glinted.MysticalSkyDiamondHelmet;
import net.Sanix.Expansions.items.glinted.MysticalSkyDiamondLeggings;
import net.Sanix.Expansions.materials.ModdedArmorMaterials;
import net.Sanix.Expansions.misc.ArmorBase;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModArmor {
	public static final Item CARBON_DIAMOND_HELMET = new ArmorItem(ModdedArmorMaterials.CARBON_DIAMOND, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR));
	public static final Item CARBON_DIAMOND_CHESTPLATE = new ArmorItem(ModdedArmorMaterials.CARBON_DIAMOND, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR));
	public static final Item CARBON_DIAMOND_LEGGINGS = new ArmorItem(ModdedArmorMaterials.CARBON_DIAMOND, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR));
	public static final Item CARBON_DIAMOND_BOOTS = new ArmorItem(ModdedArmorMaterials.CARBON_DIAMOND, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR));

	public static final Item REINFORCED_DIAMOND_HELMET = new ArmorBase(ModdedArmorMaterials.REINFORCED_DIAMOND, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR), 1);
	public static final Item REINFORCED_DIAMOND_CHESTPLATE = new ArmorBase(ModdedArmorMaterials.REINFORCED_DIAMOND, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR), 1);
	public static final Item REINFORCED_DIAMOND_LEGGINGS = new ArmorBase(ModdedArmorMaterials.REINFORCED_DIAMOND, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR), 1);
	public static final Item REINFORCED_DIAMOND_BOOTS = new ArmorBase(ModdedArmorMaterials.REINFORCED_DIAMOND, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR), 1);

	public static final Item EMERALD_REINFORCED_DIAMOND_HELMET = new ArmorBase(ModdedArmorMaterials.VILLAGER_DIAMOND, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR), 2);
	public static final Item EMERALD_REINFORCED_DIAMOND_CHESTPLATE = new ArmorBase(ModdedArmorMaterials.VILLAGER_DIAMOND, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR), 3);
	public static final Item EMERALD_REINFORCED_DIAMOND_LEGGINGS = new ArmorBase(ModdedArmorMaterials.VILLAGER_DIAMOND, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR), 2);
	public static final Item EMERALD_REINFORCED_DIAMOND_BOOTS = new ArmorBase(ModdedArmorMaterials.VILLAGER_DIAMOND, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR), 1);

	public static final Item ENDER_PEARL_REINFORCED_DIAMOND_HELMET = new ArmorBase(ModdedArmorMaterials.ENDER_DIAMOND, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR), 3);
	public static final Item ENDER_PEARL_REINFORCED_DIAMOND_CHESTPLATE = new ArmorBase(ModdedArmorMaterials.ENDER_DIAMOND, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR), 5);
	public static final Item ENDER_PEARL_REINFORCED_DIAMOND_LEGGINGS = new ArmorBase(ModdedArmorMaterials.ENDER_DIAMOND, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR), 4);
	public static final Item ENDER_PEARL_REINFORCED_DIAMOND_BOOTS = new ArmorBase(ModdedArmorMaterials.ENDER_DIAMOND, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR), 2);

	public static final Item SKY_DIAMOND_HELMET = new ArmorBase(ModdedArmorMaterials.SKY_DIAMOND, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR), 4);
	public static final Item SKY_DIAMOND_CHESTPLATE = new ArmorBase(ModdedArmorMaterials.SKY_DIAMOND, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR),6);
	public static final Item SKY_DIAMOND_LEGGINGS = new ArmorBase(ModdedArmorMaterials.SKY_DIAMOND, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR),5);
	public static final Item SKY_DIAMOND_BOOTS = new ArmorBase(ModdedArmorMaterials.SKY_DIAMOND, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR), 3);

	public static final Item INFERSICO_HELMET = new ArmorBase(ModdedArmorMaterials.INFERSICO, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR), 5);
	public static final Item INFERSICO_CHESTPLATE = new ArmorBase(ModdedArmorMaterials.INFERSICO, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR), 7);
	public static final Item INFERSICO_LEGGINGS = new ArmorBase(ModdedArmorMaterials.INFERSICO, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR), 5);
	public static final Item INFERSICO_BOOTS = new ArmorBase(ModdedArmorMaterials.INFERSICO, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR), 3);

	public static final Item ACCIDENTIUM_HELMET = new ArmorBase(ModdedArmorMaterials.ACCIDENTIUM, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR), 6);
	public static final Item ACCIDENTIUM_CHESTPLATE = new ArmorBase(ModdedArmorMaterials.ACCIDENTIUM, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR), 8);
	public static final Item ACCIDENTIUM_LEGGINGS = new ArmorBase(ModdedArmorMaterials.ACCIDENTIUM, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR), 6);
	public static final Item ACCIDENTIUM_BOOTS = new ArmorBase(ModdedArmorMaterials.ACCIDENTIUM, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR), 5);

	public static final Item CRUDEMEDIUM_HELMET = new ArmorBase(ModdedArmorMaterials.CRUDEMEDIUM, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR), 7);
	public static final Item CRUDEMEDIUM_CHESTPLATE = new ArmorBase(ModdedArmorMaterials.CRUDEMEDIUM, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR), 9);
	public static final Item CRUDEMEDIUM_LEGGINGS = new ArmorBase(ModdedArmorMaterials.CRUDEMEDIUM, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR), 8);
	public static final Item CRUDEMEDIUM_BOOTS = new ArmorBase(ModdedArmorMaterials.CRUDEMEDIUM, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR), 6);

	public static final Item SUPERICIO_HELMET = new ArmorBase(ModdedArmorMaterials.SUPERICIO, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR), 8);
	public static final Item SUPERICIO_CHESTPLATE = new ArmorBase(ModdedArmorMaterials.SUPERICIO, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR), 10);
	public static final Item SUPERICIO_LEGGINGS = new ArmorBase(ModdedArmorMaterials.SUPERICIO, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR), 9);
	public static final Item SUPERICIO_BOOTS = new ArmorBase(ModdedArmorMaterials.SUPERICIO, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR), 7);

	public static final Item SUPREVICIO_HELMET = new ArmorBase(ModdedArmorMaterials.SUPREVICIO, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR), 9);
	public static final Item SUPREVICIO_CHESTPLATE = new ArmorBase(ModdedArmorMaterials.SUPREVICIO, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR), 11);
	public static final Item SUPREVICIO_LEGGINGS = new ArmorBase(ModdedArmorMaterials.SUPREVICIO, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR), 10);
	public static final Item SUPREVICIO_BOOTS = new ArmorBase(ModdedArmorMaterials.SUPREVICIO, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR), 8);

	public static final Item SANISANIUM_HELMET = new ArmorBase(ModdedArmorMaterials.SANISANIUM, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR), 12);
	public static final Item SANISANIUM_CHESTPLATE = new ArmorBase(ModdedArmorMaterials.SANISANIUM, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR), 14);
	public static final Item SANISANIUM_LEGGINGS = new ArmorBase(ModdedArmorMaterials.SANISANIUM, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR), 13);
	public static final Item SANISANIUM_BOOTS = new ArmorBase(ModdedArmorMaterials.SANISANIUM, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR), 11);

	public static final Item EMPOWERED_SOULIUS_HELMET = new ArmorBase(ModdedArmorMaterials.EMPOWERED_SOULIUS, EquipmentSlot.HEAD, new Item.Settings().group(ModItemGroups.ARMOR), 16);
	public static final Item EMPOWERED_SOULIUS_CHESTPLATE = new ArmorBase(ModdedArmorMaterials.EMPOWERED_SOULIUS, EquipmentSlot.CHEST, new Item.Settings().group(ModItemGroups.ARMOR), 27);
	public static final Item EMPOWERED_SOULIUS_LEGGINGS = new ArmorBase(ModdedArmorMaterials.EMPOWERED_SOULIUS, EquipmentSlot.LEGS, new Item.Settings().group(ModItemGroups.ARMOR), 23);
	public static final Item EMPOWERED_SOULIUS_BOOTS = new ArmorBase(ModdedArmorMaterials.EMPOWERED_SOULIUS, EquipmentSlot.FEET, new Item.Settings().group(ModItemGroups.ARMOR), 14);

	public static final Item MYSTICAL_SKY_DIAMOND_HELMET = new MysticalSkyDiamondHelmet();
	public static final Item MYSTICAL_SKY_DIAMOND_CHESTPLATE = new MysticalSkyDiamondChestplate();
	public static final Item MYSTICAL_SKY_DIAMOND_LEGGINGS = new MysticalSkyDiamondLeggings();
	public static final Item MYSTICAL_SKY_DIAMOND_BOOTS = new MysticalSkyDiamondBoots();



	public static void armorinit() {
		blackdiamondsetinit();
		reinforceddiamondsetinit();
		emeraldreinforceddiamondsetinit();
		enderpearlreinforceddiamondsetinit();
		skydiamondsetinit();
		mysticalskydiamondsetinit();
		infersicosetinit();
		accidentiumsetinit();
		crudemediumsetinit();
		supericiosetinit();
		supreviciosetinit();
		sanisaniumsetinit();
		empoweredsouliussetinit();
	}
	
	public static <T extends Item> T registeritem(String item, T entry) {
		return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, item), entry);
	}

	public static void empoweredsouliussetinit() {
		registeritem("empowered_soulius_helmet", EMPOWERED_SOULIUS_HELMET);
		registeritem("empowered_soulius_chestplate", EMPOWERED_SOULIUS_CHESTPLATE);
		registeritem("empowered_soulius_leggings", EMPOWERED_SOULIUS_LEGGINGS);
		registeritem("empowered_soulius_boots", EMPOWERED_SOULIUS_BOOTS);
	}

	public static void blackdiamondsetinit() {
		registeritem("carbon_diamond_helmet", CARBON_DIAMOND_HELMET);
		registeritem("carbon_diamond_chestplate", CARBON_DIAMOND_CHESTPLATE);
		registeritem("carbon_diamond_leggings", CARBON_DIAMOND_LEGGINGS);
		registeritem("carbon_diamond_boots", CARBON_DIAMOND_BOOTS);
	}

	public static void reinforceddiamondsetinit() {
		registeritem("reinforced_diamond_helmet", REINFORCED_DIAMOND_HELMET);
		registeritem("reinforced_diamond_chestplate", REINFORCED_DIAMOND_CHESTPLATE);
		registeritem("reinforced_diamond_leggings", REINFORCED_DIAMOND_LEGGINGS);
		registeritem("reinforced_diamond_boots", REINFORCED_DIAMOND_BOOTS);
	}

	public static void emeraldreinforceddiamondsetinit() {
		registeritem("villager_diamond_helmet", EMERALD_REINFORCED_DIAMOND_HELMET);
		registeritem("villager_diamond_chestplate", EMERALD_REINFORCED_DIAMOND_CHESTPLATE);
		registeritem("villager_diamond_leggings", EMERALD_REINFORCED_DIAMOND_LEGGINGS);
		registeritem("villager_diamond_boots", EMERALD_REINFORCED_DIAMOND_BOOTS);
	}

	public static void enderpearlreinforceddiamondsetinit() {
		registeritem("ender_diamond_helmet", ENDER_PEARL_REINFORCED_DIAMOND_HELMET);
		registeritem("ender_diamond_chestplate", ENDER_PEARL_REINFORCED_DIAMOND_CHESTPLATE);
		registeritem("ender_diamond_leggings", ENDER_PEARL_REINFORCED_DIAMOND_LEGGINGS);
		registeritem("ender_diamond_boots", ENDER_PEARL_REINFORCED_DIAMOND_BOOTS);
	}
	public static void skydiamondsetinit() {
		registeritem("sky_diamond_helmet", SKY_DIAMOND_HELMET);
		registeritem("sky_diamond_chestplate", SKY_DIAMOND_CHESTPLATE);
		registeritem("sky_diamond_leggings", SKY_DIAMOND_LEGGINGS);
		registeritem("sky_diamond_boots", SKY_DIAMOND_BOOTS);
	}
	
	public static void mysticalskydiamondsetinit() {
		registeritem("mystical_sky_diamond_helmet", MYSTICAL_SKY_DIAMOND_HELMET);
		registeritem("mystical_sky_diamond_chestplate", MYSTICAL_SKY_DIAMOND_CHESTPLATE);
		registeritem("mystical_sky_diamond_leggings", MYSTICAL_SKY_DIAMOND_LEGGINGS);
		registeritem("mystical_sky_diamond_boots", MYSTICAL_SKY_DIAMOND_BOOTS);
	}

	public static void infersicosetinit() {
		registeritem("infersico_helmet", INFERSICO_HELMET);
		registeritem("infersico_chestplate", INFERSICO_CHESTPLATE);
		registeritem("infersico_leggings", INFERSICO_LEGGINGS);
		registeritem("infersico_boots", INFERSICO_BOOTS);
	}

	public static void accidentiumsetinit() {
		registeritem("accidentium_helmet", ACCIDENTIUM_HELMET);
		registeritem("accidentium_chestplate", ACCIDENTIUM_CHESTPLATE);
		registeritem("accidentium_leggings", ACCIDENTIUM_LEGGINGS);
		registeritem("accidentium_boots", ACCIDENTIUM_BOOTS);
	}

	public static void crudemediumsetinit() {
		registeritem("crudemedium_helmet", CRUDEMEDIUM_HELMET);
		registeritem("crudemedium_chestplate", CRUDEMEDIUM_CHESTPLATE);
		registeritem("crudemedium_leggings", CRUDEMEDIUM_LEGGINGS);
		registeritem("crudemedium_boots", CRUDEMEDIUM_BOOTS);
	}

	public static void supericiosetinit() {
		registeritem("supericio_helmet", SUPERICIO_HELMET);
		registeritem("supericio_chestplate", SUPERICIO_CHESTPLATE);
		registeritem("supericio_leggings", SUPERICIO_LEGGINGS);
		registeritem("supericio_boots", SUPERICIO_BOOTS);
	}

	public static void supreviciosetinit() {
		registeritem("suprevicio_helmet", SUPREVICIO_HELMET);
		registeritem("suprevicio_chestplate", SUPREVICIO_CHESTPLATE);
		registeritem("suprevicio_leggings", SUPREVICIO_LEGGINGS);
		registeritem("suprevicio_boots", SUPREVICIO_BOOTS);
	}

	public static void sanisaniumsetinit() {
		registeritem("sanisanium_helmet", SANISANIUM_HELMET);
		registeritem("sanisanium_chestplate", SANISANIUM_CHESTPLATE);
		registeritem("sanisanium_leggings", SANISANIUM_LEGGINGS);
		registeritem("sanisanium_boots", SANISANIUM_BOOTS);
	}
	
}
