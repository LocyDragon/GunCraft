package com.guncraft.gun.bullets;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class MM_9 {
	public static ItemStack MM_9 = new ItemStack(Material.CARROT_ITEM);
	static {
		ItemMeta meta = MM_9.getItemMeta();
		meta.setDisplayName("§f9毫米子弹");
		List<String> lores = new ArrayList<>();
		lores.add("§f=======§b[§a子弹介绍介绍§b]§f=======");
		lores.add("§f錁 全名9毫米鲁格弹，多为手枪/冲锋枪使用");
		lores.add("§f錁 一枚子弹大概有8公克(即8克)");
		meta.setLore(lores);
		MM_9.setItemMeta(meta);
	}
}
