package net.Sanix.Expansions.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.ItemPredicateArgumentType;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.function.Predicate;

public class ciCommand {
    //this is based off the code for the clear command but it is ci instead
    
    private static final DynamicCommandExceptionType FAILED_SINGLE_EXCEPTION = new DynamicCommandExceptionType((object) -> {
        return new TranslatableText("clear.failed.single", new Object[]{object});
    });
    private static final DynamicCommandExceptionType FAILED_MULTIPLE_EXCEPTION = new DynamicCommandExceptionType((object) -> {
        return new TranslatableText("clear.failed.multiple", new Object[]{object});
    });

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register((LiteralArgumentBuilder)(((LiteralArgumentBuilder)CommandManager.literal("ci").requires((serverCommandSource) -> {
            return serverCommandSource.hasPermissionLevel(2);
        })).executes((commandContext) -> {
            return execute((ServerCommandSource)commandContext.getSource(), Collections.singleton(((ServerCommandSource)commandContext.getSource()).getPlayer()), (itemStack) -> {
                return true;
            }, -1);
        })).then(((RequiredArgumentBuilder)CommandManager.argument("targets", EntityArgumentType.players()).executes((commandContext) -> {
            return execute((ServerCommandSource)commandContext.getSource(), EntityArgumentType.getPlayers(commandContext, "targets"), (itemStack) -> {
                return true;
            }, -1);
        })).then(((RequiredArgumentBuilder)CommandManager.argument("item", ItemPredicateArgumentType.itemPredicate()).executes((commandContext) -> {
            return execute((ServerCommandSource)commandContext.getSource(), EntityArgumentType.getPlayers(commandContext, "targets"), ItemPredicateArgumentType.getItemPredicate(commandContext, "item"), -1);
        })).then(CommandManager.argument("maxCount", IntegerArgumentType.integer(0)).executes((commandContext) -> {
            return execute((ServerCommandSource)commandContext.getSource(), EntityArgumentType.getPlayers(commandContext, "targets"), ItemPredicateArgumentType.getItemPredicate(commandContext, "item"), IntegerArgumentType.getInteger(commandContext, "maxCount"));
        })))));
    }

    private static int execute(ServerCommandSource source, Collection<ServerPlayerEntity> targets, Predicate<ItemStack> item, int maxCount) throws CommandSyntaxException {
        int i = 0;
        Iterator<ServerPlayerEntity> var5 = targets.iterator();
        while(var5.hasNext()) {
            ServerPlayerEntity serverPlayerEntity = var5.next();
            i += serverPlayerEntity.getInventory().remove(item, maxCount, serverPlayerEntity.playerScreenHandler.getCraftingInput());
            serverPlayerEntity.playerScreenHandler.clearCraftingSlots();
            serverPlayerEntity.currentScreenHandler.sendContentUpdates();
            serverPlayerEntity.playerScreenHandler.onContentChanged(serverPlayerEntity.getInventory());
        }

        if (i == 0) {
            if (targets.size() == 1) {
                throw FAILED_SINGLE_EXCEPTION.create(((ServerPlayerEntity)targets.iterator().next()).getName());
            } else {
                throw FAILED_MULTIPLE_EXCEPTION.create(targets.size());
            }
        } else {
            if (maxCount == 0) {
                if (targets.size() == 1) {
                    source.sendFeedback(new TranslatableText("commands.clear.test.single", new Object[]{i, ((ServerPlayerEntity)targets.iterator().next()).getDisplayName()}), true);
                } else {
                    source.sendFeedback(new TranslatableText("commands.clear.test.multiple", new Object[]{i, targets.size()}), true);
                }
            } else if (targets.size() == 1) {
                source.sendFeedback(new TranslatableText("commands.clear.success.single", new Object[]{i, ((ServerPlayerEntity)targets.iterator().next()).getDisplayName()}), true);
            } else {
                source.sendFeedback(new TranslatableText("commands.clear.success.multiple", new Object[]{i, targets.size()}), true);
            }

            return i;
        }
    }
}
