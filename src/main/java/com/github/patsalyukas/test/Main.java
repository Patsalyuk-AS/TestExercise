package com.github.patsalyukas.test;


import jdk.nashorn.internal.objects.annotations.Function;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface AdvancedArithmetic{
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic{
    @Override
    public int divisor_sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum+=i;
            }
        }
        return sum;
    }
}

public class Main {

    public static void main(String[] args) throws ClassNotFoundException{
        int n = 6;
        int i = 0;

        int sum =  Stream.iterate(1, k -> k + 1).limit(n).filter(k -> n%k==0).mapToInt(k -> k).sum();
        System.out.println(sum);

    }
}


