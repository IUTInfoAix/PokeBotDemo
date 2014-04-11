package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCheckDispoTest {

	PokeBot pkmn = new PokeBot();
	PokemonCheckDispoCell cell = new PokemonCheckDispoCell(pkmn.getPokeStats());
	
	@Test
	public void testDispo() {
		pkmn.getPokeStats().setDispo(true);
		assertEquals("next_cell", cell.ask(new Tweet("...")));
	}
	
	@Test
	public void testNonDispo() {
		pkmn.getPokeStats().setDispo(false);
		assertEquals("@usr I'm currently healing at the Pokemon Center.", cell.ask(new Tweet("usr","@forkachu #attack ")));
	}

}
