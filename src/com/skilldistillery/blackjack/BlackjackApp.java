package com.skilldistillery.blackjack;

import java.util.Scanner;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp dA = new BlackjackApp();
		dA.run();
	}

	public void run() {
		User user = new User();
		Dealer dealer = new Dealer();
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to Cecil's Blackjack App");
		System.out.println("The betting system doesnt work but we are storing the value incase we want to use it later.");
		System.out.println("Make a Bet:");
		int bet = kb.nextInt();
		System.out.println("Dealing");
		dealer.getDeck().shuffle();
		dealer.dealCards(dealer, 1);
		dealer.dealCards(user, 1);
		dealer.dealCards(user, 1);
		dealer.dealCards(dealer, 1);
		user.getHand().printHandAndValue(user.getHand(), user.getHand().getHandValue());
		System.out.println("Dealer: " + dealer.getHand().getHandValue());
		System.out.println();
		System.out.println("Player: " + user.getHand().getHandValue());
		dealer.getHand().printHandAndValue(dealer.getHand(), dealer.getHand().getHandValue());
		System.out.println("Do you want insurance? ");
		if (dealer.getHand().getHandValue() == 21 || user.getHand().getHandValue() == 21 ) {

		}
			do {
		if (user.getHand().getHandValue() < 21) {
				System.out.println("[1. Hit][2. Stay]");
				int input = kb.nextInt();
				switch (input) {
				case 1:
					dealer.dealCards(user, 1);
				case 2:
					dealer.autoPlay();
					dealer.checkForWinner();
					break;
				}
//				user.getHand().printHandAndValue(user.getHand(), user.getHand().getHandValue());
				System.out.println();
//				dealer.getHand().printHandAndValue(dealer.getHand(), dealer.getHand().getHandValue());
			} 
		} while (user.getHand().getHandValue() < 21) ;
		System.out.println("Dealer: " + dealer.getHand().getHandValue());
		System.out.println("Player: " + user.getHand().getHandValue());
			
		}
}
}
