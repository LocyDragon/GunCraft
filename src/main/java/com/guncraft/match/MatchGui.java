package com.guncraft.match;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class MatchGui implements Listener {
	public static void openGui(Player who) {
		Inventory gui = Bukkit.createInventory(null, 54, "§7>>>匹配 请先选择职业");
	}
}
