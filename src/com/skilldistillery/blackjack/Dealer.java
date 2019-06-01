package com.skilldistillery.blackjack;

import java.util.InputMismatchException;

public class Dealer extends Player {

	private Deck deck;

	Dealer() {
		deck = new Deck();
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public void dealCards(Player name, int howMany) {
		try {
			if (howMany > deck.checkDeckSize()) {
				throw new IndexOutOfBoundsException();
			}
			for (int i = 0; i < howMany; i++) {
				Card card = deck.removeCard();
				name.getHand().add(card);
			}
		} catch (InputMismatchException e) {
			System.out.println("Not an integer");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Not enough cards.");
		}
	}

	public void autoPlay() {
		if (getHand().getHandValue() < 17 ) {
			Card card = deck.removeCard();
			getHand().add(card); 
		} 
		
	}

	public void checkForWinner() {
		if ( dealer.getHand().getHandValue()>17 ) {
			
		}		
	}
}