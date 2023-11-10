package com.company;

import java.util.Scanner;
import java.util.ArrayList;

public class Swea_1486 {
    
    public static int height;
    public static int min;
    public static int sum;
    public static ArrayList<Integer> tower = new ArrayList<>();

    public static void main(String[] args) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        int  n;


        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            height = sc.nextInt();
            min = height;
            sum = 0;
            tower.clear();

            for(int i = 0; i < n; i++){
                tower.add(sc.nextInt());
            }

            findTower(0);
            System.out.println("#"+test_case+" "+min);
        }
    }

    public static void findTower(int index){

        for (int i = index; i < tower.size(); i++) {
            if(min == 0){
                return;
            }

            sum += tower.get(i);

            if(sum < height){
                findTower(i+1);
            }
            else if(sum-height < min){
                min = sum -height;
            }

            sum -= tower.get(i);

        }

    }
}

