package net.Sanix.Expansions.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.GameMode;


public class GamemodeShortenCommands {

    public static void registergmc(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("gmc")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(ctx -> {
                    if (!(ctx.getSource().getPlayer().isCreative())) {
                        ctx.getSource().getPlayer().changeGameMode(GameMode.CREATIVE);
                        ctx.getSource().getPlayer().sendMessage(new TranslatableText("Set own game mode to Creative Mode"), false);
                        return 1;
                    }
                    return 0;
                }));

    }
    public static void registergms(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("gms")
        .requires(source -> source.hasPermissionLevel(2))
        .executes(ctx -> {
            if (!(ctx.getSource().getPlayer().interactionManager.getGameMode().equals(GameMode.SURVIVAL))) {
                ctx.getSource().getPlayer().changeGameMode(GameMode.SURVIVAL);
                ctx.getSource().getPlayer().sendMessage(new TranslatableText("Set own game mode to Survival Mode"), false);
                return 1;
            }
            return 0;
        })
        );
    }

    public static void registergmsp(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("gmsp")
        .requires(source -> source.hasPermissionLevel(2))
        .executes(ctx -> {
            if (!(ctx.getSource().getPlayer().interactionManager.getGameMode().equals(GameMode.SPECTATOR))) {
                ctx.getSource().getPlayer().changeGameMode(GameMode.SPECTATOR);
                ctx.getSource().getPlayer().sendMessage(new TranslatableText("Set own game mode to Spectator Mode"), false);
                return 1;
            }
            return 0;
        }));
    }

    public static void registergma(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("gma")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(ctx -> {
                    if (!(ctx.getSource().getPlayer().interactionManager.getGameMode().equals(GameMode.ADVENTURE))) {
                        ctx.getSource().getPlayer().changeGameMode(GameMode.ADVENTURE);
                        ctx.getSource().getPlayer().sendMessage(new TranslatableText("Set own game mode to Adventure Mode"), false);
                        return 1;
                    }
                    return 0;
                }));
    }
}
