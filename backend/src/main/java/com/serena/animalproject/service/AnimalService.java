package com.serena.animalproject.service;

import com.serena.animalproject.model.bean.AnimalBean;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface AnimalService {
    Collection<AnimalBean> getAnimals();
}
