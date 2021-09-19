package net.Sanix.Expansions.registries;


import net.Sanix.Expansions.SanixExpansions;
import net.Sanix.Expansions.Toolbase.normal.*;
import net.Sanix.Expansions.items.EmpoweredSouliusSwordItem;
import net.Sanix.Expansions.materials.ModdedToolMaterials;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModTools {

	public static final Item CARBON_DIAMOND_SWORD = new SwordItem(ModdedToolMaterials.CARBON_DIAMOND, 3, -2.2f, new Item.Settings().group(ModItemGroups.TOOLS));
	public static final Item CARBON_DIAMOND_PICKAXE = new PickaxeBase(ModdedToolMaterials.CARBON_DIAMOND, 1, -2.6f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item CARBON_DIAMOND_AXE = new AxeBase(ModdedToolMaterials.CARBON_DIAMOND, 5, -2.9f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item CARBON_DIAMOND_SHOVEL = new ShovelBase(ModdedToolMaterials.CARBON_DIAMOND, 1, -2.7f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item CARBON_DIAMOND_HOE = new HoeBase(ModdedToolMaterials.CARBON_DIAMOND, 0f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item CARBON_DIAMOND_BOW = new BowBase(new Item.Settings().maxDamage(ModdedToolMaterials.CARBON_DIAMOND.getDurability()).group(ModItemGroups.TOOLS));

	public static final Item REINFORCED_DIAMOND_SWORD = new SwordItem(ModdedToolMaterials.REINFORCED_DIAMOND, 4, -2.2f, new Item.Settings().group(ModItemGroups.TOOLS));
	public static final Item REINFORCED_DIAMOND_PICKAXE = new PickaxeBase(ModdedToolMaterials.REINFORCED_DIAMOND, 2, -2.5f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item REINFORCED_DIAMOND_AXE = new AxeBase(ModdedToolMaterials.REINFORCED_DIAMOND, 6, -2.9f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item REINFORCED_DIAMOND_SHOVEL = new ShovelBase(ModdedToolMaterials.REINFORCED_DIAMOND, 2, -2.6f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item REINFORCED_DIAMOND_HOE = new HoeBase(ModdedToolMaterials.REINFORCED_DIAMOND, 0f, new Item.Settings().group(ModItemGroups.TOOLS), false);

	public static final Item VILLAGER_DIAMOND_SWORD = new SwordItem(ModdedToolMaterials.VILLAGER_DIAMOND, 4, -2.1f, new Item.Settings().group(ModItemGroups.TOOLS));
	public static final Item VILLAGER_DIAMOND_PICKAXE = new PickaxeBase(ModdedToolMaterials.VILLAGER_DIAMOND, 2, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item VILLAGER_DIAMOND_AXE = new AxeBase(ModdedToolMaterials.VILLAGER_DIAMOND, 6, -2.8f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item VILLAGER_DIAMOND_SHOVEL = new ShovelBase(ModdedToolMaterials.VILLAGER_DIAMOND, 2, -2.5f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item VILLAGER_DIAMOND_HOE = new HoeBase(ModdedToolMaterials.VILLAGER_DIAMOND, 0.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);

	public static final Item ENDER_DIAMOND_SWORD = new SwordItem(ModdedToolMaterials.ENDER_DIAMOND, 4, -2f, new Item.Settings().group(ModItemGroups.TOOLS));
	public static final Item ENDER_DIAMOND_PICKAXE = new PickaxeBase(ModdedToolMaterials.ENDER_DIAMOND, 2, -2.3f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item ENDER_DIAMOND_AXE = new AxeBase(ModdedToolMaterials.ENDER_DIAMOND, 7, -2.7f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item ENDER_DIAMOND_SHOVEL = new ShovelBase(ModdedToolMaterials.ENDER_DIAMOND, 2, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item ENDER_DIAMOND_HOE = new HoeBase(ModdedToolMaterials.ENDER_DIAMOND, 1f, new Item.Settings().group(ModItemGroups.TOOLS), false);

	public static final Item SKY_DIAMOND_SWORD = new SwordBase(ModdedToolMaterials.SKY_DIAMOND, 4, -1.9f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SKY_DIAMOND_PICKAXE = new PickaxeBase(ModdedToolMaterials.SKY_DIAMOND, 2, -2.2f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SKY_DIAMOND_AXE = new AxeBase(ModdedToolMaterials.SKY_DIAMOND, 6, -2.6f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SKY_DIAMOND_SHOVEL = new ShovelBase(ModdedToolMaterials.SKY_DIAMOND, 2, -2.3f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SKY_DIAMOND_BOW = new BowBase(new Item.Settings().maxDamage(ModdedToolMaterials.SKY_DIAMOND.getDurability()).group(ModItemGroups.TOOLS));

	public static final Item INFERSICO_SWORD = new SwordBase(ModdedToolMaterials.INFERSICO, 4, -1.8f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item INFERSICO_PICKAXE = new PickaxeBase(ModdedToolMaterials.INFERSICO, 2, -2.1f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item INFERSICO_AXE = new AxeBase(ModdedToolMaterials.INFERSICO, 6, -2.5f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item INFERSICO_SHOVEL = new ShovelBase(ModdedToolMaterials.INFERSICO, 2, -2.2f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item INFERSICO_HOE = new HoeBase(ModdedToolMaterials.INFERSICO, 0f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item INFERSICO_BOW = new BowBase(new Item.Settings().maxDamage(ModdedToolMaterials.INFERSICO.getDurability()).group(ModItemGroups.TOOLS));

	public static final Item ACCIDENTIUM_SWORD = new BlockingSwordBase(ModdedToolMaterials.ACCIDENTIUM, 4, -1.7f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item ACCIDENTIUM_PICKAXE = new PickaxeBase(ModdedToolMaterials.ACCIDENTIUM, 2, -2f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item ACCIDENTIUM_AXE = new AxeBase(ModdedToolMaterials.ACCIDENTIUM, 6, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item ACCIDENTIUM_SHOVEL = new ShovelBase(ModdedToolMaterials.ACCIDENTIUM, 2, -2.1f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item ACCIDENTIUM_HOE = new HoeBase(ModdedToolMaterials.ACCIDENTIUM, 0f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item ACCIDENTIUM_BOW = new BowBase(new Item.Settings().maxDamage(ModdedToolMaterials.ACCIDENTIUM.getDurability()).group(ModItemGroups.TOOLS));

	public static final Item MYSTICAL_SKY_DIAMOND_SWORD = new SwordBase(ModdedToolMaterials.MYSTICAL_SKY_DIAMOND, 4, -1.8f, new Item.Settings().group(ModItemGroups.TOOLS), true);
	public static final Item MYSTICAL_SKY_DIAMOND_PICKAXE = new PickaxeBase(ModdedToolMaterials.MYSTICAL_SKY_DIAMOND, 2, -1.9f, new Item.Settings().group(ModItemGroups.TOOLS), true);
	public static final Item MYSTICAL_SKY_DIAMOND_AXE = new AxeBase(ModdedToolMaterials.MYSTICAL_SKY_DIAMOND, 6, -2.5f, new Item.Settings().group(ModItemGroups.TOOLS), true);
	public static final Item MYSTICAL_SKY_DIAMOND_SHOVEL = new ShovelBase(ModdedToolMaterials.MYSTICAL_SKY_DIAMOND, 2, -2f, new Item.Settings().group(ModItemGroups.TOOLS), true);

	public static final Item CRUDEMEDIUM_SWORD = new BlockingSwordBase(ModdedToolMaterials.CRUDEMEDIUM, 4, -1.6f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item CRUDEMEDIUM_PICKAXE = new PickaxeBase(ModdedToolMaterials.CRUDEMEDIUM, 2, -2f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item CRUDEMEDIUM_AXE = new AxeBase(ModdedToolMaterials.CRUDEMEDIUM, 6, -2.3f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item CRUDEMEDIUM_SHOVEL = new ShovelBase(ModdedToolMaterials.CRUDEMEDIUM, 2, -2f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item CRUDEMEDIUM_HOE = new HoeBase(ModdedToolMaterials.CRUDEMEDIUM, 0f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item CRUDEMEDIUM_BOW = new BowBase(new Item.Settings().maxDamage(ModdedToolMaterials.CRUDEMEDIUM.getDurability()).group(ModItemGroups.TOOLS));

	public static final Item SUPERICIO_SWORD = new BlockingSwordBase(ModdedToolMaterials.SUPERICIO, 4, -1.1f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SUPERICIO_PICKAXE = new PickaxeBase(ModdedToolMaterials.SUPERICIO, 2, -1.7f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SUPERICIO_AXE = new AxeBase(ModdedToolMaterials.SUPERICIO, 6, -2.2f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SUPERICIO_SHOVEL = new ShovelBase(ModdedToolMaterials.SUPERICIO, 2, -1.9f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SUPERICIO_HOE = new HoeBase(ModdedToolMaterials.SUPERICIO, 0f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SUPERICIO_BOW = new BowBase(new Item.Settings().maxDamage(ModdedToolMaterials.SUPERICIO.getDurability()).group(ModItemGroups.TOOLS));

	public static final Item SUPREVICIO_SWORD = new BlockingSwordBase(ModdedToolMaterials.SUPREVICIO, 4, -1f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SUPREVICIO_PICKAXE = new PickaxeBase(ModdedToolMaterials.SUPREVICIO, 2, -1.6f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SUPREVICIO_AXE = new AxeBase(ModdedToolMaterials.SUPREVICIO, 6, -2.1f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SUPREVICIO_SHOVEL = new ShovelBase(ModdedToolMaterials.SUPREVICIO, 2, -1.8f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SUPREVICIO_HOE = new HoeBase(ModdedToolMaterials.SUPREVICIO, 0f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SUPREVICIO_BOW = new BowBase(new Item.Settings().maxDamage(ModdedToolMaterials.SUPREVICIO.getDurability()).group(ModItemGroups.TOOLS));

	public static final Item SANISANIUM_SWORD = new BlockingSwordBase(ModdedToolMaterials.SANISANIUM, 4, -0.75f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SANISANIUM_PICKAXE = new PickaxeBase(ModdedToolMaterials.SANISANIUM, 2, -1.5f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SANISANIUM_AXE = new AxeBase(ModdedToolMaterials.SANISANIUM, 6, -2f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SANISANIUM_SHOVEL = new ShovelBase(ModdedToolMaterials.SANISANIUM, 2, -1.7f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SANISANIUM_HOE = new HoeBase(ModdedToolMaterials.SANISANIUM, 0f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SANISANIUM_BOW = new BowBase(new Item.Settings().maxDamage(ModdedToolMaterials.SANISANIUM.getDurability()).group(ModItemGroups.TOOLS));

	public static final Item EMPOWERED_SOULIUS_SWORD = new EmpoweredSouliusSwordItem(ModdedToolMaterials.EMPOWERED_SOULIUS, 4, -0.25f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item EMPOWERED_SOULIUS_PICKAXE = new PickaxeBase(ModdedToolMaterials.EMPOWERED_SOULIUS, 2, -1.25f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item EMPOWERED_SOULIUS_AXE = new AxeBase(ModdedToolMaterials.EMPOWERED_SOULIUS, 6, -1.5f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item EMPOWERED_SOULIUS_SHOVEL = new ShovelBase(ModdedToolMaterials.EMPOWERED_SOULIUS, 2, -1.5f, new Item.Settings().group(ModItemGroups.TOOLS), false);

	public static final Item SOULIUS_DAGGER = new BlockingSwordBase(ModdedToolMaterials.SANISANIUM, 6, -0.5f, new Item.Settings().group(ModItemGroups.TOOLS), false);

	public static final Item OAK_SWORD = new SwordBase(ModdedToolMaterials.OAK, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item SPRUCE_SWORD = new SwordBase(ModdedToolMaterials.SPRUCE, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item BIRCH_SWORD = new SwordBase(ModdedToolMaterials.BIRCH, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item JUNGLE_SWORD = new SwordBase(ModdedToolMaterials.JUNGLE, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item ACACIA_SWORD = new SwordBase(ModdedToolMaterials.ACACIA, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item DARK_OAK_SWORD = new SwordBase(ModdedToolMaterials.DARK_OAK, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item WARPED_SWORD = new SwordBase(ModdedToolMaterials.WARPED, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS).fireproof(), false);
	public static final Item CRIMSON_SWORD = new SwordBase(ModdedToolMaterials.CRIMSON, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS).fireproof(), false);
	public static final Item ANDESITE_SWORD = new SwordBase(ModdedToolMaterials.ANDESITE, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item GRANITE_SWORD = new SwordBase(ModdedToolMaterials.GRANITE, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item DIORITE_SWORD = new SwordBase(ModdedToolMaterials.DIORITE, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item BLACKSTONE_SWORD = new SwordBase(ModdedToolMaterials.BLACKSTONE, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item BASALT_SWORD = new SwordBase(ModdedToolMaterials.BASALT, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	public static final Item DEEPSLATE_SWORD = new SwordBase(ModdedToolMaterials.DEEPSLATE, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);
	//public static final Item CORRUPTED_SWORD = new SwordBase(ModdedToolMaterials.CORRUPTSTONE, 3, -2.4f, new Item.Settings().group(ModItemGroups.TOOLS), false);

	public static void toolsinit() {
		carbondiamondtoolsinit();
		reinforceddiamondtoolsinit();
		emeraldreinforceddiamondtoolsinit();
		enderpearlreinforceddiamondtoolsinit();
		skydiamondtoolsinit();
		mysticalskydiamondtoolsinit();
		essencetoolsinit();
		souliustoolsinit();
		woodtoolsinit();
		stonetoolsinit();
	}
	
	public static <T extends Item> T registeritem(String item, T entry) {
		return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, item), entry);
	}

	public static void souliustoolsinit() {
		registeritem("soulius_dagger", SOULIUS_DAGGER);
		registeritem("empowered_soulius_sword", EMPOWERED_SOULIUS_SWORD);
		registeritem("empowered_soulius_pickaxe", EMPOWERED_SOULIUS_PICKAXE);
		registeritem("empowered_soulius_axe", EMPOWERED_SOULIUS_AXE);
		registeritem("empowered_soulius_shovel", EMPOWERED_SOULIUS_SHOVEL);
	}
	
	public static PickaxeBase registerpickaxe(String pickaxematerial, ToolMaterial toolmaterial, int damage, float attackspeed) {
		return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, pickaxematerial + "_pickaxe"), new PickaxeBase(toolmaterial, damage, attackspeed, new Item.Settings().group(ModItemGroups.TOOLS), false));
	}
	
	public static AxeBase registeraxe(String axematerial, ToolMaterial toolmaterial, int damage, float attackspeed) {
		return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, axematerial + "_axe"), new AxeBase(toolmaterial, damage, attackspeed, new Item.Settings().group(ModItemGroups.TOOLS), false));
	}
	
	public static ShovelBase registershovel(String shovelmaterial, ToolMaterial toolmaterial, int damage, float attackspeed) {
		return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, shovelmaterial + "_shovel"), new ShovelBase(toolmaterial, damage, attackspeed, new Item.Settings().group(ModItemGroups.TOOLS), false));
	}
	
	public static HoeBase registerhoe(String hoematerial, ToolMaterial toolmaterial, float attackspeed) {
		return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, hoematerial + "_hoe"), new HoeBase(toolmaterial, attackspeed, new Item.Settings().group(ModItemGroups.TOOLS), false));
	}

	
	public static PickaxeBase registernetherpickaxe(String pickaxematerial, ToolMaterial toolmaterial, int damage, float attackspeed) {
		return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, pickaxematerial + "_pickaxe"), new PickaxeBase(toolmaterial, damage, attackspeed, new Item.Settings().group(ModItemGroups.TOOLS).fireproof(), false));
	}
	
	public static AxeBase registernetheraxe(String axematerial, ToolMaterial toolmaterial, int damage, float attackspeed) {
		return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, axematerial + "_axe"), new AxeBase(toolmaterial, damage, attackspeed, new Item.Settings().group(ModItemGroups.TOOLS).fireproof(), false));
	}
	
	public static ShovelBase registernethershovel(String shovelmaterial, ToolMaterial toolmaterial, int damage, float attackspeed) {
		return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, shovelmaterial + "_shovel"), new ShovelBase(toolmaterial, damage, attackspeed, new Item.Settings().group(ModItemGroups.TOOLS).fireproof(), false));
	}
	
	public static HoeBase registernetherhoe(String hoematerial, ToolMaterial toolmaterial, float attackspeed) {
		return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, hoematerial + "_hoe"), new HoeBase(toolmaterial, attackspeed, new Item.Settings().group(ModItemGroups.TOOLS).fireproof(), false));
	}
	
	public static void carbondiamondtoolsinit() {
		registeritem("carbon_diamond_sword", CARBON_DIAMOND_SWORD);
		registeritem("carbon_diamond_pickaxe", CARBON_DIAMOND_PICKAXE);
		registeritem("carbon_diamond_axe", CARBON_DIAMOND_AXE);
		registeritem("carbon_diamond_shovel", CARBON_DIAMOND_SHOVEL);
		registeritem("carbon_diamond_hoe", CARBON_DIAMOND_HOE);
		registeritem("carbon_diamond_bow", CARBON_DIAMOND_BOW);
	}

	public static void reinforceddiamondtoolsinit() {
		registeritem("reinforced_diamond_sword", REINFORCED_DIAMOND_SWORD);
		registeritem("reinforced_diamond_pickaxe", REINFORCED_DIAMOND_PICKAXE);
		registeritem("reinforced_diamond_axe", REINFORCED_DIAMOND_AXE);
		registeritem("reinforced_diamond_shovel", REINFORCED_DIAMOND_SHOVEL);
		registeritem("reinforced_diamond_hoe", REINFORCED_DIAMOND_HOE);
	}
	
	public static void emeraldreinforceddiamondtoolsinit() {
		registeritem("villager_diamond_sword", VILLAGER_DIAMOND_SWORD);
		registeritem("villager_diamond_pickaxe", VILLAGER_DIAMOND_PICKAXE);
		registeritem("villager_diamond_axe", VILLAGER_DIAMOND_AXE);
		registeritem("villager_diamond_shovel", VILLAGER_DIAMOND_SHOVEL);
		registeritem("villager_diamond_hoe", VILLAGER_DIAMOND_HOE);
	}
	
    public static void enderpearlreinforceddiamondtoolsinit() {
    	registeritem("ender_diamond_sword", ENDER_DIAMOND_SWORD);
		registeritem("ender_diamond_pickaxe", ENDER_DIAMOND_PICKAXE);
		registeritem("ender_diamond_axe", ENDER_DIAMOND_AXE);
		registeritem("ender_diamond_shovel", ENDER_DIAMOND_SHOVEL);
		registeritem("ender_diamond_hoe", ENDER_DIAMOND_HOE);
	}
    
    public static void skydiamondtoolsinit() {
    	registeritem("sky_diamond_sword", SKY_DIAMOND_SWORD);
    	registeritem("sky_diamond_pickaxe", SKY_DIAMOND_PICKAXE);
    	registeritem("sky_diamond_axe", SKY_DIAMOND_AXE);
    	registeritem("sky_diamond_shovel", SKY_DIAMOND_SHOVEL);
		registeritem("sky_diamond_bow", SKY_DIAMOND_BOW);
	}
    
    public static void mysticalskydiamondtoolsinit() {
    	registeritem("mystical_sky_diamond_sword", MYSTICAL_SKY_DIAMOND_SWORD);
    	registeritem("mystical_sky_diamond_pickaxe", MYSTICAL_SKY_DIAMOND_PICKAXE);
    	registeritem("mystical_sky_diamond_axe", MYSTICAL_SKY_DIAMOND_AXE);
    	registeritem("mystical_sky_diamond_shovel", MYSTICAL_SKY_DIAMOND_SHOVEL);
    }

    public static void essencetoolsinit() {
		infersicotoolsinit();
		accidentiumtoolsinit();
		crudemediumtoolsinit();
		supericiotoolsinit();
		supreviciotoolsinit();
		sanisaniumtoolsinit();
	}

	public static void infersicotoolsinit() {
		registeritem("infersico_sword", INFERSICO_SWORD);
		registeritem("infersico_pickaxe", INFERSICO_PICKAXE);
		registeritem("infersico_axe", INFERSICO_AXE);
		registeritem("infersico_shovel", INFERSICO_SHOVEL);
		registeritem("infersico_hoe", INFERSICO_HOE);
		registeritem("infersico_bow", INFERSICO_BOW);
	}

	public static void accidentiumtoolsinit() {
		registeritem("accidentium_sword", ACCIDENTIUM_SWORD);
		registeritem("accidentium_pickaxe", ACCIDENTIUM_PICKAXE);
		registeritem("accidentium_axe", ACCIDENTIUM_AXE);
		registeritem("accidentium_shovel", ACCIDENTIUM_SHOVEL);
		registeritem("accidentium_hoe", ACCIDENTIUM_HOE);
		registeritem("accidentium_bow", ACCIDENTIUM_BOW);
	}

	public static void crudemediumtoolsinit() {
		registeritem("crudemedium_sword", CRUDEMEDIUM_SWORD);
		registeritem("crudemedium_pickaxe", CRUDEMEDIUM_PICKAXE);
		registeritem("crudemedium_axe", CRUDEMEDIUM_AXE);
		registeritem("crudemedium_shovel", CRUDEMEDIUM_SHOVEL);
		registeritem("crudemedium_hoe", CRUDEMEDIUM_HOE);
		registeritem("crudemedium_bow", CRUDEMEDIUM_BOW);
	}

	public static void supericiotoolsinit() {
		registeritem("supericio_sword", SUPERICIO_SWORD);
		registeritem("supericio_pickaxe", SUPERICIO_PICKAXE);
		registeritem("supericio_axe", SUPERICIO_AXE);
		registeritem("supericio_shovel", SUPERICIO_SHOVEL);
		registeritem("supericio_hoe", SUPERICIO_HOE);
		registeritem("supericio_bow", SUPERICIO_BOW);
	}

	public static void supreviciotoolsinit() {
		registeritem("suprevicio_sword", SUPREVICIO_SWORD);
		registeritem("suprevicio_pickaxe", SUPREVICIO_PICKAXE);
		registeritem("suprevicio_axe", SUPREVICIO_AXE);
		registeritem("suprevicio_shovel", SUPREVICIO_SHOVEL);
		registeritem("suprevicio_hoe", SUPREVICIO_HOE);
		registeritem("suprevicio_bow", SUPREVICIO_BOW);
	}
	public static void sanisaniumtoolsinit() {
		registeritem("sanisanium_sword", SANISANIUM_SWORD);
		registeritem("sanisanium_pickaxe", SANISANIUM_PICKAXE);
		registeritem("sanisanium_axe", SANISANIUM_AXE);
		registeritem("sanisanium_shovel", SANISANIUM_SHOVEL);
		registeritem("sanisanium_hoe", SANISANIUM_HOE);
		registeritem("sanisanium_bow", SANISANIUM_BOW);
	}


    public static void woodtoolsinit() {
    	oaktoolsinit();
    	sprucetoolsinit();
    	birchtoolsinit();
    	jungletoolsinit();
    	darkoaktoolsinit();
    	acaciatoolsinit();
    	crimsontoolsinit();
    	warpedtoolsinit();
    }
    
    public static void stonetoolsinit() {
    	andesitetoolsinit();
    	granitetoolsinit();
    	dioritetoolsinit();
    	deepslatetoolsinit();
    	blackstonetoolsinit();
    	basalttoolsinit();
    	furtorstonetoolsinit();
    }
    
    public static void oaktoolsinit() {
    	registeritem("oak_sword", OAK_SWORD);
		registerpickaxe("oak", ModdedToolMaterials.OAK, 1, -2.8f);
		registeraxe("oak", ModdedToolMaterials.OAK, 6, -3.2f);
		registershovel("oak", ModdedToolMaterials.OAK, 1, -3f);
		registerhoe("oak", ModdedToolMaterials.OAK, 0f);
    }
    
    public static void sprucetoolsinit() {
		registeritem("spruce_sword", SPRUCE_SWORD);
		registerpickaxe("spruce", ModdedToolMaterials.SPRUCE, 1, -2.8f);
		registeraxe("spruce", ModdedToolMaterials.SPRUCE, 6, -3.2f);
		registershovel("spruce", ModdedToolMaterials.SPRUCE, 1, -3f);
		registerhoe("spruce", ModdedToolMaterials.SPRUCE, 0f);
    }
    
    public static void birchtoolsinit() {
		registeritem("birch_sword", BIRCH_SWORD);
		registerpickaxe("birch", ModdedToolMaterials.BIRCH, 1, -2.8f);
		registeraxe("birch", ModdedToolMaterials.BIRCH, 6, -3.2f);
		registershovel("birch", ModdedToolMaterials.BIRCH, 1, -3f);
		registerhoe("birch", ModdedToolMaterials.BIRCH, 0f);
    }
    
    public static void jungletoolsinit() {
		registeritem("jungle_sword", JUNGLE_SWORD);
		registerpickaxe("jungle", ModdedToolMaterials.JUNGLE, 1, -2.8f);
		registeraxe("jungle", ModdedToolMaterials.JUNGLE, 6, -3.2f);
		registershovel("jungle", ModdedToolMaterials.JUNGLE, 1, -3f);
		registerhoe("jungle", ModdedToolMaterials.JUNGLE, 0f);
    }
    
    public static void darkoaktoolsinit() {
		registeritem("dark_oak_sword", DARK_OAK_SWORD);
		registerpickaxe("dark_oak", ModdedToolMaterials.DARK_OAK, 1, -2.8f);
		registeraxe("dark_oak", ModdedToolMaterials.DARK_OAK, 6, -3.2f);
		registershovel("dark_oak", ModdedToolMaterials.DARK_OAK, 1, -3f);
		registerhoe("dark_oak", ModdedToolMaterials.DARK_OAK, 0f);
    }
    
    public static void acaciatoolsinit() {
		registeritem("acacia_sword", ACACIA_SWORD);
		registerpickaxe("acacia", ModdedToolMaterials.ACACIA, 1, -2.8f);
		registeraxe("acacia", ModdedToolMaterials.ACACIA, 6, -3.2f);
		registershovel("acacia", ModdedToolMaterials.ACACIA, 1, -3f);
		registerhoe("acacia", ModdedToolMaterials.ACACIA, 0f);
    }
    
    public static void crimsontoolsinit() {
		registeritem("crimson_sword", CRIMSON_SWORD);
		registernetherpickaxe("crimson", ModdedToolMaterials.CRIMSON, 1, -2.8f);
		registernetheraxe("crimson", ModdedToolMaterials.CRIMSON, 6, -3.2f);
		registernethershovel("crimson", ModdedToolMaterials.CRIMSON, 1, -3f);
		registernetherhoe("crimson", ModdedToolMaterials.CRIMSON, 0f);
    }
    
    public static void warpedtoolsinit() {
		registeritem("warped_sword", WARPED_SWORD);
		registernetherpickaxe("warped", ModdedToolMaterials.WARPED, 1, -2.8f);
		registernetheraxe("warped", ModdedToolMaterials.WARPED, 6, -3.2f);
		registernethershovel("warped", ModdedToolMaterials.WARPED, 1, -3f);
		registernetherhoe("warped", ModdedToolMaterials.WARPED, 0f);
    }
    
    public static void andesitetoolsinit() {
		registeritem("andesite_sword", ANDESITE_SWORD);
		registerpickaxe("andesite", ModdedToolMaterials.ANDESITE, 1, -2.7f);
		registeraxe("andesite", ModdedToolMaterials.ANDESITE, 7, -3.2f);
		registershovel("andesite", ModdedToolMaterials.ANDESITE, 1, -2.9f);
		registerhoe("andesite", ModdedToolMaterials.ANDESITE, 0f);
    }
    
    public static void granitetoolsinit() {
		registeritem("granite_sword", GRANITE_SWORD);
		registerpickaxe("granite", ModdedToolMaterials.GRANITE, 1, -2.7f);
		registeraxe("granite", ModdedToolMaterials.GRANITE, 7, -3.2f);
		registershovel("granite", ModdedToolMaterials.GRANITE, 1, -2.9f);
		registerhoe("granite", ModdedToolMaterials.GRANITE, 0f);
    }
    
    public static void dioritetoolsinit() {
		registeritem("diorite_sword", DIORITE_SWORD);
		registerpickaxe("diorite", ModdedToolMaterials.DIORITE, 1, -2.7f);
		registeraxe("diorite", ModdedToolMaterials.DIORITE, 7, -3.2f);
		registershovel("diorite", ModdedToolMaterials.DIORITE, 1, -2.9f);
		registerhoe("diorite", ModdedToolMaterials.DIORITE, 0f);
    }

    public static void blackstonetoolsinit() {
		registeritem("blackstone_sword", BLACKSTONE_SWORD);
		registerpickaxe("blackstone", ModdedToolMaterials.BLACKSTONE, 1, -2.7f);
		registeraxe("blackstone", ModdedToolMaterials.BLACKSTONE, 7, -3.2f);
		registershovel("blackstone", ModdedToolMaterials.BLACKSTONE, 1, -2.9f);
		registerhoe("blackstone", ModdedToolMaterials.BLACKSTONE, 0f);
	}

	public static void basalttoolsinit() {
		registeritem("basalt_sword", BASALT_SWORD);
		registerpickaxe("basalt", ModdedToolMaterials.BASALT, 1, -2.7f);
		registeraxe("basalt", ModdedToolMaterials.BASALT, 7, -3.2f);
		registershovel("basalt", ModdedToolMaterials.BASALT, 1, -2.9f);
		registerhoe("basalt", ModdedToolMaterials.BASALT, 0f);
	}

	public static void deepslatetoolsinit() {
		registeritem("deepslate_sword", DEEPSLATE_SWORD);
		registerpickaxe("deepslate", ModdedToolMaterials.DEEPSLATE, 1, -2.7f);
		registeraxe("deepslate", ModdedToolMaterials.DEEPSLATE, 7, -3.2f);
		registershovel("deepslate", ModdedToolMaterials.DEEPSLATE, 1, -2.9f);
		registerhoe("deepslate", ModdedToolMaterials.DEEPSLATE, 0f);
	}

	public static void furtorstonetoolsinit() {

	}
	
	
}
