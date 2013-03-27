package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonFeatureCellTest {

    PokemonFeatureCell cell = new PokemonFeatureCell();
	
	@Test
	public void test() {
        assertEquals("@CloudDeLuna #race = Goupix", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #race ?")));

	}
	

}
