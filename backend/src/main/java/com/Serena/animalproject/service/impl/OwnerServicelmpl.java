package com.serena.animalproject.service.impl;

import com.serena.animalproject.model.Animal;
import com.serena.animalproject.model.bean.AnimalBean;
import com.serena.animalproject.model.bean.response.AnimalBeanCollectionResponse;
import com.serena.animalproject.service.AnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service("animalService")
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private com.serena.ownerproject.dao.OwnerDao ownerDao;

    @Transactional
    public OwnerBeanCollectionResponse getOwner() {

        System.out.println("START");

        Collection<Owner> ownerCollection = ownerDao.getOwner();

        System.out.println("ownerCollection= " + ownerCollection);
        if (animalCollection.isEmpty()) {
            System.out.println("No result founds in table TBL_ANIMAL");
        }

        Collection<OwnerBean> ownerBeanCollectionResponse = createOwnerBeanCollectionResponse(animalCollection);
        System.out.println("animalBeanCollectionResponse=" + animalBeanCollectionResponse);

        OwnerBeanCollectionResponse response = new OwnerBeanCollectionResponse();
        response.setContent(ownerBeanCollectionResponse);
        System.out.println("END");
        return response;
    }

    /**
     *
     * @param ownerCollection
     * @return
     */
    private Collection<OwnerBean> createOwnerBeanCollectionResponse(Collection<Owner> ownerCollection) {
        Collection<OwnerBean> ownerBeanCollection = new ArrayList<OwnerBean>();
        if (ownerCollection ==  null) {
            return owerBeanCollection;
        }

        OwnerBean ownerBean = null;
        for(Owner owner : ownerCollection) {
           ownerBean = new OwnerBean();
           ownerBean.setOwner_id(owner.getOwnerId());
            ownerBean.setOwner_name(owner.getOwnerName());
            ownerBean.setOwner_surname(ovner.getOwnerSurname());
            ownerBean.setOwner_age(owner.getOwnerAge());
            ownerBean.setOwner_sex(owner.getOwnersex());
            ownerBean.setOwner_number_phone(owner.getOwnerNumberPhone());

            OwnerBeanCollection.add(ownerBean);
        }
        return OwnerBeanCollection;
    }
}



