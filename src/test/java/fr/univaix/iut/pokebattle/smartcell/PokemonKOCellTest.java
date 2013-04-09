package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.univaix.iut.pokebattle.DAO.DAOCombat;
import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOOwner;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Combat;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.PokeCell.PokemonKOCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonKOCellTest {

	@Test
	public void test() {
		PokemonKOCell cell = new PokemonKOCell();
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Combat fight = new Combat ();
		
		DAOFactory daof = new DAOFactory(em);
		
		DAOPokemon daoPoke = daof.createDAOPokemon();
		DAOCombat daoCombat = daof.createDAOCombat();
		DAOOwner daoOwner = daof.createDAOOwner();
		
		
		Pokemon poke_1 = daoPoke.getByNom("@Smogogo13");
		Pokemon poke_2 = daoPoke.getByNom("@GwenGoupix");
		
		fight.setPoke_1(poke_1);
		fight.setPoke_2(poke_2);
		fight.setOwner_1(daoOwner.getByPokemon(poke_1).getPrenom());
		fight.setOwner_2(daoOwner.getByPokemon(poke_2).getPrenom());
		fight.setIdCombat(daoCombat.getMaxNumCB());
		
		em.persist(fight);
		em.getTransaction().commit();*/
		
		assertEquals("#KO /cc @Kyiio @cybsip @CloudDeLuna", cell.ask(new Tweet("Kyiio", "@GwenGoupix -10pv /cc @CloudDeLuna")));
		//ce test a besoin que cette ligne soit presente dans la table Combat
		//	insert into COMBAT values ( 1 , '@Smogogo13' , '@cybsip' , '@GwenGoupix' ,  '@CloudDeLuna' ) ;
	}

}
