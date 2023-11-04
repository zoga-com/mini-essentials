package ru.zoga_com.miniessentials.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.zoga_com.miniessentials.common.Variables;
import java.io.File;

public class Language {
    private final static FileConfiguration language = YamlConfiguration.loadConfiguration(new File(Variables.PLUGIN.getDataFolder() + "/lang.yml"));

    public static String getMessage(String key) {
        return language.getString(key);
    }

    public static int getVersion() {
        return language.getInt("version");
    }

    public static void checkVersion() {
        if(getVersion() != Variables.CURRENT_VERSION) {
            for(int _a = 0; _a < 3; _a++) {
                Variables.PLUGIN.getLogger().info("[mini-essentials] !!! ВЕРСИЯ ВАШЕЙ ЛОКАЛИЗАЦИИ УСТАРЕЛА! ПОЖАЛУЙСТА УДАЛИТЕ ФАЙЛ ЛОКАЛИЗАЦИИ ДЛЯ ЕГО ПЕРЕСОЗДАНИЯ !!!");
            }
        }
    }
}
