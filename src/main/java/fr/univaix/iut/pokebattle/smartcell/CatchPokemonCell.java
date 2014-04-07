package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import fr.univaix.iut.pokebattle.DAOPokemonJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

/* Classe qui permet d'attraper un pokémon si celui-ci n'a pas
 * déja un dresseur. Il renvoie le nom de son éleveur dans tous les cas 
 */

public class CatchPokemonCell implements SmartCell{
	public CatchPokemonCell(){
		
	}
	public String ask(Tweet question){
		
		
    	EntityManagerFactory emf = Persistence
    			.createEntityManagerFactory("pokebattlePU");
    	EntityManager em = emf.createEntityManager();
    	DAOPokemonJPA daopok = new DAOPokemonJPA(em);
    	Pokemon pokemon = new Pokemon();
        pokemon = daopok.getById("AboHotelBis");
		
		String asking = question.getText().toUpperCase();
		if(asking.contains("POKEBALL"))
		{
	        
	        if (pokemon.getOwner().contentEquals("null")) {
	        	pokemon.setOwner(question.getScreenName());
	        	return "@" + pokemon.getOwner() + " is now my owner.";
	        	
	        }

			else 
			{
				return "I already have an owner is name is @" + pokemon.getOwner() + ".";
			}
		}
		return null;
	}
	
}
