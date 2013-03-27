package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class InactivePokeGraduallyRegainsHealthCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		
		// 	ex :
		// 8h30
		// 	pcreux: "@bulbizare1 #stat #PV ?"
		//  bulbizare1: "@pcreux #PV=10/100"
		//
		// 9h30
		//	pcreux: "@bulbizare1 #stat #PV ?"
		//  bulbizare1: "@pcreux #PV=20/100"


		
		if(question.getText().contains("#stat") && question.getText().contains("#PV"))
		{	
			
			String answer = "@" + question.getScreenName() + "#PV=10/100"/* getPV()*/;
			return answer;
		}
		return null;
	}

}
