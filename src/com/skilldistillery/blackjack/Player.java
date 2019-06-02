package com.skilldistillery.blackjack;

import java.util.HashSet;

public class Player {
	
	private HashSet<Hand> hands;

	private Hand hand;

	Player() {
		hands = new HashSet<Hand>();
		hand = new Hand();
		hands.add(hand);
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
