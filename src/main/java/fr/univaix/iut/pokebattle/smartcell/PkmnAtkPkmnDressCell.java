package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PkmnAtkPkmnDressCell implements SmartCell {

	public String decode(Tweet question) {
		boolean hash = false;
		boolean aro = false;
		String text = question.getText(); //Cette variable récupère le contenu du tweet
		int nbH = 0; //Variable concernant le nombre de HashTag
		int nbA = 0; //Variable concernant le nombre d'arobase
		String att = ""; //Variable qui doit contenir #attack
		String nomAtt = ""; //Nom de l'attaque
		String cible = ""; //La cible
		String dresscible = ""; //Nom du dresseur de la cible
		for (int i = 0; i < text.length(); ++i) {

			if (text.charAt(i) == '#') {
				hash = true;
				nbH++;
			}

			if (text.charAt(i) == ' ') {
				hash = false;
				aro = false;
			}

			if (hash && nbH == 1) {
				att += text.charAt(i);
			}

			if (hash && att.equals("#attack") && nbH > 1) {
				nomAtt += text.charAt(i);
			}

			if (nbH == 2 && text.charAt(i) == '@') {
				aro = true;
				nbA++;
			}

			if (aro && nbA == 1) {
				cible += text.charAt(i);
			}

			if (aro && nbA > 1) {
				dresscible += text.charAt(i);
			}
		}
		return (cible + ' ' + att + ' ' + nomAtt + '!' + ' ' + "/cc" + ' ' + dresscible
				+ ' ' + '@' + question.getScreenName());
	}

	public String ask(Tweet question) {
		if (question.getText().contains("#attack") && question.getText().contains("/cc")) {
            return decode(question);
        } else {
            return null;
        }
	}
}
