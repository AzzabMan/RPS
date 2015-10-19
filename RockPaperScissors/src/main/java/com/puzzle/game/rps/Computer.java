package com.puzzle.game.rps;

import java.util.BitSet;
import java.util.Scanner;

public class Computer extends Player {
	
    public Computer(String name) {
        super.inputScanner = new Scanner(System.in);
        super.name = name;
        super.score = new BitSet();
    }
    
	@Override
	public Weapon playRound(int roundNumber) {
		// default strategy is 1/3, 1/3, 1/3 : used in case of first game, tie round,
		int strategy = (int) (Math.random() * 3);

		if (previousWeapon != null) {
			
			if (roundNumber > 0) { // more than one rounds

				// if the AI wins, it will play the same game // this can happen
				// only two successive times
				if (score.get(roundNumber - 1)) {
					strategy = previousWeapon.ordinal();
				} else {
					// if the AI loses, it will play different weapon in the
					// order ROCK, PAPER, SCISSORS
					switch (previousWeapon) {
					case ROCK:
						strategy = Weapon.PAPER.ordinal();
						break;
					case PAPER:
						strategy = Weapon.SCISSORS.ordinal();
						break;
					case SCISSORS:
						strategy = Weapon.ROCK.ordinal();
						break;
					}
				}
			}
		}
		return Weapon.values()[strategy];
    }
	
}
