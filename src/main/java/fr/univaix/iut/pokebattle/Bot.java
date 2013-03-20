package fr.univaix.iut.pokebattle;

import twitter4j.TwitterException;

public interface Bot {
    String ask(Tweet question) throws IllegalStateException, TwitterException;
}
