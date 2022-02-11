package ru.zoga_com.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.zoga_com.essentials.Main;
import ru.zoga_com.essentials.managers.LanguageManager;
import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.Bukkit;

public class CommandPing implements CommandExecutor {
    String pluginLang = Main.getLang();
    static LanguageManager languageManager = new LanguageManager();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("ping")) {
              p.sendMessage(languageManager.getLangMessage(pluginLang, "ping.before") + ((CraftPlayer) p).getHandle().ping + languageManager.getLangMessage(pluginLang, "ping.after"));
        }
    return true;
    }
}
