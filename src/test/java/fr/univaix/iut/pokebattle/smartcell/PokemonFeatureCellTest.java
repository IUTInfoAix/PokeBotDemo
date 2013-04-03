package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonFeatureCellTest {

    PokemonFeatureCell cell = new PokemonFeatureCell();
	
	@Test
	public void testRace() {
		assertEquals("@CloudDeLuna #race = Goupix", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #race ?")));
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #race ?")));
	}
	
	@Test
	public void testLevel() {
		assertEquals("@CloudDeLuna #level = N.1", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #level ?")));
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #level ?")));
	}
	
	@Test
	public void testXP() {
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #XP ?")));
		assertEquals("@CloudDeLuna #XP = XP.0", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #XP ?")));
	}
	
	/*@Test
	public void testPV() {
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #PV ?")));
		assertEquals("@CloudDeLuna #PV = 70/100", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #PV ?")));
	}*/
	
	@Test
	public void testAtt() {
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #ATT ?")));
		assertEquals("@CloudDeLuna #ATT = 0", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #ATT ?")));
	}
	
	@Test
	public void testDef() {
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #DEF ?")));
		assertEquals("@CloudDeLuna #DEF = 0", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #DEF ?")));
	}
	
	@Test
	public void testAttSpe() {
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #ATTSPE ?")));
		assertEquals("@CloudDeLuna #ATTSPE = 0", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #ATTSPE ?")));
	}
	
	@Test
	public void testDefSpe() {
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #DEFSPE ?")));
		assertEquals("@CloudDeLuna #DEFSPE = 0", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #DEFSPE ?")));
	}
	
	@Test
	public void testVit() {
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #VIT ?")));
		assertEquals("@CloudDeLuna #VIT = 0", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #stat #VIT ?")));
	}

}
