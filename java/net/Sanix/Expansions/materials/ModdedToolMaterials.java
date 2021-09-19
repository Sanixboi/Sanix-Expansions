package net.Sanix.Expansions.materials;

import net.Sanix.Expansions.registries.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModdedToolMaterials implements ToolMaterial {

    OAK(60, 2, 0, 0, 15, () -> {
        return Ingredient.ofItems(Blocks.OAK_PLANKS);
    }),

    SPRUCE(70, 2, 0, 0, 16, () -> {
        return Ingredient.ofItems(Blocks.SPRUCE_PLANKS);
    }),

    BIRCH(60, 2, 0, 0, 15, () -> {
        return Ingredient.ofItems(Blocks.BIRCH_PLANKS);
    }),

    JUNGLE(80, 2, 0, 0, 17, () -> {
        return Ingredient.ofItems(Blocks.JUNGLE_PLANKS);
    }),

    DARK_OAK(70, 2, 0, 0, 16, () -> {
        return Ingredient.ofItems(Blocks.DARK_OAK_PLANKS);
    }),

    ACACIA(65, 2, 0, 0, 16, () -> {
        return Ingredient.ofItems(Blocks.ACACIA_PLANKS);
    }),

    CRIMSON(90, 3, 0, 0, 18, () -> {
        return Ingredient.ofItems(Blocks.CRIMSON_PLANKS);
    }),

    WARPED(90, 3, 0, 0, 18, () -> {
        return Ingredient.ofItems(Blocks.WARPED_PLANKS);
    }),

    ANDESITE(140, 4, 1, 1, 5, () -> {
        return Ingredient.ofItems(Blocks.ANDESITE);
    }),

    GRANITE(145, 4, 1, 1, 5, () -> {
        return Ingredient.ofItems(Blocks.GRANITE);
    }),

    DIORITE(150, 4, 1, 1, 5, () -> {
        return Ingredient.ofItems(Blocks.DIORITE);
    }),

    DEEPSLATE(160, 5, 1, 1, 5, () -> Ingredient.ofItems(Blocks.DEEPSLATE)),

    BLACKSTONE(170, 6, 1, 1, 6, () -> Ingredient.ofItems(Blocks.BLACKSTONE)),

    BASALT(175, 6, 1, 1, 6, () -> Ingredient.ofItems(Blocks.BASALT)),

    CARBON_DIAMOND(1625, 11.25F, 3F, 3, 17, () -> {
        return Ingredient.ofItems(ModItems.CARBON_DIAMOND);
    }),

    REINFORCED_DIAMOND(2150, 26, 4F, 4, 30, () -> {
        return Ingredient.ofItems(ModItems.REINFORCED_DIAMOND);
    }),

    VILLAGER_DIAMOND(2475, 30, 4F, 4, 33, () -> {
        return Ingredient.ofItems(ModItems.VILLAGER_DIAMOND);
    }),

    ENDER_DIAMOND(2760, 42, 4F, 5, 45, () -> {
        return Ingredient.ofItems(ModItems.ENDER_DIAMOND);
    }),

    SKY_DIAMOND(7625, 62, 5F, 6, 55, () -> {
        return Ingredient.ofItems(ModItems.SKY_DIAMOND);
    }),

    MYSTICAL_SKY_DIAMOND(27550, 90, 10F, 7, 75, () -> {
        return Ingredient.ofItems(ModItems.MYSTICAL_SKY_DIAMOND);
    }),


    INFERSICO(9256/*This is the closest to the original sky diamond durability*/, 71, 5F, 6, 60, () -> {
        return Ingredient.ofItems(ModItems.INFERSICO_INGOT);
    }),

    ACCIDENTIUM(14372, 79, 6F, 6, 67, () -> {
        return Ingredient.ofItems(ModItems.ACCIDENTIUM_INGOT);
    }),

    CRUDEMEDIUM(21212, 85, 7F, 7, 70, () -> {
        return Ingredient.ofItems(ModItems.CRUDEMEDIUM_INGOT);
    }),

    SUPERICIO(29999, 94, 8F, 7, 78, () -> {
        return Ingredient.ofItems(ModItems.SUPERICIO_INGOT);
    }),

    SUPREVICIO(39682, 105, 9F, 7, 87, () -> {
        return Ingredient.ofItems(ModItems.SUPREVICIO_INGOT);
    }),

    SANISANIUM(54600 /*The old Mystical Sky diamond Durability*/, 125.25F, 10F, 8, 121, () -> {
        return Ingredient.ofItems(ModItems.SANISANIUM_INGOT);
    }),

    EMPOWERED_SOULIUS(99999, 150, 15F, 9, 160, () -> {
        return Ingredient.ofItems(ModItems.EMPOWERED_SOULIUS_INGOT);
    });

    private final int durability;
    private final float miningspeedMultiplier;
    private final float attackdamage;
    private final int mininglevel;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;


    ModdedToolMaterials(int durability, float miningspeed, float attackdamage, int mininglevel, int enchantability, Supplier<Ingredient> ingredient) {
        this.durability = durability;
        this.miningspeedMultiplier = miningspeed;
        this.attackdamage = attackdamage;
        this.mininglevel = mininglevel;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy<Ingredient>(ingredient);
    }
    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningspeedMultiplier;
    }

    @Override
    public float getAttackDamage() {
        return this.attackdamage;
    }

    @Override
    public int getMiningLevel() {
        return this.mininglevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
