package fr.univaix.iut.pokebattle.twitter;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import twitter4j.Twitter;
import twitter4j.TwitterException;

public class UpdateBioCell {

    private Twitter twitter;
    private static UpdateBioCell instance = new UpdateBioCell();

    private UpdateBioCell() {
    }

    public void setTwitter(Twitter twitter) {
        this.twitter = twitter;
    }

    public Twitter getTwitter() {
        return this.twitter;
    }
    public static UpdateBioCell getInstance() {
        return instance;
    }

    public void update(Pokemon poke) throws TwitterException {

        String owner;

        if (poke.getEleveur() != null) {
            owner = "@" + poke.getEleveur();
        } else {
            owner = "No Owner";
        }

        String answer = "#pokebattle - #pokemon - Owner: " + owner + " - Level: " + poke.getLevel();
        twitter.updateProfile(poke.getName(), "", "", answer);
    }
}
