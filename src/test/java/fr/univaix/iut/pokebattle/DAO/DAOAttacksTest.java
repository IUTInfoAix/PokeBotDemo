/*package fr.univaix.iut.pokebattle.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import fr.univaix.iut.pokebattle.beans.Attacks;
import fr.univaix.iut.pokebattle.beans.DataObjectAttack;
import fr.univaix.iut.pokebattle.beans.DataObjectPokemon;
import fr.univaix.iut.pokebattle.beans.Pokedex;
import fr.univaix.iut.pokebattle.beans.Pokemon;

public class DAOAttacksTest {

	@Test
	public void test() {
		
        Pokedex pok = Pokedex.getInstance();

        DataObjectPokemon[] pokeListe = pok.getData();
        
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
        EntityManager em = emf.createEntityManager();
        
		DAOFactory daof = new DAOFactory(em);
		DAOPokemon daoPoke = daof.createDAOPokemon();
		
		Pokemon pokName = daoPoke.getByNom("@Smogogo13");
		//Pokemon pokName = daoPoke.getByNom("@Dracaufeu13");
		//Pokemon pokName = daoPoke.getByNom("@GwenGoupix");
        
		em.getTransaction().begin();
		
        for (DataObjectPokemon j : pokeListe)
        {
        	if (pokName.getRace().equals(j.getNom()))
        	{
	        	DataObjectAttack[] listesAtt = j.getAttaques();
		        for (DataObjectAttack i : listesAtt)
		        {
		        	Attacks att = new Attacks();
		        	
		        	att.setPokemon(pokName);
		        	att.setAttack(i.getNom());
		        	att.setNiveau(i.getNiveau());
		        	att.setPP(i.getPp());
		        	att.setPrecision(i.getPrecision());
		        	att.setPuissance(i.getPuissance());
		        	
		        	em.persist(att);
		        	
		        	System.out.print(att);
		        }
        	}
        }
        
        em.getTransaction().commit();
	}

}*/
