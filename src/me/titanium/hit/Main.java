package me.titanium.hit;

import me.titanium.hit.check.Version;
import me.titanium.hit.event.*;
import me.titanium.hit.util.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main extends JavaPlugin {

    public static final Map<UUID, User> users = new HashMap<>();

    public void onEnable() {
        if(!version()) {
            getLogger().severe("This plugin created for 1.8.x versions.");
            getLogger().severe("The options will not work!");
            return;
        }


        for (Player player : Bukkit.getOnlinePlayers()) {
            new User(player.getUniqueId()).register();
        }



        getServer().getPluginManager().registerEvents(new EntityDamageByEntity(), this);
        getServer().getPluginManager().registerEvents(new ProjectileLaunch(), this);
        getServer().getPluginManager().registerEvents(new EntityDamage(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
    }

    public void onDisable() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            User user = Main.users.getOrDefault(player.getUniqueId(), null);
            if (user != null) user.unregister();
        }
    }

    private boolean version() {
        return new Version(this).check();
    }
}
