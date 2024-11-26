package com.pluginsell.infiniteBuckets;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BucketEvents implements Listener {
    @EventHandler
    public void onWaterPlaceEvent(PlayerBucketEmptyEvent e) {
        Player player = e.getPlayer();
        ItemStack itemStack = player.getItemInHand();
        if(itemStack != null) {
            ItemMeta meta = itemStack.getItemMeta();
            if (meta.equals(new BucketItems().getBucket("W").getItemMeta())) {
                e.setCancelled(true);
                e.getBlockClicked().getRelative(e.getBlockFace()).setType(Material.WATER);
                player.updateInventory();
            } else if (meta.equals(new BucketItems().getBucket("L").getItemMeta())) {
                e.setCancelled(true);
                e.getBlockClicked().getRelative(e.getBlockFace()).setType(Material.LAVA);
                player.updateInventory();
            }
        }
    }
}
