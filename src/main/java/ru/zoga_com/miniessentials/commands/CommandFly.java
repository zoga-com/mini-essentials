package ru.zoga_com.miniessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.zoga_com.miniessentials.config.Language;

@SuppressWarnings("ALL")
public class CommandFly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        try {
            ((Player) commandSender).setAllowFlight(!(((Player) commandSender).getAllowFlight()));
            commandSender.sendMessage(((Player) commandSender).getAllowFlight() ? Language.getMessage("messages.fly.enabled") : Language.getMessage("messages.fly.disabled"));
        } catch(Exception e) {
            e.printStackTrace();
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }
        return true;
    }
}
