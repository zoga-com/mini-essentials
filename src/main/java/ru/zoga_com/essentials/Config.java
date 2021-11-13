package ru.zoga_com.essentials;

import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.Bukkit;

public class Config {
  /*  public static void checkConfig() {
        try {
        File pluginDir = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator);
        File cfgFile = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator + "lang");
        File cfg = new File(cfgFile, File.separator + "ru.yml");
        FileConfiguration data = YamlConfiguration.loadConfiguration(cfg);

        if(!cfgFile.exists()) {
            pluginDir.mkdir();
            cfgFile.createNewFile();
        }
    } catch(IOException e) { e.printStackTrace(); }
    } */

    public static void checkLangs() {
        try {
        File langFiles = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator + "lang");
        File langRu = new File(langFiles, File.separator + "ru.yml");
        FileConfiguration langDataRu = YamlConfiguration.loadConfiguration(langRu);
        File langEn = new File(langFiles, File.separator + "en.yml");
        FileConfiguration langDataEn = YamlConfiguration.loadConfiguration(langEn);

        /*if(!langFiles.exists()) {
            langFiles.mkdir();
        }*/
        if(!langRu.exists()) {
            langRu.getParentFile().mkdirs(); 
            langEn.getParentFile().mkdirs(); 
            langRu.createNewFile();
            langDataRu.createSection("messages");
            langDataRu.set("messages.fly_on", "§aВы включили режим полета.");
            langDataRu.set("messages.fly_off", "§aВы выключили режим полета.");
            langDataRu.createSection("gamemode");
            langDataRu.set("gamemode.creative", "§aРежим CREATIVE включен.");
            langDataRu.set("gamemode.survival", "§aРежим SURVIVAL включен.");
            langDataRu.set("gamemode.adventure", "§aРежим ADVENTURE включен.");
            langDataRu.set("gamemode.spectator", "§aРежим SPECTATOR включен.");
            langEn.createNewFile();
            langDataEn.createSection("messages");
            langDataEn.set("messages.fly_on", "§aYou enabled flight.");
            langDataEn.set("messages.fly_off", "§aYou disabled flight.");
            langDataEn.createSection("gamemode");
            langDataEn.set("gamemode.creative", "§aGamemode CREATIVE enabled.");
            langDataEn.set("gamemode.survival", "§aGamemode SURVIVAL enabled.");
            langDataEn.set("gamemode.adventure", "§aGamemode ADVENTURE enabled.");
            langDataEn.set("gamemode.spectator", "§aGamemode SPECTATOR enabled.");
            langDataEn.save(langRu);
            langDataEn.save(langEn);
        }
    } catch(IOException e) { e.printStackTrace(); }
    }
}
