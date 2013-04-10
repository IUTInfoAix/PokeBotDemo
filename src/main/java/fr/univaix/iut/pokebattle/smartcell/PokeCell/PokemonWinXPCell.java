package fr.univaix.iut.pokebattle.smartcell.PokeCell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonWinXPCell implements SmartCell {

	public String ask(Tweet question) throws IllegalStateException, TwitterException 
	{	
		if ( question.getText().contains("#Win")) 
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
			EntityManager em = emf.createEntityManager();
			DAOFactory daof = new DAOFactory(em);
			DAOPokemon daoPoke = daof.createDAOPokemon();
			String[] phrase = question.getText().split(" ");
			
			Pokemon poke = daoPoke.getByNom(phrase[0]);
			
			int xp = poke.getXP();
			String experience = phrase[2].split("xp")[0].replace("+", "");
			
			int niveau = poke.getNiveau();
			int exp = Integer.parseInt(experience) + poke.getXP();
			int expNeed = niveau*niveau*niveau;

			em.getTransaction().begin();
			while (expNeed <= exp)
			{
				++niveau;
				poke.setNiveau(niveau);
				exp = exp - expNeed;
				poke.setXP(exp);
				expNeed = niveau*niveau*niveau;
			}
			
			if (expNeed > exp)
			{
				poke.setXP(exp);
			}
			em.persist(poke);
			em.getTransaction().commit();
		}
		
		return null;
	}
}
