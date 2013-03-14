package fr.univaix.iut.pokebattle;

public interface SmartCell {
    /**
     * Ask a question... get an answer!
     *
     * @param question
     * @return the answer when the Cell can reply to the question
     *         or null.
     */
    public abstract String ask(Tweet question);
}
