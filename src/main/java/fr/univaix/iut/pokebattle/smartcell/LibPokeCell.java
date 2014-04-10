package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.pokebattle.twitter.UpdateBioCell;
import twitter4j.TwitterException;

public class LibPokeCell implements SmartCell {

    private Pokemon poke;
    private UpdateBioCell updateBioCell = UpdateBioCell.getInstance();

    public String ask(Tweet question) throws TwitterException {
        if (question.getText().contains("Go out")) {
            poke = PokeAskOwnerCell.recupInfo(question.getText());

            if (poke.getEleveur() != null && poke.getEleveur().equals(question.getScreenName()))
            {
                poke.setEleveur(null);
                updateBioCell.update(poke);
                return "@" + question.getScreenName() + " Snif Snif =°(";
            } else {
                return "@" + question.getScreenName() + " I love pringles !";
            }
        }
        return null;
    }
}
