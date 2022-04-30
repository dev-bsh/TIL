package com.company.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> complete = new ArrayList<>();
        Queue<Integer> proQue = new LinkedList<>();
        Queue<Integer> speQue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            proQue.add(progresses[i]);
            speQue.add(speeds[i]);
        }

        int day = 0;
        int count = 0;
        while(!proQue.isEmpty()) {
            int speed = speQue.peek();
            int progress = proQue.peek() + (speed * day);
            if(progress >= 100) {
                count++;
                proQue.poll();
                speQue.poll();
                if(proQue.isEmpty()) {
                    complete.add(count);
                }
            } else if (count > 0) {
                complete.add(count);
                count = 0;
            } else {
                day++;
            }
        }

        answer = new int[complete.size()];
        for(int i = 0; i < complete.size(); i++) {
            answer[i] = complete.get(i);
        }


        return answer;
    }
}
