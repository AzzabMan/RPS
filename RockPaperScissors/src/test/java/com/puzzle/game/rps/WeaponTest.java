package com.puzzle.game.rps;

import org.junit.Assert;
import org.junit.Test;

import com.puzzle.game.rps.Weapon;

public class WeaponTest {

	@Test
	public void shoud_verify_all_scenarios(){
		Weapon rock = Weapon.ROCK;
		Weapon paper = Weapon.PAPER;
		Weapon scissors = Weapon.SCISSORS;
		
		// test All wining possible scenarios
		Assert.assertSame(rock.compareWeapon(scissors), 1);
		Assert.assertSame(paper.compareWeapon(rock), 1);
		Assert.assertSame(scissors.compareWeapon(paper), 1);
		Assert.assertSame(paper.compareWeapon(rock), 1);
		
		// test All loosing possible scenarios
		Assert.assertSame(scissors.compareWeapon(rock), -1);
		Assert.assertSame(rock.compareWeapon(paper), -1);
		Assert.assertSame(paper.compareWeapon(scissors), -1);
		Assert.assertSame(rock.compareWeapon(paper), -1);	
		
		// test All tie possible scenarios
		Assert.assertSame(scissors.compareWeapon(scissors), 0);
		Assert.assertSame(rock.compareWeapon(rock), 0);
		Assert.assertSame(paper.compareWeapon(paper), 0);
		
	}
	
}
