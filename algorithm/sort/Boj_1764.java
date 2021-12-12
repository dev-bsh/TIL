package com.company.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1764 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<String> see = new PriorityQueue<>();
        PriorityQueue<String> hear = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            see.offer(input.readLine());
        }
        for(int i = 0; i < m; i++){
            hear.offer(input.readLine());
        }

        ArrayList<String> answer = new ArrayList<>();
        while(!see.isEmpty() && !hear.isEmpty()){
            if(see.peek().compareTo(hear.peek()) > 0){
                hear.poll();
            }
            else if(see.peek().compareTo(hear.peek()) == 0){
                answer.add(see.poll());
                hear.poll();
            }
            else {
                see.poll();
            }
        }

        System.out.println(answer.size());
        for(String name:answer){
            System.out.println(name);
        }
    }
}
