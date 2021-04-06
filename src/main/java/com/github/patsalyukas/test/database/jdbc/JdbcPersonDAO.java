package com.github.patsalyukas.test.database.jdbc;

import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class JdbcPersonDAO implements PersonDAO{

    private String url;
    private String user;
    private String password;


    public JdbcPersonDAO() {
        ConToDB conToDB = new ReaderOfConfigDB().getConnection();
        url = conToDB.getUrl();
        user = conToDB.getUser();
        password = conToDB.getPassword();

        try {
            Class.forName(conToDB.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pst =connection.prepareStatement("SELECT * FROM PERSONS")
        ) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                people.add(new Person(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return people;
    }

    @Override
    public Person findById(Integer id) {
        Person person = null;
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = connection.prepareStatement("SELECT * FROM PERSONS WHERE id = ?")
        ) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                person = new Person(rs.getInt(1), rs.getString(2));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Integer save(Person p) {
        int generatedKey = 0;
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = connection.prepareStatement("INSERT INTO PERSONS(name) VALUES(?)", Statement.RETURN_GENERATED_KEYS)
        ) {
            pst.setString(1, p.getName());
            int uc = pst.executeUpdate();
            if (uc != 1) {throw new SQLException("No rows added");}
            try (ResultSet keys = pst.getGeneratedKeys()) {
                if (keys.next()) {
                    generatedKey = keys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedKey;
    }

    @Override
    public void delete(Person p) {
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = connection.prepareStatement("DELETE FROM PERSONS WHERE id=?")
        ) {
            pst.setInt(1, p.getId());
            int uc = pst.executeUpdate();
            if (uc != 1) {
                throw new SQLException("No rows removed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Integer> getIds() {
        List<Integer> ids = new ArrayList<>();
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pst = connection.prepareStatement("SELECT id FROM persons")
        ) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt(1));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ids;
    }
}
