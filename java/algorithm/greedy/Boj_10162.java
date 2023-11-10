package com.company;


import java.util.Scanner;

public class Back_10162 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] button = {300,60,10};
        int[] count = new int[3];
        int tSec = sc.nextInt();

        if(tSec%10 == 0){
            for(int i = 0; i<button.length; i++){
                count[i] = tSec/button[i];
                tSec %= button[i];
                System.out.print(count[i]+" ");
            }
        }
        else {
            System.out.println("-1");
        }

    }
}
