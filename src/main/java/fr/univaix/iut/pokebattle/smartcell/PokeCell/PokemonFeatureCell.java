package fr.univaix.iut.pokebattle.smartcell.PokeCell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonFeatureCell implements SmartCell {
	
	  public String ask(Tweet question) 
	  {
		  	  
  		if ( question.getText().contains("#stat")) 
  		{
	  		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
	  	      EntityManager em = emf.createEntityManager();
	  	      String[] phrase = question.getText().split(" ");
	  	      DAOFactory daof = new DAOFactory(em);
	  		  DAOPokemon daoPoke = daof.createDAOPokemon();
			  Pokemon poke = daoPoke.getByNom(phrase[0]);

			  if( question.getText().contains("#race")) 
		  	  {
		  	   	return "@" + question.getScreenName() + " #race = " + poke.getRace() ;
		  	  }
			  
		  	  else if( question.getText().contains("#level")) 
		  	  {
		  	   	return "@" + question.getScreenName() + " #level = " + poke.getNiveau() ;
		  	  }
		  		
		  	  else if( question.getText().contains("#XP")) 
		  	  {
		  			return "@" + question.getScreenName() + " #XP = " + poke.getXP() ;
		  	  }
		  		
		  	  else if( question.getText().contains("#PV")) 
		  	  {
		  			return "@" + question.getScreenName() + " #PV = " + poke.getPV() + "/100";

		  	  }
		  	  
		  	  else if( question.getText().contains("#ATTSPE")) 
		  	  {
		  			return "@" + question.getScreenName() + " #ATTSPE = " + poke.getAttackSpecial();

		  	  }
		  	  
		  	  else if( question.getText().contains("#DEFSPE")) 
		  	  {
		  			return "@" + question.getScreenName() + " #DEFSPE = " + poke.getDefenseSpecial();

		  	  }
		  	  
		  	  else if( question.getText().contains("#ATT")) 
		  	  {
		  			return "@" + question.getScreenName() + " #ATT = " + poke.getAttack();

		  	  }
		  	  else if( question.getText().contains("#DEF")) 
		  	  {
		  			return "@" + question.getScreenName() + " #DEF = " + poke.getDefense();

		  	  }

		  	  else if( question.getText().contains("#VIT")) 
		  	  {
		  			return "@" + question.getScreenName() + " #VIT = " + poke.getSpeed();

		  	  }
  		}
	 	return null;
	 }//ask()  
}//class
