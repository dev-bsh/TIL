package com.company.sort;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Boj_1427 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        PriorityQueue priorityQueue = new PriorityQueue(Collections.reverseOrder());
        for(int i = 0; i < s.length(); i++){
            priorityQueue.offer(s.charAt(i)- '0');
        }
        while(!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.poll());
        }

    }
}
