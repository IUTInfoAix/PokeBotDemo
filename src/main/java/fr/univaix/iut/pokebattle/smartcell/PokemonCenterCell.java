package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonCenterCell implements SmartCell{

	PokeStats m_pkstat;

	public PokemonCenterCell(PokeStats pkstat) {
		m_pkstat = pkstat;
	}

	public String ask(Tweet question) {

		int minutes = 0;

		if (question.getScreenName() == m_pkstat.getOwner()) {
			if (question.getText().contains("#heal"))
			{	
				if (m_pkstat.getHPcurr() == m_pkstat.getHPmax()){
					return "@" + question.getScreenName() + " I'm alredy full of health !";
				}

				for (int pvHeal = Math.round(m_pkstat.getHPmax()/10) ; m_pkstat.getHPcurr() == m_pkstat.getHPmax() ; )
				{
					minutes = (m_pkstat.getHPmax()-m_pkstat.getHPcurr())/10;
					m_pkstat.setHPcurr(m_pkstat.getHPcurr()+pvHeal);
					if (m_pkstat.getHPcurr() > m_pkstat.getHPmax()) {
						m_pkstat.setHPcurr(m_pkstat.getHPmax());
					}
				}
				m_pkstat.setDispo(false);
				return "@" + question.getScreenName() + " I go to the #pokecenter for " + minutes + "/ @PokeTimer #WakeMeUp " + minutes + "WakeUpForkachu !";
			}
		}
		else if (question.getScreenName() == "PokeTimer") {
			if (question.getText().contains("WakeUpForkachu")){
				m_pkstat.setHPcurr(m_pkstat.getHPmax());
				return "@"+ m_pkstat.getOwner() + " I'm restored to full health !";
			}
			
		}
		return "next_cell";	
	}
}