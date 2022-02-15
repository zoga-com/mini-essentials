package ru.zoga_com.essentials;

import org.bukkit.plugin.java.JavaPlugin;
import ru.zoga_com.essentials.commands.CommandFly;
import ru.zoga_com.essentials.commands.CommandGamemode;
import ru.zoga_com.essentials.commands.CommandPing;
import ru.zoga_com.essentials.commands.CommandSpeed;
import ru.zoga_com.essentials.managers.ConfigManager;

public class Main extends JavaPlugin {

    public void onEnable() {
        this.getLogger().info("Enabled.");
        getServer().getPluginManager().registerEvents(new Filter(), this);
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("gm").setExecutor(new CommandGamemode());
        this.getCommand("ping").setExecutor(new CommandPing());
        this.getCommand("speed").setExecutor(new CommandSpeed());
        this.saveResource("lang.yml", true);
        this.saveDefaultConfig();
    }
    public void onDisable() {
        this.getLogger().info("Disabled.");
    }
    public static String getLang() {
        return ConfigManager.getConfigString("lang");
    }
}