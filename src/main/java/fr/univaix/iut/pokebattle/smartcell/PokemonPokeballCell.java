package fr.univaix.iut.pokebattle.smartcell;


import twitter4j.Twitter;
import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.func.PokeStats;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonPokeballCell implements SmartCell {

	PokeStats m_pkstat;
	Twitter m_twit;

	public PokemonPokeballCell(PokeStats pkstat, Twitter tw) {
		m_pkstat = pkstat;
		m_twit = tw;		
	}

	public String ask(Tweet question) {

		// Test Pokeball    
		if (question.getText().contains("Pokeball!")) {
			//Tweet Pokeball NewOwner
			if (m_pkstat.getOwner() == null) {
				m_pkstat.setOwner(question.getScreenName());
				String caughtrep = "@"+question.getScreenName()+" You caught me !";
				try {
					m_twit.updateProfile(m_twit.getScreenName(), m_twit.showUser(m_twit.getScreenName()).getURL(), m_twit.showUser(m_twit.getScreenName()).getLocation() , m_twit.showUser(m_twit.getScreenName()).getDescription() + " - Owner: @"+question.getScreenName() + " - Level : " + m_pkstat.getLevel());
				} catch (TwitterException e) {
					System.out.println("Erreur set Desc Catch");
					e.printStackTrace();
				}
				return caughtrep;
			}
			String Tweet ="@" + question.getScreenName() + " " + m_pkstat.getOwner() + " is my owner!";
			return Tweet;
		}
		return "next_cell";
	}
}
