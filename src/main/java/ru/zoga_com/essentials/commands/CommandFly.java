package ru.zoga_com.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.zoga_com.essentials.Main;
import ru.zoga_com.essentials.managers.LanguageManager;
import java.io.*;

public class CommandFly implements CommandExecutor {
    String pluginLang = Main.getLang();
    static LanguageManager languageManager = new LanguageManager();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("fly")) {
           if(p.isFlying()) {
               p.setAllowFlight(false);
               p.sendMessage(languageManager.getLangMessage(pluginLang, "messages.fly_off"));
               return true;
           } else {
               p.setAllowFlight(true);
               p.sendMessage(languageManager.getLangMessage(pluginLang, "messages.fly_on"));
               return true;
           }
        }
        return true;
    }
}