package com.puzzle.game.rps;

import java.util.BitSet;
import java.util.Scanner;

public class Human extends Player {

	public Human(String name) {
		super.inputScanner = new Scanner(System.in);
		super.name = name;
		super.score = new BitSet();
	}

	@Override
	public Weapon playRound(int roundNumber) {
		System.out.println("\nPlease make a choice: Rock (r), Paper (p), or Scissors (s) ?");

		// read user input from console
		String userInput = inputScanner.nextLine();
		if (userInput != null && userInput.length() > 0) {
			char firstCharacter = userInput.toUpperCase().charAt(0);
			if (firstCharacter == 'R' || firstCharacter == 'P' || firstCharacter == 'S') {
				switch (firstCharacter) {
				case 'R':
					return Weapon.ROCK;
				case 'P':
					return Weapon.PAPER;
				case 'S':
					return Weapon.SCISSORS;
				default:
					playRound(roundNumber);
				}
			}
		}
		return playRound(roundNumber);
	}
}
