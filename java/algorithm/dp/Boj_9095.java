package com.company;

import java.util.Scanner;

public class Back_9095 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 0 ;i<tc; i++){
            int n = sc.nextInt();
            int[] dp = new int[n+1];
            if(n>2){
                dp[2] =2;
                dp[3] =4;
            }
            else if(n>1){
                dp[2] =2;
            }
            dp[1] =1;

            for(int j = 4; j<dp.length; j++){
                dp[j] = dp[j-3]+dp[j-2]+dp[j-1];
            }

            System.out.println(dp[n]);
        }
    }
}
