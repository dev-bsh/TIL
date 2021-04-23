package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Back_2217 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ropes = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = sc.nextInt();
        }
        Arrays.sort(ropes);
        for(int i = 0; i< ropes.length; i++){
            value[i] = ropes[i] * n;
            n--;
        }
        Arrays.sort(value);
        System.out.println(value[value.length-1]);
    }
}
