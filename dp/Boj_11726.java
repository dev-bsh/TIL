package com.company;

import java.util.Scanner;

public class Back_11726 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] method = new int[n+2];
        method[0] = 1;
        method[1] = 1;
        for(int i = 2; i<=n; i++){
            method[i] = (method[i-1] + method[i-2])%10007;
        }

        System.out.print(method[n]);
    }
}
