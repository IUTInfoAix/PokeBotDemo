package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonFeatureAttackCell {
	
	 public String ask(Tweet question) {
	  	  
	  		if ( question.getText().contains("#statAttack")) 
	  		{
	  			
	  		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
	  	      EntityManager em = emf.createEntityManager();
	  	      String[] phrase = question.getText().split(" ");
	  	      DAOFactory daof = new DAOFactory(em);
	  		  DAOPokemon daoPoke = daof.createDAOPokemon();
			  Pokemon Poke = daoPoke.getByNom(phrase[0]);

			  if ( question.getText().contains("#PP #charge")) 
		  	  {
		  	   	return "@" + question.getScreenName() + " #charge #PP = "  ;
		  	  }
			  
	  		}
	  
	 	return null;
	  	
	 }
}
	
