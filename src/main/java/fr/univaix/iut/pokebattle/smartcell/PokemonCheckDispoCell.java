package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCheckDispoCell implements SmartCell {
	
	PokeStats m_pkmn;
	
	public PokemonCheckDispoCell(PokeStats pk) {
		m_pkmn = pk;
	}
	
	public String ask(Tweet question) {
		if (!m_pkmn.isDispo()) {
			return "@" + question.getScreenName() + " I'm currently healing at the Pokemon Center.";
		}
		return "next_cell";
	}

}
