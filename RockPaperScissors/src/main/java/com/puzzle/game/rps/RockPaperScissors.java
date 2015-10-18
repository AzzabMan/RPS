package com.puzzle.game.rps;

import java.util.Scanner;

public class RockPaperScissors {
    private static final Scanner SCANNER = new Scanner(System.in);
    
	private Player player1;
    private Player player2;
 
    public static void main(String[] args) {
    	RockPaperScissors game = new RockPaperScissors();
    	game.showMainMenu();
    	game.launchGame();
    }

    private void showMainMenu(){
		// Display menu allowing to chose the type of game
    	printEqualChar(40);
		System.out.println("\n|   Welcome to Rock, Paper, Scissors   |");
		printEqualChar(40);
		System.out.println("\n| Options:                             |");
		System.out.println("|        1. Player vs Computer         |");
		System.out.println("|        2. Computer vs Computer       |");
		System.out.println("|        3. Exit                       |");
		printEqualChar(40);
		System.out.print("\n");

		String input = SCANNER.nextLine();
		if (input != null && input.length() > 0) {
			switch (input.charAt(0)) {
			case '1': // AI vs Human
				System.out.println("Option 1 selected");
		    	player1 = new Human("You");
		    	player2 = new Computer("Computer");
				break;
			case '2': // AI vs AI
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
    
    private void launchGame() {
    	
    	Weapon weapon1 = player1.playRound();
    	Weapon weapon2 = player2.playRound();
    	
    	System.out.println("\n" + player1.getName() + " played " + weapon1);
    	System.out.println(player2.getName() + " played " + weapon2 + "\n");
    	
    	// Compare weapons and determine winner
    	int result = weapon1.compareWeapon(weapon2);
    	switch (result) {
    	case 0:
    		System.out.println("Tie round !");
    		player1.incrementTies();
    		player2.incrementTies();
    		// this will undo the strategy
    		player1.setPreviousRound(null); 		
    		player2.setPreviousRound(null);    		
    		break;
    	case 1: // player1 win, player2 lose
    		System.out.println(weapon1 + " beats " + weapon2 + ": " + player1.getName() + " won");
    		player1.incrementWins();
    		player2.incrementLosses();
    		// feed fields for future strategy
    		player1.setPreviousRound(weapon1);
    		// if the AI wins 2 consecutive rounds, they change for the 2rd round with the new weapon (R,P,S): 1 XOR(^) 1 = 0
    		player1.setPreviousScore((byte) ( 1 ^ player1.getPreviousScore()));	
    		player2.setPreviousRound(weapon2);
    		player2.setPreviousScore((byte)0); 		
    		break;
    	case -1: // player1 lose, player2 win
    		System.out.println(weapon2 + " beats " + weapon1 + ": " + player2.getName() + " won");
    		player1.incrementLosses();
    		player2.incrementWins();
    		// feed fields for future strategy
    		player1.setPreviousRound(weapon1);
    		player1.setPreviousScore((byte)0);    		
    		player2.setPreviousRound(weapon2);
    		// if the AI wins 2 consecutive rounds, they change for the 2rd round with the new weapon (R,P,S): 1 XOR(^) 1 = 0    		
    		player2.setPreviousScore((byte) ( 1 ^ player2.getPreviousScore()));	  		
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
    	printEqualChar(40);
    	
    	System.out.printf("\n| PLAYER    | WINS   | LOSSES | TIES   |\n");
    	
    	System.out.print("|");
    	printEqualChar(38);
    	System.out.println("|");

    	printScoreForPlayer(player1);
    	printScoreForPlayer(player2);
    	
    	printEqualChar(40);
    }
    
    private void printScoreForPlayer(Player player){
    	System.out.format("| %-9s ", player.getName());
    	System.out.format("| %-6s ", player.getNumberWins());
    	System.out.format("| %-6s ", player.getNumberLosses());
    	System.out.format("| %-6s |\n", player.getNumberTies());    	
    }
    
    private void printEqualChar(int number) {
    	for (int i = 0; i < number; i++) {
    		System.out.print("=");
    	}
    }

}