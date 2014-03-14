package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

/**
 * Reply to all.
 */
public class PokemonCriesCell implements SmartCell {

	public String m_NomPokemon;
	public String m_Dresseur;
	
	public PokemonCriesCell(String Pokemon) {
		if (Pokemon != null ) {
			m_NomPokemon = Pokemon;
			m_Dresseur = "Kyochi";
		}
	}
    public String ask(Tweet question) {
        if (question.getScreenName() != null ) {
        		if (question.getText().equals("Owner?")) {
        		return "@" + question.getScreenName() + "@" + this.getDresseur() + " is my owner";
        		}
        	return "@" + question.getScreenName() + " Pika pika";
        		
        }
        return "Pika pika";
    }

    public String getDresseur() {
    	return m_Dresseur;
    }
    public String getPokemon() {
    	return m_NomPokemon;
    }
}
