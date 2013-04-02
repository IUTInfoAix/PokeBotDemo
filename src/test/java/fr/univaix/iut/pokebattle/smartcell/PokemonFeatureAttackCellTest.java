package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonFeatureAttackCellTest {

	PokemonFeatureAttackCell cell = new PokemonFeatureAttackCell();
	
	@Test
	public void testRace() {
		//assertEquals("@CloudDeLuna #race = Goupix", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #race ?")));
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #statAttack #PP #Hurlement ?")));
	}

}
