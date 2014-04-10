package fr.univaix.iut.pokebattle.twitter;

import fr.univaix.iut.pokebattle.bot.Bot;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.tuse.TUSEException;
import fr.univaix.iut.pokebattle.tuse.TwitterUserStreamEasy;
import twitter4j.Twitter;

public class TwitterBot {
    private TwitterUserStreamEasy twitterUserStreamEasy;

    public TwitterBot(final Bot bot, final Credentials credentials) {
        Twitter twitter = new TwitterBuilder(credentials).build();
        this.twitterUserStreamEasy =
                new TwitterUserStreamEasyBuilder(credentials,
                        twitter, bot).build();
    }

    public final void startBot() throws TUSEException {
        twitterUserStreamEasy.oauth();
    }

}
