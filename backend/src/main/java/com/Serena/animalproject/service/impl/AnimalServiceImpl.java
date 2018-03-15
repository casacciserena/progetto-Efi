package com.serena.animalproject.service.impl;

import com.serena.animalproject.model.Animal;
import com.serena.animalproject.model.bean.AnimalBean;
import com.serena.animalproject.model.bean.response.AnimalBeanCollectionResponse;
import com.serena.animalproject.model.bean.response.AnimalBeanResponse;
import com.serena.animalproject.service.AnimalService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;

import java.util.ArrayList;
import java.util.Collection;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    //protected final static Logger logger = LoggerFactory.getLogger(Animal.class);

    @Autowired
    private com.serena.animalproject.dao.AnimalDao animalDao;

    @Transactional
    public AnimalBeanCollectionResponse getAnimals() {

        System.out.println("START");

        Collection<Animal> animalCollection = animalDao.getAnimals();

        System.out.println("animalCollection = " + animalCollection);
        if (animalCollection.isEmpty()) {
            System.out.println("No result founds in table TBL_ANIMAL");
        }

        Collection<AnimalBean> animalBeanCollection = createAnimalBeanCollection(animalCollection);
        System.out.println("animalBeanCollection = " + animalBeanCollection);

        AnimalBeanCollectionResponse response = new AnimalBeanCollectionResponse();
        response.setContent(animalBeanCollection);
        System.out.println("END");
        return response;
    }

    @Transactional
    public AnimalBeanResponse getAnimal(@PathParam("animalId") long animalId) {

        System.out.println("START");
        System.out.println("@PathParam animalId: " + animalId);

        Animal animal = animalDao.getAnimal(animalId);
        System.out.println("animal = " + animal);
        if (animal == null) {
            System.out.println("No result founds in table TBL_ANIMAL");
        }

        AnimalBean animalBean = createAnimalBean(animal);
        System.out.println("created AnimalBean object = " + animalBean);

        AnimalBeanResponse response = new AnimalBeanResponse();
        response.setContent(animalBean);
        System.out.println("END");
        return response;
    }

    @Transactional
    public String updateAnimal(@PathParam("animalId") long animalId, AnimalBean animalBean) {

        System.out.println("START");
        //logger.info("START");
        System.out.println("@PathParam animalId: " + animalId);
        System.out.println("AnimalBean: " + animalBean);

        Animal animalFromFrontEnd = adaptAnimalBean(animalBean);
        if (animalId < 0){
            System.out.println("Operation not admissible TBL_ANIMAL: animalId < 1 " + animalId);
        }

        Animal animalFromDB = animalDao.getAnimal(animalId);
        if (animalFromDB == null) {
            System.out.println("No result founds in table TBL_ANIMAL");
        }

        System.out.println("animalId = " + animalId);
        updateAnimal(animalFromDB, animalFromFrontEnd);

        String response = animalDao.updateAnimal(animalFromDB);

        String message = animalId == -1 ? "create" : "update";

        System.out.println("Animal " + message + " { " + animalFromDB + " } ");
        System.out.println("END");
        return response;
    }

    @Transactional
    public AnimalBeanResponse createAnimal(AnimalBean animalBean) {

        System.out.println("START");
        System.out.println("AnimalBean: " + animalBean);

        Animal animal = adaptAnimalBean(animalBean);
        System.out.println("BEFORE PERSIST animal: " + animal);

        animalDao.createAnimal(animal);

        System.out.println("AFTER PERSIST animal: " + animal);

        animalBean = createAnimalBean(animal);
        System.out.println("created AnimalBean object = " + animalBean);

        AnimalBeanResponse response = new AnimalBeanResponse();
        response.setContent(animalBean);
        System.out.println("END");
        return response;
    }

    @Transactional
    public String deleteAnimal(@PathParam("animalId") long animalId) {

        System.out.println("START");
        System.out.println("@PathParam animalId: " + animalId);

        Animal animal = animalDao.getAnimal(animalId);
        System.out.println("animal = " + animal);
        if (animal == null) {
            System.out.println("No result founds in table TBL_ANIMAL");
        }

        String response = animalDao.deleteAnimal(animalId);

        System.out.println("END");
        return response;
    }

    /**
     *
     * @param animalCollection
     * @return
     */
    private Collection<AnimalBean> createAnimalBeanCollection(Collection<Animal> animalCollection) {
        Collection<AnimalBean> animalBeanCollection = new ArrayList<AnimalBean>();
        if (animalCollection ==  null) {
            return animalBeanCollection;
        }

        AnimalBean animalBean = null;
        for(Animal animal : animalCollection) {
            animalBean = new AnimalBean();
            animalBean.setAnimal_id(animal.getAnimalId());
            animalBean.setAnimal_name(animal.getAnimalName());
            animalBean.setAnimal_family(animal.getAnimalFamily());
            animalBean.setAnimal_race(animal.getAnimalRace());
            animalBean.setAnimal_descent(animal.getAnimalDescent());
            animalBean.setAnimal_legs(animal.getAnimalLegs());

            animalBeanCollection.add(animalBean);
        }
        return animalBeanCollection;
    }

    /**
     *
     * @param animal
     * @return
     */
    private AnimalBean createAnimalBean(Animal animal) {
        AnimalBean animalBean = new AnimalBean();
        animalBean.setAnimal_id(animal.getAnimalId());
        animalBean.setAnimal_name(animal.getAnimalName());
        animalBean.setAnimal_family(animal.getAnimalFamily());
        animalBean.setAnimal_race(animal.getAnimalRace());
        animalBean.setAnimal_descent(animal.getAnimalDescent());
        animalBean.setAnimal_legs(animal.getAnimalLegs());
        return animalBean;
    }

    /**
     *
     * @param animalBean
     * @return
     */
    private Animal adaptAnimalBean(AnimalBean animalBean) {
        Animal animal = new Animal();
        animal.setAnimalName(animalBean.getAnimal_name());
        animal.setAnimalFamily(animalBean.getAnimal_family());
        animal.setAnimalRace(animalBean.getAnimal_race());
        animal.setAnimalDescent(animalBean.getAnimal_descent());
        animal.setAnimalLegs(animalBean.getAnimal_legs());
        return animal;
    }

    /**
     *
     * @param animalFromDB
     * @param animalFromFrontEnd
     */
    private void updateAnimal(Animal animalFromDB, Animal animalFromFrontEnd) {
        animalFromDB.setAnimalName(animalFromFrontEnd.getAnimalName());
        animalFromDB.setAnimalFamily(animalFromFrontEnd.getAnimalFamily());
        animalFromDB.setAnimalRace(animalFromFrontEnd.getAnimalRace());
        animalFromDB.setAnimalDescent(animalFromFrontEnd.getAnimalDescent());
        animalFromDB.setAnimalLegs(animalFromFrontEnd.getAnimalLegs());
    }
}



