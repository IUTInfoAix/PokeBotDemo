package fr.univaix.iut.pokebattle.smartcell.Nurse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOOwner;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Owner;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class NurseWakeUpPokeCell implements SmartCell {

	public String ask(Tweet question) throws IllegalStateException, TwitterException {	
		
		if ( question.getText().contains("#DringDring")) 
		{
			//Twitter twitter = TwitterFactory.getSingleton();
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
	        EntityManager em = emf.createEntityManager();
			DAOFactory daof = new DAOFactory(em);
			DAOOwner daoOwn = daof.createDAOOwner();
			DAOPokemon daoPoke = daof.createDAOPokemon();
			 
			//@PokeTimer #DringDring #MaxHealth nombre NomPoke Owner
			
			String[] phrase = question.getText().split(" ");
			System.out.println(phrase[4]);
			Pokemon poke = daoPoke.getByNom(phrase[4]);
			Owner owner = daoOwn.getByPokemon(poke);
			
			em.getTransaction().begin();
			poke.setPV(Integer.parseInt(phrase[3]));
        	em.persist(poke);
        	em.getTransaction().commit();
			
			
		   return owner.getPrenom() + " " + poke.getNom() + " is restored to full health";

		}
		return null;

	}//ask ()

}
