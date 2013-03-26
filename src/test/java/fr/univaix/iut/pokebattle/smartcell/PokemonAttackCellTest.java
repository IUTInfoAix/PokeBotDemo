package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.smartcell.PokemonAttackCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttackCellTest {

	PokemonAttackCell cell = new PokemonAttackCell();

	@Test
	public void testAttack() throws IllegalStateException, TwitterException {		
		assertEquals(
				"J'attaque @GwenGoupix du dresseur @CloudDeLuna avec #charge!," +
				" sur ordre de mon dresseur qui est @cybsip", (cell.ask(new Tweet("cybsip",
				"@Smogogo13 #attack #charge @GwenGoupix /cc @CloudDeLuna"))));
	}

}