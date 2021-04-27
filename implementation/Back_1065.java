package com.company;

import java.util.Scanner;

public class Back_1065 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        while(n>0){
            if(n/10 >= 100){
                int a = n/1000;
                int b = (n-a*1000)/100;
                int c = (n-(a*1000)-(b*100))/10;
                int d = n-(a*1000)-(b*100)-(c*10);
                if(a-b == b-c && b-c == c-d){
                    count++;
                }
            }
            else if(n/10 >= 10){
                int b = n/100;
                int c = (n-b*100)/10;
                int d = n-(b*100)-(c*10);
                if(b-c == c-d){
                    count++;
                }
            }
            else{
                count += n;
                n -= n;
            }
            n--;
        }
        System.out.println(count);

    }
}
