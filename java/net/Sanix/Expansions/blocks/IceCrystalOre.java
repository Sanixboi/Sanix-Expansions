package net.Sanix.Expansions.blocks;

import net.Sanix.Expansions.registries.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class IceCrystalOre extends OreBlock {

	public IceCrystalOre() {
		super(FabricBlockSettings.of(Material.STONE).breakByHand(false).requiresTool().breakByTool(FabricToolTags.PICKAXES, 6).sounds(BlockSoundGroup.METAL).hardness(37.1415926578421f).resistance(32.56878543f));
	}
	
	protected int getExperienceWhenMined(Random random) {
	      if (this == ModBlocks.ICE_CRYSTAL_ORE) {
	         return MathHelper.nextInt(random, 6, 24);
	      } else {
	    	  return 0;
	   }
	}
	
}
