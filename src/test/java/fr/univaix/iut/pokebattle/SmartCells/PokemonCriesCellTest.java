package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();
    Twitter twitter = TwitterFactory.getSingleton();
    
    @Test
    public void testSalut() {
        assertEquals("@azaz Pika pika", cell.ask(new Tweet("azaz","Salut!")));
    }

    @Test
    public void testNotSalut() {
        assertEquals("@azaz Pika pika", cell.ask(new Tweet("azaz","au revoir")));
    }
    
    @Test
    public void testNom () throws IllegalStateException, TwitterException
    {
    	System.out.println(twitter.getScreenName());
    }

}
