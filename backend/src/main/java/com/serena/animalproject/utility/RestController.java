package com.serena.animalproject.utility;

import com.serena.animalproject.model.bean.AnimalBean;
import com.serena.animalproject.service.AnimalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController  {

    @Autowired
    private AnimalService animalService;

    @RequestMapping(value = "/animal", method = RequestMethod.GET)
    @ResponseBody
    public Collection<AnimalBean> animalBeanCollection() {
        return animalService.getAnimals();
    }
}
