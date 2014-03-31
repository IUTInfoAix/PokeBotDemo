package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.smartcell.*;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokeBot implements Bot {
    /**
     * List of smartcell the questions go through to
     * find an answer.
     */
    private final SmartCell[] smartCells = new SmartCell[]{
            new PokeAskOwnerCell(),
            new OwnAskPkmnAtkCell(),
            new PkmnAtkPkmnDressCell(),
            new PokemonCriesCell(),
    };

    /**
     * Ask something to Bot, it will respond to you.
     *
     * @param question The question you ask.
     * @return An answer... or null if it doesn't get it.
     */
    @Override
    public String ask(Tweet question) {
        for (SmartCell cell : smartCells) {
            String answer = cell.ask(question);
            if (answer != null) {
                return answer;
            }
        }
        return null;
    }

}
