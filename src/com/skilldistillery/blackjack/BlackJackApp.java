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
		// common package?
		Scanner kb = new Scanner(System.in);
		dealer = new BlackJackDealer();
		System.out.println("Welcome to Cecil's Blackjack Table");
		System.out.print("How many players?:");
		int num = kb.nextInt();
		players = dealer.setPlayers(num, dealer);
		System.out.println("Shuffling...");
		dealer.getShoe().shuffle();
//		System.out.println("Cut..."); does nothing
//		dealer.getShoe().cut();
		System.out.println("Dealing...\n");
		dealer.dealCards(players, 2);
// 		getBets(players, kb);
		dealer.printPlayerHands(players);
		dealer.printDealerHandWithBlind();
		if (dealer.getHand().getFirstCardValue() == 11) {
			dealer.offerInsurance(players, kb);
		}
		dealer.checkNaturals(players);
		dealer.getHits(players, kb);
		if (players.size() > 1) {
			dealer.turnBlind();
			dealer.playHouseRule();
		}
		dealer.checkWins(players);
		kb.close();
	}

}