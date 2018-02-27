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
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private com.serena.animalproject.dao.AnimalDao animalDao;

    @Transactional
    public AnimalBeanCollectionResponse getAnimals() {

        System.out.println("START");

        Collection<Animal> animalCollection = animalDao.getAnimals();

        System.out.println("animalCollection= " + animalCollection);
        if (animalCollection.isEmpty()) {
            System.out.println("No result founds in table TBL_ANIMAL");
        }

        Collection<AnimalBean> animalBeanCollectionResponse = createAnimalBeanCollectionResponse(animalCollection);
        System.out.println("animalBeanCollectionResponse=" + animalBeanCollectionResponse);

        AnimalBeanCollectionResponse response = new AnimalBeanCollectionResponse();
        response.setContent(animalBeanCollectionResponse);
        System.out.println("END");
        return response;
    }

    /**
     *
     * @param animalCollection
     * @return
     */
    private Collection<AnimalBean> createAnimalBeanCollectionResponse(Collection<Animal> animalCollection) {
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

            animalBeanCollection.add(animalBean);
        }
        return animalBeanCollection;
    }
}



