package com.company.programmers;

public class 컬러링북 {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] isVisited = new boolean[m][n];

        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[0].length; j++) {
                int visitSize = 0;
                // 방문하지 않았거나 0이 아니면
                if(!isVisited[i][j] || picture[i][j] != 0){
                    visitSize = dfs(i, j, picture, isVisited, 0, picture[i][j]);
                }
                if(visitSize > 0) {
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(visitSize, maxSizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }


    public int dfs(int i, int j, int[][] picture, boolean[][] isVisited, int count, int value) {
        int size = count;
        // 범위를 벗어나거나, 이전값과 같은값이 아니면
        if(i < 0 || i >= picture.length || j < 0 || j >= picture[0].length || isVisited[i][j] || value != picture[i][j]) {
            return size;
        }

        size++;
        isVisited[i][j] = true;

        size = dfs(i+1, j, picture, isVisited, size, value);
        size = dfs(i-1, j, picture, isVisited, size, value);
        size = dfs(i, j+1, picture, isVisited, size, value);
        size = dfs(i, j-1, picture, isVisited, size, value);

        return size;
    }
}
