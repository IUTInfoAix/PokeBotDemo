package fr.univaix.iut.pokebattle;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.UserStreamListener;

import com.twitter.hbc.httpclient.ControlStreamException;

import fr.univaix.iut.pokebattle.Bot;
import fr.univaix.iut.pokebattle.PokeBot;
import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.tuse.TwitterUserStreamEasy;
import fr.univaix.iut.pokebattle.tuse.UserStreamAdapter;

public class TwitterBot {
    private final static Logger logger = LoggerFactory.getLogger(TwitterBot.class);

    TwitterUserStreamEasy twitterUserStreamEasy;
    Twitter twitter = TwitterFactory.getSingleton();

    public TwitterBot(final Bot bot) {
        UserStreamListener listener = new UserStreamAdapter() {

            public void onStatus(Status status) {
                try {
                    logger.info("TwitterUserStreamEasyExample.onStatus()");
                    if (isTweetOfMe(status) || !isTweetForMe(status)) {
                        logger.info("Ignored status change");
                        return;
                    }

                    String response = bot.ask(new Tweet(status.getUser().getScreenName(), status.getText()));

                    if (response != null)
                        twitter.updateStatus(response);

                } catch (TwitterException e) {
                    e.printStackTrace();
                }
            }
        };

        twitterUserStreamEasy = new TwitterUserStreamEasy(listener);
    }

    public void startBot() throws InterruptedException, ControlStreamException, IOException {
        twitterUserStreamEasy.oauth();
    }

    private boolean isTweetForMe(Status status) throws TwitterException {
        return status.getText().contains(twitter.getScreenName());
    }

    private boolean isTweetOfMe(Status status) throws TwitterException {
        return status.getUser().getId() == twitter.getId();
    }

    public static void main(String[] args) {

        try {
            TwitterBot twitterBot = new TwitterBot(new PokeBot());
            twitterBot.startBot();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ControlStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
