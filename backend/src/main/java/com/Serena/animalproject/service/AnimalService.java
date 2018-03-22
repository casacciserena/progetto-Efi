package com.serena.animalproject.service;

import com.serena.animalproject.model.bean.AnimalBean;
import com.serena.animalproject.model.bean.response.AnimalBeanCollectionResponse;
import com.serena.animalproject.model.bean.response.AnimalBeanResponse;

import org.springframework.stereotype.Service;

@Service
public interface AnimalService {
    // Giro getAnimals
    AnimalBeanCollectionResponse getAnimals();

    // Giro getAnimal
    AnimalBeanResponse getAnimal(long animalId);

    // Giro createAnimal
    AnimalBeanResponse createAnimal(AnimalBean animalBean);

    // Giro updateAnimal
    String updateAnimal(long animalId, AnimalBean animalBean);

    // Giro deleteAnimal
    String deleteAnimal(long animalId);
}
