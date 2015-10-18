package com.puzzle.game.rps;

public enum Weapon {
	
    ROCK, PAPER, SCISSORS;

    /**
     * Compares current weapon to determine witch one is the winner
     * @param other
     * @return 	<b>1</b> if current weapon beats the other weapon
     * 			<br> 
     * 			<b>-1</b> if current weapon loses against the other weapon
     * 			<br>
     * 			<b>0</b> if these the result is a tie
     */
    public int compareWeapon(Weapon other) {
        if (this == other) {
            return 0;
        }

        switch (this) {
        case ROCK:
            return (PAPER.equals(other) ? -1 : 1);
        case PAPER:
            return (SCISSORS.equals(other) ? -1 : 1);
        case SCISSORS:
            return (ROCK.equals(other) ? -1 : 1);
        }

        return 0;
    }
}
