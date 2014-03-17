package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

/**
 * Reply to all.
 */
public class JudgeAnswerCell implements SmartCell {

    public String ask(Tweet question) {
        if (question.getScreenName() != null) {
        	System.out.println("@" + question.getScreenName() + " salut");
        	return "@" + question.getScreenName() + " salut ma poule";
        }
        return "salut";
    }

}
