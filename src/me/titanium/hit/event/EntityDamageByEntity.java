package me.titanium.hit.event;

import me.titanium.hit.Main;
import me.titanium.hit.check.ParameterB;
import me.titanium.hit.util.User;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void on(EntityDamageByEntityEvent e) {
        ParameterB parameter = new ParameterB(e);
        if (!parameter.checkEntity()) return;

        if (parameter.attackerIsHookOrArrow()) {
            e.getDamager().teleport(e.getEntity().getLocation().add(0, 0.3, 0));
            return;
        }

        User user = Main.users.getOrDefault(e.getEntity().getUniqueId(), null);
        if (user == null) return;


        Long current = System.currentTimeMillis();
        if (current - user.getCooldownAttack() < 492) {
            e.setCancelled(true);
        } else {
            user.setCooldownAttack(current);
        }
    }
}
