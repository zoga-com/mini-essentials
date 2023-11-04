package ru.zoga_com.miniessentials.common;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.ArgumentSuggestions;
import dev.jorel.commandapi.arguments.IntegerArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import ru.zoga_com.miniessentials.commands.*;
import ru.zoga_com.miniessentials.common.generics.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private static final List<Command> COMMAND_LIST = new ArrayList<>(){{
        add(new CommandFly());
        add(new CommandGamemode());
        add(new CommandPing());
        add(new CommandSpeed());
        add(new CommandTime());
        add(new CommandWeather());
    }};

    public static void registerCommands() {
        COMMAND_LIST.forEach(command -> {
            CommandAPICommand raw_command = new CommandAPICommand(command.getCommandName());
            if(command.getArgumentMap() != null) {
                command.getArgumentMap().forEach((key, value) -> {
                    switch(value) {
                        case "String":
                            raw_command.withArguments(new StringArgument(key).replaceSuggestions(ArgumentSuggestions.strings(command.getSuggestions())));
                            break;
                        case "Int":
                            raw_command.withArguments(new IntegerArgument(key).replaceSuggestions(ArgumentSuggestions.strings(command.getSuggestions())));
                            break;
                        case "StringOrInt":
                            raw_command.withArguments(new StringArgument(key));
                            break;
                    }
                });
            }
            raw_command
                    .withAliases(command.getAliases().toArray(String[]::new))
                    .withPermission(command.getPermission())
                    .executes(command::executeTasks)
                    .register();
            Variables.PLUGIN.getLogger().info(command.getCommandName() + " registered.");
        });
    }
}
