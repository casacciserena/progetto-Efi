package com.serena.animalproject.service;

import com.serena.animalproject.model.bean.response.OwnerBeanCollectionResponse;

import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
    OwnerBeanCollectionResponse getOwners();
}