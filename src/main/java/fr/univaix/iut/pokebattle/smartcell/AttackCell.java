package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AttackCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		if(question.getText().contains("#attack"))
		{	
			// ask contains pcreux: "@pikachuNyanNian #attack #foudre @bulbizare1"
			// answer should contains : "pikachuNyanNian: "@bulbizare1 #attack #foudre! /cc @pcreux"
			String alias = question.getText();
			String[] alias2 = alias.split(" ");
			String pokemonAttacked = alias2[3];
			String attackName = alias2[2];
			String dresseur = question.getScreenName();
			String owner = alias2[5];
			String response = pokemonAttacked + " #attack " + attackName
					          + "! /cc " + owner + " @" + dresseur;			
			return response;
		}
		return null;
	}

}
