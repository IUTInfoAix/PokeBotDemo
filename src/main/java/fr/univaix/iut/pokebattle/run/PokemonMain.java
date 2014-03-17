package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.JudgeBot;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.tuse.TUSEException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PokemonMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonMain.class);

    private PokemonMain() {

    }

    public static void main(String[] args) {
        try {
            BotRunner.runBot(new JudgeBot(), "twitter4j.properties");
        } catch (TUSEException e) {
            LOGGER.error("Erreur sérieuse dans le BotRunner", e);
        }
    }
}
