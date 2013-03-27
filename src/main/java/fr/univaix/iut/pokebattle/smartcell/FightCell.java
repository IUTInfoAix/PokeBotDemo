package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class FightCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		
		// 	ex :
		// 	pcreux: "@nedseb #fight with @bulbizare1 /cc @viviane"
		//  nedseb: "@pcreux #fight #ok with @pikachuNyanNian /cc @viviane"

		if(question.getText().contains("#fight"))
		{	
			String[] alias = question.getText().split(" ");
			String answer = "@" + question.getScreenName() +" #fight #ok with " 
								+ "/*Quel Pokemon?*/" + " /cc " + alias[5];
			return answer;
		}
		return null;
	}

}
