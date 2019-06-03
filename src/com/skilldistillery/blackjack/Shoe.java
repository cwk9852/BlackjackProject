package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe extends Deck {

	private List<Card> shoe;

	Shoe() {
		this.setShoe(newShoe());
	}
	
	public void printShoe() {
		for (Card card : this.shoe) {
			System.out.println("[   " + card + "   ]");
		}
	}

	private List<Card> newShoe() {
		// List<Deck> shoe = new ArrayList<>();
		List<Card> shoe = new ArrayList<>(312);
		for (int i = 0; i < 6; i++) {
			for (Suit suit : Suit.values()) {
				for (Rank rank : Rank.values()) {
					shoe.add(new Card(suit, rank));
				}
			}
		}
		return shoe;
	}

	public Card removeCard() {
		return shoe.remove(0);
	}
	
	public List<Card> getShoe() {
		return shoe;
	}

	public void setShoe(List<Card> shoe) {
		this.shoe = shoe;
	}

	public int checkShoeSize() {
		int shoeSize = shoe.size();
		return shoeSize;
	}
	
	public void shuffle() {
		Collections.shuffle(shoe);
	}
}
