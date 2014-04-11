package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.tuse.TUSEException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.TwitterException;


public class PokemonMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonMain.class);

    public static void main(String[] args) throws TwitterException {
        try {
            BotRunner.runBot(new PokeBot(), "twitter4j.properties");
        } catch (TUSEException | IllegalStateException e) {
            LOGGER.error("Erreur sérieuse dans le BotRunner", e);
        }
    }
}
