package ru.netology.daohibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.daohibernate.domain.Human;
import ru.netology.daohibernate.domain.Person;

import java.util.List;


@Repository
public class PersonsRepository {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void repositoryInit() {

        Human human1 = new Human().builder().name("Daniil").surname("Bogomolov").age(5).build();
        Human human2 = new Human().builder().name("Kirill").surname("Orlov").age(24).build();
        Human human3 = new Human().builder().name("Dmitriy").surname("Kupec").age(32).build();
        Human human4 = new Human().builder().name("Alexey").surname("Stepanov").age(15).build();
        Human human5 = new Human().builder().name("Vasiliy").surname("Utkin").age(190).build();

        Person person1 = new Person().builder().human(human1).phoneNumber("+79173412345").cityOfLeaving("Saint-Petersburg").build();
        em.persist(person1);
        Person person2 = new Person().builder().human(human2).phoneNumber("+79173412346").cityOfLeaving("Moscow").build();
        em.persist(person2);
        Person person3 = new Person().builder().human(human3).phoneNumber("+79173412347").cityOfLeaving("Moscow").build();
        em.persist(person3);
        Person person4 = new Person().builder().human(human4).phoneNumber("+79173412348").cityOfLeaving("Novosibirsk").build();
        em.persist(person4);
        Person person5 = new Person().builder().human(human5).phoneNumber("+79173412349").cityOfLeaving("Moscow").build();
        em.persist(person5);

        System.out.println("repositoryInit done");
    }

    public List<Person> getPersonsByCity(String city) {
        List<Person> persons = em.createQuery("SELECT e FROM Person e").getResultList();
        List<Person> filteredPersons = persons.stream().filter(p -> p.getCityOfLeaving().toLowerCase().equals(city.toLowerCase())).toList();
        return filteredPersons;
    }
}