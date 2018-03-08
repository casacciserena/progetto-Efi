package com.serena.animalproject.dao.impl;

import com.serena.animalproject.dao.AnimalDao;
import com.serena.animalproject.model.Animal;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository("animalDao")
public class OwnerDaoImpl implements owerDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public Collection<Owner> getOwners() {
        Criteria criteria = getSession().createCriteria(Owner.class);
        return (Collection<Owner>) criteria.list();
    }
}