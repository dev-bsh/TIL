package com.company;

import java.util.Scanner;

public class Back_2847 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] point = new int[n];
        int count = 0;
        for(int i = 0; i<n; i++){
            point[i] = sc.nextInt();
        }
        for(int i = n-1 ; i>=0; i--){
            for(int j = i-1; j>=0; j--){
                if(point[i]<=point[j]){
                    point[j]--;
                    count++;
                    j++;
                }
            }
        }
        System.out.println(count);
    }
}
