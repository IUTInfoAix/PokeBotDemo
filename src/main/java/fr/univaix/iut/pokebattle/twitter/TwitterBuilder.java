package fr.univaix.iut.pokebattle.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import fr.univaix.iut.pokebattle.tuse.Credentials;

public class TwitterBuilder {
    private Credentials credentials;

    public TwitterBuilder(Credentials credentials) {
        this.credentials = credentials;
    }

    public Twitter build() {
        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(credentials.getConsumerKey())
                .setOAuthConsumerSecret(credentials.getConsumerSecret())
                .setOAuthAccessToken(credentials.getToken())
                .setOAuthAccessTokenSecret(credentials.getTokenSecret());
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }
}