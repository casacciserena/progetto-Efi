package com.serena.animalproject.dao.impl;

import com.serena.animalproject.dao.AnimalDao;
import com.serena.animalproject.dao.OwnerDao;
import com.serena.animalproject.model.Animal;

import com.serena.animalproject.model.Owner;
import com.serena.animalproject.utility.JPAUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository("ownerDao")
public class OwnerDaoImpl implements OwnerDao {

    protected EntityManager entityManager = JPAUtility.getEntityManager();

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    protected Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }

    @Transactional
    public Collection<Owner> getOwners() {
        return (Collection<Owner>) entityManager.createNamedQuery("getOwners", Owner.class)
                .getResultList();
    }
}
