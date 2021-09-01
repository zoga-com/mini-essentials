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

        File cfgdata = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator + "lang");
        File cfg = new File(cfgdata, File.separator + "ru.yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(cfg);

        if(cmd.getName().equalsIgnoreCase("fly")) {
           if(p.isFlying()) {
               p.setAllowFlight(false);
               p.sendMessage(data.getString("messages.fly_off"));
               return true;
           } else {
               p.setAllowFlight(true);
               p.sendMessage(data.getString("messages.fly_on"));
               return true;
           }
    }
        return true;
    }
}