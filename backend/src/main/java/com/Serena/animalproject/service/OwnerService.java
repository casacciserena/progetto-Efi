package com.serena.animalproject.service;

import com.serena.animalproject.model.bean.response.AnimalBeanCollectionResponse;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
    AnimalBeanCollectionResponse getOwner();
}