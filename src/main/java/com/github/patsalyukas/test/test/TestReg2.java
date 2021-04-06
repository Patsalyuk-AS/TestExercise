package com.github.patsalyukas.test.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestReg2 {

    public static void main(String[] args) {
        String line = "<h1>a->invalid</h1>";
        String pattern = "<([^>]+)>([^<>]+)</\\1>";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        boolean findMatch = true;
        while(m.find( )){
            System.out.println(m.group(2));
            findMatch = false;
        }
        if(findMatch) {
            System.out.println("None");
        }
    }

}
