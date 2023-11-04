package ru.zoga_com.miniessentials.common.generics;

import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Command {
    void executeTasks(@NotNull CommandSender commandSender, CommandArguments args);
    String getCommandName();
    default HashMap<String, String> getArgumentMap() {
        return null;
    }
    String getPermission();
    default List<String> getSuggestions() {
        return new ArrayList<>();
    }
    List<String> getAliases();
}
