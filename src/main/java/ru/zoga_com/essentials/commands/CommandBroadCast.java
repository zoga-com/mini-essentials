package ru.zoga_com.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.Bukkit;

public class CommandBroadCast implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length > 0) {
        Player p = (Player) sender;
        String playerName = p.getName();

        File configDir = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator);
        File configFile = new File(configDir, File.separator + "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        File langs = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator + "lang");
        File langRuFile = new File(langs, File.separator + "ru.yml");
        FileConfiguration langRu = YamlConfiguration.loadConfiguration(langRuFile);
        File langEnFile = new File(langs, File.separator + "en.yml");
        FileConfiguration langEn = YamlConfiguration.loadConfiguration(langEnFile);

        if(cmd.getName().equalsIgnoreCase("bc")) {
          String message = "";
          for(int i = 1; i < args.length; i++) {
              message += " " + args[i];
          }
          if(config.getString("lang").equalsIgnoreCase("en")) {
            Bukkit.getServer().broadcastMessage(langEn.getString("broadcast") + message);
         }
          if(config.getString("lang").equalsIgnoreCase("ru")) {
            Bukkit.getServer().broadcastMessage(langRu.getString("broadcast") + message);
    }
  }
} else { sender.sendMessage("/bc <message>"); }
        return true;
    }
}