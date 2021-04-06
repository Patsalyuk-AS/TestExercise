package com.github.patsalyukas.test.database.jdbc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@Getter
public class ReaderOfConfigDB {

    private static final String PATH_ATM_CONFIG = "/home/andrey/IdeaProjects/TestProject/src/main/resources/";
    private ConToDB connection;

    public ReaderOfConfigDB() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            connection = mapper.readValue(new File(PATH_ATM_CONFIG + "db.yml"), ConToDB.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
