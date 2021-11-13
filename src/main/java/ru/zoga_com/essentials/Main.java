package ru.zoga_com.essentials;

import org.bukkit.plugin.java.JavaPlugin;
import ru.zoga_com.essentials.commands.CommandFly;
import ru.zoga_com.essentials.commands.CommandGamemode;
import ru.zoga_com.essentials.Config;


public class Main extends JavaPlugin {


    public void onEnable() {
        this.getLogger().info("Enabled.");
        Config.checkLangs();
        //getServer().getPluginManager().registerEvents(new Handlers(), this);
        this.getCommand("fly").setExecutor(new CommandFly());
        this.getCommand("gm").setExecutor(new CommandGamemode());
        this.saveDefaultConfig();
    }
    public void onDisable() {
        this.getLogger().info("Disabled.");
    }
}