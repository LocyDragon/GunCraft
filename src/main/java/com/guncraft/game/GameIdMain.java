package com.guncraft.game;

public class GameIdMain {
	private static Long idCount = 0L;
	public static Long newId() {
		idCount++;
		return idCount;
	}
}
