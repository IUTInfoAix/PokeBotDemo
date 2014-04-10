package fr.univaix.iut.pokebattle;

import java.util.List;

public interface DAOAttaque extends DAO<Attaque, String> {
    public List<Attaque> findByType(String type);
    public Attaque getById(String nom);
    
}