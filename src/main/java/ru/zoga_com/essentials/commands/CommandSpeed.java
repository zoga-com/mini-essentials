package ru.zoga_com.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.zoga_com.essentials.Main;
import ru.zoga_com.essentials.managers.LanguageManager;
import java.io.*;
import java.util.HashMap;

public class CommandSpeed implements CommandExecutor {
    private String pluginLang = Main.getLang();
    private static LanguageManager languageManager = new LanguageManager();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("speed")) {
              if(args.length == 1) {
                  if(Integer.parseInt(args[0]) <= 10) {
                      switch(getBool(p.isFlying())) {
                          case 1:
                             p.setFlySpeed(getHashMap().get(args[0]));
                             p.sendMessage(languageManager.getLangMessage(pluginLang, "messages.speed.fly") + Integer.parseInt(args[0]));
                             break;
                          case 0:
                             p.setWalkSpeed(getHashMap().get(args[0]));
                             p.sendMessage(languageManager.getLangMessage(pluginLang, "messages.speed.walk") + Integer.parseInt(args[0]));
                             break;
                      }
                  } else { p.sendMessage(languageManager.getLangMessage(pluginLang, "messages.speed.over-speed")); }
              }
        }
    return true;
    }

    public int getBool(boolean bool) {
        if(bool) {
            return 1;
        } else { return 0; }
    }

    public HashMap<String, Float> getHashMap() {
        HashMap<String, Float> hash = new HashMap<>();
        hash.put("1", 0.1f);
        hash.put("2", 0.2f);
        hash.put("3", 0.3f);
        hash.put("4", 0.4f);
        hash.put("5", 0.5f);
        hash.put("6", 0.6f);
        hash.put("7", 0.7f);
        hash.put("8", 0.8f);
        hash.put("9", 0.9f);
        hash.put("10", 1f);
        return hash;
    }
}
