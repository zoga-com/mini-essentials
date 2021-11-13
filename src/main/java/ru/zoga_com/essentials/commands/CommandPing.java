package ru.zoga_com.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import net.minecraft.server.v1_12_R1.*;

public class CommandPing implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        File configDir = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator);
        File configFile = new File(configDir, File.separator + "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        File langs = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator + "lang");
        File langRuFile = new File(langs, File.separator + "ru.yml");
        FileConfiguration langRu = YamlConfiguration.loadConfiguration(langRuFile);
        File langEnFile = new File(langs, File.separator + "en.yml");
        FileConfiguration langEn = YamlConfiguration.loadConfiguration(langEnFile);

        if(cmd.getName().equalsIgnoreCase("ping")) {
          if(config.getString("lang").equalsIgnoreCase("en")) {
              p.sendMessage(langEn.getString("ping.before") + ((CraftPlayer) p).getHandle().ping + langEn.getString("ping.after"));
          }
          if(config.getString("lang").equalsIgnoreCase("ru")) {
              p.sendMessage(langRu.getString("ping.before") + ((CraftPlayer) p).getHandle().ping + langRu.getString("ping.after"));
          }
    }
    return true;
    }
}
