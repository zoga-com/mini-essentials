package ru.zoga_com.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.Bukkit;

public class CommandFly implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
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

        if(cmd.getName().equalsIgnoreCase("fly")) {
          if(config.getString("lang").equalsIgnoreCase("en")) {
           if(p.isFlying()) {
               p.setAllowFlight(false);
               p.sendMessage(langRu.getString("messages.fly_off"));
               return true;
           } else {
               p.setAllowFlight(true);
               p.sendMessage(langRu.getString("messages.fly_on"));
               return true;
           }
          }
        if(config.getString("lang").equalsIgnoreCase("ru")) {
          if(p.isFlying()) {
              p.setAllowFlight(false);
              p.sendMessage(langEn.getString("messages.fly_off"));
              return true;
           } else {
               p.setAllowFlight(true);
               p.sendMessage(langEn.getString("messages.fly_on"));
               return true;
           }
          }
    }
        return true;
    }
}