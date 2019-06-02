package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {
	Scanner kb = new Scanner(System.in);

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
		int bet = 5;
		boolean insurance = false;
		System.out.println("Placing Minimum Bet: " + bet);
		System.out.println("Dealing...");
		Card theBlind = cecil.dealNewHand(player, kb);
		int houseHandValue = cecil.getHandValue(cecil.getHand());
		int playerHandValue = player.getHandValue(player.getHand());
		int blindHandValue = houseHandValue - theBlind.getValue();
		System.out.println("\nHouse Shows: " + blindHandValue);
		System.out.println("Player Hand: " + playerHandValue);
		if (blindHandValue == 11) {
			insurance = cecil.offerInsurance(player, kb);
			playerHandValue = player.getHandValue(player.getHand());
			houseHandValue = cecil.getHandValue(cecil.getHand());
			printHands(houseHandValue, playerHandValue);
			cecil.checkWinsTable(houseHandValue, playerHandValue);
		}
		if (cecil.checkWinsTable(houseHandValue, playerHandValue) != true) {
			do {
				theBlind = cecil.continueRound(player, kb, theBlind);
				playerHandValue = player.getHandValue(player.getHand());
				houseHandValue = cecil.getHandValue(cecil.getHand());
				printHands(houseHandValue, playerHandValue);
			} while (cecil.checkWinsTable(houseHandValue, playerHandValue) != true);
		}
//		cecil.housePays(playerHandValue, bet, insurance);
		kb.close();
	}

	public void printHands(int houseHandValue, int playerHandValue) {
		System.out.println("House Shows: " + houseHandValue);
		System.out.println("Player Hand: " + playerHandValue);
	}
}
