package com.serena.animalproject.dao;

import com.serena.animalproject.model.Animal;

import java.util.Collection;

public interface OwnerDao {
    Collection<Animal> getAnimals();
}
