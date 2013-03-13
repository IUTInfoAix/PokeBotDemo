package fr.univaix.iut.pokebattle;

import org.junit.Test;

import twitter4j.Status;
import twitter4j.StatusUpdate;

/**
 * Integration tests checking the PokeBot
 * behavior. We just test some cases to make sure that the
 * PokeBot is using SmartCells properly.
 */
public class PokeBotTest {
    PokeBot pokeBot = new PokeBot();

    @Test
    public void testSalut() {
        System.out.println(pokeBot.ask("@cybsip Salut"));
        System.out.println(pokeBot.ask("This is not a question."));
    }
}
