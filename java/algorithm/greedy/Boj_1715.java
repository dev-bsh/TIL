package com.company;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Back_1715 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            priorityQueue.add(sc.nextInt());
        }

        while(true){
            int A = priorityQueue.poll().intValue();
            if(priorityQueue.peek() == null){
                break;
            }
            else{
                int B = priorityQueue.poll().intValue();
                priorityQueue.add(A+B);
                answer += (A+B);
            }
        }

        System.out.print(answer);

    }

}
