package com.guncraft;


import com.guncraft.gun.bullets.BulletMain;
import com.guncraft.gun.guns.UZI_Normal;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GunCraft extends JavaPlugin implements Listener {
	private static GunCraft instance;
	@Override
	public void onEnable() {
		//CommandInvoker.registerCommand("GunMatch");
		//Bukkit.getPluginCommand("gunmatch").setExecutor(new MatchCommand());
		//JobSave.jobSave = registerNewConfiguration("JobSave", null);
		//Bukkit.getPluginManager().registerEvents(new MatchGui(), this);
		Bukkit.getPluginManager().registerEvents(new UZI_Normal(), this);
		Bukkit.getPluginManager().registerEvents(new BulletMain(), this);
		instance = this;
	}
	public static GunCraft getInstance() {
		return instance;
	}
	private FileConfiguration registerNewConfiguration(String configName, HashMap<String, Object> defaults) {
		File f = new File(".//plugins//GunCraft//" + configName + ".yml");
		f.getParentFile().mkdirs();
		FileConfiguration config = null;
		if (!f.exists()) {
			try {
				f.createNewFile();
				config = YamlConfiguration.loadConfiguration(f);
				if (!(defaults == null)) {
					for (String key : defaults.keySet()) {
						config.set(key, defaults.get(key));
					}
				}
				config.save(f);
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		} else {
			config = YamlConfiguration.loadConfiguration(f);
			if (!(defaults == null)) {
				for (Map.Entry<String, Object> entry : defaults.entrySet()) {
					if (config.get(entry.getKey(), new NullAbleClass()).getClass().equals(NullAbleClass.class) || config.get(entry.getKey(), new NullAbleClass()).getClass() == NullAbleClass.class) {
						config.set(entry.getKey(), entry.getValue());
					}
				}
			}
			try {
				config.save(f);
			} catch (IOException exc) {
				exc.printStackTrace();
			}
		}
		return config;
	}
}
