package net.Sanix.Expansions.mixins;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.Sanix.Expansions.registries.ModRunes;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(SwordItem.class)
public class SwordItemMixin extends ToolItem {

    @Mutable
    @Shadow @Final private Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public SwordItemMixin(ToolMaterial material, Settings settings) {
        super(material, settings);
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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (user.getInventory().contains(new ItemStack(ModRunes.LEGACY_COMBAT_RUNE))) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
            float attackDamage = ((SwordItem) itemStack.getItem()).getAttackDamage();
            builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", attackDamage, EntityAttributeModifier.Operation.ADDITION));
            builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", (double)21.6f, EntityAttributeModifier.Operation.ADDITION));
            this.attributeModifiers = builder.build();
            user.setCurrentHand(hand);
            return TypedActionResult.consume(itemStack);
        }
        return super.use(world, user, hand);
    }
}
