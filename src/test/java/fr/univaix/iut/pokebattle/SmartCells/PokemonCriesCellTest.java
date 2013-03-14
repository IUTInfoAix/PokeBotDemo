package fr.univaix.iut.pokebattle.SmartCells;

import fr.univaix.iut.pokebattle.Tweet;
import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();

    @Test
    public void testSalut() {
<<<<<<< HEAD
        assertEquals("Puce puce", cell.ask("Salut!"));
=======
        assertEquals("Pika pika", cell.ask(new Tweet("Salut!")));
>>>>>>> 2bf7a026081c1360147969ecaf5901df8d4cc176
    }

    @Test
    public void testNotSalut() {
<<<<<<< HEAD
        assertEquals("Puce puce", cell.ask("au revoir"));
=======
        assertEquals("Pika pika", cell.ask(new Tweet("au revoir")));
>>>>>>> 2bf7a026081c1360147969ecaf5901df8d4cc176
    }

}
