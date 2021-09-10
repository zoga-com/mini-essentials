package ru.zoga_com.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;

public class CommandGamemode implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        String playerName = p.getName();

        File cfgdata = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator + "lang");
        File cfg = new File(cfgdata, File.separator + "ru.yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(cfg);

        if(cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode") || cmd.getName().equalsIgnoreCase("гм")) {
           if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")) {
               p.setGameMode(GameMode.CREATIVE);
               p.sendMessage(data.getString("messages.gamemode.creative"));
               return true;
           }
           if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")) {
            p.setGameMode(GameMode.SURVIVAL);
            p.sendMessage(data.getString("messages.gamemode.survival"));
            return true;
           }
           if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a")) {
            p.setGameMode(GameMode.ADVENTURE);
            p.sendMessage(data.getString("messages.gamemode.adventure"));
            return true;
           }
           if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("spec") || args[0].equalsIgnoreCase("sp")) {
            p.setGameMode(GameMode.SPECTATOR);
            p.sendMessage(data.getString("messages.gamemode.spectator"));
            return true;
           }
    }
        return true;
    }
}