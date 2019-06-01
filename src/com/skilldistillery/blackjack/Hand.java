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

	public List<Card> getHandWithBlind() {
		return hand;
	}
	public void getOneCard() {
		
	}

	public void setHand() {
		this.hand = new ArrayList<>();
	}

	public void add(Card card) {
		hand.add(card);
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
