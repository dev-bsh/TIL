package com.company;

import java.util.Scanner;

public class Back_14501 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[21];

        for(int i = 0; i<n; i++){
           int t = sc.nextInt();
           int p = sc.nextInt();

           if(dp[i] > dp[i+1]){
               dp[i+1] = dp[i];
           }
           if(dp[i+t] < dp[i]+p){
               dp[i+t] = dp[i]+p;
           }
        }
        System.out.print(dp[n]);
    }
}
