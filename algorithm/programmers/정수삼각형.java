package com.company.programmers;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;

        for(int i = 0; i < triangle.length-1; i++) {
            int[] sum = new int[triangle[i+1].length];
            for(int j = 0; j < triangle[i].length; j++) {
                sum[j] = Math.max(triangle[i][j] + triangle[i+1][j], sum[j]);
                sum[j+1] = Math.max(triangle[i][j] + triangle[i+1][j+1], sum[j+1]);
            }
            triangle[i+1] = sum;
        }

        for(int i = 0; i < triangle[triangle.length-1].length; i++){
            answer = Math.max(triangle[triangle.length-1][i], answer);
        }

        return answer;
    }
}
