package com.github.patsalyukas.test.database.jpa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JpaPersonDAOTest {

    private JpaPersonDAO jpaPersonDAO = new JpaPersonDAO();

    @Test
    void findAll() {
        System.out.println(jpaPersonDAO.findAll());
    }

    @Test
    void findById() {
        System.out.println(jpaPersonDAO.findById(2));
    }

    @Test
    void save() {
        System.out.println(jpaPersonDAO.save(new Person("Hiber")));
    }

    @Test
    void delete() {
        Person p = jpaPersonDAO.findById(4);
        jpaPersonDAO.delete(p);
    }

    @Test
    void getIds() {
        System.out.println(jpaPersonDAO.getIds());
    }
}