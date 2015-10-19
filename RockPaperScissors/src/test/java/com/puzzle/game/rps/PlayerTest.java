package com.puzzle.game.rps;

import static org.hamcrest.core.IsSame.sameInstance;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void should_use_strategy_re_use_same_while_winning(){
		 Player player1 = new Computer("Computer");
		 player1.setPreviousWeapon(Weapon.ROCK);
		 BitSet score = new BitSet();
		 score.set(0);
		 player1.setScore(score);
		 Assert.assertThat(player1.playRound(1), sameInstance(Weapon.ROCK));
		 score.set(1);
		 Assert.assertThat(player1.playRound(2), sameInstance(Weapon.ROCK));
	}

	@Test
	public void should_use_strategy_go_to_next_weapon_while_loosing(){
		 Player player1 = new Computer("Computer");
		 player1.setPreviousWeapon(Weapon.ROCK);
		 Assert.assertThat(player1.playRound(1), sameInstance(Weapon.PAPER));
		 player1.setPreviousWeapon(Weapon.PAPER);
		 Assert.assertThat(player1.playRound(2), sameInstance(Weapon.SCISSORS));
		 player1.setPreviousWeapon(Weapon.SCISSORS);
		 Assert.assertThat(player1.playRound(3), sameInstance(Weapon.ROCK));
	}
	
	@Test
	public void should_use_default_strategy(){
		 Player player1 = new Computer("Computer");
		 Weapon weapon = player1.playRound(0);
		 Assert.assertTrue("No exception thrown", weapon!=null);
		 Assert.assertTrue(Arrays.asList(Weapon.values()).contains(weapon));  
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
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.ROCK));
		 
		 player1.setInputScanner(new Scanner("rock"));
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.ROCK));

		 player1.setInputScanner(new Scanner("R"));
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.ROCK));

		 player1.setInputScanner(new Scanner("ROCK"));
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.ROCK));

	}

	@Test
	public void should_return_paper_when_typing_pxxx(){
		
		 Player player1 = new Human("Player");	
		 player1.setInputScanner(new Scanner("p"));
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.PAPER));
		 
		 player1.setInputScanner(new Scanner("paper"));
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.PAPER));

		 player1.setInputScanner(new Scanner("P"));
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.PAPER));

		 player1.setInputScanner(new Scanner("PAPER"));
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.PAPER));
		 
	}
	
	@Test
	public void should_return_scissors_when_typing_sxxx(){
		
		 Player player1 = new Human("Player");	
		 player1.setInputScanner(new Scanner("s"));
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.SCISSORS));
		 
		 player1.setInputScanner(new Scanner("scissors"));
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.SCISSORS));

		 player1.setInputScanner(new Scanner("S"));
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.SCISSORS));

		 player1.setInputScanner(new Scanner("SCISSORS"));
		 Assert.assertThat(player1.playRound(0), sameInstance(Weapon.SCISSORS));
		 
	}	
	
}
