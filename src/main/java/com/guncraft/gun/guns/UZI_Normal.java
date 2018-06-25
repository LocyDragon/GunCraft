package com.guncraft.gun.guns;

import com.guncraft.gun.async.UZIShottingThread;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class UZI_Normal implements Listener {
	public static ItemStack gunItem = new ItemStack(Material.STICK);
	public static HashMap<String,UZIShottingThread> shottingThread = new HashMap<>();
	public static List<UUID> bullet = new ArrayList<>();
	public static Vector<String> locked = new Vector<>();
	static {
		ItemMeta meta = gunItem.getItemMeta();
		meta.setDisplayName("錀§f乌兹冲锋枪錀");
		List<String> lores = new ArrayList<>();
		lores.add("§f=======§b[§a枪械使用§b]§f=======");
		lores.add("錋§e使用: §a按住左键不放手开始射击.");
		lores.add("錋§e使用: §a9按下右键松开扳机.");
        lores.add("§f=======§b[§a枪械介绍§b]§f=======");
        lores.add("§f錁 枪械由以色列发明，现在多为中国制造");
		lores.add("§f錁 该枪甚至被用于二战时期的战斗");
		lores.add("§f錁 因为该枪过于凶猛，甚至与AK47并成为\"土匪枪\"");
		lores.add("§f=======§b[§a枪械数据§b]§f=======");
		lores.add("錋§e来源: §a黑铁合成");
		lores.add("錋§e子弹: §a9毫米子弹");
		lores.add("錋§e子弹来源: 第一大关第一小关或后面的关卡获得");
		lores.add("錋§e伤害: 微小");
		lores.add("錋§e射速: 极快");
		lores.add("錋§e后坐力: 大");
		lores.add("錋§e弹夹容量: 20");
		lores.add("錋§e换弹时间: 2.6秒");
		meta.setLore(lores);
		gunItem.setItemMeta(meta);
	}
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (bullet.contains(e.getDamager().getUniqueId())) {
			e.setDamage(3);
			bullet.remove(e.getDamager().getUniqueId());
		}
	}
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		shottingThread.remove(e.getPlayer().getName());
	}
	@EventHandler
	public void onQuit(PlayerKickEvent e) {
		shottingThread.remove(e.getPlayer().getName());
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		if (locked.contains(e.getPlayer().getName()) || shottingThread.keySet().contains(e.getPlayer().getName())) {
			return;
		}
		if (e.getPlayer().getInventory().getItemInMainHand() != null
				&& e.getPlayer().getInventory().getItemInMainHand().getType() != Material.AIR
				&& e.getPlayer().getInventory().getItemInMainHand().getType() == Material.STICK) {
			if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
				UZIShottingThread thread = new UZIShottingThread(e.getPlayer());
                thread.start();
                shottingThread.put(e.getPlayer().getName(), thread);
			} else if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
				e.getPlayer().sendMessage("&bY世界>> &a停止射击.");
				shottingThread.get(e.getPlayer().getName()).stopShotting();
				shottingThread.remove(e.getPlayer().getName());
			}
		}

	}
	public static synchronized void shot(Player who) {
		Snowball ball = who.launchProjectile(Snowball.class, who.getVelocity());
		bullet.add(ball.getUniqueId());
		Location loc = who.getLocation();
		loc.setPitch(loc.getPitch()+(float)Math.random()*4);
		loc.setYaw(loc.getYaw()+(float)Math.random()*4);
		who.teleport(loc);
	}
}
