package com.skilldistillery.blackjack;

public class Player {

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
	
	public int getHandValue(Hand hand) {
		return hand.getHandValue();
	}

}
