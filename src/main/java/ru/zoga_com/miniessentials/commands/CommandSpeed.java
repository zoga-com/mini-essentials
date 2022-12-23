package ru.zoga_com.miniessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.zoga_com.miniessentials.common.Variables;
import ru.zoga_com.miniessentials.config.Language;

public class CommandSpeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("speed")) {
            Player player = (Player) commandSender;
            if(strings.length == 1) {
                if(Integer.parseInt(strings[0]) <= 10) {
                    if(player.isFlying()) {
                        player.setFlySpeed(Variables.speeds.get(strings[0]));
                        player.sendMessage(Language.getMessage("messages.speed.fly") + strings[0]);
                    } else {
                        player.setWalkSpeed(Variables.speeds.get(strings[0]));
                        player.sendMessage(Language.getMessage("messages.speed.walk") + strings[0]);
                    }
                } else { player.sendMessage(Language.getMessage("messages.errors.speed.too_big")); }
            } else { player.sendMessage(Language.getMessage("messages.errors.speed.args")); }
        }
        return true;
    }
}
