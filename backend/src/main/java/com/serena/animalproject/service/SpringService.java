package com.serena.animalproject.service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SpringService {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
}