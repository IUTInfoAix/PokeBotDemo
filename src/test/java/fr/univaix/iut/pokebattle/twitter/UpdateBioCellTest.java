package fr.univaix.iut.pokebattle.twitter;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.jpa.Pokemon;
import org.junit.Test;

import org.mockito.Mockito;
import twitter4j.Twitter;

public class UpdateBioCellTest {
    UpdateBioCell updateBioCell;

    @Test
    public void testUpdate() throws Exception {
        Pokemon poke = new Pokemon("Ronflaix");
        poke.setLevel(100);
        poke.setEleveur("slydevis");
        Twitter twitter = Mockito.mock(Twitter.class);
        PokeBot bot = new PokeBot();
        bot.setTwitter(twitter);
        updateBioCell = UpdateBioCell.getInstance();
        updateBioCell.update(poke);
        Mockito.verify(twitter).updateProfile("Ronflaix", "", "", "#pokebattle - #pokemon - Owner: @slydevis - Level: 100");
    }
}
