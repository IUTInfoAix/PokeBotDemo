package fr.univaix.iut.pokebattle.smartcells;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

/**
 * Reply to all.
 */
public class PokemonCaptureCell implements SmartCell {

	@Override
	public String ask(Tweet question) throws IllegalStateException, TwitterException {	
		Twitter twitter = TwitterFactory.getSingleton();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
        EntityManager em = emf.createEntityManager();
        
		DAOFactory daof = new DAOFactory(em);
		DAOOwner daoOwn = daof.createDAOOwner();
		Owner owner = daoOwn.getByPokemon("@" + twitter.getScreenName());

		
		if ( question.getText().contains("Pokeball")) {
			if (owner.getPrenom().equals(null)) {
				Owner own = new Owner();
				own.setPrenom(question.getScreenName());

				own.setPokemon("@" + twitter.getScreenName());
				
				em.getTransaction().begin();
				em.persist(own);
				em.getTransaction().commit();
		        
				return question.getScreenName() + ' ' + question.getScreenName() + "is my owner";
			}
			System.out.println("coucou");
		}
		
		return null;
	}

}
