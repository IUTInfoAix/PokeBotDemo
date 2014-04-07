package fr.univaix.iut.pokebattle.smartcell;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.DAOPokemon;
import fr.univaix.iut.pokebattle.DAOPokemonJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class AskSpecificationsCell implements SmartCell{
	public String ask(Tweet question){
		
    	EntityManagerFactory emf = Persistence
    			.createEntityManagerFactory("pokebattlePU");
    	EntityManager em = emf.createEntityManager();
    	DAOPokemonJPA daopok = new DAOPokemonJPA(em);
    	Pokemon pokemon = new Pokemon();
        pokemon = daopok.getById("AboHotelBis");
        
		String asking = question.getText();
		if(asking.contains("@AboHotel #stat #level")){			
			return "#level = " + pokemon.getLevel();
		}
		
		else if(asking.contains("@AboHotel #stat #PV")){	        
			return "#PV = " + pokemon.getPVNow();
		}
		
		else if(asking.contains("@AboHotel #stat #XP")){	        
			return "#XP = " + pokemon.getXP();
		}
		else{
	        
			System.out.println(pokemon.getLevel());
			return null;
		}
	}
}
