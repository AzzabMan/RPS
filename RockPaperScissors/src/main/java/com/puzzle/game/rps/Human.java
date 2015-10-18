package com.puzzle.game.rps;

import java.util.Scanner;

public class Human extends Player {

	public Human(String name) {
		super.inputScanner = new Scanner(System.in);
		super.name = name;
	}

	@Override
	public Weapon playRound() {
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
					playRound();
				}
			}
		}
		return playRound();
	}
}
