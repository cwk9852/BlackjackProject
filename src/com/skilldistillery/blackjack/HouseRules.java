package com.skilldistillery.blackjack;

public interface HouseRules {
	
	boolean houseRule = false;

	public boolean checkWinsTable(int dealerHandValue, int playerHandValue);
	public void housePays(int playerHandValue, int bet, boolean insurance);
	public void housePaysDouble(int playerHandValue, int bet, boolean insurance);

}
