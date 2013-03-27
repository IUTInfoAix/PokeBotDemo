package fr.univaix.iut.pokebattle.smartcell;


import fr.univaix.iut.pokebattle.twitter.Tweet;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokemonCriesCellTest {

    PokemonCriesCell cell = new PokemonCriesCell();
    
    @Test
    public void testSalut() {
        assertEquals("@nedseb Sala sala", cell.ask(new Tweet("nedseb", "@Salameche_PKWEM Salut!")));
    }

    @Test
    public void testNotSalut() {
        assertEquals("@nedseb Sala sala", cell.ask(new Tweet("nedseb", "@Salameche_PKWEM au revoir")));
    }
    

}
