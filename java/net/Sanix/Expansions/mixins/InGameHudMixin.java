package net.Sanix.Expansions.mixins;

import net.Sanix.Expansions.registries.ModArmor;
import net.minecraft.block.PowderSnowBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Random;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin extends DrawableHelper {

    @Shadow protected abstract PlayerEntity getCameraPlayer();

    @Shadow private long heartJumpEndTick;

    @Shadow private int ticks;

    @Shadow private int lastHealthValue;

    @Shadow private int renderHealthValue;

    @Shadow @Final private Random random;

    @Shadow private int scaledWidth;

    @Shadow private int scaledHeight;

    @Shadow @Final private MinecraftClient client;

    @Shadow protected abstract LivingEntity getRiddenEntity();

    @Shadow protected abstract int getHeartCount(LivingEntity entity);

    @Shadow protected abstract int getHeartRows(int heartCount);

    @Shadow private long lastHealthCheckTime;

    @Shadow protected abstract void renderHealthBar(MatrixStack matrices, PlayerEntity player, int x, int y, int lines, int regeneratingHeartIndex, float maxHealth, int lastHealth, int health, int absorption, boolean blinking);

    /**
     * @author Sanixboi
     * @reason Idk how to do this any other way, let me know if there is using @inject prob can do it with info.cancel()
     * **/
    /*
    @Overwrite
    private void renderStatusBars(MatrixStack matrixStack) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        if (playerEntity != null) {
            int i = MathHelper.ceil(playerEntity.getHealth());
            boolean bl = this.heartJumpEndTick > (long)this.ticks && (this.heartJumpEndTick - (long)this.ticks) / 3L % 2L == 1L;
            long l = Util.getMeasuringTimeMs();
            if (i < this.lastHealthValue && playerEntity.timeUntilRegen > 0) {
                this.lastHealthValue = (int)l;
                this.heartJumpEndTick = (long)(this.ticks + 20);
            } else if (i > this.lastHealthValue && playerEntity.timeUntilRegen > 0) {
                this.lastHealthValue = (int)l;
                this.heartJumpEndTick = (long)(this.ticks + 10);
            }

            if (l - this.lastHealthValue > 1000L) {
                this.lastHealthValue = i;
                this.renderHealthValue = i;
                this.lastHealthValue = (int)l;
            }

            this.lastHealthValue = i;
            int j = this.renderHealthValue;
            this.random.setSeed((long)(this.ticks * 312871));
            HungerManager hungerManager = playerEntity.getHungerManager();
            int k = hungerManager.getFoodLevel();
            int m = this.scaledWidth / 2 - 91;
            int n = this.scaledWidth / 2 + 91;
            int o = this.scaledHeight - 39;
            float f = (float)playerEntity.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH);
            int p = MathHelper.ceil(playerEntity.getAbsorptionAmount());
            int q = MathHelper.ceil((f + (float)p) / 2.0F / 10.0F);
            int r = Math.max(10 - (q - 2), 3);
            int s = o - (q - 1) * r - 10;
            int t = o - 10;
            int u = p;
            int v = playerEntity.getArmor();
            int w = -1;
            if (playerEntity.hasStatusEffect(StatusEffects.REGENERATION)) {
                w = this.ticks % MathHelper.ceil(f + 5.0F);
            }


            ItemStack hs = playerEntity.getEquippedStack(EquipmentSlot.HEAD);
            ItemStack cs = playerEntity.getEquippedStack(EquipmentSlot.CHEST);
            ItemStack ls = playerEntity.getEquippedStack(EquipmentSlot.LEGS);
            ItemStack bs = playerEntity.getEquippedStack(EquipmentSlot.FEET);
            boolean sanisaniumarmor = hs.getItem().equals(ModArmor.SANISANIUM_HELMET) && cs.getItem().equals(ModArmor.SANISANIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.SANISANIUM_LEGGINGS) && bs.getItem().equals(ModArmor.SANISANIUM_BOOTS);
            boolean empoweredsouliusarmor = hs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_HELMET) && cs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_CHESTPLATE) && ls.getItem().equals(ModArmor.EMPOWERED_SOULIUS_LEGGINGS) && bs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_BOOTS);
            boolean saturationperk = sanisaniumarmor || empoweredsouliusarmor;

            int z;
            int aa;
            this.client.getProfiler().push("armor");
            if (!playerEntity.hasStatusEffect(StatusEffects.SATURATION)) {
                for(z = 0; z < 10; ++z) {
                    if (v > 0) {
                        aa = m + z * 8;
                        if (z * 2 + 1 < v) {
                            this.drawTexture(matrixStack, aa, s, 34, 9, 9, 9);
                        }

                        if (z * 2 + 1 == v) {
                            this.drawTexture(matrixStack, aa, s, 25, 9, 9, 9);
                        }

                        if (z * 2 + 1 > v) {
                            this.drawTexture(matrixStack, aa, s, 16, 9, 9, 9);
                        }
                    }
                    t -= 10;
                }
            } else {
                for(z = 0; z < 10; ++z) {
                    if (v > 0) {
                        aa = n - z * 8 - 9;
                        if (z * 2 + 1 < v) {
                            this.drawTexture(matrixStack, aa, o, 34, 9, 9, 9);
                        }

                        if (z * 2 + 1 == v) {
                            this.drawTexture(matrixStack, aa, o, 123, 9, 9, 9);
                        }

                        if (z * 2 + 1 > v) {
                            this.drawTexture(matrixStack, aa, o, 16, 9, 9, 9);
                        }
                    }
                    t -= 10;
                }
            }


            this.client.getProfiler().swap("health");

            int ai;
            int ad;
            int ae;
            for(z = MathHelper.ceil((f + (float)p) / 2.0F) - 1; z >= 0; --z) {
                aa = 16;
                if (playerEntity.hasStatusEffect(StatusEffects.POISON)) {
                    aa += 36;
                } else if (playerEntity.hasStatusEffect(StatusEffects.WITHER)) {
                    aa += 72;
                }

                int ab = 0;
                if (bl) {
                    ab = 1;
                }

                ai = MathHelper.ceil((float)(z + 1) / 10.0F) - 1;
                ad = m + z % 10 * 8;
                ae = o - ai * r;
                if (i <= 4) {
                    ae += this.random.nextInt(2);
                }

                if (u <= 0 && z == w) {
                    ae -= 2;
                }

                int af = 0;
                if (playerEntity.world.getLevelProperties().isHardcore()) {
                    af = 5;
                }

                this.drawTexture(matrixStack, ad, ae, 16 + ab * 9, 9 * af, 9, 9);
                if (bl) {
                    if (z * 2 + 1 < j) {
                        this.drawTexture(matrixStack, ad, ae, aa + 54, 9 * af, 9, 9);
                    }

                    if (z * 2 + 1 == j) {
                        this.drawTexture(matrixStack, ad, ae, aa + 63, 9 * af, 9, 9);
                    }
                }

                if (u > 0) {
                    if (u == p && p % 2 == 1) {
                        this.drawTexture(matrixStack, ad, ae, aa + 153, 9 * af, 9, 9);
                        --u;
                    } else {
                        this.drawTexture(matrixStack, ad, ae, aa + 144, 9 * af, 9, 9);
                        u -= 2;
                    }
                } else {
                    if (z * 2 + 1 < i) {
                        this.drawTexture(matrixStack, ad, ae, aa + 36, 9 * af, 9, 9);
                    }

                    if (z * 2 + 1 == i) {
                        this.drawTexture(matrixStack, ad, ae, aa + 45, 9 * af, 9, 9);
                    }
                }
            }

            LivingEntity livingEntity = this.getRiddenEntity();
            aa = this.getHeartCount(livingEntity);
            int ah;
            int al;
            if (aa == 0) {
                this.client.getProfiler().swap("food");

                if (!saturationperk && !(playerEntity.hasStatusEffect(StatusEffects.SATURATION) && !playerEntity.getHungerManager().isNotFull())) {
                    for(ah = 0; ah < 10; ++ah) {
                        ai = o;
                        ad = 16;
                        int ak = 0;
                        if (playerEntity.hasStatusEffect(StatusEffects.HUNGER)) {
                            ad += 36;
                            ak = 13;
                        }

                        if (playerEntity.getHungerManager().getSaturationLevel() <= 0.0F && this.ticks % (k * 3 + 1) == 0) {
                            ai = o + (this.random.nextInt(3) - 1);
                        }

                        al = n - ah * 8 - 9;
                        this.drawTexture(matrixStack, al, ai, 16 + ak * 9, 27, 9, 9);
                        if (ah * 2 + 1 < k) {
                            this.drawTexture(matrixStack, al, ai, ad + 36, 27, 9, 9);
                        }

                        if (ah * 2 + 1 == k) {
                            this.drawTexture(matrixStack, al, ai, ad + 45, 27, 9, 9);
                        }
                    }
                }
                t -= 10;
            }

            this.client.getProfiler().swap("air");
            ah = playerEntity.getAir();
            ai = playerEntity.getMaxAir();
            if (playerEntity.isSubmergedIn(FluidTags.WATER) || ah < ai) {

                boolean accidentiumarmor = hs.getItem().equals(ModArmor.ACCIDENTIUM_HELMET) && cs.getItem().equals(ModArmor.ACCIDENTIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.ACCIDENTIUM_LEGGINGS) && bs.getItem().equals(ModArmor.ACCIDENTIUM_BOOTS);
                boolean crudemediumarmor = hs.getItem().equals(ModArmor.CRUDEMEDIUM_HELMET) && cs.getItem().equals(ModArmor.CRUDEMEDIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.CRUDEMEDIUM_LEGGINGS) && bs.getItem().equals(ModArmor.CRUDEMEDIUM_BOOTS);
                boolean supericioarmor = hs.getItem().equals(ModArmor.SUPERICIO_HELMET) && cs.getItem().equals(ModArmor.SUPERICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPERICIO_LEGGINGS) && bs.getItem().equals(ModArmor.SUPERICIO_BOOTS);
                boolean suprevicioarmor = hs.getItem().equals(ModArmor.SUPREVICIO_HELMET) && cs.getItem().equals(ModArmor.SUPREVICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPREVICIO_LEGGINGS) && bs.getItem().equals(ModArmor.SUPREVICIO_BOOTS);

                boolean waterperk = accidentiumarmor || crudemediumarmor || supericioarmor || suprevicioarmor || sanisaniumarmor || empoweredsouliusarmor;

                if(!playerEntity.hasStatusEffect(StatusEffects.WATER_BREATHING) && !waterperk) {
                    ad = this.getHeartRows(aa) - 1;
                    t -= ad * 10;
                    ae = MathHelper.ceil((double)(ah - 2) * 10.0D / (double)ai);
                    al = MathHelper.ceil((double)ah * 10.0D / (double)ai) - ae;

                    for(int ar = 0; ar < ae + al; ++ar) {
                        if (ar < ae) {
                            this.drawTexture(matrixStack, n - ar * 8 - 9, t, 16, 18, 9, 9);
                        } else {
                            this.drawTexture(matrixStack, n - ar * 8 - 9, t, 25, 18, 9, 9);
                        }
                    }
                }
            }

            this.client.getProfiler().pop();
        }


    }
    */
    @Overwrite
    private void renderStatusBars(MatrixStack matrices) {
        PlayerEntity playerEntity = this.getCameraPlayer();
        ItemStack hs = playerEntity.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack cs = playerEntity.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack ls = playerEntity.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack bs = playerEntity.getEquippedStack(EquipmentSlot.FEET);
        boolean sanisaniumarmor = hs.getItem().equals(ModArmor.SANISANIUM_HELMET) && cs.getItem().equals(ModArmor.SANISANIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.SANISANIUM_LEGGINGS) && bs.getItem().equals(ModArmor.SANISANIUM_BOOTS);
        boolean empoweredsouliusarmor = hs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_HELMET) && cs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_CHESTPLATE) && ls.getItem().equals(ModArmor.EMPOWERED_SOULIUS_LEGGINGS) && bs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_BOOTS);
        boolean saturationperk = sanisaniumarmor || empoweredsouliusarmor;
        if (playerEntity != null) {
            int i = MathHelper.ceil(playerEntity.getHealth());
            boolean bl = this.heartJumpEndTick > (long)this.ticks && (this.heartJumpEndTick - (long)this.ticks) / 3L % 2L == 1L;
            long l = Util.getMeasuringTimeMs();
            if (i < this.lastHealthValue && playerEntity.timeUntilRegen > 0) {
                this.lastHealthCheckTime = l;
                this.heartJumpEndTick = (long)(this.ticks + 20);
            } else if (i > this.lastHealthValue && playerEntity.timeUntilRegen > 0) {
                this.lastHealthCheckTime = l;
                this.heartJumpEndTick = (long)(this.ticks + 10);
            }

            if (l - this.lastHealthCheckTime > 1000L) {
                this.lastHealthValue = i;
                this.renderHealthValue = i;
                this.lastHealthCheckTime = l;
            }

            this.lastHealthValue = i;
            int j = this.renderHealthValue;
            this.random.setSeed((long)(this.ticks * 312871));
            HungerManager hungerManager = playerEntity.getHungerManager();
            int k = hungerManager.getFoodLevel();
            int m = this.scaledWidth / 2 - 91;
            int n = this.scaledWidth / 2 + 91;
            int o = this.scaledHeight - 39;
            float f = Math.max((float)playerEntity.getAttributeValue(EntityAttributes.GENERIC_MAX_HEALTH), (float)Math.max(j, i));
            int p = MathHelper.ceil(playerEntity.getAbsorptionAmount());
            int q = MathHelper.ceil((f + (float)p) / 2.0F / 10.0F);
            int r = Math.max(10 - (q - 2), 3);
            int s = o - (q - 1) * r - 10;
            int t = o - 10;
            int u = playerEntity.getArmor();
            int v = -1;
            if (playerEntity.hasStatusEffect(StatusEffects.REGENERATION)) {
                v = this.ticks % MathHelper.ceil(f + 5.0F);
            }

            this.client.getProfiler().push("armor");

            int x;
            for(int w = 0; w < 10; ++w) {
                if (u > 0) {
                    x = m + w * 8;
                    if (w * 2 + 1 < u) {
                        this.drawTexture(matrices, x, s, 34, 9, 9, 9);
                    }

                    if (w * 2 + 1 == u) {
                        this.drawTexture(matrices, x, s, 25, 9, 9, 9);
                    }

                    if (w * 2 + 1 > u) {
                        this.drawTexture(matrices, x, s, 16, 9, 9, 9);
                    }
                }
            }

            this.client.getProfiler().swap("health");
            this.renderHealthBar(matrices, playerEntity, m, o, r, v, f, i, j, p, bl);
            LivingEntity livingEntity = this.getRiddenEntity();
            x = this.getHeartCount(livingEntity);
            int z;
            int aa;
            int ab;
            int ad;
            if (x == 0) {
                this.client.getProfiler().swap("food");

                if (!saturationperk && !(playerEntity.hasStatusEffect(StatusEffects.SATURATION) && !playerEntity.getHungerManager().isNotFull()))
                for(z = 0; z < 10; ++z) {
                    aa = o;
                    ab = 16;
                    int ac = 0;
                    if (playerEntity.hasStatusEffect(StatusEffects.HUNGER)) {
                        ab += 36;
                        ac = 13;
                    }

                    if (playerEntity.getHungerManager().getSaturationLevel() <= 0.0F && this.ticks % (k * 3 + 1) == 0) {
                        aa = o + (this.random.nextInt(3) - 1);
                    }

                    ad = n - z * 8 - 9;
                    this.drawTexture(matrices, ad, aa, 16 + ac * 9, 27, 9, 9);
                    if (z * 2 + 1 < k) {
                        this.drawTexture(matrices, ad, aa, ab + 36, 27, 9, 9);
                    }

                    if (z * 2 + 1 == k) {
                        this.drawTexture(matrices, ad, aa, ab + 45, 27, 9, 9);
                    }
                }

                t -= 10;
            }

            this.client.getProfiler().swap("air");
            z = playerEntity.getMaxAir();
            aa = Math.min(playerEntity.getAir(), z);
            if (playerEntity.isSubmergedIn(FluidTags.WATER) || aa < z) {
                boolean accidentiumarmor = hs.getItem().equals(ModArmor.ACCIDENTIUM_HELMET) && cs.getItem().equals(ModArmor.ACCIDENTIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.ACCIDENTIUM_LEGGINGS) && bs.getItem().equals(ModArmor.ACCIDENTIUM_BOOTS);
                boolean crudemediumarmor = hs.getItem().equals(ModArmor.CRUDEMEDIUM_HELMET) && cs.getItem().equals(ModArmor.CRUDEMEDIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.CRUDEMEDIUM_LEGGINGS) && bs.getItem().equals(ModArmor.CRUDEMEDIUM_BOOTS);
                boolean supericioarmor = hs.getItem().equals(ModArmor.SUPERICIO_HELMET) && cs.getItem().equals(ModArmor.SUPERICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPERICIO_LEGGINGS) && bs.getItem().equals(ModArmor.SUPERICIO_BOOTS);
                boolean suprevicioarmor = hs.getItem().equals(ModArmor.SUPREVICIO_HELMET) && cs.getItem().equals(ModArmor.SUPREVICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPREVICIO_LEGGINGS) && bs.getItem().equals(ModArmor.SUPREVICIO_BOOTS);

                boolean waterperk = accidentiumarmor || crudemediumarmor || supericioarmor || suprevicioarmor || sanisaniumarmor || empoweredsouliusarmor;

                if(!playerEntity.hasStatusEffect(StatusEffects.WATER_BREATHING) && !waterperk) {
                    ab = this.getHeartRows(x) - 1;
                    t -= ab * 10;
                    int ah = MathHelper.ceil((double)(aa - 2) * 10.0D / (double)z);
                    ad = MathHelper.ceil((double)aa * 10.0D / (double)z) - ah;

                    for(int aj = 0; aj < ah + ad; ++aj) {
                        if (aj < ah) {
                            this.drawTexture(matrices, n - aj * 8 - 9, t, 16, 18, 9, 9);
                        } else {
                            this.drawTexture(matrices, n - aj * 8 - 9, t, 25, 18, 9, 9);
                        }
                    }
                }
            }

            this.client.getProfiler().pop();
        }
    }
}
