package com.company.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_11004 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int answer = 0;

        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++){
            priorityQueue.offer(Integer.parseInt(st.nextToken()));
        }

        for(int i = 0; i < k; i++){
            answer = priorityQueue.poll();
        }
        System.out.println(answer);
    }
}
