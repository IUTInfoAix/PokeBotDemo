package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.smartcell.PokeCell.PokemonCaptureCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaptureCellTest {

    PokemonCaptureCell cell = new PokemonCaptureCell();
    
    @Test
    public void testCaptureFalse() throws IllegalStateException, TwitterException 
    {
    	assertEquals("@CloudDeLuna @CloudDeLuna is my owner !", cell.ask(new Tweet("CloudDeLuna","@GwenGoupix pokeball goo !")));
    }
}