package ru.zoga_com.essentials;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.zoga_com.essentials.commands.CommandFly;
import ru.zoga_com.essentials.commands.CommandGamemode;
import ru.zoga_com.essentials.commands.CommandPing;
import ru.zoga_com.essentials.commands.CommandInventory;
import ru.zoga_com.essentials.commands.CommandBroadCast;
import ru.zoga_com.essentials.Config;
import ru.zoga_com.essentials.Inventory;
import ru.zoga_com.essentials.commands.nms.*;


public class Main extends JavaPlugin {


    public void onEnable() {
        this.getLogger().info("Enabled.");
        Config.checkLangs();
        getServer().getPluginManager().registerEvents(new Filter(), this); //chat-filter
        getServer().getPluginManager().registerEvents(new Inventory(), this); //anti-dupe /inv
        this.getCommand("fly").setExecutor(new CommandFly()); ///fly
        this.getCommand("bc").setExecutor(new CommandBroadCast()); ///bc
        this.getCommand("gm").setExecutor(new CommandGamemode()); ///gm
        this.getCommand("inv").setExecutor(new CommandInventory()); ///inv
        this.saveDefaultConfig();
         
        // get NMS
        switch(getMcVer()) {
        case "1.12":
            this.getCommand("ping").setExecutor(new CommandPing());
            this.getLogger().info("Using 1.12 NMS api.");
            break;
        case "1.12.1":
            this.getCommand("ping").setExecutor(new CommandPing());
            this.getLogger().info("Using 1.12 NMS api.");
            break;
        case "1.12.2":
            this.getCommand("ping").setExecutor(new CommandPing());
            this.getLogger().info("Using 1.12 NMS api.");
            break;
        case "1.13":
            this.getCommand("ping").setExecutor(new CommandPing_1_13_R1());
            this.getLogger().info("Using 1.13 NMS api.");
            break;
        case "1.13.1":
            this.getCommand("ping").setExecutor(new CommandPing_1_13());
            this.getLogger().info("Using 1.13 NMS api.");
            break;
        case "1.13.2":
            this.getCommand("ping").setExecutor(new CommandPing_1_13());
            this.getLogger().info("Using 1.13 NMS api.");
            break;
        case "1.14":
            this.getCommand("ping").setExecutor(new CommandPing_1_14());
            this.getLogger().info("Using 1.14 NMS api.");
            break;
        case "1.14.1":
            this.getCommand("ping").setExecutor(new CommandPing_1_14());
            this.getLogger().info("Using 1.14 NMS api.");
            break;
        case "1.14.2":
            this.getCommand("ping").setExecutor(new CommandPing_1_14());
            this.getLogger().info("Using 1.14 NMS api.");
            break;
        case "1.14.3":
            this.getCommand("ping").setExecutor(new CommandPing_1_14());
            this.getLogger().info("Using 1.14 NMS api.");
            break;
        case "1.14.4":
            this.getCommand("ping").setExecutor(new CommandPing_1_14());
            this.getLogger().info("Using 1.14 NMS api.");
            break;
        case "1.15":
            this.getCommand("ping").setExecutor(new CommandPing_1_15());
            this.getLogger().info("Using 1.15 NMS api.");
            break;
        case "1.15.1":
            this.getCommand("ping").setExecutor(new CommandPing_1_15());
            this.getLogger().info("Using 1.15 NMS api.");
            break;
        case "1.15.2":
            this.getCommand("ping").setExecutor(new CommandPing_1_15());
            this.getLogger().info("Using 1.15 NMS api.");
            break;
        case "1.16.1":
            this.getCommand("ping").setExecutor(new CommandPing_1_16_R1());
            this.getLogger().info("Using 1.16 NMS api.");
            break;
        case "1.16.2":
            this.getCommand("ping").setExecutor(new CommandPing_1_16_R2());
            this.getLogger().info("Using 1.16 NMS api.");
            break;
        case "1.16.3":
            this.getCommand("ping").setExecutor(new CommandPing_1_16_R2());
            this.getLogger().info("Using 1.16 NMS api.");
            break;
        case "1.16.4":
            this.getCommand("ping").setExecutor(new CommandPing_1_16());
            this.getLogger().info("Using 1.16 NMS api.");
            break;
        case "1.16.5":
            this.getCommand("ping").setExecutor(new CommandPing_1_16());
            this.getLogger().info("Using 1.16 NMS api.");
            break;
        case "1.17":
            this.getCommand("ping").setExecutor(new CommandPing_1_17());
            this.getLogger().info("Using 1.17 NMS api.");
            break;
        case "1.17.1":
            this.getCommand("ping").setExecutor(new CommandPing_1_17());
            this.getLogger().info("Using 1.17 NMS api.");
            break;
        }
    }
    public void onDisable() {
        this.getLogger().info("Disabled.");
    }

    //get NMS method
    public static String getMcVer() {
        Matcher matcher = Pattern.compile("(\\(MC: )([\\d\\.]+)(\\))").matcher(Bukkit.getVersion());
        if (matcher.find()) {
          return matcher.group(2);
        }
        return null;
      }
}