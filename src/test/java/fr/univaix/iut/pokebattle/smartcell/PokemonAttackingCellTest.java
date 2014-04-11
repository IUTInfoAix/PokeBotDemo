package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttackingCellTest {

	String cible = "PkmnDummy";
	String cibleown = "needsob";

	PokeBot pkmn = new PokeBot();
	
	public void setStat() {
		pkmn.getPokeStats().setName("Forkachu");
		pkmn.getPokeStats().setOwner("@Rwog");
		pkmn.getPokeStats().setRace("Pikachu");
		pkmn.getPokeStats().setDispo(true);
		pkmn.getPokeStats().setHPmax(50);
		pkmn.getPokeStats().setHPcurr(10);
	}
	
	@Test
	public void testAttackNonProprio() {
		setStat();
		assertEquals("@BadOwner @Rwog is my user", pkmn.ask(new Tweet("BadOwner","@Forkachu #attack #foudre @pkmncible /cc @cibleown")));
		
	}
	
	@Test
	public void testAttackProprio() {
		setStat();
		assertEquals("@pkmncible #attack #foudre! /cc @Rwog @cibleown", pkmn.ask(new Tweet("Rwog","@Forkachu #attack #foudre @pkmncible /cc @cibleown")));
	}
	
	@Test
	public void testWildPokemon() {
		setStat();
		pkmn.getPokeStats().setOwner(null);
		assertEquals("@Rwog Nobody can tell me what to do ! *middle finger*...*runs away*", pkmn.ask(new Tweet("Rwog","@Forkachu #attack #foudre @pkmncible /cc @cibleown")));
	}

}
