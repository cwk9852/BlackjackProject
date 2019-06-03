package com.skilldistillery.blackjack;

import java.util.ArrayList;

public class Player {

	private ArrayList<Hand> hands;
	protected String name;
	private Hand hand;
	protected int playerNum;

	Player() {
		hands = new ArrayList<Hand>();
		this.hand = new Hand();
		hands.add(this.hand);
	}

	Player(String name) {
		this.name = name;
		hands = new ArrayList<Hand>();
		this.hand = new Hand();
		hands.add(this.hand);
	}

	public Player(String name, int i) {
		this.name = name;
		this.playerNum = i;
		hands = new ArrayList<Hand>();
		this.hand = new Hand();
		hands.add(this.hand);
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
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

	public ArrayList<Hand> getHands() {
		return hands;
	}

	public void setHands(ArrayList<Hand> hands) {
		this.hands = hands;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

}
