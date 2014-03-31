package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PkmnFightCellTest {

	PkmnFightCell cell = new PkmnFightCell();

	@Test
	public void fightTest() {
		assertEquals("",
				cell.ask(new Tweet("nedseb", "@gantben #fight with @ronflex /cc @marclap")));
	}

}
