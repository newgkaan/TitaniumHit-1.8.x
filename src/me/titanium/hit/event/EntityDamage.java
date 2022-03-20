package me.titanium.hit.event;

import me.titanium.hit.Main;
import me.titanium.hit.check.ParameterA;
import me.titanium.hit.util.User;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamage implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void on(EntityDamageEvent e) {
        ParameterA parameter = new ParameterA(e);
        if (!parameter.checkEntity()) return;
        if (!parameter.checkCause()) return;

        User user = Main.users.getOrDefault(e.getEntity().getUniqueId(), null);
        if (user == null) return;

        Long current = System.currentTimeMillis();
        if (current - user.getCooldownOther() < 492) {
            e.setCancelled(true);
        } else {
            user.setCooldownOther(current);
        }

    }
}
