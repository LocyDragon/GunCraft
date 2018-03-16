package com.guncraft.game.player;

import com.guncraft.jobs.JobEnum;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerPackage {
	private String playerName;
	private JobEnum job;
	public PlayerPackage(Player player, JobEnum chosenJob) {
		this.playerName = player.getName();
		this.job = chosenJob;
	}
	public Player getPlayer() {
		return Bukkit.getPlayer(this.playerName);
	}
	public JobEnum getJob() {
		return this.job;
	}
}
