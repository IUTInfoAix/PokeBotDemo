package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class NoOwnerCatchCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		if(question.getText().contains("Pokeball"))
		{	
			// ask contains pcreux: "pcreux: "@pikachuNyanNyan Pokeball!"
			// answer should contains : pikachuNyanNian: "@pcreux @pcreux is my owner"
			
			String ownerAsk = question.getScreenName();
			
			//check owner exist
			
			String response = "@" + ownerAsk + " @" +ownerAsk+ " is my owner";
			
			return response;
		}
		return null;
	}

}
