package fr.univaix.iut.pokebattle.smartcell;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.twitter.Tweet;

/**
 * Reply to all.
 */
public class PokemonCriesCell implements SmartCell {

    public String ask(Tweet question) throws TwitterException {
        if (question.getScreenName() != null)
        {		
            return "@" + question.getScreenName() + " Pika pika";
        }
        
        return "Pika pika";
    }

}
