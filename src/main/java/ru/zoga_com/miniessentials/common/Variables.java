package ru.zoga_com.miniessentials.common;

import org.bukkit.GameMode;
import org.bukkit.plugin.Plugin;
import java.util.HashMap;
import java.util.Map;

public class Variables {
    public static Plugin PLUGIN;
    public static Map<String, GameMode> modes = new HashMap<String, GameMode>() {{
        put("0", GameMode.SURVIVAL);
        put("survival", GameMode.SURVIVAL);
        put("1", GameMode.CREATIVE);
        put("creative", GameMode.CREATIVE);
        put("2", GameMode.ADVENTURE);
        put("adventure", GameMode.ADVENTURE);
        put("3", GameMode.SPECTATOR);
        put("spectator", GameMode.SPECTATOR);
    }};
    public static Map<GameMode, String> modeKeys = new HashMap<GameMode, String>() {{
        put(GameMode.SURVIVAL, "messages.gamemode.survival");
        put(GameMode.CREATIVE, "messages.gamemode.creative");
        put(GameMode.ADVENTURE, "messages.gamemode.adventure");
        put(GameMode.SPECTATOR, "messages.gamemode.spectator");
    }};
    public static Map<String, Float> speeds = new HashMap<String, Float>() {{
        put("1", 0.1f);
        put("2", 0.2f);
        put("3", 0.3f);
        put("4", 0.4f);
        put("5", 0.5f);
        put("6", 0.6f);
        put("7", 0.7f);
        put("8", 0.8f);
        put("9", 0.9f);
        put("10", 1f);
    }};
}
