package fr.univaix.iut.pokebattle.twitter;

import fr.univaix.iut.pokebattle.bot.Bot;
import fr.univaix.iut.pokebattle.tuse.Credentials;
import fr.univaix.iut.pokebattle.tuse.TwitterUserStreamEasy;
import fr.univaix.iut.pokebattle.tuse.UserStreamAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.UserStreamListener;

public class TwitterUserStreamEasyBuilder {
    private static final Logger LOGGER =
    LoggerFactory.getLogger(TwitterBot.class);
    private Credentials credentials;
    private Twitter twitter;
    private Bot bot;

    public TwitterUserStreamEasyBuilder(final Credentials credentials, final Twitter twitter, final Bot bot) {
        this.credentials = credentials;
        this.twitter = twitter;
        this.bot = bot;
    }

    public final TwitterUserStreamEasy build() {
        UserStreamListener listener = new UserStreamAdapter() {
            @Override
            public void onStatus(final Status status) {
                LOGGER.info("TwitterUserStreamEasyExample.onStatus()");
                try {
                    processNewQuestion(status, bot);
                } catch (TwitterException e) {
                    LOGGER.error("Twitter Error", e);
                }
            }
        };
        return new TwitterUserStreamEasy(listener, credentials);
    }

    private void processNewQuestion(final Status status, final Bot bot) throws TwitterException {
        if (isNotANewQuestion(status)) {
            LOGGER.info("Ignored status change");
            return;
        }

        String response = bot.ask(new Tweet(status.getUser()
                .getScreenName(), status.getText()));

        if (response != null) {
            twitter.updateStatus(response);
        }
    }

    private boolean isNotANewQuestion(final Status status)
            throws TwitterException {
        return isTweetOfMe(status) || !isTweetForMe(status);
    }

    private boolean isTweetForMe(final Status status) throws TwitterException {
        return status.getText().toLowerCase()
                .contains(twitter.getScreenName().toLowerCase());
    }

    private boolean isTweetOfMe(final Status status) throws TwitterException {
        return status.getUser().getId() == twitter.getId();
    }
}