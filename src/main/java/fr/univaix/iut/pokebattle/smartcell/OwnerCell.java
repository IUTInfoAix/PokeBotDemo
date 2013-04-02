package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Pokemon;

public class OwnerCell implements SmartCell {
	
	private EntityManagerFactory emf; 
	private EntityManager em;

	public OwnerCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	
	@Override
	public String ask(Tweet tweet) {
		if(tweet.getText().contains("Owner"))
		{	
			DAOPokemonJPA dao = new DAOPokemonJPA(em);
			
			// ask contains pcreux: "pcreux: "@pikachuNyanNian Owner?"
			// answer should contains : "pikachuNyanNian: "@pcreux No owner"
			String[] alias = tweet.getText().split(" ");
         	String pokemon = alias[0].toUpperCase();
         	pokemon = pokemon.substring(1, pokemon.length());
         	
        	Pokemon poke = dao.getById(pokemon);
        	
			String owner = poke.getOwner_poke().getNom_owner();
			
			//check owner exist
			String tweeteur = tweet.getScreenName();
			String response = "@" + tweeteur + " @" + owner + " is my owner";
			
			return response;
		}
		return null;
	}

}
