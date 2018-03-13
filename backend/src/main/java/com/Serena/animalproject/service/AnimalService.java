package com.serena.animalproject.service;

import com.serena.animalproject.model.bean.response.AnimalBeanCollectionResponse;
import com.serena.animalproject.model.bean.response.AnimalBeanResponse;

import org.springframework.stereotype.Service;

@Service
public interface AnimalService {
    AnimalBeanCollectionResponse getAnimals();
    AnimalBeanResponse getAnimal(long animalId);
}
