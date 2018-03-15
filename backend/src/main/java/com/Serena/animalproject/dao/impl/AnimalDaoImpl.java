package com.serena.animalproject.dao.impl;

import com.serena.animalproject.dao.AnimalDao;
import com.serena.animalproject.model.Animal;
import com.serena.animalproject.utility.JPAUtility;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Collection;

@Repository("animalDao")
public class AnimalDaoImpl implements AnimalDao {

    protected EntityManager entityManager = JPAUtility.getEntityManager();

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    protected Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }

    @Transactional
    public Collection<Animal> getAnimals() {
        return (Collection<Animal>) entityManager.createNamedQuery("getAnimals", Animal.class)
                .getResultList();
    }

    @Transactional
    public Animal getAnimal(long animalId) {
        return (Animal) entityManager.createNamedQuery("getAnimal", Animal.class)
                .setParameter("animalId", animalId)
                .getSingleResult();
    }

    @Transactional
    public String updateAnimal(Animal animalFromDB) {
        String response;
        try {
            entityManager.merge(animalFromDB);
            entityManager.flush();
            response = "SUCCESS";
        } catch(Exception exception) {
            response = "FAILED";
        }
        return response;
    }

    @Transactional
    public Animal createAnimal(Animal animal) {
        entityManager.persist(animal);
        entityManager.flush();
        return animal;
    }

    @Transactional
    public String deleteAnimal(long animalId) {
        String response;
        try {
            entityManager.createNamedQuery("deleteAnimal", Animal.class)
                    .setParameter("animalId", animalId)
                    .executeUpdate();
            entityManager.flush();
            response = "SUCCESS";
        } catch(Exception exception) {
            response = "FAILED";
        }
        return response;
    }
}
