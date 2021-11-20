package ru.zoga_com.essentials;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.*;
import org.bukkit.Bukkit;
import java.util.*;

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
                if(config.getString("lang").equalsIgnoreCase("ru")) { 
                    p.sendMessage(langRu.getString("badword"));
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        if(players.hasPermission("miniess.seefilter")) {
                            TextComponent msg = new TextComponent(langRu.getString("filter.kick-text-before") + " " + p.getName() + " " + langRu.getString("filter.kick-text-after"));
                            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(langRu.getString("filter.kick-message")).create()));
                            msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kick " + p.getName() + " " + langRu.getString("filter.kick-reason")));
                            p.spigot().sendMessage(msg);
                        }
                    }
                }
                if(config.getString("lang").equalsIgnoreCase("en")) { 
                    p.sendMessage(langEn.getString("badword")); 
                    for(Player players : Bukkit.getOnlinePlayers()) {
                        if(players.hasPermission("miniess.seefilter")) {
                            TextComponent msg = new TextComponent(langEn.getString("filter.kick-text-before") + " " + p.getName() + " " + langEn.getString("filter.kick-text-after"));
                            msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(langEn.getString("filter.kick-message")).create()));
                            msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/kick " + p.getName() + " " + langEn.getString("filter.kick-reason")));
                            p.spigot().sendMessage(msg);
                        }
                    }
                }
            }
        }
    }
}
