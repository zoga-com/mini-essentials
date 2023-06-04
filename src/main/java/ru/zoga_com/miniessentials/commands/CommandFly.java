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
            ((Player) commandSender).setFlying(((Player) commandSender).isFlying());
            commandSender.sendMessage((((Player) commandSender).isFlying()) ? Language.getMessage("messages.fly.off") : Language.getMessage("messages.fly.on"));
        } catch(Exception e) {
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }
        return true;
    }
}
