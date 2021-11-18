package com.company;

import java.util.*;

public class Back_1145 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 5;
        int[] num = new int[n];
        ArrayList<Integer> multiple = new ArrayList<>();

        for(int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);

        int k =1, count = 1,tmp;
        for(int i = num.length-1; i>=0; i--){
            tmp = num[i] * k;
            for(int j =0; j < num.length; j++){
                if(count == 3){
                    break;
                }
                else if(num[i] != num[j] && tmp>=num[j] && tmp % num[j] == 0){
                    count++;
                }
            }
            if(count == 3){
                multiple.add(tmp);
                k = 1;
            }
            else {
                k++;
                i++;
            }
            count = 1;
        }
        Collections.sort(multiple);
        System.out.println(multiple.get(0));
    }
}


