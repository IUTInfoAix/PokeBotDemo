package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokeDonneCarac implements SmartCell {

    private Pokemon poke;

    @Override
    public String ask(Tweet question) {

    	poke = PokeAskOwnerCell.recupInfo(question.getText());
    	String asking = question.getText();
    	if (poke != null && asking.contains("#stat #level ?")) {
    		return "@" + question.getScreenName() + " #level=" + poke.getLevel();
    	} else if (poke != null && asking.contains("#stat #XP ?")) {
    		return "@" + question.getScreenName() + " #XP=" + poke.getXP();
    	} else if (poke != null && asking.contains("#stat #PV ?")) {
    		return "@" + question.getScreenName() + " #PV=" + poke.getPV();
    	} else {
    		return null;
    	}
    }
}