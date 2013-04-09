package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.smartcell.PokeCell.PokemonAttackCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttackCellTest {

	PokemonAttackCell cell = new PokemonAttackCell();

	@Test
	public void testAttack() throws IllegalStateException, TwitterException {		
		assertEquals(
				"@Smogogo13 #attack #charge /cc @cybsip @CloudDeLuna @Kyiio", (cell.ask(new Tweet("CloudDeLuna",
				"@Dracaufeu13 #attack #charge @Smogogo13 /cc @cybsip @Kyiio"))));
	}
//	pcreux: "@bulbizare1 #attack #charge @pikachuNyanNian /cc @nedseb"
	//	bulbizare1: "@pikachuNyanNian #attack #charge /cc @nedseb @pcreux"
}