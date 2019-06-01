package com.skilldistillery.blackjack;

public abstract class Player {

	private Hand hand;

	Player() {
		hand = new Hand();
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

}
