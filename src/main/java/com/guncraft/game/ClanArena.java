package com.guncraft.game;

import com.guncraft.game.player.PlayerPackage;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ClanArena implements Game {
    private Long gameId;
    private UType type;
    private List<PlayerPackage> joinedList = new ArrayList<>();
	private ClanArena() {
       this.gameId = GameIdMain.newId();
       this.type = new UType(0);
	}

	public static ClanArena createGame() {
		return new ClanArena();
	}

	@Override
	public UType getType() {
		return this.type;
	}

	@Override
	public void startGame() {

	}

	@Override
	public Long getGameID() {
		return null;
	}

	@Override
	public void join(Player who) {

	}

	@Override
	public void endGame() {

	}

	@Override
	public List<PlayerPackage> getJoined() {
		return this.joinedList;
	}

	@Override
	public void quitPlayer(Player who) {

	}
}
