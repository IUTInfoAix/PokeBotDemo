package fr.univaix.iut.pokebattle.Pokemon;

import fr.univaix.iut.pokebattle.pokemon.Pokemon;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by Thomas on 14/03/2014.
 */
public class PokemonTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static DatabaseConnection dbUnitConnection;
    private static FlatXmlDataSet dataset;

    @BeforeClass
    public static void initTestFixture() throws Exception {
        // Get the entity manager for the tests.
        entityManagerFactory = Persistence.createEntityManagerFactory("pokebattlePU");
        entityManager = entityManagerFactory.createEntityManager();

        Connection connection = ((EntityManagerImpl) (entityManager.getDelegate())).getServerSession().getAccessor().getConnection();

        dbUnitConnection = new DatabaseConnection(connection);

        //Loads the data set from a file
        dataset = new FlatXmlDataSetBuilder().build(Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("jeuEssaiPokemon.xml"));
    }

    @AfterClass
    public static void finishTestFixture() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Before
    public void setUp() throws Exception {
         //Clean the data from previous test and insert new data test.
        DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, dataset);
    }

    @Test
    public void isPokemon () {
       TypedQuery<Pokemon> q = entityManager.createQuery("SELECT p FROM Pokemon p"
                                                         ,Pokemon.class);
        List<Pokemon> pokemons = q.getResultList();
        assertThat (pokemons.size()).isEqualTo(3);
    }

    @Test
    public void testName () {
        TypedQuery<Pokemon> q = entityManager.createQuery("SELECT p from Pokemon p", Pokemon.class);
        List<Pokemon> pokemons = q.getResultList();
        assertThat(pokemons.get(0).getName()).isEqualTo("ALAKAZAM");
        assertThat(pokemons.get(1).getName()).isEqualTo("Pikachu");
        assertThat(pokemons.get(2).getName()).isEqualTo("Rattata");
    }
}
