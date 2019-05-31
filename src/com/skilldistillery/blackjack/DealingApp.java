package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DealingApp {

	public static void main(String[] args) {
		DealingApp dA = new DealingApp();
		dA.run();

	}

	public void run() {
		Deck deck = new Deck();
		Scanner kb = new Scanner(System.in);
		deck.shuffle();
		System.out.println("How many cards do you want to get?");
		try {
			int howMany = kb.nextInt();
			if (howMany > 52) {
				throw new IndexOutOfBoundsException();
			}
			List<Card> hand = new ArrayList<>(howMany);
			int handValue = 0;
			for (int i = 0; i < howMany; i++) {
				Card card = deck.getDeck().remove(0);
				handValue += card.getValue();
				hand.add(card);
			}
			printHandAndValue(hand, handValue);
		} catch (InputMismatchException e) {
			System.out.println("Not an integer");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Not enough cards in the deck");
		} finally {
			kb.close();
		}
	}

	private void printHandAndValue(List<Card> hand, int value) {
		for (Card card : hand) {
			System.out.println(card);
		}
		System.out.println("Total value: " + value);
	}

}
