package ru.netology.daohibernate.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.domain.Person;
import ru.netology.daohibernate.service.PersonsService;

import java.util.List;

@RestController
@RequestMapping("/persons/by-city")
public class PersonsController {
    private final PersonsService personsService;

    @Autowired
    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping
    public List<Person> getPersonsByCity(@RequestParam(name="city") String city) {
        return personsService.getPersonsByCity(city);
    }
}