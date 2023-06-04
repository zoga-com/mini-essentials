package ru.zoga_com.miniessentials;

import org.bukkit.plugin.java.JavaPlugin;
import ru.zoga_com.miniessentials.commands.*;
import ru.zoga_com.miniessentials.common.Variables;
import ru.zoga_com.miniessentials.config.Language;

import java.util.Objects;
import java.util.logging.Level;

public class Main extends JavaPlugin {
    public void onEnable() {
        try {
            this.getLogger().log(Level.INFO, "Плагин включен. Версия: " + this.getDescription().getVersion());
            Variables.PLUGIN = this;
            this.saveResource("lang.yml", false);
            Objects.requireNonNull(this.getCommand("fly")).setExecutor(new CommandFly());
            Objects.requireNonNull(this.getCommand("gamemode")).setExecutor(new CommandGamemode());
            Objects.requireNonNull(this.getCommand("ping")).setExecutor(new CommandPing());
            Objects.requireNonNull(this.getCommand("speed")).setExecutor(new CommandSpeed());
            Objects.requireNonNull(this.getCommand("time")).setExecutor(new CommandTime());
            Objects.requireNonNull(this.getCommand("weather")).setExecutor(new CommandWeather());
            Language.checkVersion();
        } catch(Exception e) {
            getLogger().warning("Произошла ошибка при запуске плагина.");
        }
    }

    public void onDisable() {
        this.getLogger().log(Level.INFO, "Плагин выключен.");
    }
}
