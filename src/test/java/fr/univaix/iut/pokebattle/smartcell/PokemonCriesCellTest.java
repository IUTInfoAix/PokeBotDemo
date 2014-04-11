package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {
	
	PokeBot pkmn = new PokeBot();
	
	PokemonCriesCell cell = new PokemonCriesCell(pkmn.getPokeStats());

	public void setStat() {
		pkmn.getPokeStats().setName("Forkachu");
		pkmn.getPokeStats().setOwner("Rwog");
		pkmn.getPokeStats().setRace("Pikachu");
		pkmn.getPokeStats().setHPmax(50);
		pkmn.getPokeStats().setHPcurr(10);
	}
	
    @Test
    public void testSalut() {
		setStat();
        assertEquals("@usertest Hay !", pkmn.ask(new Tweet("usertest", "Hey salut!")));
    }

    @Test
    public void testNotSalut() {
    	setStat();
       assertEquals("@usertest Wut ?", pkmn.ask(new Tweet("usertest", "N'importe quoi")));
    }
    
    @Test
    public void testReturnNomEleveur() {
    	setStat();
    	assertEquals("@usertest Rwog is my owner", cell.ask(new Tweet("usertest", "Owner?")));
    }
    
    @Test
    public void testNoDresseur() {
    	setStat();
    	pkmn.getPokeStats().setOwner(null);
    	assertEquals("@person No owner", cell.ask(new Tweet("person", "Owner?")));
    }
}
