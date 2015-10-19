package com.puzzle.game.rps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PuzzleGameTest {

	@Test
	public void should_launch_one_round_game() {
//    	RockPaperScissors game = new RockPaperScissors();
//    	ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
//    	System.setIn(in);
////    	System.setIn(System.in);
//    	game.showMainMenu();
//    	game.launchGame();
		List list = new ArrayList<Weapon>(Arrays.asList(Weapon.values()));
		list.remove(Weapon.PAPER);
		list.remove(Weapon.PAPER);
		
	}
	
	
	public void should_return_rock_vs_paper()  {
		
	}

}
