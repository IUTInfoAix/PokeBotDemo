package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.jpa.DAOPokemon;
import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokeAskOwnerCell implements SmartCell {

    private Pokemon poke;

    public static String getNomPoke(String str) {
        String tmp = "";
        boolean ajoutnom = false;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ' ') {
                break;
            }
            if (ajoutnom) {
                tmp += str.charAt(i);
            }
            if (str.charAt(i) == '@') {
                ajoutnom = true;
            }
        }
        return tmp;
    }

    public static Pokemon recupInfo(String texte) {
        String nom = getNomPoke(texte);
        DAOPokemon dao = DAOFactoryJPA.createDAOPokemon();
        Pokemon poke = dao.getById(nom);
        return poke;
    }

	@Override
	public String ask(Tweet question) {
		if (question.getText().contains("Owner?")) {
            poke = recupInfo(question.getText());
            if (poke != null && poke.getEleveur() != null) {
               return "@" + question.getScreenName() + " @" + poke.getEleveur() + " is my owner";
            } else {
                return "@" + question.getScreenName() + " No owner";
            }
		}
		return null;
	}
}