package fr.univaix.iut.progbd;


import java.util.List;

public interface DAOOwner extends DAO<Owner, String> {
    public List<Owner> findByName(String name);
}