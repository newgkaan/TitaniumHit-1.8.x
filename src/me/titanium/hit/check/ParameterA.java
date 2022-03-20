package me.titanium.hit.check;

import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDamageEvent;

public class ParameterA {
    private final EntityDamageEvent e;
    public ParameterA(EntityDamageEvent e) {
        this.e = e;
    }
    public boolean checkEntity() {
        return e.getEntityType().equals(EntityType.PLAYER);
    }
    public boolean checkCause() {
        return !e.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK) && !e.getCause().equals(EntityDamageEvent.DamageCause.PROJECTILE);
    }
}
