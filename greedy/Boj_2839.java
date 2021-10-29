package com.company;

import java.util.Scanner;

public class Back_2839 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while(n>0){
            if(n < 5 && n%3 != 0){
                count = -1;
                break;
            }
            else if(n%5 == 0){
               count = n/5;
               break;
            }
            else {
                if((n%5)%3 == 0){
                    count = count + (n/5) + 1;
                    break;
                }
                else if(n%3 == 0){
                    n -= 3;
                    count++;
                }
                else {
                    n -= 5;
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
