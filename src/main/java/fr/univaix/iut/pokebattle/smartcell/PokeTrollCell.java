package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokeTrollCell implements SmartCell {
    public String ask(Tweet question) {
        if (question.getText().contains("Troll")) {
           return "@" + question.getScreenName() + " Trolol "
                   + "http://www.dailymotion.com/video/xtczcf_gandalf-epic-sax-guy_fun";
        }
        return null;
    }
}
