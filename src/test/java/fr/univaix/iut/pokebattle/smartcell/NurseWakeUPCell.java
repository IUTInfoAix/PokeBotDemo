package fr.univaix.iut.pokebattle.smartcell;


import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class NurseWakeUPCell implements SmartCell {
	
	public String ask(Tweet question) throws IllegalStateException, TwitterException {	
		
	
		if ( question.getText().contains("#DringDring"))
		{
			
			String[] phrase = question.getText().split(" ");

			return phrase[5] + " " + phrase[4] + " is restored to full health";
		}
		
		return null;

	}//ask ()


}
