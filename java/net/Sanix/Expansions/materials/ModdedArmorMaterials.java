package net.Sanix.Expansions.materials;

import java.util.function.Supplier;

import net.Sanix.Expansions.registries.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public enum ModdedArmorMaterials implements ArmorMaterial {

	CARBON_DIAMOND("carbon_diamond", 140, new int[] {5, 8, 7, 4}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6f, 0.0f, () -> {
		return Ingredient.ofItems(ModItems.CARBON_DIAMOND);
	}),

	REINFORCED_DIAMOND("reinforced_diamond", 180, new int[] {7, 9, 9, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 7f, 0.0f, () -> {
		return Ingredient.ofItems(ModItems.REINFORCED_DIAMOND);
	}),

	VILLAGER_DIAMOND("emerald_reinforced_diamond", 220, new int[] {8, 10, 10, 7}, 45, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 7.5f, 0.0f, () -> {
		return Ingredient.ofItems(ModItems.VILLAGER_DIAMOND);
	}),

	ENDER_DIAMOND("ender_pearl_reinforced_diamond", 180, new int[] {9, 11, 11, 8}, 30, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 9f, 0.0f, () -> {
		return Ingredient.ofItems(ModItems.ENDER_DIAMOND);
	}),

	SKY_DIAMOND("sky_diamond", 548, new int[] {9, 18, 16, 12}, 55, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 12.0f, 0.0f, () -> {
		return Ingredient.ofItems(ModItems.SKY_DIAMOND);
	}),

	INFERSICO("infersico", 822, new int[] {15, 20, 17, 14}, 65, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5f, 0.05f, () -> {
		return Ingredient.ofItems(ModItems.INFERSICO_INGOT);
	}),

	ACCIDENTIUM("accidentium", 1000, new int[] {16, 21, 18, 15}, 70, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 15.0f, 0.1F, () -> {
		return Ingredient.ofItems(ModItems.ACCIDENTIUM_INGOT);
	}),

	CRUDEMEDIUM("crudemedium", 1235, new int[] {18, 25, 21, 18}, 80, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 17.5f, 0.2F, () -> {
		return Ingredient.ofItems(ModItems.CRUDEMEDIUM_INGOT);
	}),

	SUPERICIO("supericio", 1568, new int[] {21, 28, 25, 20}, 92, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 19.99f, 0.299F, () -> {
		return Ingredient.ofItems(ModItems.SUPERICIO_INGOT);
	}),

	SUPREVICIO("suprevicio", 1772, new int[] {25, 34, 30, 23}, 109, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 21.212121F, 0.314159265F, () -> {
		return Ingredient.ofItems(ModItems.SUPREVICIO_INGOT);
	}),

	SANISANIUM("sanisanium", 2121, new int[] {30, 38, 34, 29}, 121 , SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 25.2122232425F, 0.4111111F, () -> {
		return Ingredient.ofItems(ModItems.SANISANIUM_INGOT);
	}),

	EMPOWERED_SOULIUS("empowered_soulius", 9999, new int[] {42, 45, 40, 36}, 160 , SoundEvents.BLOCK_SOUL_SAND_PLACE, 60, 5f, () -> {
		return Ingredient.ofItems(ModItems.EMPOWERED_SOULIUS_INGOT);
	}),

	MYSTICAL_SKY_DIAMOND("mystical_sky_diamond", 1096, new int[] {18, 24, 20, 17}, 75, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 15.0f, 0.1F, () -> {
		return Ingredient.ofItems(ModItems.MYSTICAL_SKY_DIAMOND);
	});

	private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
	private final String name;
	private final int durabilityMultiplier;
	private final int[] protectionAmounts;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;


	private final Lazy<Ingredient> repairIngredientSupplier;

	ModdedArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackresistance, Supplier<Ingredient> ingredientSupplier) {
		   this.name = name;
		   this.durabilityMultiplier = durabilityMultiplier;
		   this.protectionAmounts = protectionAmounts;
		   this.enchantability = enchantability;
		   this.equipSound = equipSound;
		   this.toughness = toughness;
		   this.knockbackResistance = knockbackresistance;
		   this.repairIngredientSupplier = new Lazy<Ingredient>(ingredientSupplier);
		}

    public int getDurability(EquipmentSlot slot) {
	      return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
	}

	public int getProtectionAmount(EquipmentSlot slot) {
	      return this.protectionAmounts[slot.getEntitySlotId()];
	}

	public int getEnchantability() {
	   return this.enchantability;
	}

	public SoundEvent getEquipSound() {
	   return this.equipSound;
	}

	public Ingredient getRepairIngredient() {
	   return (Ingredient)this.repairIngredientSupplier.get();
	}

	@Environment(EnvType.CLIENT)
	public String getName() {
	   return this.name;
	}

	public float getToughness() {
	   return this.toughness;
	}

	public float getKnockbackResistance() { return this.knockbackResistance; }

}
