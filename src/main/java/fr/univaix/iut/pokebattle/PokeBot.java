package fr.univaix.iut.pokebattle;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.smartcells.PokemonAttackCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonCaptureCell;
import fr.univaix.iut.pokebattle.smartcells.PokemonCriesCell;


public class PokeBot implements Bot {
    /**
     * List of SmartCells the questions go through to
     * find an answer.
     */
    final SmartCell[] smartCells = new SmartCell[]{
    		new PokemonAttackCell(),
    		new PokemonCaptureCell(),
    		new PokemonCriesCell(),
    };

    /**
     * Ask something to BoBot, it will respond to you.
     *
     * @param question The question you ask.
     * @return An answer... or null if it doesn't get it.
     * @throws TwitterException 
     * @throws IllegalStateException 
     */
    @Override
    public String ask(Tweet question) throws IllegalStateException, TwitterException {
        for (SmartCell cell : smartCells) {
            String answer = cell.ask(question);
            if (answer != null)
                return answer;
        }
        return null;
    }

}
