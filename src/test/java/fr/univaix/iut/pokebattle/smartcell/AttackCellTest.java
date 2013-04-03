package fr.univaix.iut.pokebattle.smartcell;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AttackCellTest {
	
	
    @Test
    public void testAttack() {
    	AttackCell cell = new AttackCell();
    	
    	assertEquals("@SALAMECHE_PKWEM #attack #foudre! /cc @WII2ZO", cell.ask(new Tweet("WII2ZO", "@PIKACHU_PKWEM #attack #foudre @SALAMECHE_PKWEM")));
    }

    @Test
    public void testNoAttack() {
    	AttackCell cell = new AttackCell();
    	
        assertEquals("@nedseb @nedseb is my owner", cell.ask(new Tweet("nedseb", "@PSYKOKWAK_PKWEM #attack #foudre @SALAMECHE_PKWEM")));
    }
    

}
