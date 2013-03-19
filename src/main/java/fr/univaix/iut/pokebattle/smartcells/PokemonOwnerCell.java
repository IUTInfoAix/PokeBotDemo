package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

/**
 * Reply to all.
 */
public class PokemonOwnerCell implements SmartCell {

	@Override
	public String ask(Tweet question) {	
		
		/*Owner owner = new Owner();*/
		
		if (question.getText().contains("Owner")) {
			return "@" + question.getScreenName() + ' ' + "@nom du owner" + " is my owner"  ;
		}
		else {
			return "@" + question.getScreenName() + " No owner";
		}
	}

}
