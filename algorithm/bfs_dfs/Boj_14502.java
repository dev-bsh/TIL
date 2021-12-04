package com.company.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14502 {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int wall = 3;
    public static int[][] virus = new int[2][2];

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] lab = new int[n][m];

        int idx = 0;
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j<m; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
                if(lab[i][j] == 2){
                    virus[idx][0] = i;
                    virus[idx][1] = j;
                }
            }
        }
        int max = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(max < countSafeArea(spreadVirus(buildWall()))){
                    max = countSafeArea(spreadVirus(buildWall()));
                }
            }
        }

    }

    public static int[][] buildWall(int[][] lab, int a, int b){
        int[][] map = lab.clone();

        for(int i = a; i<map.length; i++){
            for(int j = b; j<map[0].length; j++){
                if(map[i][j] == 0 && wall != 0){
                    map[i][j] = 1;
                    wall--;
                    buildWall(map,i,j);
                }
            }
        }



        return map;
    }

    public static int[][] spreadVirus(int[][] lab){

    }

    public static int countSafeArea(int[][] lab){
        int safeArea = 0;
        for(int i = 0; i < lab.length; i++){
            for(int j = 0; j < lab[0].length; j++){
                if(lab[i][j] == 0){
                    safeArea++;
                }
            }
        }
        return safeArea;
    }
}
