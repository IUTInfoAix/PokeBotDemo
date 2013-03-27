package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AttakCaractCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		
		// 	ex :
		// 	pcreux: "@bulbizare1 #statAttack #PP #charge ?"
		//  bulbizare1: "@pcreux #charge #PP=10/35"
		//


		
		if(question.getText().contains("#statAttack #PP"))
		{	
			String alias = question.getText();
			String[] alias2 = alias.split(" ");
			String attaque = alias2[3];
			attaque = attaque.substring(1, attaque.length() -1);
			
			String answer = "@" + question.getScreenName() + " " + attaque + " #PP=10/35";
			return answer;
			
		}
		return null;
	}

}
