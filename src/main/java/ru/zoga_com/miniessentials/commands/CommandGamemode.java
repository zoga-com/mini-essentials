package ru.zoga_com.miniessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.zoga_com.miniessentials.common.Variables;
import ru.zoga_com.miniessentials.config.Language;

public class CommandGamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("gamemode")) {
            Player player = (Player) commandSender;
            if(strings.length == 1) {
                if(Variables.modes.equals(strings[0])) {
                    player.setGameMode(Variables.modes.get(strings[0]));
                    player.sendMessage(Variables.modeKeys.get(Variables.modes.get(strings[0])));
                } else { player.sendMessage(Language.getMessage("messages.errors.gamemode.args")); }
            } else { player.sendMessage(Language.getMessage("messages.errors.gamemode.args")); }
        }
        return true;
    }
}
