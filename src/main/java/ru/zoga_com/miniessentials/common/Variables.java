package ru.zoga_com.miniessentials.common;

import org.bukkit.GameMode;
import org.bukkit.plugin.Plugin;
import java.util.HashMap;
import java.util.Map;

public class Variables {
    public static final int CURRENT_VERSION = 3;
    public static Plugin PLUGIN;
    public final static Map<String, GameMode> modes = new HashMap<>() {{
        put("0", GameMode.SURVIVAL);
        put("survival", GameMode.SURVIVAL);
        put("1", GameMode.CREATIVE);
        put("creative", GameMode.CREATIVE);
        put("2", GameMode.ADVENTURE);
        put("adventure", GameMode.ADVENTURE);
        put("3", GameMode.SPECTATOR);
        put("spectator", GameMode.SPECTATOR);
    }};
    public final static Map<GameMode, String> modeKeys = new HashMap<>() {{
        put(GameMode.SURVIVAL, "messages.gamemode.survival");
        put(GameMode.CREATIVE, "messages.gamemode.creative");
        put(GameMode.ADVENTURE, "messages.gamemode.adventure");
        put(GameMode.SPECTATOR, "messages.gamemode.spectator");
    }};
}
