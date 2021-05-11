package com.github.patsalyukas.test.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GolferSorter {

    private List<Golfer> golfers = Arrays.asList(
            new Golfer("Ivan", "Petrov", 60),
            new Golfer("Andrey", "Ivanov", 50),
            new Golfer("Sergey", "Sidorov", 45),
            new Golfer("Dima", "Sukhov", 70),
            new Golfer("Alexey", "Pukhov", 30)
    );

    //default sort is by score
    public void defaultSort() {
        golfers.stream()
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    //sort by score, then by last
    public void sortByScoreLast() {
        golfers.stream()
                .sorted(Comparator.comparing(Golfer::getScore)
                        .thenComparing(Golfer::getLast))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    //sort by score, then by last, then by first
    public void sortByScoreLastFirst() {
        golfers.stream()
                .sorted(Comparator.comparing(Golfer::getScore)
                        .thenComparing(Golfer::getLast)
                        .thenComparing(Golfer::getFirst))
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

}
