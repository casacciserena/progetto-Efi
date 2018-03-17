package com.serena.animalproject.dao.impl;

import com.serena.animalproject.dao.OwnerDao;
import com.serena.animalproject.model.Owner;
import com.serena.animalproject.utility.JPAUtility;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Collection;

@Repository("ownerDao")
public class OwnerDaoImpl implements OwnerDao {

    protected EntityManager entityManager = JPAUtility.getEntityManager();

    @Transactional
    public Collection<Owner> getOwners() {
        return (Collection<Owner>) entityManager.createNamedQuery("getOwners", Owner.class)
                .getResultList();
    }

    @Transactional
    public Owner getOwner(long ownerId) {
        return (Owner) entityManager.createNamedQuery("getOwner", Owner.class)
                .setParameter("ownerId", ownerId)
                .getSingleResult();
    }
}
