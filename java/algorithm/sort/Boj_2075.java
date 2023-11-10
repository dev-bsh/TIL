package com.company.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Boj_2075 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(input.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                priorityQueue.offer(Integer.parseInt(st.nextToken()));
            }
        }

        int answer = 0;
        for(int i = 0; i < n; i++){
            answer = priorityQueue.poll();
        }
        System.out.println(answer);


    }
}
