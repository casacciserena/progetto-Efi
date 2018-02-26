package com.serena.animalproject.service.impl;

import com.serena.animalproject.model.Animal;
import com.serena.animalproject.model.bean.AnimalBean;
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
    public Collection<AnimalBean> getAnimals(){
        Collection<Animal> animal = animalDao.getAnimals();
        return createAnimalBeanListResponse(animal);
    }

    /**
     *
     * @param animalCollection
     * @return
     */
    private Collection<AnimalBean> createAnimalBeanListResponse(Collection<Animal> animalCollection) {
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

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public AnimalBeanListResponse animalList() {
//
//        System.out.println("START");
//
//        List<Animal> animalList = entityManager.createNamedQuery("getAnimals", Animal.class)
//                .getResultList();
//        System.out.println("animalList= " + animalList);
//        if (CollectionUtils.isEmpty(animalList)) {
//            System.out.println("No result founds in table TBL_ANIMAL");
//        }
//
//        List<AnimalBean> animalBeanListResponse = createAnimalBeanListResponse(animalList);
//        System.out.println("animalBeanListResponse=" + animalBeanListResponse);
//
//        AnimalBeanListResponse response = new AnimalBeanListResponse();
//        response.setContent(animalBeanListResponse);
//        System.out.println("END");
//        return response;
//    }
//}


