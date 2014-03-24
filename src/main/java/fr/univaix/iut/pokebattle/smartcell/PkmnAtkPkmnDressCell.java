package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PkmnAtkPkmnDressCell implements SmartCell {

	public String decode(Tweet question) {
		boolean hash = false;
		boolean aro = false;
		String Text = question.getText();
		int NbH = 0;
		int NbA = 0;
		String Att = "";
		String NomAtt = "";
		String cible = "";
		String dresscible = "";
		for (int i = 0 ; i < Text.length(); ++i) {
			
			if (Text.charAt(i) == '#') {
				hash = true;
				NbH++;
			}
			
			if (Text.charAt(i) == ' ') {
				hash = false;
				aro = false;
			}
			
			if(hash && NbH == 1) {
				Att += Text.charAt(i);
			}
			
			if(hash && Att.equals("#attack") && NbH > 1) {
				NomAtt += Text.charAt(i);
			}
			
			if (NbH == 2 && Text.charAt(i) == '@') {
				aro = true;
				NbA++;
			}
			
			if (aro && NbA == 1) {
				cible += Text.charAt(i);
			}
			
			if (aro && NbA > 1) {
				dresscible += Text.charAt(i);
			}	
		}
		return (cible + ' ' + Att + ' ' + NomAtt + '!' + ' ' + "/cc" + ' ' + dresscible +  
				' ' + '@' + question.getScreenName());
	}
	
	public String ask(Tweet question) {
		return decode(question);
	}
	
}
