package ru.zoga_com.miniessentials;

import org.bukkit.plugin.java.JavaPlugin;
import ru.zoga_com.miniessentials.commands.CommandFly;
import ru.zoga_com.miniessentials.commands.CommandGamemode;
import ru.zoga_com.miniessentials.commands.CommandPing;
import ru.zoga_com.miniessentials.commands.CommandSpeed;
import ru.zoga_com.miniessentials.common.Variables;
import java.util.logging.Level;

public class Main extends JavaPlugin {
    public void onEnable() {
        this.getLogger().log(Level.INFO, "Плагин включен. Версия: " + this.getDescription().getVersion());
        Variables.PLUGIN = this;
        this.saveResource("lang.yml", false);
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("gamemode").setExecutor(new CommandGamemode());
        this.getCommand("ping").setExecutor(new CommandPing());
        this.getCommand("speed").setExecutor(new CommandSpeed());
    }

    public void onDisable() {
        this.getLogger().log(Level.INFO, "Плагин выключен.");
    }
}
