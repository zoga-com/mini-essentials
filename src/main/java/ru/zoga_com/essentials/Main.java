package ru.zoga_com.essentials;

import org.bukkit.plugin.java.JavaPlugin;
import ru.zoga_com.essentials.commands.CommandFly;
import ru.zoga_com.essentials.commands.CommandGamemode;
import ru.zoga_com.essentials.commands.CommandPing;
import ru.zoga_com.essentials.managers.ConfigManager;

public class Main extends JavaPlugin {
    static ConfigManager configManager = new ConfigManager();
    static String language = configManager.getConfigString("lang");

    public void onEnable() {
        this.getLogger().info("Enabled.");
        getServer().getPluginManager().registerEvents(new Filter(), this);
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("gm").setExecutor(new CommandGamemode());
        this.getCommand("gm").setExecutor(new CommandPing());
        this.saveDefaultConfig();
        this.saveResource("lang.yml", false);
    }
    public void onDisable() {
        this.getLogger().info("Disabled.");
    }
    public static String getLang() {
        return language;
    }
}