package fr.univaix.iut.pokebattle.smartcell;

import org.junit.Test;

import twitter4j.TwitterException;

import static org.fest.assertions.Assertions.assertThat;

import fr.univaix.iut.pokebattle.smartcell.PokeCell.PokemonWinXPCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonWinXPCellTest {

	PokemonWinXPCell cell = new PokemonWinXPCell();
	@Test
	public void test() throws IllegalStateException, TwitterException {
		assertThat(cell.ask(new Tweet("Smogogo13","@GwenGoupix #Win +24xp"))).isNull();
	}

}
