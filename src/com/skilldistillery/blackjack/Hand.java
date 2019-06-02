package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private List<Card> hand;

	Hand() {
		setHand();
	}

	public void printHand(Hand hand) {
		for (Card card : this.hand) {
			System.out.println(card);
		}
	}

	public List<Card> getHand() {
		return hand;
	}

	public int getFirstCardValue() {
		int card = hand.get(0).getValue();
		return card;
	}
	public int getSecondCardValue() {
		int card = hand.get(1).getValue();
		return card;
	}
	
	public String getCard(int index) {
		return hand.get(index).toString();
	}

	public void setHand() {
		this.hand = new ArrayList<>();
	}
	public void resetHand() {
		this.hand = null;
	}

	public Card add(Card card) {
		hand.add(card);
		return card;
	}

	public int getHandValue() {
		int handValue = 0;
		for (Card card : hand) {
			handValue += card.getValue();
		}
		return handValue;
	}

	public void printHandAndValue(Hand hand, int handValue) {
		for (Card card : this.hand) {
			System.out.println(card);
		}
		System.out.println("Total value: " + handValue);
	}

}
