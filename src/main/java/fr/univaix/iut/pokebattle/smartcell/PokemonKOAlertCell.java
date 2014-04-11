package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonKOAlertCell implements SmartCell {

	PokeStats m_pkstat;

	public PokemonKOAlertCell(PokeStats pkstat) {
		m_pkstat = pkstat;
	}

	public String ask(Tweet question) {
		if (question.getText().contains("-10HP")){
			
			m_pkstat.setHPcurr(m_pkstat.getHPcurr()-10);
			
			if (m_pkstat.getHPcurr() <= 0) {
				m_pkstat.setHPcurr(0);
				return "#KO";
			}
			
		}
		return "next_cell";
	}

} //