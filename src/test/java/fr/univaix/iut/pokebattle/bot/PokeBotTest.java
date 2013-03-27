package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Integration tests checking the PokeBot
 * behavior. We just test some cases to make sure that the
 * PokeBot is using smartcell properly.
 */
public class PokeBotTest {
    PokeBot pokeBot = new PokeBot();

    @Test
    public void testSalut() {
       // assertEquals(null, pokeBot.ask(new Tweet("Salut")));
       // assertEquals(null, pokeBot.ask(new Tweet("This is not a question.")));
        //assertEquals("@nedseb Sala sala", pokeBot.ask(new Tweet("nedseb", "Salut")));
       // assertEquals("@nedseb Sala sala", pokeBot.ask(new Tweet("nedseb", "This is not a question.")));

    }
}
