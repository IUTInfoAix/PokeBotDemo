package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonKOAlertTest {

	
	PokeBot pkmn = new PokeBot();
	PokemonKOAlertCell cell = new PokemonKOAlertCell(pkmn.getPokeStats());
	

	@Test
	public void testDecreaseHPK() {
		pkmn.getPokeStats().setName("Forkachu");
		pkmn.getPokeStats().setOwner("Rwog");
		pkmn.getPokeStats().setRace("Pikachu");
		pkmn.getPokeStats().setHPmax(50);
		pkmn.getPokeStats().setHPcurr(10);
		
		assertEquals("#KO", cell.ask(new Tweet("arbitre", "@Forkachu -10HP /cc @RwogM")));
	}

}
