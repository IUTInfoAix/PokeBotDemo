package fr.univaix.iut.pokebattle.SmartCells;

import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();

    @Test
    public void testSalut() {
        assertEquals("Puce puce", cell.ask("Salut!"));
    }

    @Test
    public void testNotSalut() {
        assertEquals("Puce puce", cell.ask("au revoir"));
    }

}
