package ru.zoga_com.miniessentials.commands;

import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.zoga_com.miniessentials.common.generics.Command;
import ru.zoga_com.miniessentials.config.Language;

import java.util.ArrayList;
import java.util.List;

public class CommandPing implements Command {
    @Override
    public void executeTasks(@NotNull CommandSender commandSender, CommandArguments args) {
        try {
            commandSender.sendMessage(Language.getMessage("messages.ping").replace("{ping}", String.valueOf(((Player) commandSender).getPing())));
        } catch (Exception e) {
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }
    }

    @Override
    public String getCommandName() {
        return "ping";
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>(){{
            add("пинг");
            add("задержка");
        }};
    }

    @Override
    public String getPermission() {
        return "miniessentials.ping";
    }
}
