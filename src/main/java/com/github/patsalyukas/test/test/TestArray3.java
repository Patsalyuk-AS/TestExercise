package com.github.patsalyukas.test.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestArray3 {

    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer>[] array = new List[n];
        String str = "";
        for (int i = 0; i < n; i++) {
            str = scanner.nextLine();
            array[i] = new ArrayList<>(Stream.of(str.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        int d = Integer.parseInt(scanner.nextLine());
        List<Integer>[] arrayQueries = new List[d];
        for (int i = 0; i < d; i++) {
            str = scanner.nextLine();
            arrayQueries[i] = new ArrayList<>(Stream.of(str.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        int line = 0;
        int row = 0;
        for (int i = 0; i < d; i++) {
            line = arrayQueries[i].get(0);
            row = arrayQueries[i].get(1);
            if ((line > n) || (row > array[line - 1].size() - 1)) {
                System.out.println("ERROR!");

            } else {
                System.out.println(array[line -1].get(row));
            }
        }
    }

}
