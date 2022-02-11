package ru.zoga_com.essentials.managers;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
    File configDir = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator);
    File configFile = new File(configDir, File.separator + "config.yml");
    FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

    public String getConfigString(String path) {
        return config.getString(path);
    }
    public FileConfiguration getConfig() {
        return config;
    }
}
