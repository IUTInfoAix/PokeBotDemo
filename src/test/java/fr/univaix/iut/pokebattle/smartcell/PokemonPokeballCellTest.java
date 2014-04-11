package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;

public class PokemonPokeballCellTest {

	PokeBot pkmn = new PokeBot();

	public void setStat() {
		pkmn.getPokeStats().setName("Forkachu");
		pkmn.getPokeStats().setOwner("@Rwog");
		pkmn.getPokeStats().setRace("Pikachu");
		pkmn.getPokeStats().setHPmax(50);
		pkmn.getPokeStats().setHPcurr(10);
	}


	@Test
	public void testPokeballOnAlreadyCaught() {
		setStat();
		assertEquals("@person @Rwog is my owner!", pkmn.ask(new Tweet("person", "Pokeball!")));
	}

	@Test
	public void testPokeballOnWildPkmn() {
		setStat();

		pkmn.getPokeStats().setOwner(null);
		assertEquals("@person You caught me !", pkmn.ask(new Tweet("person", "Pokeball!")));
	}	
}
