package fr.univaix.iut.pokebattle.bot;

import twitter4j.Twitter;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public interface Bot {
    String ask(Tweet question);
    void setTwitter(Twitter twit);
}

