package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();

    @Test
    public void testSalut() {
        assertEquals("@nedseb RON-FLEEEX", cell.ask(new Tweet("nedseb", "Salut!")));
    }

    @Test
    public void testNotSalut() {
        assertEquals("@nedseb RON-FLEEEX", cell.ask(new Tweet("nedseb", "au revoir")));
    }

}
