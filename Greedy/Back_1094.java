package com.company;

import java.util.Scanner;

public class Back_1094 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stick = 64;
        int x = sc.nextInt();
        int total=1,stickSum = stick;

        while(true){
            if(stickSum > x){
                stick /= 2;
                stickSum -= stick;
            }
            else if(stickSum == x){
                break;
            }
            else {
                stick /= 2;
                stickSum += stick;
                total++;
            }
        }
        System.out.println(total);
    }
}
