package fr.univaix.iut.pokebattle.run;

import com.twitter.hbc.httpclient.ControlStreamException;
import fr.univaix.iut.pokebattle.bot.Bot;
import fr.univaix.iut.pokebattle.twitter.Credentials;
import fr.univaix.iut.pokebattle.twitter.TwitterBot;

import java.io.IOException;
import java.io.InputStream;

import twitter4j.TwitterException;

public class BotRunner {
    static public void runBot(Bot bot, String credentialsFileName) {
        try {
            InputStream inputStream = getResourceAsStream(credentialsFileName);
            Credentials credentials = Credentials.loadCredentials(inputStream);
            TwitterBot twitterBot = new TwitterBot(bot, credentials);
            twitterBot.startBot();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ControlStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TwitterException e) {
			e.printStackTrace();
		}
    }

    static InputStream getResourceAsStream(String fileName) {
        return PokemonMain.class.getClassLoader().getResourceAsStream(fileName);
    }
}