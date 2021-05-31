package com.github.patsalyukas.test;


import jdk.nashorn.internal.objects.annotations.Function;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {

    static class Add {
        void add(int... numbers) {
            StringBuilder answer = new StringBuilder("");
            int sum = 0;
            for (int i = 0; i < numbers.length; i++) {
                answer.append(numbers[i]).append("+");
                sum += numbers[i];
            }
            answer.replace(answer.length() - 1, answer.length(), "=");
            System.out.println(answer.toString() + sum);
        }
    }


    public static void main(String[] args) throws ClassNotFoundException{
        Add ob = new Add();
        ob.add(1, 2, 3, 4);
    }
}


