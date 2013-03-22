package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonCaptureCell;

public class PokemonCaptureCellTest {

    PokemonCaptureCell cell = new PokemonCaptureCell();
    
    @Test
    public void testCaptureFalse() throws IllegalStateException, TwitterException 
    {
    	assertEquals("@azaz @cybsip is my owner !", cell.ask(new Tweet("azaz","@Smogogo13 pokeball goo !")));
    }
}