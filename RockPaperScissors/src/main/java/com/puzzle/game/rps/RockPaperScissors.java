package com.puzzle.game.rps;

import java.util.Scanner;

public class RockPaperScissors {
    private Scanner scanner;
    private int roundsCount;
    private int tiesCount;
	private Player player1;
    private Player player2;
 
    public static void main(String[] args) {
    	RockPaperScissors game = new RockPaperScissors();
    	game.showMainMenu();
    	game.launchGame();
    }
    
    public RockPaperScissors(){
    	scanner = new Scanner(System.in);
    }

    void showMainMenu(){
		// Display menu allowing to chose the type of game
    	printEqualCharacter(40);
		System.out.println("\n|   Welcome to Rock, Paper, Scissors   |");
		printEqualCharacter(40);
		System.out.println("\n| Options:                             |");
		System.out.println(  "|        1. Player vs Computer         |");
		System.out.println(  "|        2. Computer vs Computer       |");
		System.out.println(  "|        3. Exit                       |");
		printEqualCharacter(40);
		System.out.print("\n");

		String input = scanner.nextLine();
		if (input != null && input.length() > 0) {
			switch (input.charAt(0)) {
			case '1': // AI versus Human
				System.out.println("Option 1 selected");
		    	player1 = new Human("You");
		    	player2 = new Computer("Computer");
				break;
			case '2': // AI versus AI
				System.out.println("Option 2 selected");
		    	player1 = new Computer("Computer1");
		    	player2 = new Computer("Computer2");			
				break;
			case '3':
				System.out.println("Exit selected");
				System.exit(0);
			default:
				System.out.println("Invalid selection");
				showMainMenu();
			}
		} else {
			System.out.println("Invalid selection");
			showMainMenu();
		}
    }
    
    void launchGame() {
    	
    	Weapon weapon1 = player1.playRound(roundsCount);
    	Weapon weapon2 = player2.playRound(roundsCount);
    	
    	System.out.println("\n" + player1.getName() + " played " + weapon1);
    	System.out.println(player2.getName() + " played " + weapon2 + "\n");
    	
    	// Compare weapons and determine winner
    	int result = weapon1.compareWeapon(weapon2);
    	switch (result) {
    	case 0:
    		System.out.println("Tie round !");
    		tiesCount++;
    		// this will undo the strategy
    		player1.setPreviousWeapon(null); 		
    		player2.setPreviousWeapon(null);  		
    		break;
    	case 1: // player1 win, player2 lose
    		System.out.println(weapon1 + " beats " + weapon2 + ": " + player1.getName() + " won");
    		// feed fields for future strategy
    		player1.setPreviousWeapon(weapon1);
    		player2.setPreviousWeapon(weapon2);
    		player1.getScore().set(roundsCount);
    		roundsCount++;
    		break;
    	case -1: // player1 lose, player2 win
    		System.out.println(weapon2 + " beats " + weapon1 + ": " + player2.getName() + " won");
    		// feed fields for future strategy
    		player1.setPreviousWeapon(weapon1);
    		player2.setPreviousWeapon(weapon2);
    		player2.getScore().set(roundsCount);
    		roundsCount++;
    		break;
    	}
    	
    	// ask to play a new round
    	if (player1.askForNewRound()) {
    		launchGame();
    	} else {
    		printFinalStats();
    	}
    }
    
    /**
     * Printout the final score
     */
    private void printFinalStats() {
    	System.out.println("\nResults :");
    	printEqualCharacter(40);
    	
    	System.out.printf("\n| PLAYER    | WINS   | LOSSES | TIES   |\n");
    	
    	System.out.print("|");
    	printEqualCharacter(38);
    	System.out.println("|");

    	printScoreForPlayer(player1);
    	printScoreForPlayer(player2);
    	
    	printEqualCharacter(40);
    }
    
    private void printScoreForPlayer(Player player){
    	System.out.format("| %-9s ", player.getName());
    	System.out.format("| %-6s ", player.getScore().cardinality());
    	// numberOfLoses = numberRounds - (numberTies + numberWins)
    	System.out.format("| %-6s ", roundsCount - tiesCount - player.getScore().cardinality());
    	System.out.format("| %-6s |\n", tiesCount);    	
    }
    
    private void printEqualCharacter(int number) {
    	for (int i = 0; i < number; i++) {
    		System.out.print("=");
    	}
    }

}