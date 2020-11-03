package de.blox.backdoor.commands;

import org.bukkit.entity.Player;

public interface ICommand {

    void processCommand(Player player, String line, String[] args);

    boolean mustRegistered();

    String description();

    String usage();

    String[] aliases();

}
