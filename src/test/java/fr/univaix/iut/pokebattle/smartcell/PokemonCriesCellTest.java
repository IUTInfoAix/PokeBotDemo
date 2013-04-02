package fr.univaix.iut.pokebattle.smartcell;


import fr.univaix.iut.pokebattle.twitter.Tweet;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {
	
    @Test
    public void testSalut() {
    	PokemonCriesCell cell = new PokemonCriesCell();
    	
    	assertEquals("@nedseb Pika pika", cell.ask(new Tweet("nedseb", "@PIKACHU_PKWEM Salut!")));
    }

    @Test
    public void testNotSalut() {
    	PokemonCriesCell cell = new PokemonCriesCell();
    	
        assertEquals("@nedseb Pika pika", cell.ask(new Tweet("nedseb", "@PIKACHU_PKWEM au revoir")));
    }
    

}
