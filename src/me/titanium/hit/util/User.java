package me.titanium.hit.util;


import me.titanium.hit.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class User {
    private final UUID uuid;


    private Long cooldownOther = 0L;
    private Long cooldownAttack = 0L;



    public User(UUID uuid) {
        this.uuid = uuid;
    }


    public void setCooldownOther(Long cooldownOther) {
        this.cooldownOther = cooldownOther;
    }
    public void setCooldownAttack(Long cooldownAttack) {
        this.cooldownAttack = cooldownAttack;
    }

    public Long getCooldownOther() {
        return this.cooldownOther;
    }
    public Long getCooldownAttack() {
        return this.cooldownAttack;
    }


    private Player getPlayer() {
        return Bukkit.getPlayer(this.uuid);
    }



    public void register() {
        Main.users.put(uuid, this);
        Player player = getPlayer();
        if (player != null) player.setMaximumNoDamageTicks(0);
    }
    public void unregister() {
        Main.users.remove(uuid, this);
        Player player = getPlayer();
        if (player != null) player.setMaximumNoDamageTicks(20);
    }


}
