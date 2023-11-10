package com.company;

import java.util.Scanner;

public class Back_1003 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 0; i<tc; i++){
            int n = sc.nextInt();
            int[][] answer = new int[n+4][2];
            answer[0] = new int[]{1,0};
            answer[1] = new int[]{0,1};

            for(int j = 2; j<=n; j++){
                answer[j][0] = answer[j-1][0] + answer[j-2][0];
                answer[j][1] = answer[j-1][1] + answer[j-2][1];
            }

            System.out.println(answer[n][0]+" "+answer[n][1]);
        }


    }
}
