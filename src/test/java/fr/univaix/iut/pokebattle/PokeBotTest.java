package fr.univaix.iut.pokebattle;

import static org.junit.Assert.*;

import org.junit.Test;

import twitter4j.TwitterException;

/**
 * Integration tests checking the PokeBot
 * behavior. We just test some cases to make sure that the
 * PokeBot is using SmartCells properly.
 */
public class PokeBotTest {
    PokeBot pokeBot = new PokeBot();

    @Test
    public void testSalut() throws IllegalStateException, TwitterException {
        assertEquals("@azaz Pika pika", pokeBot.ask(new Tweet("azaz","Salut")));
        assertEquals("@azaz Pika pika", pokeBot.ask(new Tweet("azaz","This is not a question.")));
    }
}