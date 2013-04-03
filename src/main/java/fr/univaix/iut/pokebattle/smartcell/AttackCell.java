package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AttackCell implements SmartCell {
	
	public String ask(Tweet tweet) {
		if(tweet.getText().contains("#attack"))
		{	
			// ask contains pcreux: "@pikachuNyanNian #attack #foudre @bulbizare1"
			// answer should contains : "pikachuNyanNian: "@bulbizare1 #attack #foudre! /cc @pcreux"
			String alias = tweet.getText();
			String[] alias2 = alias.split(" ");
			String pokemonAttacked = alias2[3];
			String attackName = alias2[2];
			String dresseur = tweet.getScreenName();
			
			String response = pokemonAttacked + " #attack " + attackName
					          + "! /cc " + "@" + dresseur;			
			return response;
		}
		return null;
	}

}
