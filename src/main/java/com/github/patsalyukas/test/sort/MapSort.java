package com.github.patsalyukas.test.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MapSort {

    private static Map<String, Integer> mapOfWords = new HashMap<>();

    public static void main(String[] args) {
        mapOfWords.put("adb", 100);
        mapOfWords.put("sfg", 20);
        mapOfWords.put("asda", 122);
        mapOfWords.put("adfab", 10);
        mapOfWords.put("asgdfg", 50);

        mapOfWords.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
