package fr.univaix.iut.pokebattle.bot;

import com.google.common.collect.Lists;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import java.util.List;

import twitter4j.TwitterException;


public class JudgeBot implements Bot {
    /**
     * List of smartcell the questions go through to
     * find an answer.
     */
    final List<SmartCell> smartCells = Lists.newArrayList();

    /**
     * Ask something to Bot, it will respond to you.
     *
     * @param question The question you ask.
     * @return An answer... or null if it doesn't get it.
     * @throws TwitterException 
     * @throws IllegalStateException 
     */
    @Override
    public String ask(Tweet question) throws IllegalStateException, TwitterException {
        for (SmartCell cell : smartCells) {
            String answer; 
            answer = cell.ask(question);
            if (answer != null)
                return answer;
        }
        return null;
    }

}
