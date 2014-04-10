package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

import java.util.Scanner;

public class PokeKOCell implements SmartCell {

    private String badOwner;
    private String judge;

    public void setBadOwner(String owner) {
        this.badOwner = owner;
    }

    public void setjudge(String judge) {
        this.judge = judge;
    }

    public int decodeLife(String str) {
        Scanner in = new Scanner(str).useDelimiter("[^0-9]+");
        int integer = in.nextInt();
        return integer;
    }

    public String ask(Tweet question) {
        if (question.getText().matches("@[A-Z][a-z]+ -[0-9]+pv /cc @[a-z]+")) {
            judge = question.getScreenName();
            badOwner = OwnAskPkmnAtkCell.getDresscible();
            if (badOwner != null && judge != null) {
                System.out.println(badOwner + " " + judge);
                Pokemon poke = PokeAskOwnerCell.recupInfo(question.getText());
                if (poke.getEleveur() == null) {
                    return null;
                }
                int nbLife = poke.getPV() - decodeLife(question.getText());
                if (nbLife <= 0) {
                    poke.setPV(0);
                    return "#KO /cc @" + judge + " " + badOwner
                            + " @" + poke.getEleveur();
                }
                poke.setPV(nbLife);
                return null;
            }
            return null;
        }
        return null;
    }
}
