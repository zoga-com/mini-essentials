package ru.zoga_com.miniessentials.commands;

import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.zoga_com.miniessentials.common.generics.Command;
import ru.zoga_com.miniessentials.config.Language;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class CommandSpeed implements Command {
    @Override
    public void executeTasks(@NotNull CommandSender commandSender, CommandArguments args) {
        try {
            final int speedArgument = (int) args.getOrDefault("speed", 1);

            if (((Player) commandSender).isFlying()) {
                ((Player) commandSender).setFlySpeed(((float) speedArgument / 10));
                System.out.println(((float) speedArgument / 10));
                commandSender.sendMessage(Language.getMessage("messages.speed.fly") + speedArgument);
            } else {
                ((Player) commandSender).setWalkSpeed(((float) speedArgument / 10));
                commandSender.sendMessage(Language.getMessage("messages.speed.walk") + speedArgument);
            }
        } catch (Exception e) {
            commandSender.sendMessage(Language.getMessage("messages.errors.general.exceptionThrow").replace("{throwClass}", e.getClass().getCanonicalName()));
        }
    }

    @Override
    public String getCommandName() {
        return "speed";
    }

    @Override
    public HashMap<String, String> getArgumentMap() {
        return new HashMap<>(){{
            put("speed", "Int");
        }};
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>(){{
            add("changespeed");
            add("скорость");
        }};
    }

    @Override
    public String getPermission() {
        return "miniessentials.speed";
    }

    @Override
    public List<String> getSuggestions() {
        return new ArrayList<>(){{
            Collections.addAll(this,"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        }};
    }
}
