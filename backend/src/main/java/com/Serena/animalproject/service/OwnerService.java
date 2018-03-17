package com.serena.animalproject.service;

import com.serena.animalproject.model.bean.OwnerBean;
import com.serena.animalproject.model.bean.response.OwnerBeanCollectionResponse;
import com.serena.animalproject.model.bean.response.OwnerBeanResponse;

import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
    OwnerBeanCollectionResponse getOwners();
    OwnerBeanResponse getOwner(long ownerId);
    OwnerBeanResponse createOwner(OwnerBean ownerBean);
    String updateOwner(long ownerId, OwnerBean ownerBean);
    String deleteOwner(long ownerId);
}
