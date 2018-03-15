package com.serena.animalproject.utility;

import com.serena.animalproject.model.bean.AnimalBean;
import com.serena.animalproject.model.bean.response.AnimalBeanCollectionResponse;
import com.serena.animalproject.model.bean.response.AnimalBeanResponse;
import com.serena.animalproject.model.bean.response.OwnerBeanCollectionResponse;
import com.serena.animalproject.service.AnimalService;
import com.serena.animalproject.service.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController  {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private OwnerService ownerService;

    //------- ANIMAL ------//

    @RequestMapping(value = "/animal", method = RequestMethod.GET)
    @ResponseBody
    public AnimalBeanCollectionResponse animalBeanCollectionResponse() {
        return animalService.getAnimals();
    }

    @RequestMapping(value = "/animal/{animalId}", method = RequestMethod.GET)
    @ResponseBody
    public AnimalBeanResponse animalBeanResponse(@PathVariable(value = "animalId") long animalId) {
        return animalService.getAnimal(animalId);
    }

    @RequestMapping(value = "/animal/{animalId}", method = RequestMethod.PUT, consumes = "application/json")
    @ResponseBody
    public String response(@PathVariable(value = "animalId") long animalId, @RequestBody AnimalBean animalBean) {
        return animalService.updateAnimal(animalId, animalBean);
    }

    @RequestMapping(value = "/animal", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public AnimalBeanResponse animalBeanResponse(@RequestBody AnimalBean animalBean) {
        return animalService.createAnimal(animalBean);
    }

    @RequestMapping(value = "/animal/{animalId}", method = RequestMethod.DELETE)
    @ResponseBody
    public String response(@PathVariable(value = "animalId") long animalId) {
        return animalService.deleteAnimal(animalId);
    }

    //------- OWNER -------//

    @RequestMapping(value = "/owner", method = RequestMethod.GET)
    @ResponseBody
    public OwnerBeanCollectionResponse ownerBeanCollectionResponse() {
        return ownerService.getOwners();
    }
}



