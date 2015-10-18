package com.puzzle.game.rps;

import java.util.Scanner;

public class Computer extends Player{
	
    public Computer(String name) {
        super.inputScanner = new Scanner(System.in);
        super.name = name;
    }
    
	@Override
	public Weapon playRound() {
		int strategy = (int) (Math.random() * 3);
		
		if (previousRound != null) {
			// if the AI win, it will play the same game, this can happen only two successive times
			if(previousScore == 1) {
				strategy = previousRound.ordinal();
			}
	
			// if the AI lose OR win two consecutive rounds it will play different weapon in the order ROCK,PAPER,SCISSORS
			if(previousScore == 0) {
				switch (previousRound) {
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
		
        return Weapon.values()[strategy];
    }
	
}
