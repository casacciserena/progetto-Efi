package com.serena.animalproject.dao;

import com.serena.animalproject.model.Animal;

import java.util.Collection;

public interface AnimalDao {
    // Giro getAnimals
    Collection<Animal> getAnimals();

    // Giro getAnimal
    Animal getAnimal(long animalId);

    // Giro createAnimal
    Animal createAnimal (Animal animal);

    // Giro updateAnimal
    String updateAnimal(Animal animalFromDB);

    // Giro deleteAnimal
    String deleteAnimal(long animalId);
}
