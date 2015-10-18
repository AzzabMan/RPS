package com.puzzle.game.rps;

import java.util.Scanner;

public abstract class Player {
	
	protected Scanner inputScanner;
	private int numberWins;
	private int numberLosses;
	private int numberTies;
	protected String name;
	protected Weapon previousRound;
	protected byte previousScore;
	
	public abstract Weapon playRound();
	
	public int incrementLosses() {
		return ++numberLosses;
	}

	public int incrementWins() {
		return ++numberWins;
	}

	public int incrementTies() {
		return ++numberTies;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the numberWins
	 */
	public int getNumberWins() {
		return numberWins;
	}

	/**
	 * @return the numberLosses
	 */
	public int getNumberLosses() {
		return numberLosses;
	}

	/**
	 * @return the numberTies
	 */
	public int getNumberTies() {
		return numberTies;
	}
	
	/**
	 * @param previousRound the previousRound to set
	 */
	public void setPreviousRound(Weapon previousRound) {
		this.previousRound = previousRound;
	}

	/**
	 * @param previousScore the previousScore to set
	 */
	public void setPreviousScore(byte previousScore) {
		this.previousScore = previousScore;
	}
	
	/**
	 * @return the previousScore
	 */
	public byte getPreviousScore() {
		return previousScore;
	}

	/**
	 * Allowing to play a new round, this may take on count the strategy
	 * @return
	 */
	public boolean askForNewRound() {
		char result = 'N';
	    System.out.print("\nWould you like to play another round ? ");
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
