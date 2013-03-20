package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonFusionAttackCell;

public class PokemonFusionAttackCellTest {
	PokemonFusionAttackCell poke = new PokemonFusionAttackCell();
	@Test
	public void TestAttack(){
		assertEquals("@bulbizare #attack #ecume //cc @youvannn", poke.ask(new Tweet("youvannn", "@Carapuce #attack #ecume @bulbizare")));
	}
	
	@Test
	public void TestOwner (){
		assertEquals("@raph @youvannn is my owner",  poke.ask(new Tweet("raph","@Carapuce #attack #ecume @bulbizare")));
	}
}
