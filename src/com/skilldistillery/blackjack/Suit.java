package com.skilldistillery.blackjack;

public enum Suit {

	HEARTS("HEARTS"), SPADES("SPADES"), CLUBS("CLUBS"), DIAMONDS("DIAMONDS");

	final private String name;

	Suit(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}
}
