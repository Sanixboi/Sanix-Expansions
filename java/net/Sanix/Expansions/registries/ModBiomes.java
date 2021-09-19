package net.Sanix.Expansions.registries;

import net.Sanix.Expansions.SanixExpansions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class ModBiomes {

    public static ConfiguredFeature<?, ?> FUTURISTIC_REMAINS_GENERATION = Feature.SCATTERED_ORE.configure(
            new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_NETHER,
                    ModBlocks.FUTURISTIC_REMAINS.getDefaultState(),
                    1
            )).range(new RangeDecoratorConfig(
            UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(0))
    )).spreadHorizontally().repeat(1);

    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> HYPERRACK_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(ModBlocks.HYPERRACK.getDefaultState(), ModBlocks.HYPERRACK.getDefaultState(), ModBlocks.HYPERRACK.getDefaultState()));
    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> SPIROUS_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(ModBlocks.SPIROUS_HYLIUM.getDefaultState(), ModBlocks.HYPERRACK.getDefaultState(), ModBlocks.HYPERRACK.getDefaultState()));
    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> ANCIENT_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(ModBlocks.ANCIENT_ICE.getDefaultState(), ModBlocks.ANCIENT_ICE.getDefaultState(), ModBlocks.ANCIENT_ICE.getDefaultState()));
    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> CORRUPTSTONE_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(ModBlocks.CORRUPTSTONE.getDefaultState(), ModBlocks.CORRUPTSTONE.getDefaultState(), ModBlocks.CORRUPTSTONE.getDefaultState()));
    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> TAINTED_SURFACE_BUILDER = SurfaceBuilder.DEFAULT.withConfig(new TernarySurfaceConfig(ModBlocks.TAINTED_HYLIUM.getDefaultState(), ModBlocks.HYPERRACK.getDefaultState(), ModBlocks.HYPERRACK.getDefaultState()));

    private static final Biome HYPER_WASTES = createhyperwastes();
    private static final Biome SPIROUS_SPIKES = createspirousspikes();
    private static final Biome ANCIENT_OCEANS = createancientoceans();
    private static final Biome CORRUPTED_DELTAS = createcorrupteddeltas();
    private static final Biome TAINTED_SWAMPS = createtaintedswamps();

    public static final RegistryKey<Biome> HYPER_WASTES_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(SanixExpansions.MODID, "hyper_wastes"));
    public static final RegistryKey<Biome> SPIROUS_SPIKES_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(SanixExpansions.MODID, "spirous_spikes"));
    public static final RegistryKey<Biome> ANCIENT_OCEANS_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(SanixExpansions.MODID, "ancient_oceans"));
    public static final RegistryKey<Biome> CORRUPTED_DELTAS_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(SanixExpansions.MODID, "corrupted_deltas"));
    public static final RegistryKey<Biome> TAINTED_SWAMPS_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier(SanixExpansions.MODID, "tainted_swamps"));

    private static Biome createhyperwastes() {

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(HYPERRACK_SURFACE_BUILDER);
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.GHAST, 10, 0, 5));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 20, 0, 10));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ILLUSIONER, 5, 0, 2));
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, FUTURISTIC_REMAINS_GENERATION);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.NETHER)
                .depth(0.125F)
                .scale(0.2F)
                .temperature(2F)
                .temperatureModifier(Biome.TemperatureModifier.FROZEN)
                .downfall(0.1F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x0041FF)
                        .waterFogColor(0x0041FF)
                        .fogColor(0x0041FF)
                        .skyColor(0x0041FF)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static Biome createspirousspikes() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(SPIROUS_SURFACE_BUILDER);
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.GHAST, 8, 0, 3));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.HOGLIN, 12, 0, 5));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.PIGLIN_BRUTE, 15, 0, 4));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ILLUSIONER, 10, 0, 2));
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, FUTURISTIC_REMAINS_GENERATION);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.NETHER)
                .depth(0.125F)
                .scale(0.2F)
                .temperature(2F)
                .temperatureModifier(Biome.TemperatureModifier.NONE)
                .downfall(0.1F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x0041FF)
                        .waterFogColor(0x0041FF)
                        .fogColor(0x1E0FAA)
                        .skyColor(0x1E0FAA)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static Biome createtaintedswamps() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(TAINTED_SURFACE_BUILDER);
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMAN, 8, 0, 3));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.DROWNED, 12, 0, 5));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.ENDERMITE, 10, 0, 2));
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, FUTURISTIC_REMAINS_GENERATION);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.NETHER)
                .depth(0.125F)
                .scale(0.2F)
                .temperature(2F)
                .temperatureModifier(Biome.TemperatureModifier.NONE)
                .downfall(0.1F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x0041FF)
                        .waterFogColor(0x0041FF)
                        .fogColor(0x1E0FAA)
                        .skyColor(0x1E0FAA)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static Biome createcorrupteddeltas() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(CORRUPTSTONE_SURFACE_BUILDER);
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.MAGMA_CUBE, 12, 0, 5));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.BLAZE, 5, 0, 3));
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, FUTURISTIC_REMAINS_GENERATION);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.NETHER)
                .depth(0.125F)
                .scale(0.2F)
                .temperature(2F)
                .temperatureModifier(Biome.TemperatureModifier.NONE)
                .downfall(0.1F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x0041FF)
                        .waterFogColor(0x0041FF)
                        .fogColor(0x1E0FAA)
                        .skyColor(0x1E0FAA)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static Biome createancientoceans() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(ANCIENT_SURFACE_BUILDER);
        spawnSettings.spawn(SpawnGroup.AMBIENT, new SpawnSettings.SpawnEntry(EntityType.SNOW_GOLEM, 12, 0, 5));
        spawnSettings.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(EntityType.DROWNED, 8, 0, 3));
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        generationSettings.feature(GenerationStep.Feature.UNDERGROUND_ORES, FUTURISTIC_REMAINS_GENERATION);
        generationSettings.feature(GenerationStep.Feature.SURFACE_STRUCTURES, ModFeatures.ANCIENT_SPIKES_CONFIGURED);
        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.NETHER)
                .depth(0.125F)
                .scale(0.2F)
                .temperature(-1F)
                .temperatureModifier(Biome.TemperatureModifier.FROZEN)
                .downfall(0.1F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x0041FF)
                        .waterFogColor(0x0041FF)
                        .fogColor(0x1E0FAA)
                        .skyColor(0x1E0FAA)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    public static void registerBiomes() {
        registerbuilder("hyperrack", HYPERRACK_SURFACE_BUILDER);
        registerbuilder("spirous", SPIROUS_SURFACE_BUILDER);
        registerbuilder("ancient", ANCIENT_SURFACE_BUILDER);
        registerbuilder("corruptstone", CORRUPTSTONE_SURFACE_BUILDER);
        registerbuilder("tainted", TAINTED_SURFACE_BUILDER);
        registerbiome(HYPER_WASTES_KEY, HYPER_WASTES);
        registerbiome(SPIROUS_SPIKES_KEY, SPIROUS_SPIKES);
        registerbiome(ANCIENT_OCEANS_KEY, ANCIENT_OCEANS);
        registerbiome(CORRUPTED_DELTAS_KEY, CORRUPTED_DELTAS);
        registerbiome(TAINTED_SWAMPS_KEY, TAINTED_SWAMPS);
    }

    public static void registerbiome(RegistryKey<Biome> key, Biome biome) {
        Registry.register(BuiltinRegistries.BIOME, key.getValue(), biome);
    }

    public static void registerbuilder(String name, ConfiguredSurfaceBuilder<TernarySurfaceConfig> surfaceBuilder) {
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier(SanixExpansions.MODID, name), surfaceBuilder);
    }
}
