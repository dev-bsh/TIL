package com.company.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 안전 영역
public class Boj_2468 {

    public static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] city = new int[n][n];
        int max = 0;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j=0; j < n; j++){
                city[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, city[i][j]);
            }
        }

        int safeArea = 0;

        for(int i = max-1; i >= 0; i--){
            int count = 0;
            isVisited = new boolean[n][n];

            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(!isVisited[j][k] && city[j][k] > i){
                        count++;
                        dfs(city, j, k, i);
                    }
                }
            }

            safeArea = Math.max(safeArea,count);
        }
        System.out.println(safeArea);


    }

    private static void dfs(int[][] city, int r, int c, int max) {

        if(r < 0 || r >= city.length || c < 0 || c >= city[0].length || isVisited[r][c] || city[r][c] <= max){
            return ;
        }
        else{
            isVisited[r][c] = true;
        }

        dfs(city,r+1, c, max);

        dfs(city,r-1, c, max);

        dfs(city, r, c+1, max);

        dfs(city, r, c-1, max);

    }
}
