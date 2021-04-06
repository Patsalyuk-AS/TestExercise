package com.github.patsalyukas.test.database.jpa;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {

    public Person(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}
