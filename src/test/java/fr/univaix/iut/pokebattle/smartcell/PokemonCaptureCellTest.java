package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.smartcell.PokemonCaptureCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCaptureCellTest {

    PokemonCaptureCell cell = new PokemonCaptureCell();
    
    @Test
    public void testCaptureFalse() throws IllegalStateException, TwitterException 
    {
    	assertEquals("@azaz @cybsip is my owner !", cell.ask(new Tweet("azaz","@Smogogo13 pokeball goo !")));
    }
}