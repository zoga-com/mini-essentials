package ru.zoga_com.miniessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.zoga_com.miniessentials.common.Variables;
import ru.zoga_com.miniessentials.config.Language;

public class CommandGamemode implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, String[] strings) {
        try {
            if (strings.length != 1) {
                commandSender.sendMessage(Language.getMessage("messages.errors.gamemode.args"));
                return true;
            }
            if (!Variables.modes.containsKey(strings[0])) {
                commandSender.sendMessage(Language.getMessage("messages.errors.gamemode.args"));
                return true;
            }

            ((Player) commandSender).setGameMode(Variables.modes.get(strings[0]));
            commandSender.sendMessage(Language.getMessage(Variables.modeKeys.get(Variables.modes.get(strings[0]))));
        } catch (Exception e) {
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }

        return true;
    }
}
