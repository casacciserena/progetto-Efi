package com.serena.animalproject.service;

import com.serena.animalproject.model.bean.OwnerBean;
import com.serena.animalproject.model.bean.response.OwnerBeanCollectionResponse;
import com.serena.animalproject.model.bean.response.OwnerBeanResponse;

import org.springframework.stereotype.Service;

@Service
public interface OwnerService {
    // Giro getOwners
    OwnerBeanCollectionResponse getOwners();

    // Giro getOwner
    /*OwnerBeanResponse getOwner(long ownerId);*/

    // Giro createOwner
    //OwnerBeanResponse createOwner(OwnerBean ownerBean);

    // Giro updateOwner
    //String updateOwner(long ownerId, OwnerBean ownerBean);

    // Giro deleteOwner
    //String deleteOwner(long ownerId);
}
