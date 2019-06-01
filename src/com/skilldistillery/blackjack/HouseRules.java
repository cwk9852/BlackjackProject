package com.skilldistillery.blackjack;

public interface HouseRules {
	
	boolean houseRule = false;

	public boolean checkWinsTable(int dealerHandValue, int playerHandValue);
	public boolean housePays(int playerHandValue, int bet, boolean insurance);

}
