package fr.univaix.iut.pokebattle.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.jpa.Pokemon.Type;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class PokemonFactory {

    public static void createPoke(Pokemon poke) {
        DAOPokemon dao = DAOFactoryJPA.createDAOPokemon();
        dao.delete(dao.getById(poke.getName()));
        dao.insert(poke);
    }
}