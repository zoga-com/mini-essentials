package ru.zoga_com.miniessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.zoga_com.miniessentials.config.Language;

import java.util.Objects;

public class CommandTime implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, String[] strings) {
        try {
            if (strings.length != 1) {
                commandSender.sendMessage(Language.getMessage("messages.errors.time.args"));
                return true;
            }
            if (strings[0].equalsIgnoreCase("day") || strings[0].equalsIgnoreCase("night")) {
                switch (strings[0]) {
                    case "day" -> Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setTime(0);
                    case "night" -> Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setTime(40000);
                }
                commandSender.sendMessage(Language.getMessage("messages.time.changed")
                        .replace("{world}", Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).getName())
                        .replace("{time}", strings[0].equalsIgnoreCase("day") ? "0" : "40000")
                );
            } else {
                if (Integer.parseInt(strings[0]) > 40000 || Integer.parseInt(strings[0]) < 0) {
                    commandSender.sendMessage(Language.getMessage("messages.errors.time.invalid"));
                    return true;
                }
                Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setTime(Integer.parseInt(strings[0]));
                commandSender.sendMessage(Language.getMessage("messages.time.changed")
                        .replace("{world}", ((Player) commandSender).getLocation().getWorld().getName())
                        .replace("{time}", strings[0])
                );
            }
        } catch(Exception e) {
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }
        return true;
    }
}
