package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Back_1744 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> firstGroup = new ArrayList<>();
        ArrayList<Integer> secondGroup = new ArrayList<>();
        for(int i = 0; i<n; i++){
            numbers.add(sc.nextInt());
        }

        Collections.sort(numbers);
        int count = 0;
        int tmp = 0;
        for(int i = n-1; i>=0; i--){
            if(numbers.get(i)>1 && count == 0 && i>0){
                tmp = numbers.get(i);
                count++;
            }
            else if(numbers.get(i)>1 && count == 1){
                firstGroup.add(tmp*numbers.get(i));
                count = 0;
                tmp = 0;
            }
            else{
                if(count == 1&& i == 0){
                    firstGroup.add(tmp);
                }
                firstGroup.add(numbers.get(i));
            }
        }

        Collections.sort(firstGroup);
        System.out.println(firstGroup);
        count = 0;
        tmp = 0;
        for(int i = 0; i<firstGroup.size(); i++){
            if(firstGroup.get(i)<0 && count == 0 && i<firstGroup.size()-1){
                tmp = firstGroup.get(i);
                count++;
            }
            else if(numbers.get(i)<0 && count == 1){
                secondGroup.add(tmp*firstGroup.get(i));
                count = 0;
                tmp = 0;
            }
            else{
                if(count == 1 && i == firstGroup.size()-1){
                    secondGroup.add(tmp);
                }
                secondGroup.add(firstGroup.get(i));
            }
        }

        Collections.sort(secondGroup);

        int sum = 0;
        tmp = 0;
        for(int i = 0 ; i<secondGroup.size(); i++){
            if(secondGroup.get(i) < 0 && i<secondGroup.size()-1){
                tmp = secondGroup.get(i);
            }
            else if(secondGroup.get(i) == 0 && tmp <0){
                tmp = 0;
            }
            else{
                if(i == secondGroup.size()-1 && tmp < 0){
                    sum += tmp;
                }
                sum += secondGroup.get(i);
            }

        }

        System.out.print(sum);
    }
}
