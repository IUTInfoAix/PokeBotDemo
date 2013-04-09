package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Pokemon;
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
			  Pokemon Poke = daoPoke.getByNom(phrase[0]);

			  if( question.getText().contains("#race")) 
		  	  {
		  	   	return "@" + question.getScreenName() + " #race = " + Poke.getRace() ;
		  	  }
			  
		  	  else if( question.getText().contains("#level")) 
		  	  {
		  	   	return "@" + question.getScreenName() + " #level = " + Poke.getNiveau() ;
		  	  }
		  		
		  	  else if( question.getText().contains("#XP")) 
		  	  {
		  			return "@" + question.getScreenName() + " #XP = " + Poke.getXP() ;
		  	  }
		  		
		  	  else if( question.getText().contains("#PV")) 
		  	  {
		  			return "@" + question.getScreenName() + " #PV =" + Poke.getPV() + "/100";

		  	  }
		  	  
		  	  else if( question.getText().contains("#ATTSPE")) 
		  	  {
		  			return "@" + question.getScreenName() + " #ATTSPE = " + Poke.getAttackSpecial();

		  	  }
		  	  
		  	  else if( question.getText().contains("#DEFSPE")) 
		  	  {
		  			return "@" + question.getScreenName() + " #DEFSPE = " + Poke.getDefenseSpecial();

		  	  }
		  	  
		  	  else if( question.getText().contains("#ATT")) 
		  	  {
		  			return "@" + question.getScreenName() + " #ATT = " + Poke.getAttack();

		  	  }
		  	  else if( question.getText().contains("#DEF")) 
		  	  {
		  			return "@" + question.getScreenName() + " #DEF = " + Poke.getDefense();

		  	  }

		  	  else if( question.getText().contains("#VIT")) 
		  	  {
		  			return "@" + question.getScreenName() + " #VIT = " + Poke.getSpeed();

		  	  }
  		}
	 	return null;
	 }//ask()  
}//class
