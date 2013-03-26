package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

/**
 * Reply to all.
 */
public class PokemonCriesCell implements SmartCell {

    public String ask(Tweet question) {
        if (question.getScreenName() != null)
            return "@" + question.getScreenName() + " Pika pika";
        return "Pika pika";
    }

}
