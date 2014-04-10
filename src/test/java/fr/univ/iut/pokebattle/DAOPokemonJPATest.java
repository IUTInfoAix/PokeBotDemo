package fr.univ.iut.pokebattle;

import fr.univaix.iut.pokebattle.*;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.Connection;
import java.util.List;

import static org.fest.assertions.Assertions.assertThat;

public class DAOPokemonJPATest {

	private static EntityManager entityManager;
    private static FlatXmlDataSet dataset;
    private static DatabaseConnection dbUnitConnection;
    private static EntityManagerFactory entityManagerFactory;

    private DAOPokemon dao = new DAOPokemonJPA(entityManager);

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
                .getResourceAsStream("pokemonDataset.xml"));
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
    public void testFindByType() throws Exception {
        List<Pokemon> pokemons = dao.findByType(Type.POISON);
        assertThat(pokemons.get(0).getName()).isEqualTo("AboHotelBis");
    }

    @Test
    public void testFindAll() throws Exception {
        List<Pokemon> pokemons = dao.findAll();
        assertThat(pokemons.get(0).getName()).isEqualTo("AboHotelBis");
        assertThat(pokemons.get(1).getName()).isEqualTo("Rattata");
    }

    @Test
    public void testGetById() throws Exception {
        assertThat(dao.getById("AboHotelBis").getName()).isEqualTo("AboHotelBis");
        assertThat(dao.getById("Rattata").getName()).isEqualTo("Rattata");
    }

    @Test
    public void testDelete() throws Exception {
        dao.delete(dao.getById("AboHotelBis"));
        assertThat(dao.getById("AboHotelBis")).isNull();
    }

    @Test
    public void testInsert() throws Exception {
        Pokemon pika = new Pokemon();
        pika.setName("Pikachu");
        pika.setType1(Type.ELECTRIC);
        dao.insert(pika);
        assertThat(dao.getById("Pikachu").getName()).isEqualTo("Pikachu");
        assertThat(dao.getById("Pikachu").getType1()).isEqualTo(Type.ELECTRIC);
    }

    @Test
    public void testUpdate() throws Exception {
        Pokemon abo = dao.getById("AboHotelBis");
        assertThat(abo.getLevel()).isGreaterThan(0);
        abo.setLevel(-2);
        dao.update(abo);
        assertThat(dao.getById("AboHotelBis").getLevel()).isLessThan(0);
    }
}