package net.Sanix.Expansions.registries;

import net.Sanix.Expansions.SanixExpansions;
import net.Sanix.Expansions.fluids.HyperAcid;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModFluids {

    public static FlowableFluid HYPER_ACID_STILL;
    public static FlowableFluid HYPER_ACID_FLOWING;
    public static Item HYPER_ACID_BUCKET;
    public static Block HYPER_ACID;

    public static void registerfluids() {
        HYPER_ACID_STILL = Registry.register(Registry.FLUID, new Identifier(SanixExpansions.MODID, "hyper_acid"), new HyperAcid.Still());
        HYPER_ACID_FLOWING = Registry.register(Registry.FLUID, new Identifier(SanixExpansions.MODID, "hyper_acid_flowing"), new HyperAcid.Flowing());
        HYPER_ACID_BUCKET = Registry.register(Registry.ITEM, new Identifier(SanixExpansions.MODID, "hyper_acid_bucket"), new BucketItem(HYPER_ACID_STILL, new Item.Settings().group(ModItemGroups.ITEMS).recipeRemainder(Items.BUCKET).maxCount(1)));;
        HYPER_ACID = Registry.register(Registry.BLOCK, new Identifier(SanixExpansions.MODID, "hyper_acid"), new FluidBlock(HYPER_ACID_STILL, FabricBlockSettings.copy(Blocks.LAVA)){});
    }
}
