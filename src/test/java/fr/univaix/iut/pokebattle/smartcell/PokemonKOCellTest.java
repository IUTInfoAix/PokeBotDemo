package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonKOCellTest {

	@Test
	public void test() {
		PokemonKOCell cell = new PokemonKOCell();
		
		assertEquals("#KO /cc @Kyiio @cybsip @CloudDeLuna", cell.ask(new Tweet("Kyiio", "@GwenGoupix -10pv /cc @CloudDeLuna")));
	}

}
