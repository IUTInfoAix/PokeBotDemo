package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokeAttackCellTest {
    PokeAttackCell cell = new PokeAttackCell();
    Pokemon poke = new Pokemon();

    @Test
    public final void test() {
        Tweet tweet = new Tweet(poke.getOwner(),
        "@abohotelbis #attack #ligotage @pika /cc @thepomoaa");
        assertEquals("@pika #attack #ligotage /cc @thepomoaa @" + poke.getOwner(),
                cell.ask(tweet));
    }

    @Test
    public final void test2() {
        Tweet tweet = new Tweet("nedseb",
                "@abohotelbis #attack #ligotage @pika");
        assertEquals("Sorry, you're not my owner. My owner is " + poke.getOwner(),
                cell.ask(tweet));
    }

    @Test
    public final void test3() {
        Tweet tweet = new Tweet("nedseb", "@abohotelbis #coucou");
        assertEquals("Sorry, you're not my owner. My owner is " + poke.getOwner(), cell.ask(
                tweet));
    }
    
    @Test
    public final void test4() {
        Tweet tweet = new Tweet(poke.getOwner(), "@abohotelbis #coucou");
        assertEquals("Ce n'est pas une attaque", cell.ask(
                tweet));
    }
}