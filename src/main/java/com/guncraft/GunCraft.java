package com.guncraft;


import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class GunCraft extends JavaPlugin implements Listener {
	private static GunCraft instance;
	@Override
	public void onEnable() {
        instance = this;
	}
	public static GunCraft getInstance() {
		return instance;
	}
}
