package fr.univaix.iut.pokebattle.smartcell;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOOwner;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Owner;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

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
