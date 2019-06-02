package com.skilldistillery.blackjack;

import java.util.HashSet;

public class Player {

	private HashSet<Hand> hands;
	protected String name;
	private Hand hand;
	protected int playerNum;

	Player() {
		hands = new HashSet<Hand>();
		this.hand = new Hand();
		hands.add(this.hand);
	}

	Player(String name) {
		this.name = name;
		hands = new HashSet<Hand>();
		this.hand = new Hand();
		hands.add(this.hand);
	}

	public Player(String name, int i) {
		this.name = name;
		this.playerNum = i;
		hands = new HashSet<Hand>();
		this.hand = new Hand();
		hands.add(this.hand);
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

	public String getName() {
		return name + playerNum;
	}
	public void addHand() {
		hands.add(new Hand());
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashSet<Hand> getHands() {
		return hands;
	}

	public void setHands(HashSet<Hand> hands) {
		this.hands = hands;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
}
