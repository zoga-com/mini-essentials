package ru.zoga_com.miniessentials.commands;

import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.zoga_com.miniessentials.common.generics.Command;
import ru.zoga_com.miniessentials.config.Language;

import java.util.*;

public class CommandWeather implements Command {
    @Override
    public void executeTasks(@NotNull CommandSender commandSender, CommandArguments args) {
        try {
            final String weatherArgument = (String) args.get("weather");

            switch (Objects.requireNonNull(weatherArgument)) {
                case "clear" -> { // солнечная погода
                    Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setStorm(false);
                    ((Player) commandSender).getLocation().getWorld().setThundering(false);
                    commandSender.sendMessage(Language.getMessage("messages.weather.changed")
                            .replace("{world}", ((Player) commandSender).getLocation().getWorld().getName())
                            .replace("{weather}", weatherArgument)
                    );
                }
                case "rain" -> { // дождливая погода
                    Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setStorm(true);
                    Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setThundering(false);
                    commandSender.sendMessage(Language.getMessage("messages.weather.changed")
                            .replace("{world}", ((Player) commandSender).getLocation().getWorld().getName())
                            .replace("{weather}", weatherArgument)
                    );
                }
                case "storm" -> { // дождь с грозой
                    Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setStorm(true);
                    Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setThundering(true);
                    commandSender.sendMessage(Language.getMessage("messages.weather.changed")
                            .replace("{world}", ((Player) commandSender).getLocation().getWorld().getName())
                            .replace("{weather}", weatherArgument)
                    );
                }
                default -> commandSender.sendMessage(Language.getMessage("messages.errors.weather.args"));
            }
        } catch (Exception e) {
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }
    }

    @Override
    public String getCommandName() {
        return "weather";
    }

    @Override
    public HashMap<String, String> getArgumentMap() {
        return new HashMap<>(){{
            put("weather", "String");
        }};
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>(){{
            add("погода");
            add("wea");
            add("wth");
        }};
    }

    @Override
    public String getPermission() {
        return "miniessentials.weather";
    }

    @Override
    public List<String> getSuggestions() {
        return new ArrayList<>(){{
            Collections.addAll(this,"clear", "rain", "storm");
        }};
    }
}
