package ru.zoga_com.miniessentials;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPIBukkitConfig;
import org.bukkit.plugin.java.JavaPlugin;
import ru.zoga_com.miniessentials.common.CommandManager;
import ru.zoga_com.miniessentials.common.Variables;
import ru.zoga_com.miniessentials.config.Language;
import java.util.logging.Level;

public class Main extends JavaPlugin {
    public void onEnable() {
        try {
            this.getLogger().log(Level.INFO, "Плагин включен. Версия: " + this.getDescription().getVersion());
            Variables.PLUGIN = this;

            this.saveResource("lang.yml", false);

            CommandAPI.onLoad(new CommandAPIBukkitConfig(this).verboseOutput(true));
            CommandAPI.onEnable();

            CommandManager.registerCommands();

            Language.checkVersion();
        } catch(Exception e) {
            getLogger().warning("Произошла ошибка при запуске плагина.");
            e.printStackTrace();
        }
    }

    public void onDisable() {
        this.getLogger().log(Level.INFO, "Плагин выключен.");
    }
}
