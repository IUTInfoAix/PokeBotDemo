package fr.univaix.iut.pokebattle.twitter;

import twitter4j.Twitter;

public class Tweet {
    private String text;
    private String screenName;
    private Twitter twitter;

    public Tweet(String text) {
        this.text = text;
    }

    public Tweet(String screenName, String text) {
        this.screenName = screenName;
        this.text = text;
    }
    
    public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

	public String getScreenName() {
        return screenName;
    }

    public String getText() {
        return text;
    }
}
