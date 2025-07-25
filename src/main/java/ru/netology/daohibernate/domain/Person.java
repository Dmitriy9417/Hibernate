package ru.netology.daohibernate.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="persons")
public class Person {
    @EmbeddedId
    private Human human;
    @Column(name="phone_number", length = 20)
    private String phoneNumber;
    @Column(name="city_of_living", nullable = false, length = 50)
    private String cityOfLeaving;
}