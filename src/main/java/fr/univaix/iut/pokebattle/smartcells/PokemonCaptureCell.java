package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

/**
 * Reply to all.
 */
public class PokemonCaptureCell implements SmartCell {

	@Override
	public String ask(Tweet question) {	
		
		
		
		return "@" + question.getScreenName() + " Pika pika"  ;
	}

}
