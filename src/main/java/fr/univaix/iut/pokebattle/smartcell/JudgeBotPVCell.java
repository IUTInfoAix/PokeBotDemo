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

public class JudgeBotPVCell implements SmartCell{

	@Override
	public String ask(Tweet question) throws IllegalStateException, TwitterException {
		
		if ( question.getText().contains("#attack")) 
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
	        EntityManager em = emf.createEntityManager();
			DAOFactory daof = new DAOFactory(em);
			DAOOwner daoOwn = daof.createDAOOwner();
			DAOPokemon daoPoke = daof.createDAOPokemon();
			
			String[] phrase = question.getText().split(" ");
			
			Pokemon Poke = daoPoke.getByNom(phrase[0]);
			Owner owner = daoOwn.getByPokemon(Poke);
			
			if (phrase[3].contains("@") )
			{
				return null;
			}
			else 
			{
				return phrase[0] + " -10pv /cc " + owner.getPrenom();
			}
			
		}
		
		return null;
	}

}
