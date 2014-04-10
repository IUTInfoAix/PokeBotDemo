package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import fr.univaix.iut.pokebattle.jpa.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.jpa.DAOPokemon;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;

public class OwnAskPkmnAttCellTest {

	OwnAskPkmnAtkCell cell = new OwnAskPkmnAtkCell();

private static EntityManager entityManager;
    private static FlatXmlDataSet dataset;
    private static DatabaseConnection dbUnitConnection;
    private static EntityManagerFactory entityManagerFactory;
    private static DAOPokemon dao;


    @BeforeClass
    public static void initTestFixture() throws Exception {

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
	public void ownerAskAtkTest() {
		assertEquals("@bulbizarre #attack #plaquage! /cc @slydevis",
				cell.ask(new Tweet("slydevis", "@Pikachu #attack #plaquage @bulbizarre")));
	}

	@Test
	public void notOwnerAskAtkTest() {
		assertEquals(null,
				cell.ask(new Tweet("nedseb", "attack")));
	}
	
	@Test
	public void ownerAskAtkDressTest() {
		assertEquals("@bulbizarre #attack #plaquage! /cc @gantben @slydevis",
				cell.ask(new Tweet("slydevis", "@Pikachu #attack #plaquage @bulbizarre /cc @gantben")));
	}
	
}
