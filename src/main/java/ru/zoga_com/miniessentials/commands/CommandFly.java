package ru.zoga_com.miniessentials.commands;

import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.zoga_com.miniessentials.common.generics.Command;
import ru.zoga_com.miniessentials.config.Language;

import java.util.ArrayList;
import java.util.List;

public class CommandFly implements Command {
    @Override
    public void executeTasks(@NotNull CommandSender commandSender, CommandArguments args) {
        try {
            ((Player) commandSender).setAllowFlight(!(((Player) commandSender).getAllowFlight()));
            commandSender.sendMessage(
                    ((Player) commandSender).getAllowFlight() ? Language.getMessage("messages.fly.enabled") : Language.getMessage("messages.fly.disabled")
            );
        } catch (Exception e) {
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }
    }

    @Override
    public String getCommandName() {
        return "fly";
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>(){{
            add("полет");
            add("флай");
        }};
    }

    @Override
    public String getPermission() {
        return "miniessentials.fly";
    }
}
