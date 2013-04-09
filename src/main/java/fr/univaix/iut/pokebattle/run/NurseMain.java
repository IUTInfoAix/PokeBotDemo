package fr.univaix.iut.pokebattle.run;

import fr.univaix.iut.pokebattle.bot.NurseBot;

public class NurseMain {
    public static void main(String[] args) {
        BotRunner.runBot(new NurseBot(), "twitter4j.properties");
    }
}