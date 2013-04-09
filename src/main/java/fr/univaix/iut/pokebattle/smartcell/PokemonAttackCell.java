package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import twitter4j.Twitter;
import twitter4j.TwitterException;
//import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOOwner;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Owner;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonAttackCell implements SmartCell {

		public String ask(Tweet question) throws IllegalStateException, TwitterException {	
			if ( question.getText().contains("#attack")) 
			{
				//Twitter twitter = TwitterFactory.getSingleton();
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
		        EntityManager em = emf.createEntityManager();
				DAOFactory daof = new DAOFactory(em);
				DAOOwner daoOwn = daof.createDAOOwner();
				DAOPokemon daoPoke = daof.createDAOPokemon();
				
				String[] phrase = question.getText().split(" ");
				Pokemon poke = daoPoke.getByNom(phrase[0]);
				Owner owner = daoOwn.getByPokemon(poke);
									
	
					if ( owner.getPrenom().equals("@" + question.getScreenName())) 
					{
						poke = daoPoke.getByNom(phrase[3]);
						
						int pVPoke = poke.getPV();
						poke.setPV(pVPoke-10);
						em.getTransaction().begin(); 
						em.persist(poke);
						em.getTransaction().commit();
						
				        return phrase[3] + " #attack " + phrase[2] + " /cc " + phrase[5] + " " + owner.getPrenom() + " " + phrase[6];  
						//"@pikachuNyanNian #attack #charge /cc @nedseb @pcreux"
					}
					else
					{
						return "@" + question.getScreenName() + " " + owner.getPrenom() + " is my owner";
					}

			}//if contains attack
			return null;

		}//ask ()

}
