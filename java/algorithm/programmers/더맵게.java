package com.company.programmers;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priQue = new PriorityQueue<>();

        for(int food : scoville) {
            priQue.add(food);
        }

        while(priQue.peek() < K) {
            if(priQue.size() < 2) {
                answer = -1;
                break;
            }
            int first = priQue.poll();
            int second = priQue.poll();
            int newFood = first + (second*2);
            priQue.add(newFood);
            answer++;
        }

        return answer;
    }
}
