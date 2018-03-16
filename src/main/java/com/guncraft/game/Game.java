package com.guncraft.game;

import com.guncraft.game.player.PlayerPackage;
import org.bukkit.entity.Player;

import java.util.List;

public interface Game {
	UType getType();
	void startGame();
	Long getGameID();
	void join(Player who);
	void endGame();
	List<PlayerPackage> getJoined();
	void quitPlayer(Player who);
}
