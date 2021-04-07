package com.github.patsalyukas.test.test;

public class TestArray1 {
    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        int sum = 0;
        int max = -100;
        for (int i = 1; i <= 4; i++)
            for (int j = 1; j <= 4; j++) {
                sum = arr[i-1][j-1] + arr[i-1][j] + arr[i-1][j+1] + arr[i][j] + arr[i+1][j-1] + arr[i+1][j] + arr[i+1][j+1];
                if (max < sum) {
                    max = sum;
                }
            }
        System.out.println(max);
    }
}
