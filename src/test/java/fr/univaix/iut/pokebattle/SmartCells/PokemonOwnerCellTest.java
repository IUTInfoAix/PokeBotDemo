package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonOwnerCell;


    
public class PokemonOwnerCellTest {

    PokemonOwnerCell cell = new PokemonOwnerCell();
    Twitter twitter = TwitterFactory.getSingleton();


    @Test
    public void testOwner() throws IllegalStateException, TwitterException {
    	System.out.println(cell.ask(new Tweet("azaz","@Smogogo who is your owner ?")));
       assertEquals("@azaz No owner", cell.ask(new Tweet("azaz","@Smogogo who is your owner ?")));
    }

    @Test
    public void testNotOwner() throws IllegalStateException, TwitterException {
       assertEquals("@azaz @CloudDeLuna is my owner", cell.ask(new Tweet("azaz","@GwenGoupix who is your owner ?")));
       System.out.println(cell.ask(new Tweet("azaz","@GwenGoupix who is your owner ?")));
    }

}
