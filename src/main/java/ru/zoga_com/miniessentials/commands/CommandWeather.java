package ru.zoga_com.miniessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.zoga_com.miniessentials.config.Language;

import java.util.Objects;

public class CommandWeather implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, String[] strings) {
        try {
            if(strings.length != 1) {
                commandSender.sendMessage(Language.getMessage("messages.errors.weather.args"));
                return true;
            }

            switch (strings[0]) {
                case "clear" -> { // солнечная погода
                    Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setStorm(false);
                    ((Player) commandSender).getLocation().getWorld().setThundering(false);
                    commandSender.sendMessage(Language.getMessage("messages.weather.changed")
                            .replace("{world}", ((Player) commandSender).getLocation().getWorld().getName())
                            .replace("{weather}", strings[0])
                    );
                }
                case "rain" -> { // дождливая погода
                    Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setStorm(true);
                    Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setThundering(false);
                    commandSender.sendMessage(Language.getMessage("messages.weather.changed")
                            .replace("{world}", ((Player) commandSender).getLocation().getWorld().getName())
                            .replace("{weather}", strings[0])
                    );
                }
                case "storm" -> { // дождь с грозой
                    Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setStorm(true);
                    Objects.requireNonNull(((Player) commandSender).getLocation().getWorld()).setThundering(true);
                    commandSender.sendMessage(Language.getMessage("messages.weather.changed")
                            .replace("{world}", ((Player) commandSender).getLocation().getWorld().getName())
                            .replace("{weather}", strings[0])
                    );
                }
                default -> commandSender.sendMessage(Language.getMessage("messages.errors.weather.args"));
            }
        } catch(Exception e) {
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }

        return true;
    }
}
