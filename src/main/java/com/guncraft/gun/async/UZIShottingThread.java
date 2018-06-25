package com.guncraft.gun.async;

import com.guncraft.gun.bullets.MM_9;
import com.guncraft.gun.guns.UZI_Normal;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class UZIShottingThread extends Thread {
	private Player who;
	public boolean stop = false;
	public UZIShottingThread(Player who) {
		this.who = who;
	}
	public void stopShotting() {
		this.stop = true;
	}
	@Override
	public void run(){
		int counter = 0;
		while (who.getInventory().contains(MM_9.MM_9)) {
			if (who == null || !who.isOnline()) {
				UZI_Normal.shottingThread.remove(this.who.getName());
			}
			if (counter % 20 == 0) {
				UZI_Normal.locked.add(who.getName());
				who.sendMessage("&bY世界>> &a你现在正在换子弹,需要约三秒.");
				who.playSound(who.getLocation(), Sound.BLOCK_WOOD_PRESSUREPLATE_CLICK_OFF, 1, 1);
				try {
					Thread.sleep(26000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				who.playSound(who.getLocation(), Sound.BLOCK_WOOD_PRESSUREPLATE_CLICK_ON, 1, 1);
				UZI_Normal.locked.remove(who.getName());
			}
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (this.stop) {
				UZI_Normal.shottingThread.remove(this.who.getName());
				break;
			}
            who.getInventory().remove(MM_9.MM_9);
			who.playSound(this.who.getLocation(), Sound.BLOCK_SAND_BREAK, 3, 1);
			UZI_Normal.shot(this.who);
			counter++;
		}
		who.sendTitle("&c&l已经停止射击了", "&b>>&a&l你没有子弹了&b<<");
		UZI_Normal.shottingThread.remove(this.who.getName());
	}
}
