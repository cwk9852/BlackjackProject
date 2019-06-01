package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	Scanner kb = new Scanner(System.in);
	private Card theBlind = null;

	public static void main(String[] args) {
		BlackjackApp table = new BlackjackApp();
		table.run();
	}

	public void run() {
		BlackJackDealer cecil = new BlackJackDealer();
		BlackJackPlayer player = new BlackJackPlayer();
		System.out.println("Welcome to Cecil's Blackjack Table");
		System.out.println("Shuffling...");
		cecil.getDeck().shuffle();
		System.out.println("Dealing two cards to each player, and one blind to the house.. \n");
		theBlind = cecil.dealFirstRound(player, kb);
		System.out.println("Flipping the blind.." + theBlind);
		do {
			if (cecil.checkWins(cecil.getHandValue(cecil.getHand()), player.getHandValue(player.getHand())) == null) {
				System.out.println("Dealer:" + cecil.getHandValue(cecil.getHand()));
				System.out.println("Player:" + player.getHandValue(player.getHand()));
				System.out.println("");
				cecil.continueRound(player, kb);
			}
		} while (cecil.checkWins(cecil.getHandValue(cecil.getHand()), player.getHandValue(player.getHand())) == null);
		System.out.println(cecil.checkWins(cecil.getHandValue(cecil.getHand()), player.getHandValue(player.getHand())));
		kb.close();
	}
}
