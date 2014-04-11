package fr.univaix.iut.pokebattle.smartcell;

import twitter4j.Twitter;
import fr.univaix.iut.pokebattle.func.MatchExtractor;
import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttackingCell implements SmartCell {

	PokeStats m_pkstat;
	Twitter m_tw;
	public PokemonAttackingCell(PokeStats stats, Twitter twt) {
		m_pkstat = stats;
		m_tw = twt;
	}


	@Override
	public String ask(Tweet question) {

		//Recup target
		MatchExtractor meuh = new MatchExtractor();
		String[] usess = meuh.matchExtract(question.getText(), "@");
		//usess[0] = le pkmn / usess[1] = la cible / usess[2] = owner de la cible		
		if (question.getText().contains("#attack")) {

			if (m_pkstat.getOwner() == null) {
				return "@" + question.getScreenName()+ " Nobody can tell me what to do ! *middle finger*...*runs away*";
			}
			if ( m_pkstat.getOwner().equals("@"+question.getScreenName())) {
				return usess[1] + " #attack #foudre! /cc " + m_pkstat.getOwner() +" "+ usess[2] ;
			}
			else {
				return "@" + question.getScreenName() + " " +m_pkstat.getOwner() + " is my user";
			}

		}

		return "last_cell";

	}

}
