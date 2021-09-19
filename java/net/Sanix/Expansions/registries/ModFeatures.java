package net.Sanix.Expansions.registries;

import net.Sanix.Expansions.SanixExpansions;
import net.Sanix.Expansions.features.AncientSpikes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ModFeatures {

    public static final Feature<DefaultFeatureConfig> ANCIENT_SPIKES = new AncientSpikes(DefaultFeatureConfig.CODEC);

    public static final ConfiguredFeature<?, ?> ANCIENT_SPIKES_CONFIGURED = ANCIENT_SPIKES.configure(FeatureConfig.DEFAULT).decorate(Decorator.CHANCE.configure(new ChanceDecoratorConfig(10)));

    public static void registerfeatures() {
        registerfeature("ancient_spikes", ANCIENT_SPIKES);

        RegistryKey<ConfiguredFeature<?, ?>> ANCIENT_SPIKES_KEY = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier(SanixExpansions.MODID, "ancient_spikes"));
        registerconfig(ANCIENT_SPIKES_KEY, ANCIENT_SPIKES_CONFIGURED);
    }

    public static void registerfeature(String name, Feature<DefaultFeatureConfig> feature) {
        Registry.register(Registry.FEATURE, new Identifier(SanixExpansions.MODID, name), feature);
    }

    public static void registerconfig(RegistryKey<ConfiguredFeature<?, ?>> key, ConfiguredFeature<?, ?> config) {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, key.getValue(), config);
    }
}
