package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class CaractCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		
		// 	ex :
		// 	pcreux: "@bulbizare1 #stat #level ?"
		// 	bulbizare1: "@pcreux #level=1"
		//
		//	pcreux: "@bulbizare1 #stat #XP ?"
		// 	bulbizare1: "@pcreux #XP=0"
		//
		//	pcreux: "@bulbizare1 #stat #PV ?"
		// bulbizare1: "@pcreux #PV=10/100"

		
		if(question.getText().contains("#stat"))
		{	
			if (question.getText().contains("#level")){
				String answer = "@" + question.getScreenName() + "#level=1"/* + getLevel()*/;
				return answer;
			}
			if (question.getText().contains("#XP")){
				String answer = "@" + question.getScreenName() + "#XP=0"/* + getXp()*/;
				return answer;
			}
			if (question.getText().contains("#PV")){
				String answer = "@" + question.getScreenName() + "#PV=10/100"/* + getPv()*/;
				return answer;
			}
		}
		return null;
	}

}
