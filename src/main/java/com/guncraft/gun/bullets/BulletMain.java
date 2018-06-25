package com.guncraft.gun.bullets;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BulletMain implements Listener {
	@EventHandler
	public void onEatBullet(PlayerItemConsumeEvent e) {
		if (e.getItem().getType() == Material.CARROT_ITEM) {
			e.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE+"Y世界 >>"+ChatColor.AQUA+"阿勒?你好像吃了一个子弹！");
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 400, 2));
		}
	}
}
