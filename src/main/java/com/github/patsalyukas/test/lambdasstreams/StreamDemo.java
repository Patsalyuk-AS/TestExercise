package com.github.patsalyukas.test.lambdasstreams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.math.BigDecimal.ONE;

public class StreamDemo {

    private List<String> strings = Arrays.asList("This", "is", "a", "list", "of", "strings");

    public String joinStrings() {
        return strings.stream().collect(Collectors.joining(" "));
    }

    public String toUpperCase() {
        return strings.stream().map(String::toUpperCase).collect(Collectors.joining(" "));
    }

    public int getTotalLength() {
        return strings.stream().collect(Collectors.summingInt(String::length));
    }

    public double sumFirstNBigDecimals(int num) {
        return Stream.iterate(ONE, val -> val.add(ONE))
                .limit(num)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
    }

    public double sumRandoms(int num) {
        return Stream.generate(Math::random)
                .limit(num)
                .reduce(Double::sum)
                .orElse(0.0);
    }

}
