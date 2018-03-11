package com.serena.animalproject.service.impl;

import com.serena.animalproject.model.Animal;
import com.serena.animalproject.model.Owner;
import com.serena.animalproject.model.bean.AnimalBean;
import com.serena.animalproject.model.bean.OwnerBean;
import com.serena.animalproject.model.bean.response.AnimalBeanCollectionResponse;
import com.serena.animalproject.model.bean.response.OwnerBeanCollectionResponse;
import com.serena.animalproject.service.AnimalService;

import com.serena.animalproject.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service("ownerService")
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private com.serena.animalproject.dao.OwnerDao ownerDao;

    @Transactional
    public OwnerBeanCollectionResponse getOwners() {

        System.out.println("START");

        Collection<Owner> ownerCollection = ownerDao.getOwners();

        System.out.println("ownerCollection = " + ownerCollection);
        if (ownerCollection.isEmpty()) {
            System.out.println("No result founds in table TBL_OWNER");
        }

        Collection<OwnerBean> ownerBeanCollection = createOwnerBeanCollection(ownerCollection);
        System.out.println("animalBeanCollection = " + ownerBeanCollection);

        OwnerBeanCollectionResponse response = new OwnerBeanCollectionResponse();
        response.setContent(ownerBeanCollection);
        System.out.println("END");
        return response;
    }

    /**
     *
     * @param ownerCollection
     * @return
     */
    private Collection<OwnerBean> createOwnerBeanCollection(Collection<Owner> ownerCollection) {
        Collection<OwnerBean> ownerBeanCollection = new ArrayList<OwnerBean>();
        if (ownerCollection ==  null) {
            return ownerBeanCollection;
        }

        OwnerBean ownerBean = null;
        for(Owner owner : ownerCollection) {
           ownerBean = new OwnerBean();
           ownerBean.setOwner_id(owner.getOwnerId());
           ownerBean.setOwner_name(owner.getOwnerName());
           ownerBean.setOwner_surname(owner.getOwnerSurname());
           ownerBean.setOwner_age(owner.getOwnerAge());
           ownerBean.setOwner_sex(owner.getOwnerSex());
           ownerBean.setOwner_mobile_phone(owner.getOwnerMobilePhone());

           ownerBeanCollection.add(ownerBean);
        }
        return ownerBeanCollection;
    }
}



