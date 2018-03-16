package com.guncraft.game;

public class UType {
	private int type = 0;
	public UType(int type) {
		this.type = type;
	}
	public String getType() {
		switch (type) {
			case 0:
				return "团队竞技";
			default:
				return "团队竞技";
		}
	}
}
