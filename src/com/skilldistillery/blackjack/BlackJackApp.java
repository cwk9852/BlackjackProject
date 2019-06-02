package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackApp {
	BlackJackDealer dealer;
	ArrayList<Player> players;

	public static void main(String[] args) {
		BlackJackApp version = new BlackJackApp();
		version.run();
	}

	public void run() {
		Scanner kb = new Scanner(System.in);
		dealer = new BlackJackDealer();
		System.out.println("Welcome to Cecil's Blackjack Table");
		System.out.println("How many players?");
		int num = kb.nextInt();
		players = setPlayers(num);
		System.out.println("Shuffling...");
		dealer.getShoe().shuffle();
		System.out.println("Cut...");
		dealer.getShoe().cut();
		System.out.println("Dealing...\n");
		dealer.dealCards(players, 2);
		printHands();
//		if dealer is showing an ace offer insurance to each player
		if (dealer.getHand().getFirstCardValue() == 11) {
			dealer.offerInsurance(players, kb);
		}
		dealer.turnBlind();
		int selection = kb.nextInt();
		// if blackjack, then natural blackjack or push if both
		switch (selection) {
		case 1:
			boolean keepGoing = true;
		case 2:
			keepGoing = false;
			do {
//				dealer.dealBlackJackHand(players, kb);
			} while (keepGoing);
		case 3:
			kb.close();
		}
	}

	public ArrayList<Player> setPlayers(int num) {
		players = new ArrayList<>();
		players.add(dealer);
		for (int i = 1; i < num + 1; i++) {
			players.add(new Player("Player ", i));
		}
		return players;
	}

	public void printHands() {
		for (Player player : players ) {
			System.out.println("\t" +player.getName());
			for (Hand hand : player.getHands()) {
				hand.printHand();
			}
		}
//		this.getHand().printHand(this.getHand());
	}
}