package com.github.patsalyukas.test.test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TestBigInteger1 {

    public static void main(String[] args) {
        String s[] = new String[]{"9", "-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000", null, null};
        Arrays.sort(s, Collections.reverseOrder(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((o1 == null) || (o2 == null)) {
                    return 0;
                }
                BigDecimal b1 = new BigDecimal(o1);
                BigDecimal b2 = new BigDecimal(o2);
                return b1.compareTo(b2);
            }
        }));
        Arrays.asList(s).forEach(System.out::println);
    }
}
