package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.smartcell.PokeCell.PokemonFeatureAttackCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonFeatureAttackCellTest {

	PokemonFeatureAttackCell cell = new PokemonFeatureAttackCell();
	
	@Test
	public void testPP() {
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #statAttack #PP #Hurlement ?")));
		assertEquals("@CloudDeLuna #Hurlement #PP=20/20", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #statAttack #PP #Hurlement ?")));
	}
	
	@Test
	public void testPrecision() {
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #statAttack #PRECISION #Hurlement ?")));
		assertEquals("@CloudDeLuna #Hurlement #PRECISION=100", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #statAttack #PRECISION #Hurlement ?")));
	}
	
	@Test
	public void testPuissance() {
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #statAttack #PUISSANCE #Hurlement ?")));
		assertEquals("@CloudDeLuna #Hurlement #PUISSANCE=-", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #statAttack #PUISSANCE #Hurlement ?")));
	}
	
	@Test
	public void testNiveau() {
		System.out.println(cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #statAttack #NIVEAU #Hurlement ?")));
		assertEquals("@CloudDeLuna #Hurlement #NIVEAU=N.9", cell.ask(new Tweet("CloudDeLuna", "@GwenGoupix #statAttack #NIVEAU #Hurlement ?")));
	}

}
