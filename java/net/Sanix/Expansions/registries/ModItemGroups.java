package net.Sanix.Expansions.registries;

import net.Sanix.Expansions.SanixExpansions;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static ItemGroup BLOCKS;
    public static ItemGroup ITEMS;
    public static ItemGroup TOOLS;
    public static ItemGroup ARMOR;
    public static ItemGroup COMPRESSED_BLOCKS;
    public static ItemGroup RUNES;
    public static ItemGroup COMPRESSED_ITEMS;
    public static ItemGroup INSPIRED_ITEMS;
    public static ItemGroup FOODS;

    public static void itemgroupsinit() {
        BLOCKS = FabricItemGroupBuilder.build(new Identifier(SanixExpansions.MODID, "blocks"), () -> new ItemStack(ModBlocks.SANIX_BLOCK));
        ITEMS = FabricItemGroupBuilder.build(new Identifier(SanixExpansions.MODID, "items"), () -> new ItemStack(ModItems.SKY_DIAMOND));
        TOOLS = FabricItemGroupBuilder.build(new Identifier(SanixExpansions.MODID, "tools"), () -> new ItemStack(ModTools.SKY_DIAMOND_PICKAXE));
        ARMOR = FabricItemGroupBuilder.build(new Identifier(SanixExpansions.MODID, "armor"), () -> new ItemStack(ModArmor.SKY_DIAMOND_HELMET));
        COMPRESSED_BLOCKS = FabricItemGroupBuilder.build(new Identifier(SanixExpansions.MODID, "compressed_blocks"), () -> new ItemStack(ModBlocks.COMPRESSED_DIAMOND_BLOCK));
        RUNES = FabricItemGroupBuilder.build(new Identifier(SanixExpansions.MODID, "runes"), () -> new ItemStack(ModRunes.EMPTY_RUNE));
        COMPRESSED_ITEMS = FabricItemGroupBuilder.build(new Identifier(SanixExpansions.MODID, "compressed_items"), () -> new ItemStack(ModItems.OCTUPLE_COMPRESSED_FEATHER));
        INSPIRED_ITEMS = FabricItemGroupBuilder.build(new Identifier(SanixExpansions.MODID, "inspired_items"), () -> new ItemStack(ModItems.INFERSICO_ESSENCE));
        FOODS = FabricItemGroupBuilder.build(new Identifier(SanixExpansions.MODID, "foods"), () -> new ItemStack(ModItems.MYSTICAL_SKY_DIAMOND_APPLE));
    }
}
