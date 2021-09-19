package net.Sanix.Expansions.mixins;

import com.google.common.collect.Maps;
import net.Sanix.Expansions.registries.ModTools;
import net.minecraft.client.item.ModelPredicateProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.item.UnclampedModelPredicateProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ModelPredicateProviderRegistry.class)
public class ModelPredicateProviderRegistryMixin {

    @Shadow @Final private static Map<Item, Map<Identifier, ModelPredicateProvider>> ITEM_SPECIFIC;

    @Inject(at = @At("HEAD"), method = "register(Lnet/minecraft/item/Item;Lnet/minecraft/util/Identifier;Lnet/minecraft/client/item/UnclampedModelPredicateProvider;)V")
    private static void register(Item item, Identifier id, UnclampedModelPredicateProvider provider, CallbackInfo info) {
        if (item.equals(Items.SHIELD)) {

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.INFERSICO_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.ACCIDENTIUM_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.CRUDEMEDIUM_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.SUPERICIO_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.SUPREVICIO_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.SANISANIUM_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.SOULIUS_DAGGER, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.EMPOWERED_SOULIUS_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            //for legacy combat rune

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.CARBON_DIAMOND_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.REINFORCED_DIAMOND_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.VILLAGER_DIAMOND_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.ENDER_DIAMOND_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.SKY_DIAMOND_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.MYSTICAL_SKY_DIAMOND_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(Items.WOODEN_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.OAK_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.SPRUCE_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.BIRCH_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.JUNGLE_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.ACACIA_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.ANDESITE_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.GRANITE_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.DIORITE_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.DARK_OAK_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.CRIMSON_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(ModTools.WARPED_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(Items.STONE_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(Items.IRON_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(Items.GOLDEN_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(Items.DIAMOND_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);

            (ITEM_SPECIFIC.computeIfAbsent(Items.NETHERITE_SWORD, (itemx) -> Maps.newHashMap())).put(id, provider);


        }

    }
}
