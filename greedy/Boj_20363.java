package com.company;

import java.util.Scanner;

public class Back_20363 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int targetX = sc.nextInt();
        int targetY = sc.nextInt();
        int x = 0;
        int y = 0;
        int count;

        if(targetX>=targetY){
            x = targetX + targetY/10;
            count = x;
        }
        else {
            y = targetY + targetX/10;
            count = y;
        }

        while (x < targetX || y < targetY) {
            if (x == 0) {
                x = targetX;
                count += targetX;
                y -= x / 10;
            } else {
                y = targetY;
                count += targetY;
                x -= y / 10;
            }
        }
        System.out.println(count);

    }
}
