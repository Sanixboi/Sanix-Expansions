package net.Sanix.Expansions.registries;

import net.Sanix.Expansions.SanixExpansions;
import net.Sanix.Expansions.items.*;
import net.Sanix.Expansions.items.glinted.GlintedItem;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {
	public static final Item CARBON_DIAMOND = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item REINFORCED_DIAMOND = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item VILLAGER_DIAMOND = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item ENDER_DIAMOND = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item SKY_DIAMOND = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item SKY_DIAMOND_INGOT = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item MYSTICAL_FLARE = new GlintedItem(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item MYSTICAL_SKY_DIAMOND = new GlintedItem(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item DIAMOND_TOOL_ROD = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item BROWN_DIAMOND_TOOL_ROD = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item ENDER_DIAMOND_ROD = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item SKY_DIAMOND_APPLE = new Item(new Item.Settings().group(ModItemGroups.FOODS).food(new FoodComponent.Builder().hunger(8).saturationModifier(16f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 300, 4), 1f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 300, 1), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 600), 1f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 300, 2), 1f).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20 * 150, 2), 1f).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 300), 1f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 300, 1, false, false, false), 1f).build()));
	public static final Item ENCHANTED_SKY_DIAMOND_APPLE = new GlintedItem(new Item.Settings().group(ModItemGroups.FOODS).rarity(Rarity.EPIC).food(new FoodComponent.Builder().hunger(12).saturationModifier(32f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 600, 9), 1f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 400, 2), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 1200), 1f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 600, 3), 1f).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20 * 300, 4), 1f).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 600, 1), 1f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 300, 2, false, false, false), 1f).build()));
	public static final Item MYSTICAL_SKY_DIAMOND_APPLE = new GlintedItem(new Item.Settings().group(ModItemGroups.FOODS).rarity(Rarity.EPIC).food(new FoodComponent.Builder().hunger(16).saturationModifier(64f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 1200, 19), 1f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 800, 3), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 2400), 1f).statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 1200, 5), 1f).statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20 * 600, 9), 1f).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 1200, 2), 1f).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 300, 4, false, false, false), 1f).build()));
	public static final Item HUNGERBARTOP = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item HUNGERBARBOTTOM = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item HUNGERBAR = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item ICE_CRYSTAL = new Item(new Item.Settings().rarity(Rarity.EPIC).group(ModItemGroups.ITEMS));
	public static final Item MYCELIUM_CRYSTAL = new Item(new Item.Settings().rarity(Rarity.EPIC).group(ModItemGroups.ITEMS));
	public static final Item ORIGINAL_ENCHANTED_GOLDEN_APPLE = new GlintedItem(new Item.Settings().group(ModItemGroups.FOODS).rarity(Rarity.EPIC).food(new FoodComponent.Builder().hunger(4).saturationModifier(9.6f).alwaysEdible().statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 30 * 20, 3), 1f).statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 300 * 20), 1f).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 300 * 20), 1f).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 120 * 20), 1f).build()));
	public static final Item SANIX_LOGO_LEFT_PART = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item SANIX_LOGO_RIGHT_PART = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item SANIX_LOGO = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item REVERSE = new Item(new Item.Settings().group(ModItemGroups.ITEMS));

	public static final Item INFERSICO_SEEDS = new AliasedBlockItem(ModBlocks.INFERSICO_CROP, new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_SEEDS = new AliasedBlockItem(ModBlocks.ACCIDENTIUM_CROP, new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_SEEDS = new AliasedBlockItem(ModBlocks.CRUDEMEDIUM_CROP, new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_SEEDS = new AliasedBlockItem(ModBlocks.SUPERICIO_CROP, new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_SEEDS = new AliasedBlockItem(ModBlocks.SUPREVICIO_CROP, new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_SEEDS = new AliasedBlockItem(ModBlocks.SANISANIUM_CROP, new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

	public static final Item COMPRESSED_ENDER_PEARL = new Item(new Item.Settings().group(ModItemGroups.COMPRESSED_ITEMS));
	public static final Item COMPRESSED_FEATHER = new Item(new Item.Settings().group(ModItemGroups.COMPRESSED_ITEMS));
	public static final Item DOUBLE_COMPRESSED_FEATHER = new Item(new Item.Settings().group(ModItemGroups.COMPRESSED_ITEMS));
	public static final Item TRIPLE_COMPRESSED_FEATHER = new Item(new Item.Settings().group(ModItemGroups.COMPRESSED_ITEMS));
	public static final Item QUADRUPLE_COMPRESSED_FEATHER = new Item(new Item.Settings().group(ModItemGroups.COMPRESSED_ITEMS));
	public static final Item QUINTUPLE_COMPRESSED_FEATHER = new Item(new Item.Settings().group(ModItemGroups.COMPRESSED_ITEMS));
	public static final Item SEXTUPLE_COMPRESSED_FEATHER = new Item(new Item.Settings().group(ModItemGroups.COMPRESSED_ITEMS));
	public static final Item SEPTUPLE_COMPRESSED_FEATHER = new Item(new Item.Settings().group(ModItemGroups.COMPRESSED_ITEMS));
	public static final Item OCTUPLE_COMPRESSED_FEATHER = new Item(new Item.Settings().group(ModItemGroups.COMPRESSED_ITEMS));

	public static final Item MAGIC_FERTILIZER = new MagicFertilizer(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item MYSTICAL_FERTILIZER = new MysticalFertilizer(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRYSTALLIZED_FERTILIZER = new CrystallizedFertilizer(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item INFERSICO_ESSENCE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_ESSENCE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_ESSENCE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_ESSENCE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_ESSENCE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_ESSENCE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item EMPTY_INFUSION_STONE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item INFERSICO_CRYSTAL = new CraftingDamagableItem(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS).maxDamageIfAbsent(256));
	public static final Item ACCIDENTIUM_CRYSTAL = new CraftingDamagableItem(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS).maxDamageIfAbsent(512));
	public static final Item CRUDEMEDIUM_CRYSTAL = new CraftingDamagableItem(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS).maxDamageIfAbsent(1024));
	public static final Item SUPERICIO_CRYSTAL = new CraftingDamagableItem(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS).maxDamageIfAbsent(2048));
	public static final Item SUPREVICIO_CRYSTAL = new CraftingDamagableItem(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS).maxDamageIfAbsent(4096));
	public static final Item ULTIMATE_ESSENCE_CRYSTAL = new UltimateInfusionStone();
	public static final Item INFERSICO_INGOT = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_INGOT = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_INGOT = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_INGOT = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_INGOT = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_INGOT = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

    public static final Item EMPTY_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item INFERSICO_EMPTY_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_EMPTY_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_EMPTY_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_EMPTY_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_EMPTY_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_EMPTY_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

	public static final Item INFERSICO_SWORD_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_SWORD_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_SWORD_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_SWORD_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_SWORD_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_SWORD_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

	public static final Item INFERSICO_PICKAXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_PICKAXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_PICKAXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_PICKAXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_PICKAXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_PICKAXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

	public static final Item INFERSICO_AXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_AXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_AXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_AXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_AXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_AXE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

	public static final Item INFERSICO_SHOVEL_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_SHOVEL_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_SHOVEL_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_SHOVEL_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_SHOVEL_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_SHOVEL_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

	public static final Item INFERSICO_HOE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_HOE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_HOE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_HOE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_HOE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_HOE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

	public static final Item INFERSICO_BOW_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_BOW_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_BOW_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_BOW_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_BOW_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_BOW_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

	public static final Item INFERSICO_HELMET_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_HELMET_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_HELMET_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_HELMET_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_HELMET_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_HELMET_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

	public static final Item INFERSICO_CHESTPLATE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_CHESTPLATE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_CHESTPLATE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_CHESTPLATE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_CHESTPLATE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_CHESTPLATE_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

	public static final Item INFERSICO_LEGGINGS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_LEGGINGS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_LEGGINGS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_LEGGINGS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_LEGGINGS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_LEGGINGS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));

	public static final Item INFERSICO_BOOTS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item ACCIDENTIUM_BOOTS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item CRUDEMEDIUM_BOOTS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPERICIO_BOOTS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SUPREVICIO_BOOTS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));
	public static final Item SANISANIUM_BOOTS_CORE = new Item(new Item.Settings().group(ModItemGroups.INSPIRED_ITEMS));


	public static final Item SKY_DIAMOND_CRYSTAL = new SkyDiamondCrystal(new Item.Settings().group(ModItemGroups.ITEMS));

	public static final Item SOULIUS_INGOT = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item EMPOWERED_SOULIUS_INGOT = new Item(new Item.Settings().group(ModItemGroups.ITEMS));

	public static final Item SANDY_INGOT = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item HYPERIUM_INGOT = new Item(new Item.Settings().group(ModItemGroups.ITEMS));
	public static final Item NETHERITE_PLATE = new Item(new Item.Settings().group(ModItemGroups.ITEMS));

	public static void itemsinit() {
		registeritems();
	}


	public static void registeritems() {
		registeritem("carbon_diamond", CARBON_DIAMOND);
		registeritem("reinforced_diamond", REINFORCED_DIAMOND);
		registeritem("villager_diamond", VILLAGER_DIAMOND);
		registeritem("ender_diamond", ENDER_DIAMOND);
		registeritem("sky_diamond", SKY_DIAMOND);
		registeritem("sky_diamond_ingot", SKY_DIAMOND_INGOT);
		registeritem("mystical_flare", MYSTICAL_FLARE);
		registeritem("mystical_sky_diamond", MYSTICAL_SKY_DIAMOND);
		registeritem("ice_crystal", ICE_CRYSTAL);
		registeritem("mycelium_crystal", MYCELIUM_CRYSTAL);
		registeritem("diamond_tool_rod", DIAMOND_TOOL_ROD);
		registeritem("brown_diamond_tool_rod", BROWN_DIAMOND_TOOL_ROD);
		registeritem("ender_diamond_rod", ENDER_DIAMOND_ROD);
		registeritem("sky_diamond_apple", SKY_DIAMOND_APPLE);
		registeritem("enchanted_sky_diamond_apple", ENCHANTED_SKY_DIAMOND_APPLE);
		registeritem("mystical_sky_diamond_apple", MYSTICAL_SKY_DIAMOND_APPLE);
		registeritem("original_enchanted_golden_apple", ORIGINAL_ENCHANTED_GOLDEN_APPLE);
		registeritem("hungerbartop", HUNGERBARTOP);
		registeritem("hungerbarbottom", HUNGERBARBOTTOM);
		registeritem("hungerbar", HUNGERBAR);
		registeritem("compressed_feather", COMPRESSED_FEATHER);
		registeritem("double_compressed_feather", DOUBLE_COMPRESSED_FEATHER);
		registeritem("triple_compressed_feather", TRIPLE_COMPRESSED_FEATHER);
		registeritem("quadruple_compressed_feather", QUADRUPLE_COMPRESSED_FEATHER);
		registeritem("quintuple_compressed_feather", QUINTUPLE_COMPRESSED_FEATHER);
		registeritem("sextuple_compressed_feather", SEXTUPLE_COMPRESSED_FEATHER);
		registeritem("septuple_compressed_feather", SEPTUPLE_COMPRESSED_FEATHER);
		registeritem("octuple_compressed_feather", OCTUPLE_COMPRESSED_FEATHER);
		registeritem("compressed_ender_pearl", COMPRESSED_ENDER_PEARL);
		registeritem("sanix_logo_left_part", SANIX_LOGO_LEFT_PART);
		registeritem("sanix_logo_right_part", SANIX_LOGO_RIGHT_PART);
		registeritem("sanix_logo", SANIX_LOGO);
		registeritem("reverse", REVERSE);
		registeritem("sky_diamond_crystal", SKY_DIAMOND_CRYSTAL);

		//seeds
		registeritem("infersico_seeds", INFERSICO_SEEDS);
		registeritem("accidentium_seeds", ACCIDENTIUM_SEEDS);
		registeritem("crudemedium_seeds", CRUDEMEDIUM_SEEDS);
		registeritem("supericio_seeds", SUPERICIO_SEEDS);
		registeritem("suprevicio_seeds", SUPREVICIO_SEEDS);
		registeritem("sanisanium_seeds",  SANISANIUM_SEEDS);

		//Fertilizers
		registeritem("magic_fertilizer", MAGIC_FERTILIZER);
		registeritem("mystical_fertilizer", MYSTICAL_FERTILIZER);
		registeritem("crystallized_fertilizer", CRYSTALLIZED_FERTILIZER);

		//essences
		registeritem("infersico_essence", INFERSICO_ESSENCE);
		registeritem("accidentium_essence", ACCIDENTIUM_ESSENCE);
		registeritem("crudemedium_essence", CRUDEMEDIUM_ESSENCE);
		registeritem("supericio_essence", SUPERICIO_ESSENCE);
		registeritem("suprevicio_essence", SUPREVICIO_ESSENCE);
		registeritem("sanisanium_essence", SANISANIUM_ESSENCE);

		registeritem("infersico_ingot", INFERSICO_INGOT);
		registeritem("accidentium_ingot", ACCIDENTIUM_INGOT);
		registeritem("crudemedium_ingot", CRUDEMEDIUM_INGOT);
		registeritem("supericio_ingot", SUPERICIO_INGOT);
		registeritem("suprevicio_ingot", SUPREVICIO_INGOT);
		registeritem("sanisanium_ingot", SANISANIUM_INGOT);

		//crystals
		registeritem("empty_infusion_stone", EMPTY_INFUSION_STONE);
		registeritem("infersico_infusion_stone", INFERSICO_CRYSTAL);
		registeritem("accidentium_infusion_stone", ACCIDENTIUM_CRYSTAL);
		registeritem("crudemedium_infusion_stone", CRUDEMEDIUM_CRYSTAL);
		registeritem("supericio_infusion_stone", SUPERICIO_CRYSTAL);
		registeritem("suprevicio_infusion_stone", SUPREVICIO_CRYSTAL);
		registeritem("ultimate_infusion_stone", ULTIMATE_ESSENCE_CRYSTAL);

        registeritem("empty_core", EMPTY_CORE);
		registeritem("infersico_empty_core", INFERSICO_EMPTY_CORE);
		registeritem("accidentium_empty_core", ACCIDENTIUM_EMPTY_CORE);
		registeritem("crudemedium_empty_core", CRUDEMEDIUM_EMPTY_CORE);
		registeritem("supericio_empty_core", SUPERICIO_EMPTY_CORE);
		registeritem("suprevicio_empty_core", SUPREVICIO_EMPTY_CORE);
		registeritem("sanisanium_empty_core", SANISANIUM_EMPTY_CORE);

		registeritem("infersico_sword_core", INFERSICO_SWORD_CORE);
		registeritem("accidentium_sword_core", ACCIDENTIUM_SWORD_CORE);
		registeritem("crudemedium_sword_core", CRUDEMEDIUM_SWORD_CORE);
		registeritem("supericio_sword_core", SUPERICIO_SWORD_CORE);
		registeritem("suprevicio_sword_core", SUPREVICIO_SWORD_CORE);
		registeritem("sanisanium_sword_core", SANISANIUM_SWORD_CORE);

		registeritem("infersico_pickaxe_core", INFERSICO_PICKAXE_CORE);
		registeritem("accidentium_pickaxe_core", ACCIDENTIUM_PICKAXE_CORE);
		registeritem("crudemedium_pickaxe_core", CRUDEMEDIUM_PICKAXE_CORE);
		registeritem("supericio_pickaxe_core", SUPERICIO_PICKAXE_CORE);
		registeritem("suprevicio_pickaxe_core", SUPREVICIO_PICKAXE_CORE);
		registeritem("sanisanium_pickaxe_core", SANISANIUM_PICKAXE_CORE);

		registeritem("infersico_axe_core", INFERSICO_AXE_CORE);
		registeritem("accidentium_axe_core", ACCIDENTIUM_AXE_CORE);
		registeritem("crudemedium_axe_core", CRUDEMEDIUM_AXE_CORE);
		registeritem("supericio_axe_core", SUPERICIO_AXE_CORE);
		registeritem("suprevicio_axe_core", SUPREVICIO_AXE_CORE);
		registeritem("sanisanium_axe_core", SANISANIUM_AXE_CORE);

		registeritem("infersico_shovel_core", INFERSICO_SHOVEL_CORE);
		registeritem("accidentium_shovel_core", ACCIDENTIUM_SHOVEL_CORE);
		registeritem("crudemedium_shovel_core", CRUDEMEDIUM_SHOVEL_CORE);
		registeritem("supericio_shovel_core", SUPERICIO_SHOVEL_CORE);
		registeritem("suprevicio_shovel_core", SUPREVICIO_SHOVEL_CORE);
		registeritem("sanisanium_shovel_core", SANISANIUM_SHOVEL_CORE);

		registeritem("infersico_hoe_core", INFERSICO_HOE_CORE);
		registeritem("accidentium_hoe_core", ACCIDENTIUM_HOE_CORE);
		registeritem("crudemedium_hoe_core", CRUDEMEDIUM_HOE_CORE);
		registeritem("supericio_hoe_core", SUPERICIO_HOE_CORE);
		registeritem("suprevicio_hoe_core", SUPREVICIO_HOE_CORE);
		registeritem("sanisanium_hoe_core", SANISANIUM_HOE_CORE);

		registeritem("infersico_bow_core", INFERSICO_BOW_CORE);
		registeritem("accidentium_bow_core", ACCIDENTIUM_BOW_CORE);
		registeritem("crudemedium_bow_core", CRUDEMEDIUM_BOW_CORE);
		registeritem("supericio_bow_core", SUPERICIO_BOW_CORE);
		registeritem("suprevicio_bow_core", SUPREVICIO_BOW_CORE);
		registeritem("sanisanium_bow_core", SANISANIUM_BOW_CORE);

		registeritem("infersico_helmet_core", INFERSICO_HELMET_CORE);
		registeritem("accidentium_helmet_core", ACCIDENTIUM_HELMET_CORE);
		registeritem("crudemedium_helmet_core", CRUDEMEDIUM_HELMET_CORE);
		registeritem("supericio_helmet_core", SUPERICIO_HELMET_CORE);
		registeritem("suprevicio_helmet_core", SUPREVICIO_HELMET_CORE);
		registeritem("sanisanium_helmet_core", SANISANIUM_HELMET_CORE);

		registeritem("infersico_chestplate_core", INFERSICO_CHESTPLATE_CORE);
		registeritem("accidentium_chestplate_core", ACCIDENTIUM_CHESTPLATE_CORE);
		registeritem("crudemedium_chestplate_core", CRUDEMEDIUM_CHESTPLATE_CORE);
		registeritem("supericio_chestplate_core", SUPERICIO_CHESTPLATE_CORE);
		registeritem("suprevicio_chestplate_core", SUPREVICIO_CHESTPLATE_CORE);
		registeritem("sanisanium_chestplate_core", SANISANIUM_CHESTPLATE_CORE);

		registeritem("infersico_leggings_core", INFERSICO_LEGGINGS_CORE);
		registeritem("accidentium_leggings_core", ACCIDENTIUM_LEGGINGS_CORE);
		registeritem("crudemedium_leggings_core", CRUDEMEDIUM_LEGGINGS_CORE);
		registeritem("supericio_leggings_core", SUPERICIO_LEGGINGS_CORE);
		registeritem("suprevicio_leggings_core", SUPREVICIO_LEGGINGS_CORE);
		registeritem("sanisanium_leggings_core", SANISANIUM_LEGGINGS_CORE);

		registeritem("infersico_boots_core", INFERSICO_BOOTS_CORE);
		registeritem("accidentium_boots_core", ACCIDENTIUM_BOOTS_CORE);
		registeritem("crudemedium_boots_core", CRUDEMEDIUM_BOOTS_CORE);
		registeritem("supericio_boots_core", SUPERICIO_BOOTS_CORE);
		registeritem("suprevicio_boots_core", SUPREVICIO_BOOTS_CORE);
		registeritem("sanisanium_boots_core", SANISANIUM_BOOTS_CORE);

		registeritem("soulius_ingot", SOULIUS_INGOT);
		registeritem("empowered_soulius_ingot", EMPOWERED_SOULIUS_INGOT);
		registeritem("sandy_iron_ingot", SANDY_INGOT);
		registeritem("hyperium_ingot", HYPERIUM_INGOT);
		registeritem("netherite_plate", NETHERITE_PLATE);
	}
	
	public static <T extends Item> T registeritem(String item, T entry) {
		return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, item), entry);
	}
	
}
