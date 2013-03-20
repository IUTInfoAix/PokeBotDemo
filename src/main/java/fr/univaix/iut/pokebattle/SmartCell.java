package fr.univaix.iut.pokebattle;

import twitter4j.TwitterException;

public interface SmartCell {
    /**
     * Ask a question... get an answer!
     *
     * @param question
     * @return the answer when the Cell can reply to the question
     *         or null.
     * @throws TwitterException 
     * @throws IllegalStateException 
     */
    public abstract String ask(Tweet question) throws IllegalStateException, TwitterException;
}
