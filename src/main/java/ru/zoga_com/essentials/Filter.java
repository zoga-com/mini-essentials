package ru.zoga_com.essentials;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.Sound;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.*;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.*;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;

public class Filter implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        File configDir = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator);
        File configFile = new File(configDir, File.separator + "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        File langs = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator + "lang");
        File langRuFile = new File(langs, File.separator + "ru.yml");
        FileConfiguration langRu = YamlConfiguration.loadConfiguration(langRuFile);
        File langEnFile = new File(langs, File.separator + "en.yml");
        FileConfiguration langEn = YamlConfiguration.loadConfiguration(langEnFile);

        String rawMessage = e.getMessage();

        List<String> words = config.getStringList("chat-filter");

        for(String badWords : words) {
            if(rawMessage.contains(badWords)) {
                e.setMessage("");
                if(config.getString("lang").equalsIgnoreCase("ru")) { p.sendMessage(langRu.getString("badword")); }
                if(config.getString("lang").equalsIgnoreCase("en")) { p.sendMessage(langEn.getString("badword")); }
            }
        }
    }
}
