package com.guncraft.gun.guns;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class AK47_Normal implements Listener {
	public static ItemStack gunItem = new ItemStack(Material.STICK);
	static {
		ItemMeta meta = gunItem.getItemMeta();
		meta.setDisplayName("錀§fAK47錀");
		List<String> lores = new ArrayList<>();
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
		meta.setLore(lores);
		gunItem.setItemMeta(meta);
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {

	}
	public static void shot(Player who) {

	}
}
