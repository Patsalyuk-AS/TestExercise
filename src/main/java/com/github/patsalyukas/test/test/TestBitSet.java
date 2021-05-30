package com.github.patsalyukas.test.test;

import java.util.BitSet;
import java.util.Scanner;

public class TestBitSet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        BitSet b1 = new BitSet(m);
        BitSet b2 = new BitSet(m);
        String command;
        int number1;
        int number2;
        for (int i = 0; i < n; i++) {
            command = scanner.next();
            number1 = scanner.nextInt();
            number2 = scanner.nextInt();
            switch (command) {
                case "AND":
                    if (number1 == 1) {
                        b1.and(b2);
                    } else {
                        b2.and(b1);
                    }
                    break;
                case "OR":
                    if (number1 == 1) {
                        b1.or(b2);
                    } else {
                        b2.or(b1);
                    }
                    break;
                case "XOR":
                    if (number1 == 1) {
                        b1.xor(b2);
                    } else {
                        b2.xor(b1);
                    }
                    break;
                case "FLIP":
                    if (number1 == 1) {
                        b1.flip(number2);
                    } else {
                        b2.flip(number2);
                    }
                    break;
                case "SET":
                    if (number1 == 1) {
                        b1.set(number2);
                    } else {
                        b2.set(number2);
                    }
            }
            System.out.printf("%d %d", b1.cardinality(), b2.cardinality());
        }
        scanner.close();
    }
}
