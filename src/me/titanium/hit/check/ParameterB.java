package me.titanium.hit.check;

import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ParameterB {
    private final EntityDamageByEntityEvent e;
    public ParameterB(EntityDamageByEntityEvent e) {
        this.e = e;
    }

    public boolean checkEntity() {
        return e.getEntityType().equals(EntityType.PLAYER);
    }
    public boolean attackerIsHookOrArrow() {
        return e.getDamager().getType().equals(EntityType.FISHING_HOOK) || e.getDamager().getType().equals(EntityType.ARROW);
    }
}
