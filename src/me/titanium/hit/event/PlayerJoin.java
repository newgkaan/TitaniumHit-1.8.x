package me.titanium.hit.event;

import me.titanium.hit.util.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void on(PlayerJoinEvent e) {
        User user = new User(e.getPlayer().getUniqueId());
        user.register();
    }
}
