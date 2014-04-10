package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class CatchPokemonTest {

		CatchPokemonCell cell = new CatchPokemonCell();
		
		private static EntityManager entityManager;
	    private static FlatXmlDataSet dataset;
	    private static DatabaseConnection dbUnitConnection;
	    private static EntityManagerFactory entityManagerFactory;
		
		@BeforeClass
		public static void initTestFixture() throws Exception {
		    // Get the entity manager for the tests.
		    entityManagerFactory = Persistence.createEntityManagerFactory("pokebattlePUTest");
		    entityManager = entityManagerFactory.createEntityManager();

		    DAOFactoryJPA.setEntityManager(entityManager);
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
		public void testCaptureAboHotelBisSucces() throws DatabaseUnitException {
			assertEquals("@CaptainObvious You are now my owner.",
					cell.ask(new Tweet("CaptainObvious", "@AboHotelBis pokeball !")));
		}
			
		@Test
		public void testAboHotelBisFail() throws DatabaseUnitException {
			assertEquals("@CaptainObvious I already have an owner is name is @Tristan.",
					cell.ask(new Tweet("CaptainObvious", "@AboHotelBis pokeball !")));
		}

}