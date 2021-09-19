package net.Sanix.Expansions.blocks;

import net.Sanix.Expansions.registries.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class SkyDiamondOre extends OreBlock {

	public SkyDiamondOre() {
		super(FabricBlockSettings.of(Material.STONE).breakByHand(false).requiresTool().breakByTool(FabricToolTags.PICKAXES, 5).sounds(BlockSoundGroup.METAL).hardness(15f).resistance(12f));
	}
	
	protected int getExperienceWhenMined(Random random) {
	      if (this == ModBlocks.SKY_DIAMOND_ORE) {
	         return MathHelper.nextInt(random, 0, 12);
	      } else {
	    	  return 0;
	   }
	}
	
}
