package fr.univaix.iut.pokebattle.smartcells;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOOwner;
import fr.univaix.iut.pokebattle.beans.Owner;

public class PokemonAttackCell implements SmartCell {

		public String ask(Tweet question) throws IllegalStateException, TwitterException {	
			
		
			
				Twitter twitter = TwitterFactory.getSingleton();
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
		        EntityManager em = emf.createEntityManager();
				DAOFactory daof = new DAOFactory(em);
				DAOOwner daoOwn = daof.createDAOOwner();
				
				String[] phrase = question.getText().split(" ");
				Owner owner = daoOwn.getByPokemon(phrase[0]) ;
				
				
				if ( question.getText().contains("#attack")) 
				{
					if ( owner.getPrenom().equals("@" + question.getScreenName())) 
					{
				        return "J'attaque " + phrase[3] + " du dresseur " + phrase[5] + " avec " + phrase [2] 
				        		+ "!"  + ", sur ordre de mon dresseur qui est " + owner.getPrenom();  
						//return "@" + question.getScreenName() + ' ' + "@" + question.getScreenName() + "is my owner";
					}
					else
					{
						return "@" + question.getScreenName() + " " + owner.getPrenom() + " is my owner";
					}

				}
				return null;

		}

}
