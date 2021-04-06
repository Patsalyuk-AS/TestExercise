package com.github.patsalyukas.test.database.jdbc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Person {

    public static final String DEFAULT_NAME = "UNKNOWN";

    private Integer id;
    private String name;

    public Person() {
        this(DEFAULT_NAME);
    }

    public Person(String name) {
        this.name = name;
    }
}
