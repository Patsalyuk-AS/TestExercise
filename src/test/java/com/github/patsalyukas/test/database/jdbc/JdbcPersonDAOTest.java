package com.github.patsalyukas.test.database.jdbc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JdbcPersonDAOTest {

    JdbcPersonDAO jdbcPersonDAO = new JdbcPersonDAO();


    @Test
    void findAll() {
        System.out.println(jdbcPersonDAO.findAll());
    }

    @Test
    void findById() {
        Person person = jdbcPersonDAO.findById(2);
        assertNotNull(person);
        assertEquals("Sidorod", jdbcPersonDAO.findById(2).getName());
    }

    @Test
    void save() {
        Person p = new Person("Nikolaev");
        Integer result = jdbcPersonDAO.save(p);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    void delete() {
        int maxId = jdbcPersonDAO.getIds().stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(1);
        System.out.printf("maxId = %d%n", maxId);
        Person p = jdbcPersonDAO.findById(maxId);
        jdbcPersonDAO.delete(p);
        assertNull(jdbcPersonDAO.findById(maxId));
    }

    @Test
    void getIds() {
        System.out.println(jdbcPersonDAO.getIds());
    }

}