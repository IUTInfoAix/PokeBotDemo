package fr.univaix.iut.pokebattle.smartcell;

import java.util.Calendar;

import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonHPRefreshCell implements SmartCell {

	PokeStats m_pkmn;

	public PokemonHPRefreshCell(PokeStats pk) {
		m_pkmn = pk;
	}

	@Override
	public String ask(Tweet question) {
		long before = (((m_pkmn.getLastDate().getTime())/1000)/60);
		long now = (((Calendar.getInstance().getTime().getTime()/1000))/60);
		
		long waited = now - before;
		if (m_pkmn.isDispo() == true) {

			if (waited >= 60) {
				// Regen 10% HP
				m_pkmn.setHPcurr(m_pkmn.getHPcurr()+(Math.round(m_pkmn.getHPmax()/10)));
				// Met au max si pv supérieurs au max
				if (m_pkmn.getHPcurr() > m_pkmn.getHPmax())
					m_pkmn.setHPcurr(m_pkmn.getHPmax());
			}
		} else {
			m_pkmn.setLastDate(Calendar.getInstance().getTime());

		}
		return "next_cell";
	}
}
