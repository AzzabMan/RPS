package com.puzzle.game.rps;

import static org.hamcrest.core.IsSame.sameInstance;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import com.puzzle.game.rps.Computer;
import com.puzzle.game.rps.Human;
import com.puzzle.game.rps.Player;
import com.puzzle.game.rps.Weapon;

public class PlayerTest {
	
	@Test
	public void should_get_random_weapon(){
		 Player player1 = new Computer("Computer");
		 Weapon weapon = player1.playRound();
		 Assert.assertTrue("No exception thrown", weapon!=null);
	}

	@Test
	public void should_launch_new_round(){
		 Player player1 = new Human("Payer");	
		 player1.setInputScanner(new Scanner("y"));
		 Assert.assertTrue(player1.askForNewRound());
	}

	@Test
	public void should_not_launch_new_round(){
		 Player player1 = new Human("Player");	
		 player1.setInputScanner(new Scanner("n"));
		 Assert.assertFalse(player1.askForNewRound());
	}
	
	@Test
	public void should_return_rock_when_typing_rxxx(){
		 Player player1 = new Human("Player");	
		 player1.setInputScanner(new Scanner("r"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.ROCK));
		 
		 player1.setInputScanner(new Scanner("rock"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.ROCK));

		 player1.setInputScanner(new Scanner("R"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.ROCK));

		 player1.setInputScanner(new Scanner("ROCK"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.ROCK));

	}

	@Test
	public void should_return_paper_when_typing_pxxx(){
		
		 Player player1 = new Human("Player");	
		 player1.setInputScanner(new Scanner("p"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.PAPER));
		 
		 player1.setInputScanner(new Scanner("paper"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.PAPER));

		 player1.setInputScanner(new Scanner("P"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.PAPER));

		 player1.setInputScanner(new Scanner("PAPER"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.PAPER));
		 
	}
	
	@Test
	public void should_return_scissors_when_typing_sxxx(){
		
		 Player player1 = new Human("Player");	
		 player1.setInputScanner(new Scanner("s"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.SCISSORS));
		 
		 player1.setInputScanner(new Scanner("scissors"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.SCISSORS));

		 player1.setInputScanner(new Scanner("S"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.SCISSORS));

		 player1.setInputScanner(new Scanner("SCISSORS"));
		 Assert.assertThat(player1.playRound(), sameInstance(Weapon.SCISSORS));
		 
	}	
	
}
