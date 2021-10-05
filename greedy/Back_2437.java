package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Back_2437 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);

        int answer = 1;
        int count = answer;
        int idx = N-1;
        while(true){
            if(idx < 0){
                break;
            }
            else{
                if(count < nums[idx]){
                    idx--;
                }
                else if(count == nums[idx]){
                    answer++;
                    idx = N-1;
                    count = answer;
                }
                else{
                    count -= nums[idx];
                    idx--;
                }
            }
        }

        System.out.print(answer);

    }
}

