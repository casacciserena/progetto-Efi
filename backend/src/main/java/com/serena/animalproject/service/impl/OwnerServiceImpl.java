package com.serena.animalproject.service.impl;

import com.serena.animalproject.model.Owner;
import com.serena.animalproject.model.bean.OwnerBean;
import com.serena.animalproject.model.bean.response.OwnerBeanCollectionResponse;
import com.serena.animalproject.model.bean.response.OwnerBeanResponse;
import com.serena.animalproject.service.OwnerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import java.util.ArrayList;
import java.util.Collection;

@Service("ownerService")
public class OwnerServiceImpl implements OwnerService {

  //protected final static Logger logger = LoggerFactory.getLogger(Animal.class);

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

    @Transactional
    public OwnerBeanResponse getOwner(@PathParam("ownerId") long ownerId) {

        System.out.println("START");
        System.out.println("@PathParam ownerId: " + ownerId);

        Owner owner = ownerDao.getOwner(ownerId);
        System.out.println("owner = " + owner);
        if (owner == null) {
            System.out.println("No result founds in table TBL_OWNER");
        }

        OwnerBean ownerBean = createOwnerBean(owner);
        System.out.println("created OwnerBean object = " + ownerBean);

        OwnerBeanResponse response = new OwnerBeanResponse();
        response.setContent(ownerBean);
        System.out.println("END");
        return response;
    }
    @Transactional
    public String updateOwner(@PathParam("ownerId") long ownerId,OwnerBean ownerBean) {

        System.out.println("START");
        //logger.info("START");
        System.out.println("@PathParam ownerId: " + ownerId);
        System.out.println("OwnerBean: " + ownerBean);

        Owner ownerFromFrontEnd = adaptOwnerBean(ownerBean);
        if (animalId < 0){
            System.out.println("Operation not admissible TBL_OWNER: ownerId < 1 " + ownerId);
        }

        Owner ownerFromDB = ownerDao.getOwner(ownerId);
        if (OwnerFromDB == null) {
            System.out.println("No result founds in table TBL_OWNER");
        }

        System.out.println("ownerlId = " + ownerId);
        updateOwner(OwnerFromDB, ownerFromFrontEnd);

        String response = animalDao.updateOwner(ownerFromDB);

        String message = animalId == -1 ? "create" : "update";

        System.out.println("Owner " + message + " { " + ownerFromDB + " } ");
        System.out.println("END");
        return response;
    }

    @Transactional
    public OwnerBeanResponse createOwner(OwnerBean ownerBean) {

        System.out.println("START");
        System.out.println("OwnerBean: " + ownerBean);

        Owner owner = adaptOwnerBean(ownerBean);
        System.out.println("BEFORE PERSIST owner: " + owner);

        animalDao.createOwner(owner);

        System.out.println("AFTER PERSIST owner: " + owner);

        animalBean = createOwnerBean(owner);
        System.out.println("created OwnerBean object = " + ownerBean);

        OwnerBeanResponse response = new OwnerBeanResponse();
        response.setContent(ownerBean);
        System.out.println("END");
        return response;
    }

    @Transactional
    public String deleteOwner(@PathParam("ownerId") long ownerId) {

        System.out.println("START");
        System.out.println("@PathParam ownerId: " + ownerId);

        Owner owner = ownerDao.getOwner(ownerId);
        System.out.println("owner = " + owner);
        if (owner == null) {
            System.out.println("No result founds in table TBL_OWNER");
        }

        String response = ownerDao.deleteOwner(ownerId);

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
