package net.Sanix.Expansions.mixins;

import com.mojang.authlib.GameProfile;
import net.Sanix.Expansions.registries.ModArmor;
import net.Sanix.Expansions.registries.ModItems;
import net.Sanix.Expansions.registries.ModRunes;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public abstract class ClientPlayerEntityMixin extends PlayerEntity {

	@Shadow @Final public ClientPlayNetworkHandler networkHandler;

	public ClientPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile profile) {
		super(world, pos, yaw, profile);
	}


	@Inject(at = @At(value = "JUMP", opcode = 1, ordinal = 9), method = "tickMovement")
	public void fly(CallbackInfo info) {

		ItemStack hs = getEquippedStack(EquipmentSlot.HEAD);
		ItemStack cs = getEquippedStack(EquipmentSlot.CHEST);
		ItemStack ls = getEquippedStack(EquipmentSlot.LEGS);
		ItemStack bootss  = getEquippedStack(EquipmentSlot.FEET);
		boolean containsskydiamondarmor = hs.getItem().equals(ModArmor.SKY_DIAMOND_HELMET) && cs.getItem().equals(ModArmor.SKY_DIAMOND_CHESTPLATE) && ls.getItem().equals(ModArmor.SKY_DIAMOND_LEGGINGS) && bootss.getItem().equals(ModArmor.SKY_DIAMOND_BOOTS);

		if(containsskydiamondarmor) {
				if(checkFallFlying()) {
					this.networkHandler.sendPacket(new ClientCommandC2SPacket(this, ClientCommandC2SPacket.Mode.START_FALL_FLYING));
				}
		}
	}
	@Inject(at = @At("HEAD"), method = "tick")
	private void tick(CallbackInfo info) {

		ItemStack hs = getEquippedStack(EquipmentSlot.HEAD);
		ItemStack cs = getEquippedStack(EquipmentSlot.CHEST);
		ItemStack ls = getEquippedStack(EquipmentSlot.LEGS);
		ItemStack bootss  = getEquippedStack(EquipmentSlot.FEET);
		boolean containsskydiamondarmor = hs.getItem().equals(ModArmor.SKY_DIAMOND_HELMET) && cs.getItem().equals(ModArmor.SKY_DIAMOND_CHESTPLATE) && ls.getItem().equals(ModArmor.SKY_DIAMOND_LEGGINGS) && bootss.getItem().equals(ModArmor.SKY_DIAMOND_BOOTS);

		boolean suprevicioarmor = hs.getItem().equals(ModArmor.SUPREVICIO_HELMET) && cs.getItem().equals(ModArmor.SUPREVICIO_CHESTPLATE) && ls.getItem().equals(ModArmor.SUPREVICIO_LEGGINGS) && bootss.getItem().equals(ModArmor.SUPREVICIO_BOOTS);
		boolean sanisaniumarmor = hs.getItem().equals(ModArmor.SANISANIUM_HELMET) && cs.getItem().equals(ModArmor.SANISANIUM_CHESTPLATE) && ls.getItem().equals(ModArmor.SANISANIUM_LEGGINGS) && bootss.getItem().equals(ModArmor.SANISANIUM_BOOTS);
		boolean empoweredsouliusarmor = hs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_HELMET) && cs.getItem().equals(ModArmor.EMPOWERED_SOULIUS_CHESTPLATE) && ls.getItem().equals(ModArmor.EMPOWERED_SOULIUS_LEGGINGS) && bootss.getItem().equals(ModArmor.EMPOWERED_SOULIUS_BOOTS);

		boolean flightperk = suprevicioarmor || sanisaniumarmor || empoweredsouliusarmor;




	if(flightperk) {
		getAbilities().allowFlying = true;
	} else if (!isCreative() && !isSpectator()){
		getAbilities().allowFlying = false;
		getAbilities().flying = false;
	}

	if(containsskydiamondarmor) {

		if (getInventory().contains(new ItemStack(ModRunes.HERO_OF_THE_VILLAGE_RUNE))) {
			StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 20 * 5);
			addStatusEffect(effect);
		}



		if (getInventory().contains(new ItemStack(ModRunes.BAD_OMEN_RUNE_TIER_4))) {
			removeStatusEffect(StatusEffects.BAD_OMEN);
		}
				
		if (getInventory().contains(new ItemStack(ModRunes.BLINDNESS_RUNE_TIER_4))) {
			removeStatusEffect(StatusEffects.BLINDNESS);
		}
				
		if (getInventory().contains(new ItemStack(ModRunes.GLOWING_RUNE_TIER_4))) {
			removeStatusEffect(StatusEffects.GLOWING);
		}
				
		if (getInventory().contains(new ItemStack(ModRunes.HUNGER_RUNE_TIER_4))) {
			removeStatusEffect(StatusEffects.HUNGER);
		}
				
		if (getInventory().contains(new ItemStack(ModRunes.MINING_FATIGUE_RUNE_TIER_4))) {
			removeStatusEffect(StatusEffects.MINING_FATIGUE);
		}
				
		if (getInventory().contains(new ItemStack(ModRunes.NAUSEA_RUNE_TIER_4))) {
			removeStatusEffect(StatusEffects.NAUSEA);
		}
				
		if (getInventory().contains(new ItemStack(ModRunes.POISON_RUNE_TIER_4))) {
			removeStatusEffect(StatusEffects.POISON);
		}
				
		if (getInventory().contains(new ItemStack(ModRunes.SLOWNESS_RUNE_TIER_4)) || getInventory().contains(new ItemStack(ModRunes.SLOWNESS_RUNE_TIER_5)) || !(enderChestInventory.count(ModRunes.SLOWNESS_RUNE_TIER_5) == 0) || getOffHandStack().equals(new ItemStack(ModRunes.SLOWNESS_RUNE_TIER_2))) {
			removeStatusEffect(StatusEffects.SLOWNESS);
		}
				
		if (getInventory().contains(new ItemStack(ModRunes.WEAKNESS_RUNE_TIER_4))) {
			removeStatusEffect(StatusEffects.WEAKNESS);
		}
				
		if (getInventory().contains(new ItemStack(ModRunes.WITHER_RUNE_TIER_4))) {
			removeStatusEffect(StatusEffects.WITHER);
		}


		if(getInventory().contains(new ItemStack(ModRunes.CONCRETE_RUNE))) {
			int slot = getInventory().getSlotWithStack(new ItemStack(Items.BLACK_CONCRETE_POWDER));
			int a = getInventory().count(Items.BLACK_CONCRETE_POWDER);

			int slot2 = getInventory().getSlotWithStack(new ItemStack(Items.RED_CONCRETE_POWDER));
			int a2 = getInventory().count(Items.RED_CONCRETE_POWDER);

			int slot3 = getInventory().getSlotWithStack(new ItemStack(Items.GREEN_CONCRETE_POWDER));
			int a3 = getInventory().count(Items.GREEN_CONCRETE_POWDER);

			int slot4 = getInventory().getSlotWithStack(new ItemStack(Items.BROWN_CONCRETE_POWDER));
			int a4 = getInventory().count(Items.BROWN_CONCRETE_POWDER);

			int slot5 = getInventory().getSlotWithStack(new ItemStack(Items.BLUE_CONCRETE_POWDER));
			int a5 = getInventory().count(Items.BLUE_CONCRETE_POWDER);

			int slot6 = getInventory().getSlotWithStack(new ItemStack(Items.PURPLE_CONCRETE_POWDER));
			int a6 = getInventory().count(Items.PURPLE_CONCRETE_POWDER);

			int slot7 = getInventory().getSlotWithStack(new ItemStack(Items.CYAN_CONCRETE_POWDER));
			int a7 = getInventory().count(Items.CYAN_CONCRETE_POWDER);

			int slot8 = getInventory().getSlotWithStack(new ItemStack(Items.LIGHT_GRAY_CONCRETE_POWDER));
			int a8 = getInventory().count(Items.LIGHT_GRAY_CONCRETE_POWDER);

			int slot9 = getInventory().getSlotWithStack(new ItemStack(Items.GRAY_CONCRETE_POWDER));
			int a9 = getInventory().count(Items.GRAY_CONCRETE_POWDER);

			int slot10 = getInventory().getSlotWithStack(new ItemStack(Items.PINK_CONCRETE_POWDER));
			int a10 = getInventory().count(Items.PINK_CONCRETE_POWDER);

			int slot11 = getInventory().getSlotWithStack(new ItemStack(Items.LIME_CONCRETE_POWDER));
			int a11 = getInventory().count(Items.LIME_CONCRETE_POWDER);

			int slot12 = getInventory().getSlotWithStack(new ItemStack(Items.YELLOW_CONCRETE_POWDER));
			int a12 = getInventory().count(Items.YELLOW_CONCRETE_POWDER);

			int slot13 = getInventory().getSlotWithStack(new ItemStack(Items.LIGHT_BLUE_CONCRETE_POWDER));
			int a13 = getInventory().count(Items.LIGHT_BLUE_CONCRETE_POWDER);

			int slot14 = getInventory().getSlotWithStack(new ItemStack(Items.MAGENTA_CONCRETE_POWDER));
			int a14 = getInventory().count(Items.MAGENTA_CONCRETE_POWDER);

			int slot15 = getInventory().getSlotWithStack(new ItemStack(Items.ORANGE_CONCRETE_POWDER));
			int a15 = getInventory().count(Items.ORANGE_CONCRETE_POWDER);

			int slot16 = getInventory().getSlotWithStack(new ItemStack(Items.GREEN_CONCRETE_POWDER));
			int a16 = getInventory().count(Items.WHITE_CONCRETE_POWDER);

			getInventory().setStack(slot, new ItemStack(Items.BLACK_CONCRETE));

			if (getInventory().getSlotWithStack(new ItemStack(Items.RED_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot2, new ItemStack(Items.RED_CONCRETE));
				for(int i = a2 - 1; i > 0; i--) {
					getInventory().insertStack(slot2, new ItemStack(Items.RED_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.GREEN_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot3, new ItemStack(Items.GREEN_CONCRETE));
				for(int i = a3 - 1; i > 0; i--) {
					getInventory().insertStack(slot3, new ItemStack(Items.GREEN_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.BROWN_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot4, new ItemStack(Items.BROWN_CONCRETE));
				for(int i = a4 - 1; i > 0; i--) {
					getInventory().insertStack(slot4, new ItemStack(Items.BROWN_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.BLUE_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot5, new ItemStack(Items.BLUE_CONCRETE));
				for(int i = a5 - 1; i > 0; i--) {
					getInventory().insertStack(slot5, new ItemStack(Items.BLUE_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.PURPLE_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot6, new ItemStack(Items.PURPLE_CONCRETE));
				for(int i = a6 - 1; i > 0; i--) {
					getInventory().insertStack(slot6, new ItemStack(Items.PURPLE_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.CYAN_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot7, new ItemStack(Items.CYAN_CONCRETE));
				for(int i = a7 - 1; i > 0; i--) {
					getInventory().insertStack(slot7, new ItemStack(Items.CYAN_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.LIGHT_GRAY_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot8, new ItemStack(Items.LIGHT_GRAY_CONCRETE));
				for(int i = a8 - 1; i > 0; i--) {
					getInventory().insertStack(slot8, new ItemStack(Items.LIGHT_GRAY_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.GRAY_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot9, new ItemStack(Items.GRAY_CONCRETE));
				for(int i = a9 - 1; i > 0; i--) {
					getInventory().insertStack(slot9, new ItemStack(Items.GRAY_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.PINK_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot10, new ItemStack(Items.PINK_CONCRETE));
				for(int i = a10 - 1; i > 0; i--) {
					getInventory().insertStack(slot10, new ItemStack(Items.PINK_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.LIME_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot11, new ItemStack(Items.LIME_CONCRETE));
				for(int i = a11 - 1; i > 0; i--) {
					getInventory().insertStack(slot11, new ItemStack(Items.LIME_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.YELLOW_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot12, new ItemStack(Items.YELLOW_CONCRETE));
				for(int i = a12 - 1; i > 0; i--) {
					getInventory().insertStack(slot12, new ItemStack(Items.YELLOW_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.LIGHT_BLUE_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot13, new ItemStack(Items.LIGHT_BLUE_CONCRETE));
				for(int i = a13 - 1; i > 0; i--) {
					getInventory().insertStack(slot13, new ItemStack(Items.LIGHT_BLUE_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.MAGENTA_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot14, new ItemStack(Items.MAGENTA_CONCRETE));
				for(int i = a14 - 1; i > 0; i--) {
					getInventory().insertStack(slot14, new ItemStack(Items.MAGENTA_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.ORANGE_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot15, new ItemStack(Items.ORANGE_CONCRETE));
				for(int i = a15 - 1; i > 0; i--) {
					getInventory().insertStack(slot15, new ItemStack(Items.ORANGE_CONCRETE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.WHITE_CONCRETE_POWDER)) > -1) {
				getInventory().setStack(slot16, new ItemStack(Items.WHITE_CONCRETE));
				for(int i = a16 - 1; i > 0; i--) {
					getInventory().insertStack(slot16, new ItemStack(Items.WHITE_CONCRETE));
				}
			}
		}

		if (getInventory().contains(new ItemStack(ModRunes.SPONGE_RUNE))) {
			int slot = getInventory().getSlotWithStack(new ItemStack(Items.WET_SPONGE));
			int a = getInventory().count(Items.WET_SPONGE);
			if (getInventory().getSlotWithStack(new ItemStack(Items.WET_SPONGE)) > -1) {
				getInventory().setStack(slot, new ItemStack(Items.SPONGE));
				for(int i = a - 1; i > 0; i--) {
					getInventory().insertStack(slot, new ItemStack(Items.SPONGE));
				}
			}

		}

		if (getInventory().contains(new ItemStack(ModRunes.AUTOSMELT_RUNE_TIER_1))) {
			int slot = getInventory().getSlotWithStack(new ItemStack(Items.IRON_ORE));
			int a = getInventory().count(Items.IRON_ORE);
			int slot2 = getInventory().getSlotWithStack(new ItemStack(Items.GOLD_ORE));
			int a2 = getInventory().count(Items.GOLD_ORE);

			int slot3 = getInventory().getSlotWithStack(new ItemStack(Items.COAL_ORE));
			int a3 = getInventory().count(Items.COAL_ORE);
			int slot4 = getInventory().getSlotWithStack(new ItemStack(Items.LAPIS_ORE));
			int a4 = getInventory().count(Items.LAPIS_ORE);

			int slot5 = getInventory().getSlotWithStack(new ItemStack(Items.REDSTONE_ORE));
			int a5 = getInventory().count(Items.REDSTONE_ORE);
			int slot6 = getInventory().getSlotWithStack(new ItemStack(Items.DIAMOND_ORE));
			int a6 = getInventory().count(Items.DIAMOND_ORE);

			int slot7 = getInventory().getSlotWithStack(new ItemStack(Items.EMERALD_ORE));
			int a7 = getInventory().count(Items.EMERALD_ORE);
			int slot8 = getInventory().getSlotWithStack(new ItemStack(Items.NETHER_QUARTZ_ORE));
			int a8 = getInventory().count(Items.NETHER_QUARTZ_ORE);
			int slot9 = getInventory().getSlotWithStack(new ItemStack(Items.ANCIENT_DEBRIS));
			int a9 = getInventory().count(Items.ANCIENT_DEBRIS);
			int slot10 = getInventory().getSlotWithStack(new ItemStack(Items.COBBLESTONE));
			int a10 = getInventory().count(Items.COBBLESTONE);

			if (getInventory().getSlotWithStack(new ItemStack(Items.IRON_ORE)) > -1) {
				getInventory().setStack(slot, new ItemStack(Items.IRON_INGOT));
				for(int i = a - 1; i > 0; i--) {
					getInventory().insertStack(slot, new ItemStack(Items.IRON_INGOT));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.GOLD_ORE)) > -1) {
				getInventory().setStack(slot2, new ItemStack(Items.GOLD_INGOT));
				for(int i = a2 - 1; i > 0; i--) {
					getInventory().insertStack(slot2, new ItemStack(Items.GOLD_INGOT));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.COAL_ORE)) > -1) {
				getInventory().setStack(slot3, new ItemStack(Items.COAL));
				for(int i = a3 - 1; i > 0; i--) {
					getInventory().insertStack(slot3, new ItemStack(Items.COAL));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.LAPIS_ORE)) > -1) {
				getInventory().setStack(slot4, new ItemStack(Items.LAPIS_LAZULI));
				for(int i = a4 - 1; i > 0; i--) {
					getInventory().insertStack(slot4, new ItemStack(Items.LAPIS_LAZULI));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.REDSTONE_ORE)) > -1) {
				getInventory().setStack(slot5, new ItemStack(Items.REDSTONE));
				for(int i = a5 - 1; i > 0; i--) {
					getInventory().insertStack(slot5, new ItemStack(Items.REDSTONE));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.DIAMOND_ORE)) > -1) {
				getInventory().setStack(slot6, new ItemStack(Items.DIAMOND));
				for(int i = a6 - 1; i > 0; i--) {
					getInventory().insertStack(slot6, new ItemStack(Items.DIAMOND));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.EMERALD_ORE)) > -1) {
				getInventory().setStack(slot7, new ItemStack(Items.EMERALD));
				for(int i = a7 - 1; i > 0; i--) {
					getInventory().insertStack(slot7, new ItemStack(Items.EMERALD));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.NETHER_QUARTZ_ORE)) > -1) {
				getInventory().setStack(slot8, new ItemStack(Items.QUARTZ));
				for(int i = a8 - 1; i > 0; i--) {
					getInventory().insertStack(slot8, new ItemStack(Items.QUARTZ));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.ANCIENT_DEBRIS)) > -1) {
				getInventory().setStack(slot9, new ItemStack(Items.NETHERITE_SCRAP));
				for(int i = a9 - 1; i > 0; i--) {
					getInventory().insertStack(slot9, new ItemStack(Items.NETHERITE_SCRAP));
				}
			}

			if (getInventory().getSlotWithStack(new ItemStack(Items.COBBLESTONE)) > -1) {
				getInventory().setStack(slot10, new ItemStack(Items.STONE));
				for(int i = a10 - 1; i > 0; i--) {
					getInventory().insertStack(slot10, new ItemStack(Items.STONE));
				}
			}
		}
	 } else if (!(isCreative()) && !(isSpectator()) && !(flightperk)) {
		getAbilities().allowFlying = false;
		getAbilities().flying = false;
	}
	if (hs.getItem().equals(ModArmor.MYSTICAL_SKY_DIAMOND_HELMET) && cs.getItem().equals(ModArmor.MYSTICAL_SKY_DIAMOND_CHESTPLATE) && ls.getItem().equals(ModArmor.MYSTICAL_SKY_DIAMOND_LEGGINGS) && bootss.getItem().equals(ModArmor.MYSTICAL_SKY_DIAMOND_BOOTS)) {
		StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.SPEED, 100,  1);
		addStatusEffect(effect);

		StatusEffectInstance effectInstance = new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20 * 30);
		addStatusEffect(effectInstance);

		if (jumping) {
			  StatusEffectInstance effect3 = new StatusEffectInstance(StatusEffects.JUMP_BOOST, 5 * 20);
			  addStatusEffect(effect3);
		}
		getAbilities().allowFlying = true;
		
		if (getInventory().contains(new ItemStack(ModRunes.MYSTICAL_SKY_DIAMOND_APPLE_RUNE))) {
			int slot = getInventory().getSlotWithStack(new ItemStack(Items.GOLDEN_APPLE));
			int a = getInventory().count(Items.GOLDEN_APPLE);
			if (getInventory().getSlotWithStack(new ItemStack(Items.GOLDEN_APPLE)) > -1) {
				getInventory().setStack(slot, new ItemStack(ModItems.MYSTICAL_SKY_DIAMOND_APPLE));
				for(int i = a - 1; i > 0; i--) {
					getInventory().insertStack(slot, new ItemStack(ModItems.MYSTICAL_SKY_DIAMOND_APPLE));
				}
			}
			
		}
		
		if (getInventory().contains(new ItemStack(ModRunes.AUTOSMELT_RUNE_TIER_2))) {
        	int slot = getInventory().getSlotWithStack(new ItemStack(Items.IRON_ORE));
			int a = getInventory().count(Items.IRON_ORE);

			int slot2 = getInventory().getSlotWithStack(new ItemStack(Items.GOLD_ORE));
			int a2 = getInventory().count(Items.GOLD_ORE);
			
			int slot3 = getInventory().getSlotWithStack(new ItemStack(Items.COAL_ORE));
			int a3 = getInventory().count(Items.COAL_ORE);

			int slot4 = getInventory().getSlotWithStack(new ItemStack(Items.LAPIS_ORE));
			int a4 = getInventory().count(Items.LAPIS_ORE);
			
			int slot5 = getInventory().getSlotWithStack(new ItemStack(Items.REDSTONE_ORE));
			int a5 = getInventory().count(Items.REDSTONE_ORE);

			int slot6 = getInventory().getSlotWithStack(new ItemStack(Items.DIAMOND_ORE));
			int a6 = getInventory().count(Items.DIAMOND_ORE);
			
			int slot7 = getInventory().getSlotWithStack(new ItemStack(Items.EMERALD_ORE));
			int a7 = getInventory().count(Items.EMERALD_ORE);

			int slot8 = getInventory().getSlotWithStack(new ItemStack(Items.NETHER_QUARTZ_ORE));
			int a8 = getInventory().count(Items.NETHER_QUARTZ_ORE);
			
			int slot9 = getInventory().getSlotWithStack(new ItemStack(Items.ANCIENT_DEBRIS));
			int a9 = getInventory().count(Items.ANCIENT_DEBRIS);

			int slot10 = getInventory().getSlotWithStack(new ItemStack(Items.COBBLESTONE));
			int a10 = getInventory().count(Items.COBBLESTONE);
			
			int slot11 = getInventory().getSlotWithStack(new ItemStack(Items.STONE));
			int a11 = getInventory().count(Items.STONE);
			
			int slot12 = getInventory().getSlotWithStack(new ItemStack(Items.PORKCHOP));
			int a12 = getInventory().count(Items.PORKCHOP);
			
			int slot13 = getInventory().getSlotWithStack(new ItemStack(Items.BEEF));
			int a13 = getInventory().count(Items.BEEF);
			
			int slot14 = getInventory().getSlotWithStack(new ItemStack(Items.CHICKEN));
			int a14 = getInventory().count(Items.CHICKEN);
			
			int slot15 = getInventory().getSlotWithStack(new ItemStack(Items.COD));
			int a15 = getInventory().count(Items.COD);
			
			int slot16 = getInventory().getSlotWithStack(new ItemStack(Items.SALMON));
			int a16 = getInventory().count(Items.SALMON);
			
			int slot17 = getInventory().getSlotWithStack(new ItemStack(Items.POTATO));
			int a17 = getInventory().count(Items.POTATO);
			
			int slot18 = getInventory().getSlotWithStack(new ItemStack(Items.MUTTON));
			int a18 = getInventory().count(Items.MUTTON);
			
			int slot19 = getInventory().getSlotWithStack(new ItemStack(Items.RABBIT));
			int a19 = getInventory().count(Items.RABBIT);
			
			int slot20 = getInventory().getSlotWithStack(new ItemStack(Items.KELP));
			int a20 = getInventory().count(Items.KELP);
			
			int slot21 = getInventory().getSlotWithStack(new ItemStack(Items.SAND));
			int a21 = getInventory().count(Items.SAND);
			
			int slot22 = getInventory().getSlotWithStack(new ItemStack(Items.SANDSTONE));
			int a22 = getInventory().count(Items.SANDSTONE);
			
			int slot23 = getInventory().getSlotWithStack(new ItemStack(Items.RED_SANDSTONE));
			int a23 = getInventory().count(Items.RED_SANDSTONE);
			
			int slot24 = getInventory().getSlotWithStack(new ItemStack(Items.QUARTZ_BLOCK));
			int a24 = getInventory().count(Items.QUARTZ_BLOCK);
			
			int slot25 = getInventory().getSlotWithStack(new ItemStack(Items.CLAY_BALL));
			int a25 = getInventory().count(Items.CLAY_BALL);
			
			int slot26 = getInventory().getSlotWithStack(new ItemStack(Items.NETHERRACK));
			int a26 = getInventory().count(Items.NETHERRACK);
			
			int slot27 = getInventory().getSlotWithStack(new ItemStack(Items.CLAY));
			int a27 = getInventory().count(Items.CLAY);
			
			int slot28 = getInventory().getSlotWithStack(new ItemStack(Items.STONE_BRICKS));
			int a28 = getInventory().count(Items.STONE_BRICKS);
			
			int slot29 = getInventory().getSlotWithStack(new ItemStack(Items.WHITE_TERRACOTTA));
			int a29 = getInventory().count(Items.WHITE_TERRACOTTA);

			int slot30 = getInventory().getSlotWithStack(new ItemStack(Items.ORANGE_TERRACOTTA));
			int a30 = getInventory().count(Items.ORANGE_TERRACOTTA);
			
			int slot31 = getInventory().getSlotWithStack(new ItemStack(Items.MAGENTA_TERRACOTTA));
			int a31 = getInventory().count(Items.MAGENTA_TERRACOTTA);
			
			int slot32 = getInventory().getSlotWithStack(new ItemStack(Items.LIGHT_BLUE_TERRACOTTA));
			int a32 = getInventory().count(Items.LIGHT_BLUE_TERRACOTTA);
			
			int slot33 = getInventory().getSlotWithStack(new ItemStack(Items.YELLOW_TERRACOTTA));
			int a33 = getInventory().count(Items.YELLOW_TERRACOTTA);
			
			int slot34 = getInventory().getSlotWithStack(new ItemStack(Items.LIME_TERRACOTTA));
			int a34 = getInventory().count(Items.LIME_TERRACOTTA);
			
			int slot35 = getInventory().getSlotWithStack(new ItemStack(Items.PINK_TERRACOTTA));
			int a35 = getInventory().count(Items.PINK_TERRACOTTA);
			
			int slot36 = getInventory().getSlotWithStack(new ItemStack(Items.GRAY_TERRACOTTA));
			int a36 = getInventory().count(Items.GRAY_TERRACOTTA);
			
			int slot37 = getInventory().getSlotWithStack(new ItemStack(Items.LIGHT_GRAY_TERRACOTTA));
			int a37 = getInventory().count(Items.LIGHT_GRAY_TERRACOTTA);
			
			int slot38 = getInventory().getSlotWithStack(new ItemStack(Items.CYAN_TERRACOTTA));
			int a38 = getInventory().count(Items.CYAN_TERRACOTTA);
			
			int slot39 = getInventory().getSlotWithStack(new ItemStack(Items.PURPLE_TERRACOTTA));
			int a39 = getInventory().count(Items.PURPLE_TERRACOTTA);
			
			int slot40 = getInventory().getSlotWithStack(new ItemStack(Items.BLUE_TERRACOTTA));
			int a40 = getInventory().count(Items.BLUE_TERRACOTTA);
			
			int slot41 = getInventory().getSlotWithStack(new ItemStack(Items.BROWN_TERRACOTTA));
			int a41 = getInventory().count(Items.BROWN_TERRACOTTA);
			
			int slot42 = getInventory().getSlotWithStack(new ItemStack(Items.GREEN_TERRACOTTA));
			int a42 = getInventory().count(Items.GREEN_TERRACOTTA);
			
			int slot43 = getInventory().getSlotWithStack(new ItemStack(Items.RED_TERRACOTTA));
			int a43 = getInventory().count(Items.RED_TERRACOTTA);
			
			int slot44 = getInventory().getSlotWithStack(new ItemStack(Items.BLACK_TERRACOTTA));
			int a44 = getInventory().count(Items.BLACK_TERRACOTTA);
			
			int slot45 = getInventory().getSlotWithStack(new ItemStack(Items.CACTUS));
			int a45 = getInventory().count(Items.CACTUS);
			
			int slot46 = getInventory().getSlotWithStack(new ItemStack(Items.CHORUS_FRUIT));
			int a46 = getInventory().count(Items.CHORUS_FRUIT);
			
			int slot47 = getInventory().getSlotWithStack(new ItemStack(Items.WET_SPONGE));
			int a47 = getInventory().count(Items.WET_SPONGE);
			
			int slot48 = getInventory().getSlotWithStack(new ItemStack(Items.SEA_PICKLE));
			int a48 = getInventory().count(Items.SEA_PICKLE);

			int slot49 = getInventory().getSlotWithStack(new ItemStack(Items.OAK_LOG));
			int a49 = getInventory().count(Items.OAK_LOG);
			
			int slot50 = getInventory().getSlotWithStack(new ItemStack(Items.SPRUCE_LOG));
			int a50 = getInventory().count(Items.SPRUCE_LOG);
			
			int slot51 = getInventory().getSlotWithStack(new ItemStack(Items.BIRCH_LOG));
			int a51 = getInventory().count(Items.BIRCH_LOG);
			
			int slot52 = getInventory().getSlotWithStack(new ItemStack(Items.JUNGLE_LOG));
			int a52 = getInventory().count(Items.JUNGLE_LOG);
			
			int slot53 = getInventory().getSlotWithStack(new ItemStack(Items.ACACIA_LOG));
			int a53 = getInventory().count(Items.ACACIA_LOG);
			
			int slot54 = getInventory().getSlotWithStack(new ItemStack(Items.DARK_OAK_LOG));
			int a54 = getInventory().count(Items.DARK_OAK_LOG);
			
			int slot55 = getInventory().getSlotWithStack(new ItemStack(Items.CRIMSON_STEM));
			int a55 = getInventory().count(Items.CRIMSON_STEM);
			
			int slot56 = getInventory().getSlotWithStack(new ItemStack(Items.WARPED_STEM));
			int a56 = getInventory().count(Items.WARPED_STEM);
			
			
			int slot57 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_OAK_LOG));
			int a57 = getInventory().count(Items.STRIPPED_OAK_LOG);
			
			int slot58 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_SPRUCE_LOG));
			int a58 = getInventory().count(Items.STRIPPED_SPRUCE_LOG);
			
			int slot59 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_BIRCH_LOG));
			int a59 = getInventory().count(Items.STRIPPED_BIRCH_LOG);
			
			int slot60 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_JUNGLE_LOG));
			int a60 = getInventory().count(Items.STRIPPED_JUNGLE_LOG);
			
			int slot61 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_ACACIA_LOG));
			int a61 = getInventory().count(Items.STRIPPED_ACACIA_LOG);
			
			int slot62 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_DARK_OAK_LOG));
			int a62 = getInventory().count(Items.STRIPPED_DARK_OAK_LOG);
			
			int slot63 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_CRIMSON_STEM));
			int a63 = getInventory().count(Items.STRIPPED_CRIMSON_STEM);
			
			int slot64 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_WARPED_STEM));
			int a64 = getInventory().count(Items.STRIPPED_WARPED_STEM);

			int slot65 = getInventory().getSlotWithStack(new ItemStack(Items.OAK_WOOD));
			int a65 = getInventory().count(Items.OAK_WOOD);
			
			int slot66 = getInventory().getSlotWithStack(new ItemStack(Items.SPRUCE_WOOD));
			int a66 = getInventory().count(Items.SPRUCE_WOOD);
			
			int slot67 = getInventory().getSlotWithStack(new ItemStack(Items.BIRCH_WOOD));
			int a67 = getInventory().count(Items.BIRCH_WOOD);
			
			int slot68 = getInventory().getSlotWithStack(new ItemStack(Items.JUNGLE_WOOD));
			int a68 = getInventory().count(Items.JUNGLE_WOOD);
			
			int slot69 = getInventory().getSlotWithStack(new ItemStack(Items.ACACIA_WOOD));
			int a69 = getInventory().count(Items.ACACIA_WOOD);
			
			int slot70 = getInventory().getSlotWithStack(new ItemStack(Items.DARK_OAK_WOOD));
			int a70 = getInventory().count(Items.DARK_OAK_WOOD);
			
			
			int slot71 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_OAK_WOOD));
			int a71 = getInventory().count(Items.STRIPPED_OAK_WOOD);
			
			int slot72 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_SPRUCE_WOOD));
			int a72 = getInventory().count(Items.STRIPPED_SPRUCE_WOOD);
			
			int slot73 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_BIRCH_WOOD));
			int a73 = getInventory().count(Items.STRIPPED_BIRCH_WOOD);
			
			int slot74 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_JUNGLE_WOOD));
			int a74 = getInventory().count(Items.STRIPPED_JUNGLE_WOOD);
			
			int slot75 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_ACACIA_WOOD));
			int a75 = getInventory().count(Items.STRIPPED_ACACIA_WOOD);
			
			int slot76 = getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_DARK_OAK_WOOD));
			int a76 = getInventory().count(Items.STRIPPED_DARK_OAK_WOOD);
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.IRON_ORE)) > -1) {
				getInventory().setStack(slot, new ItemStack(Items.IRON_INGOT));
				for(int i = a - 1; i > 0; i--) {
					getInventory().insertStack(slot, new ItemStack(Items.IRON_INGOT));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.GOLD_ORE)) > -1) {
				getInventory().setStack(slot2, new ItemStack(Items.GOLD_INGOT));
				for(int i = a2 - 1; i > 0; i--) {
					getInventory().insertStack(slot2, new ItemStack(Items.GOLD_INGOT));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.COAL_ORE)) > -1) {
				getInventory().setStack(slot3, new ItemStack(Items.COAL));
				for(int i = a3 - 1; i > 0; i--) {
					getInventory().insertStack(slot3, new ItemStack(Items.COAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.LAPIS_ORE)) > -1) {
				getInventory().setStack(slot4, new ItemStack(Items.LAPIS_LAZULI));
				for(int i = a4 - 1; i > 0; i--) {
					getInventory().insertStack(slot4, new ItemStack(Items.LAPIS_LAZULI));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.REDSTONE_ORE)) > -1) {
				getInventory().setStack(slot5, new ItemStack(Items.REDSTONE));
				for(int i = a5 - 1; i > 0; i--) {
					getInventory().insertStack(slot5, new ItemStack(Items.REDSTONE));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.DIAMOND_ORE)) > -1) {
				getInventory().setStack(slot6, new ItemStack(Items.DIAMOND));
				for(int i = a6 - 1; i > 0; i--) {
					getInventory().insertStack(slot6, new ItemStack(Items.DIAMOND));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.EMERALD_ORE)) > -1) {
				getInventory().setStack(slot7, new ItemStack(Items.EMERALD));
				for(int i = a7 - 1; i > 0; i--) {
					getInventory().insertStack(slot7, new ItemStack(Items.EMERALD));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.NETHER_QUARTZ_ORE)) > -1) {
				getInventory().setStack(slot8, new ItemStack(Items.QUARTZ));
				for(int i = a8 - 1; i > 0; i--) {
					getInventory().insertStack(slot8, new ItemStack(Items.QUARTZ));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.ANCIENT_DEBRIS)) > -1) {
				getInventory().setStack(slot9, new ItemStack(Items.NETHERITE_SCRAP));
				for(int i = a9 - 1; i > 0; i--) {
					getInventory().insertStack(slot9, new ItemStack(Items.NETHERITE_SCRAP));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.COBBLESTONE)) > -1) {
				getInventory().setStack(slot10, new ItemStack(Items.STONE));
				for(int i = a10 - 1; i > 0; i--) {
					getInventory().insertStack(slot10, new ItemStack(Items.STONE));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STONE)) > -1) {
				getInventory().setStack(slot11, new ItemStack(Items.SMOOTH_STONE));
				for(int i = a11 - 1; i > 0; i--) {
					getInventory().insertStack(slot11, new ItemStack(Items.SMOOTH_STONE));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.PORKCHOP)) > -1) {
				getInventory().setStack(slot12, new ItemStack(Items.COOKED_PORKCHOP));
				for(int i = a12 - 1; i > 0; i--) {
					getInventory().insertStack(slot12, new ItemStack(Items.COOKED_PORKCHOP));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.BEEF)) > -1) {
				getInventory().setStack(slot13, new ItemStack(Items.COOKED_BEEF));
				for(int i = a13 - 1; i > 0; i--) {
					getInventory().insertStack(slot13, new ItemStack(Items.COOKED_BEEF));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.CHICKEN)) > -1) {
				getInventory().setStack(slot14, new ItemStack(Items.COOKED_CHICKEN));
				for(int i = a14 - 1; i > 0; i--) {
					getInventory().insertStack(slot14, new ItemStack(Items.COOKED_CHICKEN));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.COD)) > -1) {
				getInventory().setStack(slot15, new ItemStack(Items.COOKED_COD));
				for(int i = a15 - 1; i > 0; i--) {
					getInventory().insertStack(slot15, new ItemStack(Items.COOKED_COD));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.SALMON)) > -1) {
				getInventory().setStack(slot16, new ItemStack(Items.COOKED_SALMON));
				for(int i = a16 - 1; i > 0; i--) {
					getInventory().insertStack(slot16, new ItemStack(Items.COOKED_SALMON));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.POTATO)) > -1) {
				getInventory().setStack(slot17, new ItemStack(Items.BAKED_POTATO));
				for(int i = a17 - 1; i > 0; i--) {
					getInventory().insertStack(slot17, new ItemStack(Items.BAKED_POTATO));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.MUTTON)) > -1) {
				getInventory().setStack(slot18, new ItemStack(Items.COOKED_MUTTON));
				for(int i = a18 - 1; i > 0; i--) {
					getInventory().insertStack(slot18, new ItemStack(Items.COOKED_MUTTON));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.RABBIT)) > -1) {
				getInventory().setStack(slot19, new ItemStack(Items.COOKED_RABBIT));
				for(int i = a19 - 1; i > 0; i--) {
					getInventory().insertStack(slot19, new ItemStack(Items.COOKED_RABBIT));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.KELP)) > -1) {
				getInventory().setStack(slot20, new ItemStack(Items.DRIED_KELP));
				for(int i = a20 - 1; i > 0; i--) {
					getInventory().insertStack(slot20, new ItemStack(Items.DRIED_KELP));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.SAND)) > -1) {
				getInventory().setStack(slot21, new ItemStack(Items.GLASS));
				for(int i = a21 - 1; i > 0; i--) {
					getInventory().insertStack(slot21, new ItemStack(Items.GLASS));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.SANDSTONE)) > -1) {
				getInventory().setStack(slot22, new ItemStack(Items.SMOOTH_SANDSTONE));
				for(int i = a22 - 1; i > 0; i--) {
					getInventory().insertStack(slot22, new ItemStack(Items.SMOOTH_SANDSTONE));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.RED_SANDSTONE)) > -1) {
				getInventory().setStack(slot23, new ItemStack(Items.SMOOTH_RED_SANDSTONE));
				for(int i = a23 - 1; i > 0; i--) {
					getInventory().insertStack(slot23, new ItemStack(Items.SMOOTH_RED_SANDSTONE));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.QUARTZ_BLOCK)) > -1) {
				getInventory().setStack(slot24, new ItemStack(Items.SMOOTH_QUARTZ));
				for(int i = a24 - 1; i > 0; i--) {
					getInventory().insertStack(slot24, new ItemStack(Items.SMOOTH_QUARTZ));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.CLAY_BALL)) > -1) {
				getInventory().setStack(slot25, new ItemStack(Items.BRICK));
				for(int i = a25 - 1; i > 0; i--) {
					getInventory().insertStack(slot25, new ItemStack(Items.BRICK));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.NETHERRACK)) > -1) {
				getInventory().setStack(slot26, new ItemStack(Items.NETHER_BRICK));
				for(int i = a26 - 1; i > 0; i--) {
					getInventory().insertStack(slot26, new ItemStack(Items.NETHER_BRICK));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.CLAY)) > -1) {
				getInventory().setStack(slot27, new ItemStack(Items.TERRACOTTA));
				for(int i = a27 - 1; i > 0; i--) {
					getInventory().insertStack(slot27, new ItemStack(Items.TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STONE_BRICKS)) > -1) {
				getInventory().setStack(slot28, new ItemStack(Items.CRACKED_STONE_BRICKS));
				for(int i = a28 - 1; i > 0; i--) {
					getInventory().insertStack(slot28, new ItemStack(Items.CRACKED_STONE_BRICKS));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.WHITE_TERRACOTTA)) > -1) {
				getInventory().setStack(slot29, new ItemStack(Items.WHITE_GLAZED_TERRACOTTA));
				for(int i = a29 - 1; i > 0; i--) {
					getInventory().insertStack(slot29, new ItemStack(Items.WHITE_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.ORANGE_TERRACOTTA)) > -1) {
				getInventory().setStack(slot30, new ItemStack(Items.ORANGE_GLAZED_TERRACOTTA));
				for(int i = a30 - 1; i > 0; i--) {
					getInventory().insertStack(slot30, new ItemStack(Items.ORANGE_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.MAGENTA_TERRACOTTA)) > -1) {
				getInventory().setStack(slot31, new ItemStack(Items.MAGENTA_GLAZED_TERRACOTTA));
				for(int i = a31 - 1; i > 0; i--) {
					getInventory().insertStack(slot31, new ItemStack(Items.MAGENTA_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.LIGHT_BLUE_TERRACOTTA)) > -1) {
				getInventory().setStack(slot32, new ItemStack(Items.LIGHT_BLUE_GLAZED_TERRACOTTA));
				for(int i = a32 - 1; i > 0; i--) {
					getInventory().insertStack(slot32, new ItemStack(Items.LIGHT_BLUE_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.YELLOW_TERRACOTTA)) > -1) {
				getInventory().setStack(slot33, new ItemStack(Items.YELLOW_GLAZED_TERRACOTTA));
				for(int i = a33 - 1; i > 0; i--) {
					getInventory().insertStack(slot33, new ItemStack(Items.YELLOW_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.LIME_TERRACOTTA)) > -1) {
				getInventory().setStack(slot34, new ItemStack(Items.LIME_GLAZED_TERRACOTTA));
				for(int i = a34 - 1; i > 0; i--) {
					getInventory().insertStack(slot34, new ItemStack(Items.LIME_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.PINK_TERRACOTTA)) > -1) {
				getInventory().setStack(slot35, new ItemStack(Items.PINK_GLAZED_TERRACOTTA));
				for(int i = a35 - 1; i > 0; i--) {
					getInventory().insertStack(slot35, new ItemStack(Items.PINK_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.GRAY_TERRACOTTA)) > -1) {
				getInventory().setStack(slot36, new ItemStack(Items.GRAY_GLAZED_TERRACOTTA));
				for(int i = a36 - 1; i > 0; i--) {
					getInventory().insertStack(slot36, new ItemStack(Items.GRAY_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.LIGHT_GRAY_TERRACOTTA)) > -1) {
				getInventory().setStack(slot37, new ItemStack(Items.LIGHT_GRAY_GLAZED_TERRACOTTA));
				for(int i = a37 - 1; i > 0; i--) {
					getInventory().insertStack(slot37, new ItemStack(Items.LIGHT_GRAY_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.CYAN_TERRACOTTA)) > -1) {
				getInventory().setStack(slot38, new ItemStack(Items.CYAN_GLAZED_TERRACOTTA));
				for(int i = a38 - 1; i > 0; i--) {
					getInventory().insertStack(slot38, new ItemStack(Items.CYAN_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.PURPLE_TERRACOTTA)) > -1) {
				getInventory().setStack(slot39, new ItemStack(Items.PURPLE_GLAZED_TERRACOTTA));
				for(int i = a39 - 1; i > 0; i--) {
					getInventory().insertStack(slot39, new ItemStack(Items.PURPLE_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.BLUE_TERRACOTTA)) > -1) {
				getInventory().setStack(slot40, new ItemStack(Items.BLUE_GLAZED_TERRACOTTA));
				for(int i = a40 - 1; i > 0; i--) {
					getInventory().insertStack(slot40, new ItemStack(Items.BLUE_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.BROWN_TERRACOTTA)) > -1) {
				getInventory().setStack(slot41, new ItemStack(Items.BROWN_GLAZED_TERRACOTTA));
				for(int i = a41 - 1; i > 0; i--) {
					getInventory().insertStack(slot41, new ItemStack(Items.BROWN_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.GREEN_TERRACOTTA)) > -1) {
				getInventory().setStack(slot42, new ItemStack(Items.GREEN_GLAZED_TERRACOTTA));
				for(int i = a42 - 1; i > 0; i--) {
					getInventory().insertStack(slot42, new ItemStack(Items.GREEN_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.RED_TERRACOTTA)) > -1) {
				getInventory().setStack(slot43, new ItemStack(Items.RED_GLAZED_TERRACOTTA));
				for(int i = a43 - 1; i > 0; i--) {
					getInventory().insertStack(slot43, new ItemStack(Items.RED_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.BLACK_TERRACOTTA)) > -1) {
				getInventory().setStack(slot44, new ItemStack(Items.BLACK_GLAZED_TERRACOTTA));
				for(int i = a44 - 1; i > 0; i--) {
					getInventory().insertStack(slot44, new ItemStack(Items.BLACK_GLAZED_TERRACOTTA));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.CACTUS)) > -1) {
				getInventory().setStack(slot45, new ItemStack(Items.GREEN_DYE));
				for(int i = a45 - 1; i > 0; i--) {
					getInventory().insertStack(slot45, new ItemStack(Items.GREEN_DYE));
				}
			}
			
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.CHORUS_FRUIT)) > -1) {
				getInventory().setStack(slot46, new ItemStack(Items.POPPED_CHORUS_FRUIT));
				for(int i = a46 - 1; i > 0; i--) {
					getInventory().insertStack(slot46, new ItemStack(Items.POPPED_CHORUS_FRUIT));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.WET_SPONGE)) > -1) {
				getInventory().setStack(slot47, new ItemStack(Items.SPONGE));
				for(int i = a47 - 1; i > 0; i--) {
					getInventory().insertStack(slot47, new ItemStack(Items.SPONGE));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.SEA_PICKLE)) > -1) {
				getInventory().setStack(slot48, new ItemStack(Items.LIME_DYE));
				for(int i = a48 - 1; i > 0; i--) {
					getInventory().insertStack(slot48, new ItemStack(Items.LIME_DYE));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.OAK_LOG)) > -1) {
				getInventory().setStack(slot49, new ItemStack(Items.CHARCOAL));
				for(int i = a49 - 1; i > 0; i--) {
					getInventory().insertStack(slot49, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.SPRUCE_LOG)) > -1) {
				getInventory().setStack(slot50, new ItemStack(Items.CHARCOAL));
				for(int i = a50 - 1; i > 0; i--) {
					getInventory().insertStack(slot50, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.BIRCH_LOG)) > -1) {
				getInventory().setStack(slot51, new ItemStack(Items.CHARCOAL));
				for(int i = a51 - 1; i > 0; i--) {
					getInventory().insertStack(slot51, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.JUNGLE_LOG)) > -1) {
				getInventory().setStack(slot52, new ItemStack(Items.CHARCOAL));
				for(int i = a52 - 1; i > 0; i--) {
					getInventory().insertStack(slot52, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.ACACIA_LOG)) > -1) {
				getInventory().setStack(slot53, new ItemStack(Items.CHARCOAL));
				for(int i = a53 - 1; i > 0; i--) {
					getInventory().insertStack(slot53, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.DARK_OAK_LOG)) > -1) {
				getInventory().setStack(slot54, new ItemStack(Items.CHARCOAL));
				for(int i = a54 - 1; i > 0; i--) {
					getInventory().insertStack(slot54, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.CRIMSON_STEM)) > -1) {
				getInventory().setStack(slot55, new ItemStack(Items.CHARCOAL));
				for(int i = a55 - 1; i > 0; i--) {
					getInventory().insertStack(slot55, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.WARPED_STEM)) > -1) {
				getInventory().setStack(slot56, new ItemStack(Items.CHARCOAL));
				for(int i = a56 - 1; i > 0; i--) {
					getInventory().insertStack(slot56, new ItemStack(Items.CHARCOAL));
				}
			}
			
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_OAK_LOG)) > -1) {
				getInventory().setStack(slot57, new ItemStack(Items.CHARCOAL));
				for(int i = a57 - 1; i > 0; i--) {
					getInventory().insertStack(slot57, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_SPRUCE_LOG)) > -1) {
				getInventory().setStack(slot58, new ItemStack(Items.CHARCOAL));
				for(int i = a58 - 1; i > 0; i--) {
					getInventory().insertStack(slot58, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_BIRCH_LOG)) > -1) {
				getInventory().setStack(slot59, new ItemStack(Items.CHARCOAL));
				for(int i = a59 - 1; i > 0; i--) {
					getInventory().insertStack(slot59, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_JUNGLE_LOG)) > -1) {
				getInventory().setStack(slot60, new ItemStack(Items.CHARCOAL));
				for(int i = a60 - 1; i > 0; i--) {
					getInventory().insertStack(slot60, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_ACACIA_LOG)) > -1) {
				getInventory().setStack(slot61, new ItemStack(Items.CHARCOAL));
				for(int i = a61 - 1; i > 0; i--) {
					getInventory().insertStack(slot61, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_DARK_OAK_LOG)) > -1) {
				getInventory().setStack(slot62, new ItemStack(Items.CHARCOAL));
				for(int i = a62 - 1; i > 0; i--) {
					getInventory().insertStack(slot62, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_CRIMSON_STEM)) > -1) {
				getInventory().setStack(slot63, new ItemStack(Items.CHARCOAL));
				for(int i = a63 - 1; i > 0; i--) {
					getInventory().insertStack(slot63, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_WARPED_STEM)) > -1) {
				getInventory().setStack(slot64, new ItemStack(Items.CHARCOAL));
				for(int i = a64 - 1; i > 0; i--) {
					getInventory().insertStack(slot64, new ItemStack(Items.CHARCOAL));
				}
			}
			
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.OAK_WOOD)) > -1) {
				getInventory().setStack(slot65, new ItemStack(Items.CHARCOAL));
				for(int i = a65 - 1; i > 0; i--) {
					getInventory().insertStack(slot65, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.SPRUCE_WOOD)) > -1) {
				getInventory().setStack(slot66, new ItemStack(Items.CHARCOAL));
				for(int i = a66 - 1; i > 0; i--) {
					getInventory().insertStack(slot66, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.BIRCH_WOOD)) > -1) {
				getInventory().setStack(slot67, new ItemStack(Items.CHARCOAL));
				for(int i = a67 - 1; i > 0; i--) {
					getInventory().insertStack(slot67, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.JUNGLE_WOOD)) > -1) {
				getInventory().setStack(slot68, new ItemStack(Items.CHARCOAL));
				for(int i = a68 - 1; i > 0; i--) {
					getInventory().insertStack(slot68, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.ACACIA_WOOD)) > -1) {
				getInventory().setStack(slot69, new ItemStack(Items.CHARCOAL));
				for(int i = a69 - 1; i > 0; i--) {
					getInventory().insertStack(slot69, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.DARK_OAK_WOOD)) > -1) {
				getInventory().setStack(slot70, new ItemStack(Items.CHARCOAL));
				for(int i = a70 - 1; i > 0; i--) {
					getInventory().insertStack(slot70, new ItemStack(Items.CHARCOAL));
				}
			}
			
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_OAK_WOOD)) > -1) {
				getInventory().setStack(slot71, new ItemStack(Items.CHARCOAL));
				for(int i = a71 - 1; i > 0; i--) {
					getInventory().insertStack(slot71, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_SPRUCE_WOOD)) > -1) {
				getInventory().setStack(slot72, new ItemStack(Items.CHARCOAL));
				for(int i = a72 - 1; i > 0; i--) {
					getInventory().insertStack(slot72, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_BIRCH_WOOD)) > -1) {
				getInventory().setStack(slot73, new ItemStack(Items.CHARCOAL));
				for(int i = a73 - 1; i > 0; i--) {
					getInventory().insertStack(slot73, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_JUNGLE_WOOD)) > -1) {
				getInventory().setStack(slot74, new ItemStack(Items.CHARCOAL));
				for(int i = a74 - 1; i > 0; i--) {
					getInventory().insertStack(slot74, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_ACACIA_WOOD)) > -1) {
				getInventory().setStack(slot75, new ItemStack(Items.CHARCOAL));
				for(int i = a75 - 1; i > 0; i--) {
					getInventory().insertStack(slot75, new ItemStack(Items.CHARCOAL));
				}
			}
			
			if (getInventory().getSlotWithStack(new ItemStack(Items.STRIPPED_DARK_OAK_WOOD)) > -1) {
				getInventory().setStack(slot76, new ItemStack(Items.CHARCOAL));
				for(int i = a76 - 1; i > 0; i--) {
					getInventory().insertStack(slot76, new ItemStack(Items.CHARCOAL));
				}
			}
		}


	} 

	}
	
	
  }

