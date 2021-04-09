//возвращает количество подмассивов сумму элементов, которого меньше нуля
package com.github.patsalyukas.test.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TestArray2 {

    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        int a[] = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
        int arr[] = null;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++){
                arr = Arrays.copyOfRange(a, i, j + 1);
                if (sumIntArraysMembers(arr) < 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
        scanner.close();
    }

    private static long sumIntArraysMembers(int array[]) {
        return Arrays.stream(array).asLongStream().sum();
    }

}
