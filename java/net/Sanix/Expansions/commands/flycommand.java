package net.Sanix.Expansions.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

public class flycommand {

    private static boolean fly = false;

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("fly")
                .requires(source -> source.hasPermissionLevel(2))
                .executes(ctx -> {
                   if (!fly) {
                       ctx.getSource().getPlayer().getAbilities().allowFlying = true;
                       ctx.getSource().getPlayer().getAbilities().flying = true;
                       ctx.getSource().getPlayer().sendMessage(new TranslatableText("Flight has been turned on for " + ctx.getSource().getPlayer().getName().asString()), false);
                       fly = true;
                  } else {
                       ctx.getSource().getPlayer().getAbilities().allowFlying = false;
                       ctx.getSource().getPlayer().getAbilities().flying = false;
                       ctx.getSource().getPlayer().sendMessage(new TranslatableText("Flight has been turned off for " + ctx.getSource().getPlayer().getName().asString()), false);
                       fly = false;
                 }
                    return 0;
                }));
    }
}
