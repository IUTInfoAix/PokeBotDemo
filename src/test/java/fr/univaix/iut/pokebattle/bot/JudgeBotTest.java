package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.*;

public class JudgeBotTest {
    JudgeBot judgeBot = new JudgeBot();

    @Test
    public void testAsk() throws Exception {
        assertThat(judgeBot.ask(new Tweet("Salut"))).isNull();
        assertThat(judgeBot.ask(new Tweet("This is not a question."))).isNull();
        assertEquals("@GwenGoupix -10pv /cc @CloudDeLuna" , judgeBot.ask(new Tweet("@Smogogo13" , "@GwenGoupix #attack #Detritus /cc @CloudDeLuna @cybsip @zaza13" )) );
    }
}
