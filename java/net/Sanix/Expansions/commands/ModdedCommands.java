package net.Sanix.Expansions.commands;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;


public class ModdedCommands {

    public static void addcommands() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) ->  {
            GamemodeShortenCommands.registergmc(dispatcher);
            GamemodeShortenCommands.registergms(dispatcher);
            GamemodeShortenCommands.registergmsp(dispatcher);
            GamemodeShortenCommands.registergma(dispatcher);
            ciCommand.register(dispatcher);
            healcommand.register(dispatcher);
            flycommand.register(dispatcher);
        });

    }
}
