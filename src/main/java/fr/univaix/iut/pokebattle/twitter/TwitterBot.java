package fr.univaix.iut.pokebattle.twitter;

import com.twitter.hbc.httpclient.ControlStreamException;
import fr.univaix.iut.pokebattle.bot.Bot;
import fr.univaix.iut.pokebattle.tuse.TwitterUserStreamEasy;
import twitter4j.Twitter;

import java.io.IOException;

public class TwitterBot {
    TwitterUserStreamEasy twitterUserStreamEasy;
    Twitter twitter;

    public TwitterBot(final Bot bot, Credentials credentials) {
        this.twitter = new TwitterBuilder(credentials).build();
        this.twitterUserStreamEasy = new TwitterUserStreamEasyBuilder(twitter, bot).build();
    }

    public void startBot() throws InterruptedException, ControlStreamException, IOException {
        twitterUserStreamEasy.oauth();
    }

}
