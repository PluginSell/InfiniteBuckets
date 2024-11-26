package com.pluginsell.infiniteBuckets;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class BucketItems {
    public ItemStack getBucket(String type) {
        ItemStack itemStack = null;
        if(type.equalsIgnoreCase("W")) {
            itemStack = new BucketItems().waterBucket();
        } else if(type.equalsIgnoreCase("L")) {
            itemStack = new BucketItems().lavaBucket();
        }

        return itemStack;
    }

    private ItemStack waterBucket() {
        ItemStack waterBucket = new ItemStack(Material.WATER_BUCKET);
        ItemMeta bucketMeta = waterBucket.getItemMeta();
        bucketMeta.setDisplayName("§b§lInfinite Water Bucket");
        bucketMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§bRight click this bucket to use.");
        lore.add("§bThis bucket will never empty!");

        bucketMeta.setLore(lore);
        waterBucket.setItemMeta(bucketMeta);

        waterBucket.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        return waterBucket;
    }

    private ItemStack lavaBucket() {
        ItemStack lavaBucket = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta bucketMeta = lavaBucket.getItemMeta();
        bucketMeta.setDisplayName("§c§lInfinite Lava Bucket");
        bucketMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§bRight click this bucket to use.");
        lore.add("§bThis bucket will never empty!");

        bucketMeta.setLore(lore);
        lavaBucket.setItemMeta(bucketMeta);

        lavaBucket.addUnsafeEnchantment(Enchantment.DURABILITY, 1);

        return lavaBucket;
    }
}
