package com.github.patsalyukas.test;


import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException{
        Stream<Integer> stream =  Arrays.asList(1, 2, 3, 5).stream();
        Integer integer = stream.max(Comparator.comparingInt(Integer::intValue)).orElse(1);

    }
}


