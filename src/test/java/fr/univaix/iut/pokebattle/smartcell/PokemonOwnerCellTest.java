package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.smartcell.PokemonOwnerCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;



    
public class PokemonOwnerCellTest {

    PokemonOwnerCell cell = new PokemonOwnerCell();
    
    @Test
    public void testOwner() throws IllegalStateException, TwitterException {
    	System.out.println(cell.ask(new Tweet("azaz","@Smogogo13 who is your owner ?")));
       assertEquals("@azaz @cybsip is my owner", cell.ask(new Tweet("azaz","@Smogogo13 who is your owner ?")));
    }

    @Test
    public void testNotOwner() throws IllegalStateException, TwitterException {
       assertEquals("@azaz @CloudDeLuna is my owner", cell.ask(new Tweet("azaz","@GwenGoupix who is your owner ?")));
       System.out.println(cell.ask(new Tweet("azaz","@GwenGoupix who is your owner ?")));
    }
}
