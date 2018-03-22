package com.serena.animalproject.dao.impl;

import com.serena.animalproject.dao.AnimalDao;
import com.serena.animalproject.model.Animal;
import com.serena.animalproject.utility.JPAUtility;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import java.util.Collection;

@Repository("animalDao")
public class AnimalDaoImpl implements AnimalDao {

    protected EntityManager entityManager = JPAUtility.getEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();

    // Giro getAnimals
    @Transactional
    public Collection<Animal> getAnimals() {
        return (Collection<Animal>) entityManager.createNamedQuery("getAnimals", Animal.class)
                .getResultList();
    }

    //  Giro getAnimal
    @Transactional
    public Animal getAnimal(long animalId) {
        return (Animal) entityManager.createNamedQuery("getAnimal", Animal.class)
                .setParameter("animalId", animalId)
                .getSingleResult();
    }

    // Giro updateAnimal
    @Transactional
    public String updateAnimal(Animal animalFromDB) {
        String response;
        entityTransaction.begin();
        try {
            entityManager.merge(animalFromDB);
            entityTransaction.commit();
            response = "SUCCESS";
        } catch(Exception exception) {
            entityTransaction.rollback();
            response = "FAILED";
        }
        return response;
    }

    // Giro createAnimal
    @Transactional
    public Animal createAnimal(Animal animal) {
        entityTransaction.begin();
        entityManager.persist(animal);
        entityTransaction.commit();
        return animal;
    }

    // Giro deleteAnimal
    @Transactional
    public String deleteAnimal(long animalId) {
        String response;
        entityTransaction.begin();
        try {
            entityManager.createNamedQuery("deleteAnimal")
                    .setParameter("animalId", animalId)
                    .executeUpdate();
            entityTransaction.commit();
            response = "SUCCESS";
        } catch(Exception exception) {
            entityTransaction.rollback();
            response = "FAILED";
        }
        return response;
    }
}
