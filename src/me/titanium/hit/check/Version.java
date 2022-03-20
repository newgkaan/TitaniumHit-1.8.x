package me.titanium.hit.check;

import org.bukkit.plugin.Plugin;

public class Version {
    private final Plugin plugin;
    public Version(Plugin plugin) {
        this.plugin = plugin;
    }

    public boolean check() {
        String var = plugin.getServer().getClass().getPackage().getName();
        String var1 = var.substring(var.lastIndexOf(".") + 1);
        return var1.contains("v1_8");
    }
}
