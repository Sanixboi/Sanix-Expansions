package net.Sanix.Expansions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

public class AntiGravityEffect extends StatusEffect {
    public AntiGravityEffect() {
        super(StatusEffectType.NEUTRAL, 0xFF0000);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.setVelocity(entity.getVelocity().getX(), (entity.getVelocity().getY() * -1) + ((entity.getVelocity().getY() / 3) * (amplifier + 1)), entity.getVelocity().getZ());
    }
}
