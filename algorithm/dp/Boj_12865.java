package com.company;
import java.util.Scanner;

public class Back_12865 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[n+1][k+1];
        for(int i = 1; i<=n; i++){
            int weight = sc.nextInt();
            int value = sc.nextInt();
            for(int j = 0; j<=k; j++){
                if(j<weight){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],value+dp[i-1][j-weight]);
                }
            }
        }
        System.out.print(dp[n][k]);

    }
}
