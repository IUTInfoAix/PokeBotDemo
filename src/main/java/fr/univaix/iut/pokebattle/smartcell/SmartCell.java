package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public interface SmartCell {
    /**
     * Ask a question... get an answer!
     *
     * @param question
     * @return the answer when the Cell can reply to the question
     *         or null.
     */
    String ask(Tweet question);
}
