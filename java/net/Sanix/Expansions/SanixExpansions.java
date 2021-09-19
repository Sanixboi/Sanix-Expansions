package net.Sanix.Expansions;

import net.Sanix.Expansions.commands.ModdedCommands;
import net.Sanix.Expansions.effects.AntiGravityEffect;
import net.Sanix.Expansions.effects.CorruptedGravityEffect;
import net.Sanix.Expansions.effects.SlideSpeedEffect;
import net.Sanix.Expansions.enchantments.SlideSpeedEnchantment;
import net.Sanix.Expansions.guis.TeleportationGui;
import net.Sanix.Expansions.items.AbilitySwordItem;
import net.Sanix.Expansions.registries.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.kyrptonaught.customportalapi.CustomPortalApiRegistry;
import net.kyrptonaught.customportalapi.portal.PortalIgnitionSource;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.SmithingScreenHandler;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import org.lwjgl.glfw.GLFW;


public class SanixExpansions implements ModInitializer {



	// The Hell Difficulty has taught me lots about server/client things (fixing some of the runes I made)and other ideas for the mod itself. Thanks Fundy! :D
	// - Sanixboi 6/8/20
	public static ConfiguredFeature<?, ?> SKY_DIAMOND_ORE_GENERATION = Feature.ORE.configure(
			new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ModBlocks.SKY_DIAMOND_ORE.getDefaultState(),
					4
			)).range(
					new RangeDecoratorConfig(
							UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(12))))
			.spreadHorizontally().repeat(4);

	public static ConfiguredFeature<?, ?> ICE_CRYSTAL_ORE_GENERATION = Feature.ORE.configure(
			new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ModBlocks.ICE_CRYSTAL_ORE.getDefaultState(),
					2
			)).range(
			new RangeDecoratorConfig(
					UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(10))))
	.spreadHorizontally().repeat(2);


	public static ConfiguredFeature<?, ?> MYCELIUM_CRYSTAL_ORE_GENERATION = Feature.ORE.configure(
			new OreFeatureConfig(
					OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
					ModBlocks.MYCELIUM_CRYSTAL_ORE.getDefaultState(),
					1
			)).range(
					new RangeDecoratorConfig(
							UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(9))))
					.spreadHorizontally().repeat(2);


	public static String MODID = "sanixexpansions";

	private static KeyBinding ability;
	public static SoundEvent ENTITY_PLAYER_OLDHURT = Registry.register(Registry.SOUND_EVENT, new Identifier("sanixexpansions:oldhurt"), new SoundEvent(new Identifier("sanixexpansions:oldhurt")));

	public static ScreenHandlerType<ScreenHandler> TELEPORTATION_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(MODID, "teleportation_handler"), (syncId, inventory) -> new TeleportationGui(syncId, inventory, inventory.player));

	public static final StatusEffect CORRUPTED_GRAVITY = new CorruptedGravityEffect();
	public static final StatusEffect ANTI_GRAVITY = new AntiGravityEffect();
	public static final StatusEffect SLIDE_SPEED = new SlideSpeedEffect().addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "075eed5d-db1f-418d-bc34-6d68b4f11290", 0.50000000298023224D, EntityAttributeModifier.Operation.MULTIPLY_TOTAL);

	public static final Enchantment SLIDE_SPEED_EMCHANTMENT = new SlideSpeedEnchantment();
	@Override
	public void onInitialize() {


		SExpansions.init();
		ModdedCommands.addcommands();

		ability = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"Sword Dash",
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_B,
				"Sanix Expansions"
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if (ability.isPressed()) {
				assert client.player != null;
				ItemStack stack = client.player.getActiveItem();
				if (stack.getItem() instanceof AbilitySwordItem) {
					((AbilitySwordItem)stack.getItem()).ability(client.player, client.player.getEntityWorld(), client.player.getActiveHand());
				}
			}
		});

		CustomPortalApiRegistry.addPortal(ModBlocks.CHARGED_GLOWSTONE, PortalIgnitionSource.WATER, new Identifier(MODID, "dims/hyper_nether"), 0, 125, 255);

	    Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MODID, "sky_diamond_ore_generation"), SKY_DIAMOND_ORE_GENERATION);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MODID, "ice_crystal_ore_generation"), ICE_CRYSTAL_ORE_GENERATION);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MODID, "mycelium_crystal_ore_generation"), MYCELIUM_CRYSTAL_ORE_GENERATION);

		ModFluids.registerfluids();
		ModFeatures.registerfeatures();
		ModBiomes.registerBiomes();

		Registry.register(Registry.STATUS_EFFECT, new Identifier(MODID, "slide_speed"), SLIDE_SPEED);
		Registry.register(Registry.STATUS_EFFECT, new Identifier(MODID, "corrupted_gravity"), CORRUPTED_GRAVITY);
		Registry.register(Registry.STATUS_EFFECT, new Identifier(MODID, "anti_gravity"), ANTI_GRAVITY);
		Registry.register(Registry.ENCHANTMENT, new Identifier(MODID, "slide_speed"), SLIDE_SPEED_EMCHANTMENT);
	}

	
}