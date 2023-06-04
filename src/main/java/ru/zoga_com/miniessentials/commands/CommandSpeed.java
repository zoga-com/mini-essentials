package ru.zoga_com.miniessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.zoga_com.miniessentials.common.Variables;
import ru.zoga_com.miniessentials.config.Language;

public class CommandSpeed implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, String[] strings) {
        try {
            if (strings.length == 1) {
                if (Integer.parseInt(strings[0]) <= 10 && Integer.parseInt(strings[0]) >= 0) {
                    if (((Player) commandSender).isFlying()) {
                        ((Player) commandSender).setFlySpeed(Variables.speeds.get(strings[0]));
                        commandSender.sendMessage(Language.getMessage("messages.speed.fly") + strings[0]);
                    } else {
                        ((Player) commandSender).setWalkSpeed(Variables.speeds.get(strings[0]));
                        commandSender.sendMessage(Language.getMessage("messages.speed.walk") + strings[0]);
                    }
                } else {
                    commandSender.sendMessage(Language.getMessage("messages.errors.speed.too_big"));
                }
            } else {
                commandSender.sendMessage(Language.getMessage("messages.errors.speed.args"));
            }
        } catch(Exception e) {
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }
        return true;
    }
}
