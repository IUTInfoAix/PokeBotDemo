package fr.univaix.iut.pokebattle.smartcells;

import java.security.acl.Owner;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.SmartCell;
import fr.univaix.iut.pokebattle.Tweet;

/**
 * Reply to all.
 */
public class PokemonCaptureCell implements SmartCell {

	@Override
	public String ask(Tweet question) {	
		Twitter twitter = TwitterFactory.getSingleton();
		DAOFactory daof = new DAOFactory();
		DAOOwner daoOwn = daof.createDAOOwner();
		Owner owner = DAOOwner.getByPokemon(twitter.getScreenName());
		
		if ( question.getText().contains("Pokeball")) {
			if (owner != null) {
				
				Owner own = new Owner();
				own.setPrenom(question.getScreenName());
				own.setPokemon(twitter.getScreenName());
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionPedaPU");
		        EntityManager em = emf.createEntityManager();
		        
		        em.getTransaction().begin();
		        em.persist(own);
		        em.getTransaction().commit();
		        
				return "@" + question.getScreenName() + ' ' + "@" + question.getScreenName() + "is my owner";
			}
		}
		
		return null;
	}

}
