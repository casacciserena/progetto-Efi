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
public class AnimalDaoImpl implements AnimalDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public Collection<Animal> getAnimals() {
        Criteria criteria = getSession().createCriteria(Animal.class);
        return (Collection<Animal>) criteria.list();
    }
}
