package com.company.programmers;

import java.util.*;
public class 모의고사 {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] supoja = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};

        int[] correct = new int[3];
        int count = 0;
        int max = 0;
        for(int i = 0; i < supoja.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                int supojaIndex = 0;
                if(j < supoja[i].length) {
                    supojaIndex = j;
                } else {
                    supojaIndex = j % supoja[i].length;
                }

                if(supoja[i][supojaIndex] == answers[j]) {
                    correct[i]++;
                }
            }
            max = Math.max(max, correct[i]);
        }

        for(int i = 0; i < 3; i++) {
            if(correct[i] == max) {
                answer.add(i+1);
            }
        }

        return answer;
    }
}
