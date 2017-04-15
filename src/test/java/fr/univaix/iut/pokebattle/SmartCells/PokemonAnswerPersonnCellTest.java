package fr.univaix.iut.pokebattle.SmartCells;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonAnswerPersonCell;

public class PokemonAnswerPersonnCellTest {
	PokemonAnswerPersonCell pk = new PokemonAnswerPersonCell();
	
	@Test
	public void TestSalut(){
        assertEquals("@youvannn Skwalop skwalop", pk.ask(new Tweet("@youvannn", "@carapuce Salut!")));
	}
}
