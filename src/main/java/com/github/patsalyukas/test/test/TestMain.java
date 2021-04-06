package com.github.patsalyukas.test.test;

import java.util.Arrays;
import java.util.List;

public class TestMain {
    public static void main(String[] args){
        List<String> strings = Arrays.asList("259.259.259.259", "266.266.266.266", "255.255.255.255",
                "555.555.555.555", "666.666.666.666", "249.249.249.249", "249.249.249.256");
        for (String IP : strings) {
            System.out.println(IP.matches(new MyRegex().pattern));
        }
    }

}

class MyRegex {
    String pattern = "^([0-1]?\\d{0,2}|[2][0-4]\\d|[2][5][0-5])\\.([0-1]?\\d{0,2}|[2][0-4]\\d|[2][5][0-5])\\.([0-1]?\\d{0,2}|[2][0-4]\\d|[2][5][0-5])\\.([0-1]?\\d{0,2}|[2][0-4]\\d|[2][5][0-5])$";
}
