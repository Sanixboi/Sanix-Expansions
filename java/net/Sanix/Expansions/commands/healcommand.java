package net.Sanix.Expansions.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import org.apache.logging.log4j.core.jmx.Server;

public class healcommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("heal")
        .requires(source -> source.hasPermissionLevel(2))
        .executes(ctx -> {
            if (ctx.getSource().getPlayer() != null) {
                ServerPlayerEntity player = ctx.getSource().getPlayer();
                player.setHealth(20.0F);
                player.clearStatusEffects();
                player.sendMessage(new TranslatableText("§6You've been healed"), false);
                return 1;
            } else {
                return 0;
            }
        }));
    }
}
