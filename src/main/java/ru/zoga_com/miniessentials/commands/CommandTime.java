package ru.zoga_com.miniessentials.commands;

import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.zoga_com.miniessentials.common.generics.Command;
import ru.zoga_com.miniessentials.config.Language;

import java.util.*;

public class CommandTime implements Command {
    @Override
    public void executeTasks(@NotNull CommandSender commandSender, CommandArguments args) {
        try {
            final String timeArgument = (String) args.get("time");

            if (timeArgument.equalsIgnoreCase("day") || timeArgument.equalsIgnoreCase("night")) {
                switch (timeArgument) {
                    case "day" ->
                            Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setTime(0);
                    case "night" ->
                            Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setTime(40000);
                }
                commandSender.sendMessage(Language.getMessage("messages.time.changed")
                        .replace("{world}", Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).getName())
                        .replace("{time}", timeArgument.equalsIgnoreCase("day") ? "0" : "40000")
                );
            } else {
                if (Integer.parseInt(timeArgument) > 40000 || Integer.parseInt(timeArgument) < 0) {
                    commandSender.sendMessage(Language.getMessage("messages.errors.time.invalid"));
                    return;
                }

                Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setTime(Integer.parseInt(timeArgument));
                commandSender.sendMessage(Language.getMessage("messages.time.changed")
                        .replace("{world}", ((Player) commandSender).getLocation().getWorld().getName())
                        .replace("{time}", timeArgument)
                );
            }
        } catch (Exception e) {
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }
    }

    @Override
    public String getCommandName() {
        return "time";
    }

    @Override
    public HashMap<String, String> getArgumentMap() {
        return new HashMap<>(){{
            put("time", "StringOrInt");
        }};
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>(){{
            add("время");
            add("timeset");
            add("settime");
        }};
    }

    @Override
    public String getPermission() {
        return "miniessentials.time";
    }
}
