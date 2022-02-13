package ru.zoga_com.essentials;

import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.*;
import org.bukkit.Bukkit;
import java.util.*;
import net.minecraft.server.v1_12_R1.*;
import ru.zoga_com.essentials.managers.ConfigManager;
import ru.zoga_com.essentials.managers.LanguageManager;

public class Filter implements Listener {
    private static String pluginLang = Main.getLang();
    LanguageManager languageManager = new LanguageManager();
    ConfigManager configManager = new ConfigManager();
    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String rawMessage = e.getMessage();
        List<String> words = configManager.getConfig().getStringList("chat-filter");

        for(String badWords : words) {
            if(rawMessage.contains(badWords)) {
                e.setMessage("");
                p.sendMessage(languageManager.getLangMessage(pluginLang, "badword"));
            }
        }
    }
}
