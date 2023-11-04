package ru.zoga_com.miniessentials.commands;

import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.zoga_com.miniessentials.common.Variables;
import ru.zoga_com.miniessentials.common.generics.Command;
import ru.zoga_com.miniessentials.config.Language;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CommandGamemode implements Command {
    @Override
    public void executeTasks(@NotNull CommandSender commandSender, CommandArguments args) {
        try {
            final String modeArgument = (String) args.get("mode");

            ((Player) commandSender).setGameMode(Variables.modes.get(modeArgument));
            commandSender.sendMessage(Language.getMessage(Variables.modeKeys.get(Variables.modes.get(modeArgument))));
        } catch (Exception e) {
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }
    }

    @Override
    public String getCommandName() {
        return "gamemode";
    }

    @Override
    public HashMap<String, String> getArgumentMap() {
        return new HashMap<>(){{
            put("mode", "String");
        }};
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>(){{
            add("gm");
            add("гм");
        }};
    }

    @Override
    public String getPermission() {
        return "miniessentials.gamemode";
    }

    @Override
    public List<String> getSuggestions() {
        return new ArrayList<>(){{
            Collections.addAll(this,"0", "survival", "1", "creative", "2", "adventure", "3", "spectator");
        }};
    }
}
