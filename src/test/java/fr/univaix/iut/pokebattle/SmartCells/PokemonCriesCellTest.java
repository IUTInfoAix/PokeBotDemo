package fr.univaix.iut.pokebattle.SmartCells;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();

    @Test
    public void testSalut() {
        assertEquals("@azaz Pika pika", cell.ask(new Tweet("azaz","Salut!")));
    }

    @Test
    public void testNotSalut() {
        assertEquals("@azaz Pika pika", cell.ask(new Tweet("azaz","au revoir")));
    }

}
