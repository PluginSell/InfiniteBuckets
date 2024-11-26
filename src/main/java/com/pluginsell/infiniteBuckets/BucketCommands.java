package com.pluginsell.infiniteBuckets;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BucketCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String s, String[] args) {
        if (args.length >= 3) {
            if (args[0].equalsIgnoreCase("give")) {
                Player target = Bukkit.getPlayer(args[1]);
                if (target != null && target.isOnline()) {
                    if (!(commandSender instanceof Player) || commandSender.hasPermission("infinitebuckets.give")) {
                        if (args[2].toUpperCase().contains("W")) {
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(), new BucketItems().getBucket("W"));
                            } else {
                                target.getInventory().addItem(new BucketItems().getBucket("W"));
                            }
                            commandSender.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', "&aYou have given &6" + target.getName() + " &aan &e" + new BucketItems().getBucket("W").getItemMeta().getDisplayName()));
                            if (commandSender instanceof Player) {
                                target.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', "&6" + commandSender.getName() + " &ahas given you an " + new BucketItems().getBucket("W").getItemMeta().getDisplayName()));
                            } else {
                                target.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', "&aYou have been given an " + new BucketItems().getBucket("W").getItemMeta().getDisplayName()));
                            }
                        } else if (args[2].toUpperCase().contains("L")) {
                            if (target.getInventory().firstEmpty() == -1) {
                                target.getWorld().dropItemNaturally(target.getLocation(), new BucketItems().getBucket("L"));
                            } else {
                                target.getInventory().addItem(new BucketItems().getBucket("L"));
                            }
                            commandSender.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', "&aYou have given &6" + target.getName() + " &aan &e" + new BucketItems().getBucket("L").getItemMeta().getDisplayName()));
                            if (commandSender instanceof Player) {
                                target.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', "&6" + commandSender.getName() + " &ahas given you an " + new BucketItems().getBucket("L").getItemMeta().getDisplayName()));
                            } else {
                                target.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', "&aYou have been given an " + new BucketItems().getBucket("L").getItemMeta().getDisplayName()));
                            }
                        } else {
                            commandSender.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', "&cCommand Usage: &a/bucket give <player> (water/lava)."));
                        }
                    } else {
                        commandSender.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', "&cYou do not have permissions to use that command."));
                    }
                } else {
                    commandSender.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', "&cThat is an invalid player."));
                }
            } else {
                commandSender.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', "&cCommand Usage: &a/bucket give <player> (water/lava)."));
            }
        } else {
            commandSender.sendMessage(Main.prefix + ChatColor.translateAlternateColorCodes('&', "&cCommand Usage: &a/bucket give <player> (water/lava)."));
        }
        return true;
    }
}
