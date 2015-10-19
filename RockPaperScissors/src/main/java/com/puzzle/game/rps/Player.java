package com.puzzle.game.rps;

import java.util.BitSet;
import java.util.Scanner;

public abstract class Player {
	
	protected Scanner inputScanner;
	protected String name;
	protected Weapon previousWeapon;
	/* this attribute will store the result of all games on bit format */
	protected BitSet score;

	public abstract Weapon playRound(int roundNumber);
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param previousRound the previousWeapon to set
	 */
	public void setPreviousWeapon(Weapon previousWeapon) {
		this.previousWeapon = previousWeapon;
	}

	/**
	 * @return the score
	 */
	public BitSet getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(BitSet score) {
		this.score = score;
	}

	/**
	 * Allowing to play a new round, this may take on count the strategy
	 * @return
	 */
	public boolean askForNewRound() {
		char result = 'N';
	    System.out.print("\nWould you like to play another round: Yes (y), No (n) ? ");
		String input = inputScanner.nextLine();
		if (input != null && input.length() > 0) {
			result = input.toUpperCase().charAt(0);
	    }  else {
	    	askForNewRound();
	    }
		return result == 'Y';        
  	}

	public void setInputScanner(Scanner inputScanner) {
		this.inputScanner = inputScanner;
	}
}
