package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Back_1931 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        ArrayList<Time> list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            list.add(new Time(sc.nextInt(),sc.nextInt()));
        }

        Collections.sort(list, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.getY() - o2.getY() > 0)
                    return 1;
                else if(o1.getY() == o2.getY()){
                    return o1.getX() - o2.getX();
                }
                else
                    return -1;
            }
        });

        Time tmp = new Time(0,0);
        for(int i = 0; i<n; i++){
             if(list.get(i).getX() >= tmp.getY()){
                 count++;
                 tmp = list.get(i);
             }
        }
        System.out.print(count);

    }
}
class Time{
   private int x = 0;
   private int y = 0;

   public Time(int x, int y){
        this.x = x;
        this.y = y;
   }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}