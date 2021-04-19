package com.company;

import java.util.Scanner;

public class Back_5585 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int changes = 1000-sc.nextInt();
        int idx=0,count = 0;
        int[] moneys = {500,100,50,10,5,1};

        while(changes > 0){
            if(changes >= moneys[idx]){
                changes -= moneys[idx];
                count++;
            }
            else {
                idx++;
            }
        }

        System.out.print(count);

    }
}
