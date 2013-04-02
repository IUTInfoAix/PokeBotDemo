package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.DAO.DAOCombat;
import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Combat;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeBotWinnerCell implements SmartCell {

	public String ask(Tweet question) throws IllegalStateException, TwitterException {	
		if ( question.getText().contains("#KO")) 
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
			EntityManager em = emf.createEntityManager();
			
			
			DAOFactory daof = new DAOFactory(em);
			
			DAOCombat daocombat = daof.createDAOCombat();
			DAOPokemon daoPoke = daof.createDAOPokemon();
			Pokemon Poke = daoPoke.getByNom("@" + question.getScreenName());
			Combat combat = daocombat.getByPokemon(Poke);
			
			Pokemon poke1 = combat.getPoke_1();
			Pokemon poke2 = combat.getPoke_2();
			
			return (Poke.equals(poke1) ? poke2.getNom() : poke1.getNom()) + " #win";
			
		}
		return null;
}
}