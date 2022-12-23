package ru.zoga_com.miniessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.zoga_com.miniessentials.config.Language;

public class CommandPing implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("ping")) {
            commandSender.sendMessage(Language.getMessage("messages.ping").replace("{ping}", "" + ((Player) commandSender).getPing()));
        }
        return true;
    }
}
