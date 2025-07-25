package ru.netology.daohibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.daohibernate.domain.Person;
import ru.netology.daohibernate.repository.PersonsRepository;

import java.util.List;

@Service
public class PersonsService {
    private final PersonsRepository personsRepository;

    @Autowired
    public PersonsService(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
        personsRepository.repositoryInit();
    }

    public List<Person> getPersonsByCity(String city) {
        return personsRepository.getPersonsByCity(city);
    }
}