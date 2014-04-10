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
    PokeBot pokeBot;


    @Test
    public void testAskHelloFromFollower() throws CloneNotSupportedException {        
        pokeBot = new PokeBot();
        assertEquals("@Tristan Hi @Tristan, I am Abo.", pokeBot.ask(new Tweet("Tristan", "Hi, how are you ?")));
    }

    @Test
    public void testAskHelloFromNoOne() throws CloneNotSupportedException {        
        pokeBot = new PokeBot();
        assertEquals("Hi, I am Abo.", pokeBot.ask(new Tweet("Hi, how are you ?")));

    }


    @Test
    public void testAskNoOwner() throws CloneNotSupportedException {
        pokeBot = new PokeBot();
        assertEquals("@Tristan I don't have owner.", pokeBot.ask(new Tweet("Tristan", "Do you have an owner ?")));
    }

    @Test
    public void testASkOwner() throws CloneNotSupportedException {
        pokeBot = new PokeBot();
        assertEquals("@Tristan My owner is @CaptainObvious.", pokeBot.ask(new Tweet("Tristan","Do you have an owner ?")));
    }

    @Test
    public void testNoQuestion() throws CloneNotSupportedException {
        pokeBot = new PokeBot();
        assertEquals("@Tristan I don't understand your question.", pokeBot.ask(new Tweet("Tristan", "This is not a question")));

    }
}
