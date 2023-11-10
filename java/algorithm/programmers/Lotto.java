package com.company.programmers;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int zeroCount = 0;
        int correctCount = 0;

        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                zeroCount++;
            }
            else {
                for(int j = 0; j < lottos.length; j++) {
                    if(lottos[i] == win_nums[j]){
                        correctCount++;
                    }
                }
            }
        }

        int maxRank = Math.max((7 - (correctCount + zeroCount)), 1);
        int minRank = Math.min((7 - correctCount), 6);
        if(maxRank == 7) {
            maxRank = 6;
        }
        answer = new int[]{maxRank, minRank};

        return answer;
    }
}
