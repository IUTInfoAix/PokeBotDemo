package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CatchPokemonTest {
	CatchPokemonCell cell = new CatchPokemonCell();
	
	@Test
	public void TestCatchWithoutEleveur(){
		PokeBot pokeBot = new PokeBot();
		
		assertEquals("@CaptainObvious is now my owner.", cell.ask(new Tweet ("CaptainObvious","POKEBALL !")));
	}
	
	@Test
	public void TestCatchWithEleveur(){
		PokeBot pokeBot = new PokeBot();
		
		assertEquals("I already have an owner is name is @Jacky.", cell.ask(new Tweet("CaptainObvious", "POKEBALL !")));
	}
}
