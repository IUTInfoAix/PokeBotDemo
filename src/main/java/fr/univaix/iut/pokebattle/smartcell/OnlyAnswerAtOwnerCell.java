package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Pokemon;

public class OnlyAnswerAtOwnerCell implements SmartCell {
	
	private EntityManagerFactory emf; 
	private EntityManager em;
	
	public OnlyAnswerAtOwnerCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
    
	@Override
	public String ask(Tweet tweet) {
		
		DAOPokemonJPA dao = new DAOPokemonJPA(em);
		//pcreux: "@pikachuNyanNian #attack #foudre @bulbizare1"
		//pikachuNyanNian: "@pcreux @nedseb is my owner"
		
		String[] alias = tweet.getText().split(" ");
     	String pokemon = alias[0].toUpperCase();
     	pokemon = pokemon.substring(1, pokemon.length());
    	Pokemon poke = dao.getById(pokemon);
    	
    	String tweeteur = tweet.getScreenName();
		String owner = poke.getOwner_poke().getNom_owner();
		
		String reponse="";
		if (!owner.equals(tweeteur)) {
			reponse +=  "@" + tweeteur
					  + " " + owner + " is my owner";
		}
		
		return reponse;
	}
}
