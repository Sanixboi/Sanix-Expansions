package net.Sanix.Expansions.items.runes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.*;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GUIRune extends Item {

    public static final TranslatableText CONTAINER_NAME;
    public String type;
    public GUIRune(Settings settings, String type) {
        super(settings);
        this.type = type;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            String types = type.toLowerCase();
            if (type.toLowerCase().equals("enderchest")) {
                EnderChestInventory enderChestInventory = user.getEnderChestInventory();
                user.openHandledScreen(new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> GenericContainerScreenHandler.createGeneric9x3(i, playerInventory, enderChestInventory), CONTAINER_NAME));
                user.incrementStat(Stats.OPEN_ENDERCHEST);
            } else {
                user.openHandledScreen(createScreenHandlerFactory(world, user.getBlockPos()));
                switch (types) {
                    case "crafting":
                        user.incrementStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
                        break;
                    case "grindstone":
                        user.incrementStat(Stats.INTERACT_WITH_GRINDSTONE);
                        break;
                    case "smithing":
                        user.incrementStat(Stats.INTERACT_WITH_SMITHING_TABLE);
                        break;
                    case "loom":
                        user.incrementStat(Stats.INTERACT_WITH_LOOM);
                        break;
                    case "furnace":
                        user.incrementStat(Stats.INTERACT_WITH_FURNACE);
                        break;
                }
            }
            return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
        }
        return new TypedActionResult<>(ActionResult.PASS, user.getStackInHand(hand));
    }



    public NamedScreenHandlerFactory createScreenHandlerFactory(World world, BlockPos pos) {
        Text TITLE = !type.toLowerCase().equals("grindstone") ? !type.toLowerCase().equals("smithing") ? !type.toLowerCase().equals("enchanting") ? new TranslatableText("container." + type.toLowerCase()): new TranslatableText("container.enchant") : new TranslatableText("container.upgrade"): new TranslatableText("container.grindstone_title");
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) -> {
            switch (type.toLowerCase()) {
                case "crafting":
                    return new CraftingScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
                case "grindstone":
                    return new GrindstoneScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
                case "loom":
                    return new LoomScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
                case "smithing":
                    return new SmithingScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
                case "enchanting":
                    return new EnchantmentScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
                case "stonecutter":
                    return new StonecutterScreenHandler(i, playerInventory, ScreenHandlerContext.create(world, pos));
            }


            return null;
        }, TITLE);
    }

    static {
        CONTAINER_NAME = new TranslatableText("container.enderchest");
    }
}
