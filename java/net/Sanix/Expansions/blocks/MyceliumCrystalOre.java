package net.Sanix.Expansions.blocks;

import net.Sanix.Expansions.registries.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class MyceliumCrystalOre extends OreBlock {

	public MyceliumCrystalOre() {
		super(FabricBlockSettings.of(Material.STONE).breakByHand(false).requiresTool().breakByTool(FabricToolTags.PICKAXES, 7).sounds(BlockSoundGroup.METAL).hardness(51.653426f).resistance(45.463643f));
	}
	
	protected int getExperienceWhenMined(Random random) {
	      if (this == ModBlocks.MYCELIUM_CRYSTAL_ORE) {
	         return MathHelper.nextInt(random, 12, 64);
	      } else {
	    	  return 0;
	   }
	}
	
}
