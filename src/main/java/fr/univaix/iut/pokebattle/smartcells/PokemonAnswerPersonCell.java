package fr.univaix.iut.pokebattle.smartcells;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

public class PokemonAnswerPersonCell implements SmartCell{
	Pokemon carapuce = new Pokemon("Carapuce_bot", "Skwalop skwalop", "null");
	
	public String ask(Tweet Question){
		String Resultat = null;
		if(Question.getText().contains("Salut")){
			Resultat = Question.getScreenName() + " " + carapuce.getCriPoke();
			return Resultat;
		}
		return Resultat;
		
	}
}
