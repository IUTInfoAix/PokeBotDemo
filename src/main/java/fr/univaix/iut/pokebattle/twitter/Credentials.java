package fr.univaix.iut.pokebattle.twitter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Credentials {

    private String consumerKey;
    private String consumerSecret;
    private String token;
    private String tokenSecret;

    public Credentials() {
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getToken() {
        return token;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    public static Credentials loadCredentials(InputStream propertiesFile) throws IOException {
        Properties properties = new Properties();
        properties.load(propertiesFile);
        Credentials credentials = new Credentials();
        credentials.setConsumerKey(properties.getProperty("oauth.consumerKey"));
        credentials.setConsumerSecret(properties.getProperty("oauth.consumerSecret"));
        credentials.setToken(properties.getProperty("oauth.accessToken"));
        credentials.setTokenSecret(properties.getProperty("oauth.accessTokenSecret"));
        return credentials;
    }
}
