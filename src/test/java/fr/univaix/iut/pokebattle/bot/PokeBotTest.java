package fr.univaix.iut.pokebattle.bot;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOOwner;
import fr.univaix.iut.pokebattle.beans.Owner;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

/**
 * Integration tests checking the PokeBot
 * behavior. We just test some cases to make sure that the
 * PokeBot is using smartcell properly.
 */
public class PokeBotTest {
    PokeBot pokeBot = new PokeBot();
    
    @Test
    public void testSalut() throws IllegalStateException, TwitterException {
        assertEquals("Pika pika", pokeBot.ask(new Tweet("Salut")));
        assertEquals("Pika pika", pokeBot.ask(new Tweet("This is not a question.")));
        assertEquals("@nedseb Pika pika", pokeBot.ask(new Tweet("nedseb", "Salut")));
        assertEquals("@nedseb Pika pika", pokeBot.ask(new Tweet("nedseb", "This is not a question.")));
    }
    
    @Test
    public void testOwner() {
		Pokemon Poke = new Pokemon();
		Poke.setNom("@GwenGoupix");
        Owner monOwner = new Owner(Poke,"@CloudDeLuna");
        System.out.println(monOwner);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
        EntityManager em = emf.createEntityManager();
        DAOFactory daof = new DAOFactory(em);

        DAOOwner daoOwn = daof.createDAOOwner();        
    }
}
