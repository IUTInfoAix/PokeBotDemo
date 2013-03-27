package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public interface Bot {
    String ask(Tweet question);
}
