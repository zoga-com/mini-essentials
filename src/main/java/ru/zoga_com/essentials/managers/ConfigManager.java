package ru.zoga_com.essentials.managers;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
    private static File configFile = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator + "config.yml");
    private static FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

    public static String getConfigString(String path) {
        return config.getString(path);
    }
    public FileConfiguration getConfig() {
        return config;
    }
}
