package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.pokebattle.twitter.UpdateBioCell;
import twitter4j.TwitterException;

public class CatchPokeWithoutOwner implements SmartCell {

	private Pokemon poke;
    private UpdateBioCell updateBioCell = UpdateBioCell.getInstance();

	@Override
	public String ask(Tweet question) throws TwitterException {
		if (question.getText().contains("Pokeball!")) {
            poke = PokeAskOwnerCell.recupInfo(question.getText());
            if (poke != null && poke.getEleveur() != null) {
            	return "@" + question.getScreenName() + " @" + poke.getEleveur() + " is my owner";
            } else if (poke != null && poke.getEleveur() == null) {
            	poke.setEleveur(question.getScreenName());
                updateBioCell.update(poke);
                return "@" + question.getScreenName() + " @" + poke.getEleveur() + " is my owner";
            }
		}
		return null;
	}
}
