package fr.univaix.iut.pokebattle;

import java.util.List;

public interface DAOPokemon extends DAO<Pokemon, String> {
    public List<Pokemon> findByType(Type type1);
    public Pokemon getById(String nom);
    
}
