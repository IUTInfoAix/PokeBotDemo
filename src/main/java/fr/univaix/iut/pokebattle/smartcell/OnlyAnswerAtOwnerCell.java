package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OnlyAnswerAtOwnerCell implements SmartCell {

	@Override
	public String ask(Tweet question) {

		//pcreux: "@pikachuNyanNian #attack #foudre @bulbizare1"
		//pikachuNyanNian: "@pcreux @nedseb is my owner"
		String reponse = "";
//		if (/*Owner != Twitteur*/) {
//			reponse +=  "@" + question.getScreenName()
//					  + " " /* + Owner*/ + " is my owner";
//		}
//		else
//			/* Le pokemon répond normalement */
		
		return reponse;
	}
}
