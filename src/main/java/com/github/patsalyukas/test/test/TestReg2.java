package com.github.patsalyukas.test.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg2 {

    public static void main(String[] args) {
        String str = "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        String regex = "<(.+>)(.+)(</\\1)";
        Pattern p = Pattern.compile(regex);
        Matcher m;
        System.out.printf("Исходная строка: %s%n", str);
        while (str.matches(regex)) {
            m = p.matcher(str);
            while (m.find()) {
                str = str.replaceAll(m.group(), m.group(2));
            }
            System.out.printf("Полученная строка: %s%n", str);
        }
        System.out.printf("Полученная строка: %s%n", str);
    }

}
