package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.DAOPokemon;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokeAttackCell {


    public  String ask(final Tweet tweet) {
        DAOPokemon DAO = DAOFactoryJPA.createDAOPokemon();
        Pokemon poke = DAO.getById("AboHotelBis");
        
        if (poke.getOwner() != tweet.getScreenName()) {
        	return "Sorry, you're not my owner. My owner is " + poke.getOwner();
        } else {
	        String result = "@";
	        if (tweet.getHashTag(0).equals("attack")) {
	            for (int i = 1; i < tweet.getText().length(); i++) {
	                if (tweet.getText().charAt(i) == '@') {
	                    for (; Character.isLetterOrDigit(tweet.getText().charAt(++i));) {
	                        result += tweet.getText().charAt(i);
	                        if (i + 1 == tweet.getText().length()) {
	                            break;
	                        }
	                    }
	                    result += " #attack #";
	                    result += tweet.getHashTag(1);
	                    //ajout de l'attaque
	                    if (i + 1 < tweet.getText().length()) {
	                        if (tweet.getText().charAt(i) == ' ' & tweet.getText().charAt(i + 1) == '/') {
	                            for (; i < tweet.getText().length(); i++) {
	                                result += tweet.getText().charAt(i);
	                            }
	                        }
	                    } else {
	                        result += " /cc";
	                    }
	                }
	            }
	            result += " @";
	            result += tweet.getScreenName();
	            return result;
	        } else {
	            return "Ce n'est pas une attaque";
	        }
        }
    }
}
