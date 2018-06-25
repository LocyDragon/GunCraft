package com.guncraft.gun;

import com.guncraft.gun.guns.UZI_Normal;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;

public class Gun implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
		if (!sender.isOp()) {
			sender.sendMessage("未知的指令.");
		}
		if (args[0].equalsIgnoreCase("UZI")) {
			String who = args[1];
			HashMap map = Bukkit.getPlayer(who).getInventory().addItem(UZI_Normal.gunItem);
			if (!map.isEmpty()) {
				Bukkit.getPlayer(who).getWorld().dropItem(Bukkit.getPlayer(who).getLocation(), UZI_Normal.gunItem);
			}
		}
		return false;
	}
}
