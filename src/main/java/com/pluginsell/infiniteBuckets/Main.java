package com.pluginsell.infiniteBuckets;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static String prefix = ChatColor.translateAlternateColorCodes('&', "&3InfiniteBuckets &b> ");

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&aPlugin has been enabled."));
        getServer().getPluginManager().registerEvents(new BucketEvents(), this);
        getCommand("infinitebuckets").setExecutor(new BucketCommands());

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&cPlugin has been disabled."));
    }
}
