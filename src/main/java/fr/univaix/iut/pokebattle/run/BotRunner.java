package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.Bot;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.tuse.TUSEException;
import fr.univaix.iut.pokebattle.twitter.TwitterBot;

import java.io.IOException;
import java.io.InputStream;

public class BotRunner {

    public static void runBot(Bot bot, String credentialsFileName) throws TUSEException {
        try (InputStream inputStream = getResourceAsStream(credentialsFileName)) {
            Credentials credentials = Credentials.loadCredentials(inputStream);
            TwitterBot twitterBot = new TwitterBot(bot, credentials);
            twitterBot.startBot();
        } catch (IOException e) {
            throw new TUSEException("Input error on credentials loading", e);
        }
    }

    static InputStream getResourceAsStream(String fileName) {
        return PokemonMain.class.getClassLoader().getResourceAsStream(fileName);
    }
    
}
