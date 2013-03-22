package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.*;

import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonAttackCell;

public class PokemonAttackCellTest {

	PokemonAttackCell cell = new PokemonAttackCell();
	Twitter twitter = TwitterFactory.getSingleton();

	@Test
	public void testAttack() throws IllegalStateException, TwitterException {		
		assertEquals(
				"J'attaque @GwenGoupix du dresseur @CloudDeLuna avec #charge!," +
				" sur ordre de mon dresseur qui est @cybsip", (cell.ask(new Tweet("cybsip",
				"@Smogogo13 #attack #charge @GwenGoupix /cc @CloudDeLuna"))));
	}

}
