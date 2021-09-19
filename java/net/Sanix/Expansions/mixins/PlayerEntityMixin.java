package net.Sanix.Expansions.mixins;

import net.Sanix.Expansions.SanixExpansions;
import net.Sanix.Expansions.registries.*;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.ItemCooldownManager;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;


@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    @Final
    @Shadow
    public PlayerInventory inventory;
    @Shadow
    protected EnderChestInventory enderChestInventory;

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);
    @Shadow protected abstract void vanishCursedItems();


    @Shadow public abstract boolean isSpectator();


    @Shadow public abstract void startFallFlying();

    @Shadow @Final private ItemCooldownManager itemCooldownManager;

    @Shadow public abstract void setFireTicks(int ticks);

    @Shadow @Final public PlayerAbilities abilities;


    @Shadow public abstract void playSound(SoundEvent event, SoundCategory category, float volume, float pitch);

    @Shadow public abstract ItemCooldownManager getItemCooldownManager();

    @Shadow public abstract PlayerAbilities getAbilities();

    @Shadow public double capeX;

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }


    @Inject(at = @At("HEAD"), method = "takeShieldHit")
    protected void takeShieldHit(LivingEntity attacker, CallbackInfo info) {
        super.takeShieldHit(attacker);
        if (attacker.getMainHandStack().getItem() instanceof AxeItem) {
            float f = 0.25F + (float)EnchantmentHelper.getEfficiency(this) * 0.05F;
            f += 0.75F;

            FabricLoader loader = FabricLoader.getInstance();
            if (loader.isModLoaded("fabricshieldlib")) {
                double shieldlvl = 1;
                System.out.println(shieldlvl);
                System.out.println((int)(150 / shieldlvl));
                if (this.random.nextFloat() < f) {
                    if (attacker.getMainHandStack().getItem().equals(ModTools.ACCIDENTIUM_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), (int)(150 / shieldlvl));
                    } else if (attacker.getMainHandStack().getItem().equals(ModTools.CRUDEMEDIUM_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), (int)(300 / shieldlvl));
                    } else if (attacker.getMainHandStack().getItem().equals(ModTools.SUPERICIO_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), (int)(600 / shieldlvl));
                    } else if (attacker.getMainHandStack().getItem().equals(ModTools.SUPREVICIO_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), (int)(1000 / shieldlvl));
                    } else if  (attacker.getMainHandStack().getItem().equals(ModTools.SANISANIUM_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), (int)(1600 / shieldlvl));
                    } else if (attacker.getMainHandStack().getItem().equals(ModTools.EMPOWERED_SOULIUS_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), (int)(3200 / shieldlvl));
                    } else {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), (int)(100 / shieldlvl));
                    }

                    this.clearActiveItem();
                    this.world.sendEntityStatus(this, (byte)30);
                }
            } else {
                System.out.println("!mod");
                if (this.random.nextFloat() < f) {
                    if (attacker.getMainHandStack().getItem().equals(ModTools.ACCIDENTIUM_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), 150);
                    } else if (attacker.getMainHandStack().getItem().equals(ModTools.CRUDEMEDIUM_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), 300);
                    } else if (attacker.getMainHandStack().getItem().equals(ModTools.SUPERICIO_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), 600);
                    } else if (attacker.getMainHandStack().getItem().equals(ModTools.SUPREVICIO_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), 1000);
                    } else if  (attacker.getMainHandStack().getItem().equals(ModTools.SANISANIUM_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), 1600);
                    } else if (attacker.getMainHandStack().getItem().equals(ModTools.EMPOWERED_SOULIUS_AXE)) {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), 3200);
                    } else {
                        this.getItemCooldownManager().set(getActiveItem().getItem(), 100);
                    }

                    this.clearActiveItem();
                    this.world.sendEntityStatus(this, (byte)30);
                }
            }


        }

    }

    /**
     * @author Sanixboi
     * @reason was a simple method to replace anyways
     */
    @Overwrite
    public void dropInventory() {
        System.out.println("ok this may work");
        if (!this.world.getGameRules().getBoolean(GameRules.KEEP_INVENTORY) && !(inventory.contains(new ItemStack(ModRunes.INVENTORY_RUNE)))) {
            this.vanishCursedItems();
            this.inventory.dropAll();
        }
    }


    @Inject(at = @At("HEAD"), method = "isInvulnerableTo", cancellable = true)
    public void isInvulnerableTo(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        ItemStack hs = getEquippedStack(EquipmentSlot.HEAD);
        ItemStack cs = getEquippedStack(EquipmentSlot.CHEST);
        ItemStack ls = getEquippedStack(EquipmentSlot.LEGS);
        ItemStack bs/*it's boots stack btw don't get confused*/ = getEquippedStack(EquipmentSlot.FEET);

        boolean supericioarmor = hs.getItem().equals(ModArmor.SUPERICIO_HELMET) && cs.getItem().equals(ModArmor.SUPERICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPERICIO_LEGGINGS) && bs.getItem().equals(ModArmor.SUPERICIO_BOOTS);
        boolean suprevicioarmor = hs.getItem().equals(ModArmor.SUPREVICIO_HELMET) && cs.getItem().equals(ModArmor.SUPREVICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPREVICIO_LEGGINGS) && bs.getItem().equals(ModArmor.SUPREVICIO_BOOTS);
        boolean sanisaniumarmor = hs.getItem().equals(ModArmor.SANISANIUM_HELMET) && cs.getItem().equals(ModArmor.SANISANIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.SANISANIUM_LEGGINGS) && bs.getItem().equals(ModArmor.SANISANIUM_BOOTS);
        boolean empoweredsouliusarmor = hs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_HELMET) && cs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_CHESTPLATE) && ls.getItem().equals(ModArmor.EMPOWERED_SOULIUS_LEGGINGS) && bs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_BOOTS);

        boolean nofallperk = supericioarmor || suprevicioarmor || sanisaniumarmor || empoweredsouliusarmor;

        if (damageSource == DamageSource.FALL) {
            cir.setReturnValue(!this.world.getGameRules().getBoolean(GameRules.FALL_DAMAGE) || nofallperk);
        }
    }



    /**
     * @author Sanixboi
     * @reason stuff
     * **/
    @Overwrite
    public float getBlockBreakingSpeed(BlockState block) {
        float f = this.inventory.getBlockBreakingSpeed(block);

        ItemStack hs = getEquippedStack(EquipmentSlot.HEAD);
        ItemStack cs = getEquippedStack(EquipmentSlot.CHEST);
        ItemStack ls = getEquippedStack(EquipmentSlot.LEGS);
        ItemStack bs = getEquippedStack(EquipmentSlot.FEET);

        boolean accidentiumarmor = hs.getItem().equals(ModArmor.ACCIDENTIUM_HELMET) && cs.getItem().equals(ModArmor.ACCIDENTIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.ACCIDENTIUM_LEGGINGS) && bs.getItem().equals(ModArmor.ACCIDENTIUM_BOOTS);
        boolean crudemediumarmor = hs.getItem().equals(ModArmor.CRUDEMEDIUM_HELMET) && cs.getItem().equals(ModArmor.CRUDEMEDIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.CRUDEMEDIUM_LEGGINGS) && bs.getItem().equals(ModArmor.CRUDEMEDIUM_BOOTS);
        boolean supericioarmor = hs.getItem().equals(ModArmor.SUPERICIO_HELMET) && cs.getItem().equals(ModArmor.SUPERICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPERICIO_LEGGINGS) && bs.getItem().equals(ModArmor.SUPERICIO_BOOTS);
        boolean suprevicioarmor = hs.getItem().equals(ModArmor.SUPREVICIO_HELMET) && cs.getItem().equals(ModArmor.SUPREVICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPREVICIO_LEGGINGS) && bs.getItem().equals(ModArmor.SUPREVICIO_BOOTS);
        boolean sanisaniumarmor = hs.getItem().equals(ModArmor.SANISANIUM_HELMET) && cs.getItem().equals(ModArmor.SANISANIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.SANISANIUM_LEGGINGS) && bs.getItem().equals(ModArmor.SANISANIUM_BOOTS);
        boolean empoweredsouliusarmor = hs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_HELMET) && cs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_CHESTPLATE) && ls.getItem().equals(ModArmor.EMPOWERED_SOULIUS_LEGGINGS) && bs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_BOOTS);
        boolean waterhelmperk = hs.getItem().equals(ModArmor.ACCIDENTIUM_HELMET) || hs.getItem().equals(ModArmor.CRUDEMEDIUM_HELMET) || hs.getItem().equals(ModArmor.SUPERICIO_HELMET) || hs.getItem().equals(ModArmor.SUPREVICIO_HELMET) || hs.getItem().equals(ModArmor.SANISANIUM_HELMET) || hs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_HELMET);

        boolean delaylessperk = sanisaniumarmor || empoweredsouliusarmor;

        if (f > 1.0F) {
            int i = EnchantmentHelper.getEfficiency(this);
            ItemStack itemStack = this.getMainHandStack();
            if (i > 0 && !itemStack.isEmpty()) {
                f += (float)(i * i + 1);
            }
        }

        if (StatusEffectUtil.hasHaste(this)) {
            f *= 1.0F + (float)(StatusEffectUtil.getHasteAmplifier(this) + 1) * 0.2F;
        }

        if (this.hasStatusEffect(StatusEffects.MINING_FATIGUE)) {
            float k;
            switch(this.getStatusEffect(StatusEffects.MINING_FATIGUE).getAmplifier()) {
                case 0:
                    k = 0.3F;
                    break;
                case 1:
                    k = 0.09F;
                    break;
                case 2:
                    k = 0.0027F;
                    break;
                case 3:
                default:
                    k = 8.1E-4F;
            }

            f *= k;
        }

        if (this.isSubmergedIn(FluidTags.WATER) && !EnchantmentHelper.hasAquaAffinity(this) && !waterhelmperk) {
            f /= 5.0F;
        }

        if (!this.onGround && !delaylessperk) {
            f /= 5.0F;
        }

        return f;
    }


    /**
     * @author Sanixboi
     * @reason The inject method didn't work :|
     * **/
    @Overwrite
    public boolean checkFallFlying() {
        ItemStack hs = getEquippedStack(EquipmentSlot.HEAD);
        ItemStack cs = getEquippedStack(EquipmentSlot.CHEST);
        ItemStack ls = getEquippedStack(EquipmentSlot.LEGS);
        ItemStack bs = getEquippedStack(EquipmentSlot.FEET);
        boolean skydiamondarmor = hs.getItem().equals(ModArmor.SKY_DIAMOND_HELMET) && cs.getItem().equals(ModArmor.SKY_DIAMOND_CHESTPLATE) && ls.getItem().equals(ModArmor.SKY_DIAMOND_LEGGINGS) && bs.getItem().equals(ModArmor.SKY_DIAMOND_BOOTS) ;
        boolean mysticalskydiamondarmor = hs.getItem().equals(ModArmor.MYSTICAL_SKY_DIAMOND_HELMET) && cs.getItem().equals(ModArmor.MYSTICAL_SKY_DIAMOND_CHESTPLATE) && ls.getItem().equals(ModArmor.MYSTICAL_SKY_DIAMOND_LEGGINGS) && bs.getItem().equals(ModArmor.MYSTICAL_SKY_DIAMOND_BOOTS);
        boolean infersicoarmor = hs.getItem().equals(ModArmor.INFERSICO_HELMET) && cs.getItem().equals(ModArmor.INFERSICO_CHESTPLATE) && ls.getItem().equals(ModArmor.INFERSICO_LEGGINGS) && bs.getItem().equals(ModArmor.INFERSICO_BOOTS);
        boolean accidentiumarmor = hs.getItem().equals(ModArmor.ACCIDENTIUM_HELMET) && cs.getItem().equals(ModArmor.ACCIDENTIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.ACCIDENTIUM_LEGGINGS) && bs.getItem().equals(ModArmor.ACCIDENTIUM_BOOTS);
        boolean crudemediumarmor = hs.getItem().equals(ModArmor.CRUDEMEDIUM_HELMET) && cs.getItem().equals(ModArmor.CRUDEMEDIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.CRUDEMEDIUM_LEGGINGS) && bs.getItem().equals(ModArmor.CRUDEMEDIUM_BOOTS);
        boolean supericioarmor = hs.getItem().equals(ModArmor.SUPERICIO_HELMET) && cs.getItem().equals(ModArmor.SUPERICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPERICIO_LEGGINGS) && bs.getItem().equals(ModArmor.SUPERICIO_BOOTS);
        boolean glideperk = skydiamondarmor || mysticalskydiamondarmor || infersicoarmor || accidentiumarmor || crudemediumarmor || supericioarmor;
        System.out.println(glideperk);

        if (!this.onGround && !this.isFallFlying() && !this.isTouchingWater() && !this.hasStatusEffect(StatusEffects.LEVITATION)) {
            ItemStack itemStack = this.getEquippedStack(EquipmentSlot.CHEST);
            System.out.println(itemStack.getItem() == Items.ELYTRA && ElytraItem.isUsable(itemStack) || glideperk);
            if (itemStack.getItem() == Items.ELYTRA && ElytraItem.isUsable(itemStack) || glideperk) {
                startFallFlying();
                return true;
            }
        }

        return false;
    }



    @Inject(at = @At("HEAD"), method = "getHurtSound", cancellable = true)
    public void getHurtSound(DamageSource source, CallbackInfoReturnable<SoundEvent> cir) {
        if (!(source == DamageSource.ON_FIRE) && !(source == DamageSource.DROWN)) {
            cir.setReturnValue(source == DamageSource.SWEET_BERRY_BUSH ? SoundEvents.ENTITY_PLAYER_HURT_SWEET_BERRY_BUSH : inventory.contains(new ItemStack(ModRunes.INVENTORY_RUNE)) ? SanixExpansions.ENTITY_PLAYER_OLDHURT : SoundEvents.ENTITY_PLAYER_HURT);  // if you don't know what the ? was (I didn't know before either), it allows you to return a value in a single line e.g source = DamageSource.FIRE ? (the value for true) : (the value for false)
        }
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info) {
        ItemStack hs = getEquippedStack(EquipmentSlot.HEAD);
        ItemStack cs = getEquippedStack(EquipmentSlot.CHEST);
        ItemStack ls = getEquippedStack(EquipmentSlot.LEGS);
        ItemStack bs = getEquippedStack(EquipmentSlot.FEET);
        for (int i = 0; i < inventory.main.size(); i++) {
            if (inventory.getStack(i).getItem().equals(ModRunes.SCAFFOLD_RUNE)) {
                if (inventory.getStack(i).getOrCreateSubTag("scaffold").getInt("enablescaffold") == 1) {
                    for (int b = 0; b < 36; b++) {
                        ItemStack stack = inventory.getStack(b);
                        if(stack.getItem() instanceof BlockItem && !(((BlockItem)stack.getItem()).getBlock() instanceof FlowerBlock)){

                            BlockPos pos = getBlockPos().add(0, -1, 0);
                            if (world.getBlockState(pos).getBlock().equals(Blocks.AIR) || world.getBlockState(pos).getBlock().equals(Blocks.CAVE_AIR) || world.getBlockState(pos).getBlock().equals(Blocks.VOID_AIR) || world.getBlockState(pos).getBlock().equals(Blocks.WATER) && !(world.getBlockState(getBlockPos()).getBlock().equals(Blocks.WATER))) {
                                world.setBlockState(pos, ((BlockItem)stack.getItem()).getBlock().getDefaultState());

                                playSound(world.getBlockState(pos).getBlock().getSoundGroup(getBlockStateAtPos()).getPlaceSound(), SoundCategory.BLOCKS, getSoundVolume(), world.getBlockState(pos).getBlock().getSoundGroup(getBlockStateAtPos()).getPitch());
                                if(!abilities.creativeMode) stack.decrement(1);
                            }
                        }
                    }
                }
            }
        }

        assert getEntityWorld().getBiomeKey(getBlockPos()).isPresent();
        if (getEntityWorld().getBiomeKey(getBlockPos()).get().equals(ModBiomes.CORRUPTED_DELTAS_KEY)) {
            addStatusEffect(new StatusEffectInstance(SanixExpansions.CORRUPTED_GRAVITY, 300, 0));
        }

        if (getEquippedStack(EquipmentSlot.FEET).hasEnchantments() && isOnGround() && (getLandingBlockState().getBlock().equals(Blocks.ICE) || getLandingBlockState().getBlock().equals(Blocks.FROSTED_ICE) || getLandingBlockState().getBlock().equals(Blocks.BLUE_ICE) || getLandingBlockState().getBlock().equals(Blocks.PACKED_ICE) || getLandingBlockState().getBlock().equals(ModBlocks.ANCIENT_ICE))) {
            int slidelevel = EnchantmentHelper.getLevel(SanixExpansions.SLIDE_SPEED_EMCHANTMENT, getEquippedStack(EquipmentSlot.FEET));
            if (slidelevel > 0) addStatusEffect(new StatusEffectInstance(SanixExpansions.SLIDE_SPEED, 40 * slidelevel, slidelevel - 1, true, true, false));
        }

        assert getEntityWorld().getBiomeKey(getBlockPos()).isPresent();
        if (!hs.getItem().equals(Items.LEATHER_HELMET) && !cs.getItem().equals(Items.LEATHER_CHESTPLATE) && !ls.getItem().equals(Items.LEATHER_LEGGINGS) && !bs.getItem().equals(Items.LEATHER_BOOTS) && getEntityWorld().getBiomeKey(getBlockPos()).get().equals(ModBiomes.ANCIENT_OCEANS_KEY)) {
            if (world.isClient) {
                Random random = world.getRandom();
                boolean bl = lastRenderX != getX() || lastRenderZ != getZ();
                if (bl && random.nextBoolean()) {
                    world.addParticle(ParticleTypes.SNOWFLAKE, getX(), (double)(getY() + 1), getZ(), (double)(MathHelper.nextBetween(random, -1.0F, 1.0F) * 0.083333336F), 0.05000000074505806D, (double)(MathHelper.nextBetween(random, -1.0F, 1.0F) * 0.083333336F));
                }
            }
            setInPowderSnow(true);
        }


        boolean skydiamondarmor = hs.getItem().equals(ModArmor.SKY_DIAMOND_HELMET) && cs.getItem().equals(ModArmor.SKY_DIAMOND_CHESTPLATE) && ls.getItem().equals(ModArmor.SKY_DIAMOND_LEGGINGS) && bs.getItem().equals(ModArmor.SKY_DIAMOND_BOOTS);
        boolean accidentiumarmor = hs.getItem().equals(ModArmor.ACCIDENTIUM_HELMET) && cs.getItem().equals(ModArmor.ACCIDENTIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.ACCIDENTIUM_LEGGINGS) && bs.getItem().equals(ModArmor.ACCIDENTIUM_BOOTS);
        boolean crudemediumarmor = hs.getItem().equals(ModArmor.CRUDEMEDIUM_HELMET) && cs.getItem().equals(ModArmor.CRUDEMEDIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.CRUDEMEDIUM_LEGGINGS) && bs.getItem().equals(ModArmor.CRUDEMEDIUM_BOOTS);
        boolean supericioarmor = hs.getItem().equals(ModArmor.SUPERICIO_HELMET) && cs.getItem().equals(ModArmor.SUPERICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPERICIO_LEGGINGS) && bs.getItem().equals(ModArmor.SUPERICIO_BOOTS);
        boolean suprevicioarmor = hs.getItem().equals(ModArmor.SUPREVICIO_HELMET) && cs.getItem().equals(ModArmor.SUPREVICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPREVICIO_LEGGINGS) && bs.getItem().equals(ModArmor.SUPREVICIO_BOOTS);
        boolean sanisaniumarmor = hs.getItem().equals(ModArmor.SANISANIUM_HELMET) && cs.getItem().equals(ModArmor.SANISANIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.SANISANIUM_LEGGINGS) && bs.getItem().equals(ModArmor.SANISANIUM_BOOTS);
        boolean empoweredsouliusarmor = hs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_HELMET) && cs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_CHESTPLATE) && ls.getItem().equals(ModArmor.EMPOWERED_SOULIUS_LEGGINGS) && bs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_BOOTS);

        boolean waterperk = accidentiumarmor || crudemediumarmor || supericioarmor || suprevicioarmor || sanisaniumarmor || empoweredsouliusarmor;
        boolean fireresperk = crudemediumarmor || supericioarmor || suprevicioarmor || sanisaniumarmor || empoweredsouliusarmor;
        boolean saturationperk = sanisaniumarmor || empoweredsouliusarmor;

        boolean badoment2 = getMainHandStack().getItem().equals(ModRunes.BAD_OMEN_RUNE_TIER_2) || getOffHandStack().getItem().equals(ModRunes.BAD_OMEN_RUNE_TIER_2);
        boolean slownesst2 = getMainHandStack().getItem().equals(ModRunes.SLOWNESS_RUNE_TIER_2) || getOffHandStack().getItem().equals(ModRunes.SLOWNESS_RUNE_TIER_2);
        boolean withert2 = getMainHandStack().getItem().equals(ModRunes.WITHER_RUNE_TIER_2) || getOffHandStack().getItem().equals(ModRunes.WITHER_RUNE_TIER_2);
        boolean weaknesst2 = getMainHandStack().getItem().equals(ModRunes.WEAKNESS_RUNE_TIER_2) || getOffHandStack().getItem().equals(ModRunes.WEAKNESS_RUNE_TIER_2);
        boolean poisont2 = getMainHandStack().getItem().equals(ModRunes.POISON_RUNE_TIER_2) || getOffHandStack().getItem().equals(ModRunes.POISON_RUNE_TIER_2);
        boolean nauseat2 = getMainHandStack().getItem().equals(ModRunes.NAUSEA_RUNE_TIER_2) || getOffHandStack().getItem().equals(ModRunes.NAUSEA_RUNE_TIER_2);
        boolean miningfatiguet2 = getMainHandStack().getItem().equals(ModRunes.MINING_FATIGUE_RUNE_TIER_2) || getOffHandStack().getItem().equals(ModRunes.MINING_FATIGUE_RUNE_TIER_2);
        boolean hungert2 = getMainHandStack().getItem().equals(ModRunes.HUNGER_RUNE_TIER_2) || getOffHandStack().getItem().equals(ModRunes.HUNGER_RUNE_TIER_2);
        boolean glowingt2 = getMainHandStack().getItem().equals(ModRunes.GLOWING_RUNE_TIER_2) || getOffHandStack().getItem().equals(ModRunes.GLOWING_RUNE_TIER_2);
        boolean blindnesst2 = getMainHandStack().getItem().equals(ModRunes.BLINDNESS_RUNE_TIER_2) || getOffHandStack().getItem().equals(ModRunes.BLINDNESS_RUNE_TIER_2);

        if (skydiamondarmor) {

            if (inventory.contains(new ItemStack(ModRunes.SKY_DIAMOND_APPLE_RUNE))) {
                int slot = world.isClient ? inventory.getSlotWithStack(new ItemStack(Items.GOLDEN_APPLE)): -1;
                int a = inventory.count(Items.GOLDEN_APPLE);
                int slot2 = world.isClient ? inventory.getSlotWithStack(new ItemStack(Items.ENCHANTED_GOLDEN_APPLE)): -1;
                int a2 = inventory.count(Items.ENCHANTED_GOLDEN_APPLE);
                if (inventory.getSlotWithStack(new ItemStack(Items.GOLDEN_APPLE)) > -1) {
                    inventory.setStack(slot, new ItemStack(ModItems.SKY_DIAMOND_APPLE));
                    for(int i = a - 1; i > 0; i--) {
                        inventory.insertStack(slot, new ItemStack(ModItems.SKY_DIAMOND_APPLE));
                    }
                }

                if (inventory.getSlotWithStack(new ItemStack(Items.ENCHANTED_GOLDEN_APPLE)) > -1) {
                    inventory.setStack(slot2, new ItemStack(ModItems.ENCHANTED_SKY_DIAMOND_APPLE));
                    for(int i = a2 - 1; i > 0; i--) {
                        inventory.insertStack(slot2, new ItemStack(ModItems.ENCHANTED_SKY_DIAMOND_APPLE));
                    }
                }
            }

            if (inventory.contains(new ItemStack(ModRunes.ENCHANTED_SKY_DIAMOND_APPLE_RUNE))) {
                int slot = world.isClient ? inventory.getSlotWithStack(new ItemStack(Items.GOLDEN_APPLE)): -1;
                int a = inventory.count(Items.GOLDEN_APPLE);
                int slot2 = world.isClient ? inventory.getSlotWithStack(new ItemStack(Items.ENCHANTED_GOLDEN_APPLE)): -1;
                int a2 = inventory.count(Items.ENCHANTED_GOLDEN_APPLE);
                if (slot > -1) {
                    inventory.setStack(slot, new ItemStack(ModItems.ENCHANTED_SKY_DIAMOND_APPLE));
                    for(int i = a - 1; i > 0; i--) {
                        inventory.insertStack(slot, new ItemStack(ModItems.ENCHANTED_SKY_DIAMOND_APPLE));
                    }
                }

                if (slot2 > -1) {
                    inventory.setStack(slot2, new ItemStack(ModItems.MYSTICAL_SKY_DIAMOND_APPLE));
                    for(int i = a2 - 1; i > 0; i--) {
                        inventory.insertStack(slot2, new ItemStack(ModItems.MYSTICAL_SKY_DIAMOND_APPLE));
                    }
                }
            }

            if (inventory.contains(new ItemStack(ModRunes.ROCKET_RUNE_TIER_3))) {

                ItemStack rocket = new ItemStack(Items.FIREWORK_ROCKET, 64);
                //from FireworkRocketRecipe class
                NbtCompound compoundTag = rocket.getOrCreateSubTag("Fireworks");
                compoundTag.putByte("Flight", (byte)3);
                if (inventory.getStack(8).getItem().equals(Items.AIR) || inventory.getStack(8).getItem().equals(Items.FIREWORK_ROCKET)) inventory.setStack(8, rocket);
			/*
			RecipeSerializer
			*/
            }

            else if (inventory.contains(new ItemStack(ModRunes.ROCKET_RUNE_TIER_2))) {

                ItemStack rocket = new ItemStack(Items.FIREWORK_ROCKET, 64);
                //from FireworkRocketRecipe class
                NbtCompound compoundTag = rocket.getOrCreateSubTag("Fireworks");
                compoundTag.putByte("Flight", (byte)2);
                if (inventory.getStack(8).getItem().equals(Items.AIR) || inventory.getStack(8).getItem().equals(Items.FIREWORK_ROCKET) && inventory.getStack(8).getCount() < 64) inventory.setStack(8, rocket);
            }

            else if (inventory.contains(new ItemStack(ModRunes.ROCKET_RUNE_TIER_1))) {
                ItemStack rocket = new ItemStack(Items.FIREWORK_ROCKET, 64);
                //from FireworkRocketRecipe class
                NbtCompound compoundTag = rocket.getOrCreateSubTag("Fireworks");
                compoundTag.putByte("Flight", (byte)1);
                if (inventory.getStack(8).getItem().equals(Items.AIR) || inventory.getStack(8).getItem().equals(Items.FIREWORK_ROCKET) && inventory.getStack(8).getCount() < 64) inventory.setStack(8, rocket);
            }
        }

        if (waterperk) {
            if (submergedInWater) {
                StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.WATER_BREATHING, 20 * 10, 0, false, false);
                addStatusEffect(effect);
            }

            if (badoment2) {
                removeStatusEffect(StatusEffects.BAD_OMEN);
            }

            if (slownesst2) {
                removeStatusEffect(StatusEffects.SLOWNESS);
            }

            if (withert2) {
                removeStatusEffect(StatusEffects.WITHER);
            }

            if (weaknesst2) {
                removeStatusEffect(StatusEffects.WEAKNESS);
            }

            if (poisont2) {
                removeStatusEffect(StatusEffects.POISON);
            }

            if (nauseat2) {
                removeStatusEffect(StatusEffects.NAUSEA);
            }

            if (miningfatiguet2) {
                removeStatusEffect(StatusEffects.MINING_FATIGUE);
            }

            if (hungert2) {
                removeStatusEffect(StatusEffects.HUNGER);
            }

            if (glowingt2) {
                removeStatusEffect(StatusEffects.GLOWING);
            }

            if (blindnesst2) {
                removeStatusEffect(StatusEffects.BLINDNESS);
            }
        }



        if (fireresperk) {
            StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 10, 0, false, false);
            addStatusEffect(effect);
            setFireTicks(0);


            for (int i = 0; i < 9; i++) {
                //switch statements not compatible
                    if (inventory.getStack(i).getItem().equals(ModRunes.BAD_OMEN_RUNE_TIER_3)) {
                        removeStatusEffect(StatusEffects.BAD_OMEN);
                    }

                    if (inventory.getStack(i).getItem().equals(ModRunes.SLOWNESS_RUNE_TIER_3)) {
                        removeStatusEffect(StatusEffects.SLOWNESS);
                    }

                    if (inventory.getStack(i).getItem().equals(ModRunes.WITHER_RUNE_TIER_3)) {
                        removeStatusEffect(StatusEffects.WITHER);
                    }

                    if (inventory.getStack(i).getItem().equals(ModRunes.WEAKNESS_RUNE_TIER_3)) {
                        removeStatusEffect(StatusEffects.WEAKNESS);
                    }

                    if (inventory.getStack(i).getItem().equals(ModRunes.NAUSEA_RUNE_TIER_3)) {
                        removeStatusEffect(StatusEffects.NAUSEA);
                    }

                    if (inventory.getStack(i).getItem().equals(ModRunes.MINING_FATIGUE_RUNE_TIER_3)) {
                        removeStatusEffect(StatusEffects.MINING_FATIGUE);
                    }

                    if (inventory.getStack(i).getItem().equals(ModRunes.HUNGER_RUNE_TIER_3)) {
                        removeStatusEffect(StatusEffects.HUNGER);
                    }

                    if (inventory.getStack(i).getItem().equals(ModRunes.GLOWING_RUNE_TIER_3)) {
                        removeStatusEffect(StatusEffects.GLOWING);
                    }

                    if (inventory.getStack(i).getItem().equals(ModRunes.BLINDNESS_RUNE_TIER_3)) {
                        removeStatusEffect(StatusEffects.BLINDNESS);
                    }
                }
        }


        if (saturationperk) {
            StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.SATURATION, 20 * 5, 0, false, false);
            addStatusEffect(effect);
        }
    }
}
