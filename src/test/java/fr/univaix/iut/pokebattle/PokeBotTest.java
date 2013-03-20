package fr.univaix.iut.pokebattle;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOOwner;
import fr.univaix.iut.pokebattle.beans.Owner;


/**
 * Integration tests checking the PokeBot
 * behavior. We just test some cases to make sure that the
 * PokeBot is using SmartCells properly.
 */
public class PokeBotTest {
    PokeBot pokeBot = new PokeBot();

    @Test
    public void testSalut() {
        assertEquals("@azaz Pika pika", pokeBot.ask(new Tweet("azaz","Salut")));
        assertEquals("@azaz Pika pika", pokeBot.ask(new Tweet("azaz","This is not a question.")));
    }
    
    @Test
    public void testOwner() {
        Owner monOwner = new Owner("@Pika","@John");
        System.out.println(monOwner);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        em.persist(monOwner);
        
        em.getTransaction().commit();
        DAOFactory daof = new DAOFactory(em);
        DAOOwner daoOwn = daof.createDAOOwner();
        
        
        System.out.println(daoOwn.getByPokemon("@GwenGoupix"));
        
    }
}