package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();
    Twitter twitter = TwitterFactory.getSingleton();

    @Test
    public void testSalut() {
        assertEquals("@nedseb Pika pika", cell.ask(new Tweet("nedseb", "Salut!")));
    }

    @Test
    public void testNotSalut() {
        assertEquals("@nedseb Pika pika", cell.ask(new Tweet("nedseb", "au revoir")));
    }
    
    @Test
    public void testNom () throws IllegalStateException, TwitterException
    {
    	Tweet Twt = new Tweet("nedseb", "au revoir");
    	System.out.println(Twt.getScreenName());
    }

}
