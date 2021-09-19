package net.Sanix.Expansions.Toolbase.normal;

import com.google.common.collect.ImmutableMultimap;
import net.Sanix.Expansions.registries.ModRunes;
import net.fabricmc.fabric.api.object.builder.v1.client.model.FabricModelPredicateProviderRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class BlockingSwordBase extends SwordItem {
	private boolean glint;
	public BlockingSwordBase(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings, boolean isglinted) {
		super(material, attackDamage, attackSpeed, settings);
		FabricModelPredicateProviderRegistry.register(this, new Identifier("blocking"),(itemStack, clientWorld, livingEntity, seed) -> {
			return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getActiveItem() == itemStack ? 1.0F : 0.0F;
		});
		this.glint = isglinted;
	}


	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BLOCK;
	}

	public String getTranslationKey(ItemStack stack) {
		return stack.getSubTag("BlockEntityTag") != null ? this.getTranslationKey() : super.getTranslationKey(stack);
	}


	public int getMaxUseTime(ItemStack stack) {
		return 72000;
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		if (glint) {
			return true;
		}
		return super.hasGlint(stack);
	}

	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if(hand.equals(Hand.MAIN_HAND) && user.getOffHandStack().getItem() instanceof ShieldItem && !user.getItemCooldownManager().isCoolingDown(user.getOffHandStack().getItem())) {
			return TypedActionResult.pass(user.getStackInHand(hand));
		} else {
			ItemStack itemStack = user.getStackInHand(hand);
			user.setCurrentHand(hand);
			return TypedActionResult.consume(itemStack);
		}

	}


	
	
}
