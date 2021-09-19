package net.Sanix.Expansions.Toolbase.normal;

import net.Sanix.Expansions.materials.ModdedToolMaterials;
import net.Sanix.Expansions.registries.ModTools;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class PickaxeBase extends PickaxeItem {
	private boolean glint;
	public PickaxeBase(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings, boolean isglinted) {
		super(material, attackDamage, attackSpeed, settings);
		this.glint = isglinted;
	}

	@Override
	public void onCraft(ItemStack stack, World world, PlayerEntity player) {
		if (((PickaxeItem)stack.getItem()).getMaterial().equals(ModdedToolMaterials.EMPOWERED_SOULIUS)) {
			stack.addEnchantment(Enchantments.FORTUNE, 10);
			stack.addEnchantment(Enchantments.EFFICIENCY, 10);
		}
		super.onCraft(stack, world, player);
	}


	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (hand.equals(Hand.MAIN_HAND)) {
			ItemStack stack = user.getMainHandStack();
			ItemStack stack2 = new ItemStack(ModTools.EMPOWERED_SOULIUS_PICKAXE);
			stack2.addEnchantment(Enchantments.EFFICIENCY, 10);
			if (((PickaxeItem)stack.getItem()).getMaterial().equals(ModdedToolMaterials.EMPOWERED_SOULIUS)) {
				if (EnchantmentHelper.getEquipmentLevel(Enchantments.SILK_TOUCH, user) > 0 || !(EnchantmentHelper.getEquipmentLevel(Enchantments.FORTUNE, user) > 0)) {
					System.out.println("ok ???");
					stack2.addEnchantment(Enchantments.FORTUNE, 10);
					user.getInventory().setStack(user.getInventory().getSlotWithStack(stack), stack2);
					user.sendMessage(new TranslatableText("Set Pickaxe mode to: Fortune"), true);
				} else if (EnchantmentHelper.getEquipmentLevel(Enchantments.FORTUNE, user) > 0) {
					stack2.addEnchantment(Enchantments.SILK_TOUCH, 1);
					user.getInventory().setStack(user.getInventory().getSlotWithStack(stack), stack2);
					user.sendMessage(new TranslatableText("Set Pickaxe mode to: Silk Touch"), true);
				}
				//tag.putInt("is_silk", tag.getInt("is_silk") == 1 ? 0: 1);
			}
		}

		return super.use(world, user, hand);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		if (glint) {
			return true;
		}
		return super.hasGlint(stack);
	}

}
