package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AnswerJugeCell implements SmartCell {

	@Override
	public String ask(Tweet tweet) {
		
		String texte = tweet.getText();
		String[] tabMots = texte.split(" ");
		String pokeAttaquant = tweet.getScreenName();
		String reponseJuge = "@ " + pokeAttaquant + "-10pv /cc "
				                  + tabMots[5];
		
		return reponseJuge;
	}

	//pcreux: "@bulbizare1 #attack #charge @pikachuNyanNian /cc @nedseb @viviane"
	//bulbizare1: "@pikachuNyanNian #attack #charge /cc @nedseb @pcreux @viviane"
	//viviane: "@bulbizare1 -10pv /cc @pcreux"
	

}
