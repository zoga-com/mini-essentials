package ru.zoga_com.miniessentials.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.zoga_com.miniessentials.common.Variables;
import java.io.File;

public class Language {
    private static FileConfiguration language = YamlConfiguration.loadConfiguration(new File(Variables.PLUGIN.getDataFolder() + "/lang.yml"));
    public static String getMessage(String key) {
        return language.getString(key);
    }
}
