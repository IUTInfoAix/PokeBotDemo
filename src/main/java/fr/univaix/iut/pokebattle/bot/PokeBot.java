package fr.univaix.iut.pokebattle.bot;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import fr.univaix.iut.pokebattle.func.*;
import fr.univaix.iut.pokebattle.smartcell.*;

import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokeBot implements Bot {
	private Twitter m_Twit;
	private PokeStats m_Stats;
	private final SmartCell[] smartCells;
	
	public PokeBot() {
		m_Stats = PokeStats.getInstance();
		m_Twit = new TwitterFactory().getSingleton();
		smartCells = new SmartCell[]{
				new PokemonHPRefreshCell(m_Stats),
				new PokemonCriesCell(m_Stats),
				new PokemonPokeballCell(m_Stats, m_Twit),
				new PokemonKOAlertCell(m_Stats),
				new PokemonStatsCell(m_Stats),
				new PokemonCheckDispoCell(m_Stats),
				new PokemonAttackingCell(m_Stats, m_Twit),
				
		};
}

	


	@Override
	public String ask(Tweet question) {
		for (SmartCell cell : smartCells) {
			String answer = cell.ask(question);
			if (answer == "last_cell") { break; }
			if (answer == "next_cell") { answer = null; }
			if (answer != null) {
				return answer;
			}
		}
		return "@"+ question.getScreenName() + " Wut ?";
	}

	// Getters 
	public PokeStats getPokeStats() {return m_Stats;}
	

	// Setters
	public void setTwitter(Twitter twit) {
		try {
			m_Twit = twit;
			MatchExtractor match = new MatchExtractor();
			User usr = twit.showUser(twit.getScreenName());
			m_Stats.setName(twit.getScreenName());
		} 
		catch (IllegalStateException | TwitterException e) {
			System.out.println("Problème setTwitter() !");
			e.printStackTrace();
		} 
	}
}
