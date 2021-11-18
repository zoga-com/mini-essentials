package ru.zoga_com.essentials;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.Bukkit;

public class Inventory implements Listener {
    @EventHandler
    public void onChat(InventoryClickEvent e) {
        if(e.getInventory().getName().equals("#inventory-see")) {
        e.setCancelled(true);
        }
    }
}
