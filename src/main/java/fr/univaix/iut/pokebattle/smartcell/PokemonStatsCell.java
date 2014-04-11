package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonStatsCell implements SmartCell{

	PokeStats m_pkst;
	
	public PokemonStatsCell(PokeStats pkmn) {
		m_pkst = pkmn;
	}
	
	public String ask(Tweet question) {
		
		if (question.getText().contains("#stat")) {
			String strres="@" + question.getScreenName();
			
			if (question.getText().contains("#level")) {
				strres += " #level=" + m_pkst.getLevel();
			}
			if (question.getText().contains("#PV")) {
				strres += " #PV=" + m_pkst.getHPcurr()+"/"+m_pkst.getHPmax();
			}
			if (question.getText().contains("#XP")) {
				strres += " #XP=" + m_pkst.getXp();
			}
			return strres;
		}
		return "next_cell";
	}

}
