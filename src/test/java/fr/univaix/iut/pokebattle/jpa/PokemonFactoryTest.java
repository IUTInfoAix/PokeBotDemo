package fr.univaix.iut.pokebattle.jpa;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;

import static org.fest.assertions.Assertions.assertThat;

public class PokemonFactoryTest {
    private static EntityManager entityManager;
    private static FlatXmlDataSet dataset;
    private static DatabaseConnection dbUnitConnection;
    private static EntityManagerFactory entityManagerFactory;
    private static DAOPokemon dao;

    PokemonFactory pf = new PokemonFactory();

    @BeforeClass
    public static void initTestFixture() throws Exception {
        // Get the entity manager for the tests.

        entityManagerFactory = Persistence.createEntityManagerFactory("pokebattlePUTest");
        entityManager = entityManagerFactory.createEntityManager();
        DAOFactoryJPA.setEntityManager(entityManager);

        dao = DAOFactoryJPA.createDAOPokemon();

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
    public void testCreatePoke() throws Exception {

        Pokemon ronflex = new Pokemon("Ronflaix");
        ronflex.setType1(Pokemon.Type.NORMAL);
        ronflex.setBaseHP(160);
        ronflex.setAttack(110);
        ronflex.setDefense(65);
        ronflex.setAttackSpecial(65);
        ronflex.setDefenseSpecial(110);
        ronflex.setSpeed(30);

        pf.createPoke(ronflex);

        assertThat(dao.getById("Ronflaix")).isNotNull();
    }
}
