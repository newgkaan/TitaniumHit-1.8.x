package me.titanium.hit.event;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

public class ProjectileLaunch implements Listener {

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void on(ProjectileLaunchEvent e) {
        if (e.getEntity().getType().equals(EntityType.ARROW)) {
            e.getEntity().setVelocity(e.getEntity().getVelocity().multiply(1.2100000003949385D));
        } else if (e.getEntity().getType().equals(EntityType.FISHING_HOOK)) {
            e.getEntity().setVelocity(e.getEntity().getVelocity().multiply(1.210000000000000D));
        }
    }

}
