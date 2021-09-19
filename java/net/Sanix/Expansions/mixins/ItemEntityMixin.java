package net.Sanix.Expansions.mixins;

import net.Sanix.Expansions.registries.ModBlocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    public ItemEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow public abstract ItemStack getStack();

    @Inject(at = @At("RETURN"), method = "damage")
    public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (getStack().getItem().equals(Items.GLOWSTONE)) {
            ItemEntity chglowstone = new ItemEntity(world, getX(), getY() + 10, getZ(), new ItemStack(ModBlocks.CHARGED_GLOWSTONE, this.getStack().getCount()));
            world.spawnEntity(chglowstone);
        } else if (getStack().getItem().equals(ModBlocks.CHARGED_GLOWSTONE.asItem())) {
            ItemEntity chglowstone = new ItemEntity(world, getX(), getY() + 10, getZ(), new ItemStack(ModBlocks.SUPERCHARGED_GLOWSTONE, this.getStack().getCount()));
            world.spawnEntity(chglowstone);
        }



    }
}
