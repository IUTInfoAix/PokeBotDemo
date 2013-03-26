package fr.univaix.iut.pokebattle.bot;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public interface Bot {
    String ask(Tweet question) throws IllegalStateException, TwitterException;
}
