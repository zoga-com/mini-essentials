package ru.zoga_com.essentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.io.*;
import org.bukkit.configuration.file.*;
import org.bukkit.Bukkit;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import java.util.*;
import org.bukkit.Material;

public class CommandInventory implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length > 0) {
        Player p = (Player) sender;
        String playerName = p.getName();

        File configDir = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator);
        File configFile = new File(configDir, File.separator + "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        File langs = new File(Bukkit.getServer().getPluginManager().getPlugin("MiniEssentials").getDataFolder(), File.separator + "lang");
        File langRuFile = new File(langs, File.separator + "ru.yml");
        FileConfiguration langRu = YamlConfiguration.loadConfiguration(langRuFile);
        File langEnFile = new File(langs, File.separator + "en.yml");
        FileConfiguration langEn = YamlConfiguration.loadConfiguration(langEnFile);

        if(cmd.getName().equalsIgnoreCase("inventory")) {
                if(args.length > 1) {
                    Player p2 = Bukkit.getPlayer(args[0]);

                    Inventory p2Inv = p2.getInventory();

                    ItemStack[] p2Items = p2Inv.getStorageContents();

                    Inventory gui = Bukkit.createInventory(null, 54, "Инвентарь игрока " + args[0] + " #inventory_see");
   
                    for(int i = 0; i < p2Items.length; i++) {
                    ItemStack item = new ItemStack(p2Items[i].getType());
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(p2Items[i].getItemMeta().getDisplayName());
                    ArrayList<String> itemLore = new ArrayList<String>();
                    itemLore.addAll(p2Items[i].getItemMeta().getLore());
                    itemMeta.setLore(itemLore);
                    item.setItemMeta(itemMeta);
                    gui.setItem(i, item);
                    }
        
                    ItemStack helmet = p2.getInventory().getHelmet();
                    ItemStack chest = p2.getInventory().getChestplate();
                    ItemStack legs = p2.getInventory().getLeggings();
                    ItemStack boots = p2.getInventory().getBoots();

                    gui.setItem(50, helmet);
                    gui.setItem(51, chest);
                    gui.setItem(52, legs);
                    gui.setItem(53, boots);
        
                    p.openInventory(gui);

                    return true;
                }
         }
        } else { sender.sendMessage("/inv <nick>"); }
        return true;
}
}
