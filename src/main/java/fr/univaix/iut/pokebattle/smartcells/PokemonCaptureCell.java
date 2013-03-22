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
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Owner;
import fr.univaix.iut.pokebattle.beans.Pokemon;

/**
 * Reply to all.
 */
public class PokemonCaptureCell implements SmartCell {

	@Override
	public String ask(Tweet question) throws IllegalStateException, TwitterException {	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
        EntityManager em = emf.createEntityManager();
        
		DAOFactory daof = new DAOFactory(em);
		DAOOwner daoOwn = daof.createDAOOwner();
		DAOPokemon daoPoke = daof.createDAOPokemon();
		
		String[] phrase = question.getText().split(" ");
		Pokemon Poke = daoPoke.getByNom(phrase[0]);
		Owner owner = daoOwn.getByPokemon(Poke);
		
		if ( question.getText().contains("pokeball")) {
			if (owner == null) {
				Owner own = new Owner();
				own.setPrenom("@" + question.getScreenName());

				own.setPokemon(Poke);
				
				em.getTransaction().begin();
				em.persist(own);
				em.getTransaction().commit();
		        
				return "@" + question.getScreenName() + " @" + question.getScreenName() + " is my owner";
			}
			else
			{
				return "@" + question.getScreenName() + " " + owner.getPrenom() + " is my owner !";
			}
		}
		
		return null;
	}

}
