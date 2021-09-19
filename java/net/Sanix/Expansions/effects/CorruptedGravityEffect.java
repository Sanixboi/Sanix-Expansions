package net.Sanix.Expansions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectType;

import java.util.Random;

public class CorruptedGravityEffect extends StatusEffect {

    public CorruptedGravityEffect() {
        super(StatusEffectType.HARMFUL, 0x733DAC);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.getVelocity().getY() < 0) {
            Random r = new Random();
            double amount = r.nextInt(20 * (amplifier + 1));
            int d = entity.isOnGround() ? 2:1;
            if (amount > ((6.0 / d) + amplifier)) {
                if (!entity.isOnGround()) entity.setVelocity(entity.getVelocity().getX(), entity.getVelocity().getY() / (1 + (amount / 10) - (0.5 * ((amplifier * 4) + 1) * amount/6.1)), entity.getVelocity().getZ());
            } else {
                entity.setVelocity(entity.getVelocity().getX(), (amount / 20) / (amplifier  * 5 + 1) + entity.getVelocity().getY(), entity.getVelocity().getZ());
            }
        }
    }
}
