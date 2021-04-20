package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Back_11399 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        int[] times = new int[tc];
        int timeSum = 0;
        for(int i = 0; i< tc; i++){
            times[i] = sc.nextInt();
        }
        Arrays.sort(times);

        for(int i = 0; i< tc; i++){
            for(int j = 0; j<=i; j++){
                timeSum += times[j];
            }
        }

        System.out.print(timeSum);
    }
}
