package com.github.patsalyukas.test.innerclasses;

import java.util.Arrays;
import java.util.List;

public class StringSorterDemo {

    public static void main(String[] args) {
        StringSorter ss = new StringSorter();
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        ss.setStrings(strings);

        System.out.println(ss.lengthSortWithStream());
    }

}
