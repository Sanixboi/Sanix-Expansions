package net.Sanix.Expansions.registries;


import net.Sanix.Expansions.SanixExpansions;
import net.Sanix.Expansions.blocks.CrackedGlassBlock;
import net.Sanix.Expansions.blocks.IceCrystalOre;
import net.Sanix.Expansions.blocks.MyceliumCrystalOre;
import net.Sanix.Expansions.blocks.SkyDiamondOre;
import net.Sanix.Expansions.blocks.crops.*;
import net.Sanix.Expansions.blocks.stairs.ModStairsBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
	public static final Block SANIX_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(2.0f).resistance(1.5f));
	public static final Block RETRO_SANIX_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(2.0f).resistance(1.5f));
	public static final Block CLEANED_RETRO_SANIX_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(2.0f).resistance(1.5f));
	public static final Block BLUE_DYE_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(1.25f).resistance(1.0f));
	public static final Block CARBON_DIAMOND_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.METAL).hardness(5f).resistance(4f));
	public static final Block REINFORCED_DIAMOND_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL).hardness(7f).resistance(5.75f));
	public static final Block VILLAGER_DIAMOND_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL).hardness(8f).resistance(6.25f));
	public static final Block ENDER_DIAMOND_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL).hardness(10f).resistance(9.2512f));
	public static final Block COMPRESSED_END_STONE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(2.5f).resistance(1.0f));
	public static final Block SKY_DIAMOND_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).sounds(BlockSoundGroup.METAL).hardness(20f).resistance(15f));
	public static final Block MYSTICAL_SKY_DIAMOND_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).sounds(BlockSoundGroup.METAL).hardness(30f).resistance(20f));
	public static final Block COMPRESSED_DIAMOND_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.METAL).hardness(10f).resistance(6f));
	public static final Block COMPRESSED_EMERALD_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.METAL).hardness(11f).resistance(7f));
	public static final Block ICE_CRYSTAL_BLOCK = new Block(FabricBlockSettings.of(Material.ICE).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 6).sounds(BlockSoundGroup.METAL).hardness(65f).resistance(45f));
	public static final Block REVERSE_ICE_CRYSTAL_BLOCK = new Block(FabricBlockSettings.of(Material.ICE).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 6).sounds(BlockSoundGroup.METAL).hardness(65f).resistance(45f));
	public static final Block MYCELIUM_CRYSTAL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().sounds(BlockSoundGroup.METAL).hardness(120f).resistance(100f));
	public static final Block REVERSE_MYCELIUM_CRYSTAL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().sounds(BlockSoundGroup.METAL).hardness(120f).resistance(100f));
	public static final Block DOUBLE_COMPRESSED_END_STONE = new Block(FabricBlockSettings.of(Material.STONE).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).hardness(5f).resistance(3.4857379341f));
	public static final Block SKY_DIAMOND_ORE = new SkyDiamondOre();
	public static final Block ICE_CRYSTAL_ORE = new IceCrystalOre();
	public static final Block MYCELIUM_CRYSTAL_ORE = new MyceliumCrystalOre();
	public static final Block INFERSICO_CROP = new InfersicoSeedCrop(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Block ACCIDENTIUM_CROP = new AccidentiumSeedCrop(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Block CRUDEMEDIUM_CROP = new CrudemediumSeedCrop(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Block SUPERICIO_CROP = new SupericioSeedCrop(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Block SUPREVICIO_CROP = new SuprevicioSeedCrop(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Block SANISANIUM_CROP = new SanisaniumSeedCrop(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Block INFERSICO_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.METAL).hardness(5f).resistance(2f)); //sky
	public static final Block ACCIDENTIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 1).sounds(BlockSoundGroup.METAL).hardness(22f).resistance(16f)); // sky
	public static final Block CRUDEMEDIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.METAL).hardness(26f).resistance(19f)); //mystical
	public static final Block SUPERICIO_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.METAL).hardness(34f).resistance(23f)); // mystical block
	public static final Block SUPREVICIO_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL).hardness(55f).resistance(40f)); // ice block
	public static final Block SANISANIUM_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL).hardness(100f).resistance(70f));
	public static final Block INFERSICO_INGOT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.METAL).hardness(13f).resistance(8f)); //sky
	public static final Block ACCIDENTIUM_INGOT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 1).sounds(BlockSoundGroup.METAL).hardness(20f).resistance(14f)); // sky
	public static final Block CRUDEMEDIUM_INGOT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.METAL).hardness(24f).resistance(17f)); //mystical
	public static final Block SUPERICIO_INGOT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.METAL).hardness(32f).resistance(21f)); // mystical block
	public static final Block SUPREVICIO_INGOT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL).hardness(57f).resistance(38f)); // ice block
	public static final Block SANISANIUM_INGOT_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).requiresTool().breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.METAL).hardness(98f).resistance(68f));
	public static final Block HYPERRACK = new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.NETHERRACK).hardness(50f).resistance(40f).breakByTool(FabricToolTags.PICKAXES));
	public static final Block CORRUPTSTONE = new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE).hardness(75f).resistance(69f).breakByTool(FabricToolTags.PICKAXES));
	public static final Block FUTURISTIC_REMAINS = new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 5).sounds(BlockSoundGroup.ANCIENT_DEBRIS).hardness(125f).resistance(100f));
	public static final Block WARPEDSTONE = new Block(FabricBlockSettings.of(Material.GLASS, MapColor.DARK_AQUA).requiresTool().strength(0.5F).sounds(BlockSoundGroup.GLASS).luminance((state) -> 15));
	public static final Block CHARGED_GLOWSTONE = new Block(FabricBlockSettings.of(Material.GLASS, MapColor.DIAMOND_BLUE).requiresTool().strength(0.5F).sounds(BlockSoundGroup.GLASS).luminance((state) -> 20));
	public static final Block SUPERCHARGED_GLOWSTONE = new Block(FabricBlockSettings.of(Material.GLASS, MapColor.LIGHT_BLUE).requiresTool().strength(0.5F).sounds(BlockSoundGroup.GLASS).luminance((state) -> 30));
	public static final Block LIQUIDSTONE = new Block(FabricBlockSettings.of(Material.GLASS, MapColor.DARK_AQUA));
	public static final Block ANCIENT_ICE = new Block(FabricBlockSettings.of(Material.DENSE_ICE).sounds(BlockSoundGroup.GLASS).slipperiness(1f).breakByTool(FabricToolTags.PICKAXES).strength(0.6f));

	//blocks from Sanix Additions (CT 8c)
	public static final Block WHITE_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.WHITE).requiresTool().strength(1));
	public static final Block YELLOW_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.YELLOW).requiresTool().strength(1));
	public static final Block GREEN_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.GREEN).requiresTool().strength(1));
	public static final Block BLUE_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.BLUE).requiresTool().strength(1));
	public static final Block RED_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.RED).requiresTool().strength(1));
	public static final Block LIME_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.LIME).requiresTool().strength(1));
	public static final Block MAGENTA_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.MAGENTA).requiresTool().strength(1));
	public static final Block BLACK_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.BLACK).requiresTool().strength(1));
	public static final Block LIGHT_BLUE_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.LIGHT_BLUE).requiresTool().strength(1));
	public static final Block GRAY_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.GRAY).requiresTool().strength(1));
	public static final Block LIGHT_GRAY_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.LIGHT_GRAY).requiresTool().strength(1));
	public static final Block CYAN_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.CYAN).requiresTool().strength(1));
	public static final Block ORANGE_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.ORANGE).requiresTool().strength(1));
	public static final Block PINK_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.PINK).requiresTool().strength(1));
	public static final Block PURPLE_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.PURPLE).requiresTool().strength(1));
	public static final Block BROWN_GLAZED_CONCRETE = new Block(FabricBlockSettings.of(Material.STONE, DyeColor.BROWN).requiresTool().strength(1));

	public static final Block CRACKED_GLASS = new CrackedGlassBlock(FabricBlockSettings.of(Material.GLASS).sounds(BlockSoundGroup.GLASS).strength(0.15f));
	public static final Block CRACKED_TINTED_GLASS = new TintedGlassBlock(FabricBlockSettings.copy(CRACKED_GLASS));
	public static final Block CRACKED_OAK_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).strength(1f, 1.5f));
	public static final Block CRACKED_SPRUCE_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).strength(1f, 1.5f));
	public static final Block CRACKED_BIRCH_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).strength(1f, 1.5f));
	public static final Block CRACKED_JUNGLE_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).strength(1f, 1.5f));
	public static final Block CRACKED_DARK_OAK_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).strength(1f, 1.5f));
	public static final Block CRACKED_ACACIA_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).strength(1f, 1.5f));
	public static final Block CRACKED_WARPED_PLANKS = new Block(FabricBlockSettings.of(Material.NETHER_WOOD).strength(1f));
	public static final Block CRACKED_CRIMSON_PLANKS = new Block(FabricBlockSettings.of(Material.NETHER_WOOD).strength(1f));

	public static final Block SANDY_IRON_BLOCK = new Block(FabricBlockSettings.of(Material.METAL, MapColor.PALE_YELLOW));

	//hyper nether blocks
	public static final Block SPIROUS_HYLIUM = new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.NYLIUM));
	public static final Block TAINTED_HYLIUM = new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.NYLIUM));
	public static final Block HYPER_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE));
	public static final Block HYPER_BRICKS_STAIRS = new ModStairsBlock(HYPER_BRICKS.getDefaultState(), FabricBlockSettings.copy(HYPER_BRICKS));
	public static final Block HYPER_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copy(HYPER_BRICKS));
	public static final Block POLISHED_HYPER_BRICKS = new Block(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.STONE));
	public static final Block POLISHED_HYPER_BRICKS_STAIRS = new ModStairsBlock(POLISHED_HYPER_BRICKS.getDefaultState(), FabricBlockSettings.copy(POLISHED_HYPER_BRICKS));
	public static final Block POLISHED_HYPER_BRICKS_SLAB = new SlabBlock(FabricBlockSettings.copy(POLISHED_HYPER_BRICKS));

	// mystical sky FabricBlockSettings.of(Material.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).sounds(BlockSoundGroup.METAL).hardness(30f).resistance(20f)
	// sky FabricBlockSettings.of(Material.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).sounds(BlockSoundGroup.METAL).hardness(20f).resistance(15f)
	
	public static void blockinit() {
		registerfullBlock("sanix_block", SANIX_BLOCK, false);
		registerfullBlock("retro_sanix_block", RETRO_SANIX_BLOCK, false);
		registerfullBlock("cleaned_retro_sanix_block", CLEANED_RETRO_SANIX_BLOCK, false);
		registerfullBlock("blue_dye_block", BLUE_DYE_BLOCK, false);
		registerfullBlock("carbon_diamond_block", CARBON_DIAMOND_BLOCK, false);
		registerfullBlock("reinforced_diamond_block", REINFORCED_DIAMOND_BLOCK, false);
		registerfullBlock("villager_diamond_block", VILLAGER_DIAMOND_BLOCK, false);
		registerfullBlock("ender_diamond_block", ENDER_DIAMOND_BLOCK, false);
		registerfullBlock("sky_diamond_ore", SKY_DIAMOND_ORE, false);
		registerfullBlock("compressed_end_stone", COMPRESSED_END_STONE, true);
		registerfullBlock("sky_diamond_block", SKY_DIAMOND_BLOCK, false);
		registerfullBlock("mystical_sky_diamond_block", MYSTICAL_SKY_DIAMOND_BLOCK, false);
		registerfullBlock("compressed_diamond_block", COMPRESSED_DIAMOND_BLOCK, true);
		registerfullBlock("compressed_emerald_block", COMPRESSED_EMERALD_BLOCK, true);
		registerfullBlock("ice_crystal_block", ICE_CRYSTAL_BLOCK, false);
		registerfullBlock("reverse_ice_crystal_block", REVERSE_ICE_CRYSTAL_BLOCK, false);
		registerfullBlock("mycelium_crystal_block", MYCELIUM_CRYSTAL_BLOCK, false);
		registerfullBlock("reverse_mycelium_crystal_block", REVERSE_MYCELIUM_CRYSTAL_BLOCK, false);
		registerfullBlock("ice_crystal_ore", ICE_CRYSTAL_ORE, false);
		registerfullBlock("mycelium_crystal_ore", MYCELIUM_CRYSTAL_ORE, false);
		registerfullBlock("double_compressed_end_stone", DOUBLE_COMPRESSED_END_STONE, true);
		registerfullBlock("infersico_block", INFERSICO_BLOCK, false);
		registerfullBlock("accidentium_block", ACCIDENTIUM_BLOCK, false);
		registerfullBlock("crudemedium_block", CRUDEMEDIUM_BLOCK, false);
		registerfullBlock("supericio_block", SUPERICIO_BLOCK, false);
		registerfullBlock("suprevicio_block", SUPREVICIO_BLOCK, false);
		registerfullBlock("sanisanium_block", SANISANIUM_BLOCK, false);
		registerfullBlock("infersico_ingot_block", INFERSICO_INGOT_BLOCK, false);
		registerfullBlock("accidentium_ingot_block", ACCIDENTIUM_INGOT_BLOCK, false);
		registerfullBlock("crudemedium_ingot_block", CRUDEMEDIUM_INGOT_BLOCK, false);
		registerfullBlock("supericio_ingot_block", SUPERICIO_INGOT_BLOCK, false);
		registerfullBlock("suprevicio_ingot_block", SUPREVICIO_INGOT_BLOCK, false);
		registerfullBlock("sanisanium_ingot_block", SANISANIUM_INGOT_BLOCK, false);
		registerfullBlock("hyperrack", HYPERRACK, false);
		registerfullBlock("corruptstone", CORRUPTSTONE, false);
		registerfullBlock("futuristic_remains", FUTURISTIC_REMAINS, false);
		registerfullBlock("charged_glowstone", CHARGED_GLOWSTONE, false);
		registerfullBlock("supercharged_glowstone", SUPERCHARGED_GLOWSTONE, false);
		registerfullBlock("warpedstone", WARPEDSTONE, false);
		registerfullBlock("liquidstone", LIQUIDSTONE, false);
		registerfullBlock("ancient_ice", ANCIENT_ICE, false);
		//SA blocks
		registerfullBlock("white_glazed_concrete", WHITE_GLAZED_CONCRETE, false);
		registerfullBlock("orange_glazed_concrete", ORANGE_GLAZED_CONCRETE, false);
		registerfullBlock("magenta_glazed_concrete", MAGENTA_GLAZED_CONCRETE, false);
		registerfullBlock("light_blue_glazed_concrete", LIGHT_BLUE_GLAZED_CONCRETE, false);
		registerfullBlock("yellow_glazed_concrete", YELLOW_GLAZED_CONCRETE, false);
		registerfullBlock("lime_glazed_concrete", LIME_GLAZED_CONCRETE, false);
		registerfullBlock("pink_glazed_concrete", PINK_GLAZED_CONCRETE, false);
		registerfullBlock("gray_glazed_concrete", GRAY_GLAZED_CONCRETE, false);
		registerfullBlock("light_gray_glazed_concrete", LIGHT_GRAY_GLAZED_CONCRETE, false);
		registerfullBlock("cyan_glazed_concrete", CYAN_GLAZED_CONCRETE, false);
		registerfullBlock("purple_glazed_concrete", PURPLE_GLAZED_CONCRETE, false);
		registerfullBlock("blue_glazed_concrete", BLUE_GLAZED_CONCRETE, false);
		registerfullBlock("brown_glazed_concrete", BROWN_GLAZED_CONCRETE, false);
		registerfullBlock("green_glazed_concrete", GREEN_GLAZED_CONCRETE, false);
		registerfullBlock("red_glazed_concrete", RED_GLAZED_CONCRETE, false);
		registerfullBlock("black_glazed_concrete", BLACK_GLAZED_CONCRETE, false);

		registerfullBlock("cracked_glass", CRACKED_GLASS, false);
		registerfullBlock("cracked_tinted_glass", CRACKED_TINTED_GLASS, false);
		registerfullBlock("cracked_oak_planks", CRACKED_OAK_PLANKS, false);
		registerfullBlock("cracked_spruce_planks", CRACKED_SPRUCE_PLANKS, false);
		registerfullBlock("cracked_birch_planks", CRACKED_BIRCH_PLANKS, false);
		registerfullBlock("cracked_jungle_planks", CRACKED_JUNGLE_PLANKS, false);
		registerfullBlock("cracked_dark_oak_planks", CRACKED_DARK_OAK_PLANKS, false);
		registerfullBlock("cracked_acacia_planks", CRACKED_ACACIA_PLANKS, false);
		registerfullBlock("cracked_warped_planks", CRACKED_WARPED_PLANKS, false);
		registerfullBlock("cracked_crimson_planks", CRACKED_CRIMSON_PLANKS, false);

		registerfullBlock("sandy_iron_block", SANDY_IRON_BLOCK, false);
		registerfullBlock("spirous_hylium", SPIROUS_HYLIUM, false); //hyper + nylium = hylium huh helium
		registerfullBlock("tainted_hylium", TAINTED_HYLIUM, false);
		registerfullBlock("hyper_bricks", HYPER_BRICKS, false);
		registerfullBlock("hyper_bricks_stairs", HYPER_BRICKS_STAIRS, false);
		registerfullBlock("hyper_bricks_slab", HYPER_BRICKS_SLAB, false);
		registerfullBlock("polished_hyper_bricks", POLISHED_HYPER_BRICKS, false);
		registerfullBlock("polished_hyper_bricks_stairs", POLISHED_HYPER_BRICKS_STAIRS, false);
		registerfullBlock("polished_hyper_bricks_slab", POLISHED_HYPER_BRICKS_SLAB, false);

		Registry.register(Registry.BLOCK, new Identifier(SanixExpansions.MODID, "infersico_crop"), INFERSICO_CROP);
		Registry.register(Registry.BLOCK, new Identifier(SanixExpansions.MODID, "accidentium_crop"), ACCIDENTIUM_CROP);
		Registry.register(Registry.BLOCK, new Identifier(SanixExpansions.MODID, "crudemedium_crop"), CRUDEMEDIUM_CROP);
		Registry.register(Registry.BLOCK, new Identifier(SanixExpansions.MODID, "supericio_crop"), SUPERICIO_CROP);
		Registry.register(Registry.BLOCK, new Identifier(SanixExpansions.MODID, "suprevicio_crop"), SUPREVICIO_CROP);
		Registry.register(Registry.BLOCK, new Identifier(SanixExpansions.MODID, "sanisanium_crop"), SANISANIUM_CROP);
	}
	
	public static <T extends Block> T registerBlock(String block, T entry) {
		return Registry.register(Registry.BLOCK, new Identifier(SanixExpansions.MODID, block), entry);
	}
	
	public static BlockItem registerBlockItem(String blockitem, Block block, boolean c) {
		if (c) {
			return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, blockitem), new BlockItem(block, new Item.Settings().group(ModItemGroups.COMPRESSED_BLOCKS)));
		} else {
			return Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, blockitem), new BlockItem(block, new Item.Settings().group(ModItemGroups.BLOCKS)));
		}
	}
	
	public static <T extends Block> void registerfullBlock (String blockname, T entry, boolean ifcompress) {
		registerBlock(blockname, entry);
		registerBlockItem(blockname, entry, ifcompress);
	}
	
}
