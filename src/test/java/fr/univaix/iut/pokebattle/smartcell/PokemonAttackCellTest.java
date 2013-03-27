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
				"@GwenGoupix #attack #charge /cc @CloudDeLuna @cybsip @zaza13", (cell.ask(new Tweet("cybsip",
				"@Smogogo13 #attack #charge @GwenGoupix /cc @CloudDeLuna @zaza13"))));
	}
//	pcreux: "@bulbizare1 #attack #charge @pikachuNyanNian /cc @nedseb"
	//	bulbizare1: "@pikachuNyanNian #attack #charge /cc @nedseb @pcreux"
}