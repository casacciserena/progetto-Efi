package com.serena.animalproject.dao.impl;

import com.serena.animalproject.dao.OwnerDao;
import com.serena.animalproject.model.Owner;
import com.serena.animalproject.utility.JPAUtility;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import java.util.Collection;

@Repository("ownerDao")
public class OwnerDaoImpl implements OwnerDao {

    protected EntityManager entityManager = JPAUtility.getEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();

    // Giro getOwners
    @Transactional
    public Collection<Owner> getOwners() {
        return (Collection<Owner>) entityManager.createNamedQuery("getOwners", Owner.class)
                .getResultList();
    }

    // Giro GetOwner
    @Transactional
    public Owner getOwner(long ownerId) {
        return (Owner) entityManager.createNamedQuery("getOwner", Owner.class)
                .setParameter("ownerId", ownerId)
                .getSingleResult();
    }
    // Giro updateOwner
    @Transactional
    public String updateOwner(Owner ownerFromDB) {
        String response;
        entityTransaction.begin();
        try {
            entityManager.merge(ownerFromDB);
            entityTransaction.commit();
            response = "SUCCESS";
        } catch(Exception exception) {
            entityTransaction.rollback();
            response = "FAILED";
        }
        return response;
    }
}
