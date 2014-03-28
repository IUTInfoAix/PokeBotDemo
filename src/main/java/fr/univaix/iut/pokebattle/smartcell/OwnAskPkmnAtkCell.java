package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OwnAskPkmnAtkCell implements SmartCell {

	public String decode(Tweet question) {
		boolean hashA = false;
		boolean aro = false;
		String text = question.getText(); //Cette variable récupère le contenu du tweet
		int nbH = 0; //Variable concernant le nombre de HashTag
		String att = ""; //Variable qui doit contenir #attack
		String nomatt = ""; //Nom de l'attaque
		String cible = ""; //La cible
		for (int i = 0; i < text.length(); ++i) {

			if (text.charAt(i) == '#') {
				hashA = true;
				nbH++;
			}

			if (text.charAt(i) == ' ') {
				hashA = false;
			}

			if (hashA && nbH == 1) {
				att += text.charAt(i);
			}

			if (hashA && att.equals("#attack") && nbH > 1) {
				nomatt += text.charAt(i);
			}

			if (nbH == 2 && text.charAt(i) == '@') {
				aro = true;
			}

			if (aro) {
				cible += text.charAt(i);
			}
		}
		return (cible + ' ' + att + ' ' + nomatt + '!' + ' ' + "/cc" + ' ' + '@'
				+ question.getScreenName());
	}



	public String ask(Tweet question) {
		if (question.getText().contains("#attack")) {
            return decode(question);
        } else {
            return null;
        }
	}
}
