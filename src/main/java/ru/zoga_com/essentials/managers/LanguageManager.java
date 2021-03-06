package ru.zoga_com.essentials.managers;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class LanguageManager {
    File langs = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator + "lang.yml");
    FileConfiguration lang = YamlConfiguration.loadConfiguration(langs);

    public String getLangMessage(String language, String path) {
        switch(language) {
            case "ru":
              return lang.getString(path);
            case "en":
              return lang.getString(path);
            default:
              return "Message '" + path + "' not found."; 
        }
    }
}
