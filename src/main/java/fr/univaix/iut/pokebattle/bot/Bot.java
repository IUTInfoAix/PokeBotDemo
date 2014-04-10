package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;


public interface Bot {
    void setTwitter(Twitter twitter);
    String ask(Tweet question) throws TwitterException;
}
