package net.Sanix.Expansions.mixins;

import net.Sanix.Expansions.SanixExpansions;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {

    @Inject(at = @At("TAIL"), method = "addDefaultOres")
    private static void addCustomOres(GenerationSettings.Builder builder, CallbackInfo info) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, SanixExpansions.SKY_DIAMOND_ORE_GENERATION);
    }
}
