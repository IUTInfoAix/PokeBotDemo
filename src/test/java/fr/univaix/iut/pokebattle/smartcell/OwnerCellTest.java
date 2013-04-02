package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OwnerCellTest {

	@Test
    public void testOwner() {
    	OwnerCell cell = new OwnerCell();
    	
    	assertEquals("@nedseb @WII2ZO is my owner",
    			cell.ask(new Tweet("nedseb", "@PIKACHU_PKWEM Owner ?")));
    }

}
