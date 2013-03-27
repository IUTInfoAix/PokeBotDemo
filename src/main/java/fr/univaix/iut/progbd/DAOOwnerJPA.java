package fr.univaix.iut.progbd;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOOwnerJPA implements DAOOwner {

    private EntityManager entityManager;

    public DAOOwnerJPA(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Owner> findByName(String name) {
        TypedQuery<Owner> query = entityManager.createNamedQuery(Owner.FIND_BY_NAME, Owner.class);
        query.setParameter("fname", name);
        return query.getResultList();
    }

    @Override
    public boolean delete(Owner obj) {
        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Owner> findAll() {
        TypedQuery<Owner> query = entityManager.createNamedQuery(Owner.FIND_BY_NAME, Owner.class);
        return query.getResultList();
    }

    @Override
    public Owner getById(String id) {
        return entityManager.find(Owner.class, id);
    }

    @Override
    public Owner insert(Owner obj) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(obj);
        tx.commit();
        return entityManager.find(Owner.class, obj.getNom_owner());
    }

    @Override
    public boolean update(Owner obj) {
        try {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(obj);
            tx.commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}