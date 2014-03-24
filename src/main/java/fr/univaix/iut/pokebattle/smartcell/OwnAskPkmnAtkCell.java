package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OwnAskPkmnAtkCell implements SmartCell {

	public String decode(Tweet question) {
		boolean hashA = false;
		boolean Aro = false;
		String Text = question.getText();
		int NbH = 0;
		String Att = "";
		String NomAtt = "";
		String cible = "";
		for (int i = 0 ; i < Text.length(); ++i) {
			
			if (Text.charAt(i) == '#') {
				hashA = true;
				NbH++;
			}
			
			if (Text.charAt(i) == ' ') {
				hashA = false;
			}
			
			if(hashA && NbH == 1) {
				Att += Text.charAt(i);
			}
			
			if(hashA && Att.equals("#attack") && NbH > 1) {
				NomAtt += Text.charAt(i);
			}
			
			if (NbH == 2 && Text.charAt(i) == '@') {
				Aro = true;
			}
			
			if (Aro) {
				cible += Text.charAt(i);
			}
		}
		return (cible + ' ' + Att + ' ' + NomAtt + '!' + ' ' + "/cc" + ' ' + '@' + question.getScreenName());
	}
	
	
	
	public String ask(Tweet question) {
		return decode(question);
	}
}
