package com.guncraft.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {
	public static boolean contains(ItemStack item, Inventory inv) {
		for (ItemStack item2 : inv) {
			if (item2 != null && item2.getType() == item.getType()) {
				if (item2.getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName())) {
					return true;
				}
			}
		}
		return false;
	}
	public static void remove(ItemStack item, Player who) {
		Inventory inv = who.getInventory();
		for (int i = 0;i < inv.getSize();i++) {
			if (inv.getItem(i) != null && inv.getItem(i).getType() == item.getType() && inv.getItem(i)
					.getItemMeta().getDisplayName().equals(item.getItemMeta().getDisplayName())) {
				ItemStack itemTo = inv.getItem(i);
				if (itemTo.getAmount() == 1) {
					itemTo.setType(Material.AIR);
				} else {
					itemTo.setAmount(itemTo.getAmount()-1);
				}
				inv.setItem(i, itemTo);
				who.updateInventory();
				return;
			}
		}
	}
}
