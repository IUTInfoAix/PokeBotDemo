package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OwnerCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		if(question.getText().contains("Owner"))
		{	
			// ask contains pcreux: "pcreux: "@pikachuNyanNian Owner?"
			// answer should contains : "pikachuNyanNian: "@pcreux No owner"
			
			String ownerAsk = question.getScreenName();
			
			//check owner exist
			
			String response = "@" + ownerAsk + " @Albert" + " is my owner";
			
			return response;
		}
		return null;
	}

}
