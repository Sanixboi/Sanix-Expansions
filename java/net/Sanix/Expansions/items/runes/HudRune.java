package net.Sanix.Expansions.items.runes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import net.Sanix.Expansions.registries.ModItemGroups;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class HudRune extends Item{
	
	public HudRune() {
		super(new Item.Settings().group(ModItemGroups.RUNES));
	}
	
	@Override
	public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
		LocalDateTime now = LocalDateTime.now(); 
		tooltip.add(new TranslatableText("item.sanixexpansions.hud_rune.tooltip", dtf.format(now)));
	}
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		user.sendMessage(new TranslatableText("X:%s Y: %s Z:%s", (int)user.getX(), (int)user.getY(), (int)user.getZ()), false);
		user.sendMessage(new TranslatableText("Real World Time:%s", dtf.format(now)), false);
		return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand)); 
	}

}
