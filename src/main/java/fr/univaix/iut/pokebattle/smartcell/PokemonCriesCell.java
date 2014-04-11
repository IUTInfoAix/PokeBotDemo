package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCriesCell implements SmartCell {

	PokeStats m_pksts;
	
	// Chaînes déclenchant un cri de pokémon 
	public CharSequence[] HiSet = {"salut","wesh","bonjour", "au revoir",
							 		"bye", "adieu"};
	
	public PokemonCriesCell(PokeStats pkstat) {
		m_pksts = pkstat;
	}
	
    public String ask(Tweet question) {

        if (question.getScreenName() != null ) {
        	if (question.getText().toLowerCase().contains("owner")) {
        		if (m_pksts.getOwner() != null) {
        			return "@" + question.getScreenName() 
        					+ " " + m_pksts.getOwner() + " is my owner";
        			}
        			return "@" + question.getScreenName() 
        					+ " No owner";
        	}
        	for (int i = 0 ; i< HiSet.length; i++ ) {
        		if (question.getText().toLowerCase().contains(HiSet[i]))
        			return "@" + question.getScreenName() + " Hay !";
        	}
        }
        return "next_cell";
    }
}
