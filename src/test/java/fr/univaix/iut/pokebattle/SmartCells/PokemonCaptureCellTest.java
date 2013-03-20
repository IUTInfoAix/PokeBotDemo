/*package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import DAO.DAOFactory;
import DAO.DAOOwner;
import beans.Owner;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonCaptureCell;

public class PokemonCaptureCellTest {

    PokemonCaptureCell cell = new PokemonCaptureCell();
    
    @Test
    public void testCaptureFalse() throws IllegalStateException, TwitterException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
        EntityManager em = emf.createEntityManager();
        
		DAOFactory daof = new DAOFactory(em);
		DAOOwner daoOwn = daof.createDAOOwner();
		Owner owner = new Owner();
		System.out.println(daoOwn.getByPokemon("@CloudDeLuna"));
    }
}*/
