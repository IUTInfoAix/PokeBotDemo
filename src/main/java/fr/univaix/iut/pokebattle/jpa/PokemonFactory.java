package fr.univaix.iut.pokebattle.jpa;

public class PokemonFactory {

    public static void createPoke(Pokemon poke) {
        DAOPokemon dao = DAOFactoryJPA.createDAOPokemon();
        dao.update(poke);
    }
}