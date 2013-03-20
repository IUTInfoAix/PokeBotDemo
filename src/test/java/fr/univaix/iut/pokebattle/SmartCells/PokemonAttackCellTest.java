package fr.univaix.iut.pokebattle.SmartCells;

import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonAttackCell;

public class PokemonAttackCellTest {
	
	PokemonAttackCell cell = new PokemonAttackCell();
	Twitter twitter = TwitterFactory.getSingleton();
	
	@Test
	public void testAttack() throws IllegalStateException, TwitterException {
		//assertEquals("@bulbizarre #attack #foudre! /cc @pcreux", cell.ask(new Tweet("@pikachu #attack #foudre @bulbizarre")));
		System.out.println(cell.ask(new Tweet("@CloudDeLuna", "@GwenGoupix #attack #flameche @Smogogo13")));
	}

}

