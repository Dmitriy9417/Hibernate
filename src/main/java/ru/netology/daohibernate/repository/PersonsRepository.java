package ru.netology.daohibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.daohibernate.domain.Human;
import ru.netology.daohibernate.domain.Person;

import java.util.List;


@Repository
public interface PersonsRepository extends JpaRepository<Person, Human> {

    List<Person> findAll();

    List<Person> findByIgnoreCaseCityOfLiving(String city);

    List<Person> findByHumanAgeLessThanOrderByHumanAgeAsc(int humanAge);

    List<Person> findByHumanNameIgnoreCaseAndHumanSurnameIgnoreCase(String humanName, String humanSurname);
}