package com.serena.animalproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.collections.CollectionUtils;

import com.serena.animalproject.utility.JPAAbstractService;
import com.serena.animalproject.model.Animal;
import com.serena.animalproject.model.bean.AnimalBean;
import com.serena.animalproject.model.bean.response.AnimalBeanListResponse;

@Stateless
@LocalBean
@Path("/animal")
public class AnimalService extends JPAAbstractService<Animal> {

    public AnimalService() {
        super(Animal.class);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public AnimalBeanListResponse listAnimals() {

        System.out.println("START");

        List<Animal> animalList = (List<Animal>) entityManager.createNamedQuery("getAnimals", Animal.class)
                .getResultList();
        System.out.println("animalList= " + animalList);
        if (CollectionUtils.isEmpty(animalList)) {
            System.out.println("No result founds in table TBL_ANIMAL");
        }

        List<AnimalBean> animalBeanListResponse = createAnimalBeanListResponse(animalList);
        System.out.println("animalBeanListResponse=" + animalBeanListResponse);

        AnimalBeanListResponse response = new AnimalBeanListResponse();
        response.setContent(animalBeanListResponse);
        System.out.println("END");
        return response;
    }

    /**
     *
     * @param animalList
     * @return
     */
    private List<AnimalBean> createAnimalBeanListResponse(List<Animal> animalList) {
        List<AnimalBean> animalBeanList = new ArrayList<AnimalBean>();
        if (animalList ==  null) {
            return animalBeanList;
        }

        AnimalBean animalBean = null;
        for(Animal animal : animalList) {
            animalBean = new AnimalBean();
            animalBean.setAnimal_id(animal.getAnimalId());
            animalBean.setAnimal_name(animal.getAnimalName());
            animalBean.setAnimal_family(animal.getAnimalFamily());
            animalBean.setAnimal_race(animal.getAnimalRace());
            animalBean.setAnimal_descent(animal.getAnimalDescent());

            animalBeanList.add(animalBean);
        }
        return animalBeanList;
    }
}

