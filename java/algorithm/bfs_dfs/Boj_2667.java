package com.company.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_2667 {

    public static boolean[][] isVisited;
    public static int houseCnt = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        isVisited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            String tmp = input.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int village = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!isVisited[i][j] && map[i][j] == 1){
                    village++;
                    dfs(map, i, j);
                    priorityQueue.add(houseCnt);
                    houseCnt = 0;
                }
            }
        }
        System.out.println(village);
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }

    private static void dfs(int[][] map, int r, int c) {

        if(r < 0 || r >= map.length || c < 0 || c >= map[0].length || isVisited[r][c] || map[r][c] == 0){
            return ;
        }
        else{
            isVisited[r][c] = true;
            houseCnt++;
        }

        dfs(map,r+1, c);

        dfs(map,r-1, c);

        dfs(map, r, c+1);

        dfs(map, r, c-1);
    }
}
