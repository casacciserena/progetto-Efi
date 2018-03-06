package com.serena.animalproject.utility;

import com.serena.animalproject.model.bean.response.AnimalBeanCollectionResponse;
import com.serena.animalproject.service.AnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController  {

    @Autowired
    private AnimalService animalService;

    @RequestMapping(value = "/animal", method = RequestMethod.GET)
    @ResponseBody
    public AnimalBeanCollectionResponse animalBeanCollectionResponse() {
        return animalService.getAnimals();
    }
}
public class RestController  {

    @Autowired
    private OwnerService ownerService;

    @RequestMapping(value = "/owner", method = RequestMethod.GET)
    @ResponseBody
    public OwnerBeanCollectionResponse ownerBeanCollectionResponse() {
        return ownerService.getOwners();
    }
}