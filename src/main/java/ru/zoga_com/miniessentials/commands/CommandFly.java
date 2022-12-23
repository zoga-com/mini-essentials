package ru.zoga_com.miniessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.zoga_com.miniessentials.config.Language;

public class CommandFly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("fly")) {
            Player player = (Player) commandSender;
            player.setFlying(player.isFlying());
            player.sendMessage((player.isFlying()) ? Language.getMessage("messages.fly.off") : Language.getMessage("messages.fly.on"));
        }
        return true;
    }
}
