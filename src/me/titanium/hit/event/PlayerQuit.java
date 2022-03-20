package me.titanium.hit.event;

import me.titanium.hit.Main;
import me.titanium.hit.util.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void on(PlayerQuitEvent e) {
        User user = Main.users.getOrDefault(e.getPlayer().getUniqueId(), null);
        user.unregister();
    }
}
