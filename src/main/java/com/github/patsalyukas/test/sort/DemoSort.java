package com.github.patsalyukas.test.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DemoSort {

    private List<String> stringList = Arrays.asList("this", "is", "a", "list", "of", "strings");

    //java 7
    public List<String> alphaSort(){
        Collections.sort(stringList);
        return stringList;
    }

    //java 8
    public List<String> alphaSortUsingStream() {
        return stringList.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    //sorting by length with lambda
    public List<String> sortWithLambda() {
        Collections.sort(stringList,
                (s1, s2)-> s1.length() - s2.length());
        return stringList;
    }

    //sorting by length with sorted
    public List<String> sortWithSorted() {
        return stringList.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
    }

    //sorting by length with compareingInt
    public List<String > sortWithComparingInt() {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    //sorting by length and then alpha using sorted
    public List<String> sortLengthAlpha() {
        return stringList.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    //sorting by length and then reverse alpha
    public List<String> sortLengthReverseAlpha() {
        return stringList.stream()
                .sorted(Comparator.comparing(String::length)
                        .thenComparing(Comparator.reverseOrder()))
                .collect(Collectors.toList());
    }

}
