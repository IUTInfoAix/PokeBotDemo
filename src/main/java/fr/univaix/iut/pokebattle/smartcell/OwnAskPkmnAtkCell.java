package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OwnAskPkmnAtkCell implements SmartCell {

    private Pokemon poke;
    private static String dresscible;
	public String decode(Tweet question) {
		boolean hashA = false;
		boolean aro = false;
		if (!(question.getScreenName().equals(poke.getEleveur()))) {
			return '@' + poke.getEleveur() + " is my owner";
		}

		String text = question.getText(); //Cette variable récupère le contenu du tweet
		int nbH = 0; //Variable concernant le nombre de HashTag
		int nbA = 0; //Variable concernant le nombre d'arobase
		String att = ""; //Variable qui doit contenir #attack
		String nomatt = ""; //Nom de l'attaque
		String cible = ""; //La cible
		dresscible = ""; //Nom du dresseur de la cible
		for (int i = 0; i < text.length(); ++i) {

			if (text.charAt(i) == '#') {
				hashA = true;
				nbH++;
			}

			if (text.charAt(i) == ' ') {
				hashA = false;
				aro = false;
			}

			if (hashA && nbH == 1) {
				att += text.charAt(i);
			}

			if (hashA && att.equals("#attack") && nbH > 1) {
				nomatt += text.charAt(i);
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

		if (nomatt.isEmpty()) {
			return '@' + question.getScreenName() + " ZzZz...Fleeex?";
		}

		if (!dresscible.isEmpty()) {
			return (cible + ' ' + att + ' ' + nomatt + '!' + ' ' + "/cc" + ' ' + dresscible
					+ ' ' + '@' + question.getScreenName());
		}

		return (cible + ' ' + att + ' ' + nomatt + '!' + ' ' + "/cc" + ' ' + '@'
				+ question.getScreenName());

	}

    public static String getDresscible() {
        return dresscible;
    }

	public String ask(Tweet question) {
        poke = PokeAskOwnerCell.recupInfo(question.getText());
		if (poke != null && question.getText().contains("#attack")) {
            return decode(question);
        } else {
            return null;
        }
	}
}
