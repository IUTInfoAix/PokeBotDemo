package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;
import org.junit.Test;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCenterCellTest {

	PokeBot pkmn = new PokeBot();
	PokemonCenterCell cell = new PokemonCenterCell(pkmn.getPokeStats());
	@Test
	public void testHeal() {
		pkmn.getPokeStats().setOwner("Rwog");
		pkmn.getPokeStats().setHPcurr(10);
		pkmn.getPokeStats().setHPmax(50);
		
		// Not enough Time To finish
	}

}
