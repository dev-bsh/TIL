package com.company.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14442 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][][] isVisited = new int[N][M][K+1];

        for(int i = 0; i < N; i++){
            String tmp = input.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        for(int i = 0; i < K; i++){
            isVisited[0][0][i] = 1;
        }

        System.out.println(bfs(map,isVisited,K));

    }

    public static int bfs(int[][] map, int[][][] isVisited, int K){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,0});

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int crash = current[2];

            for(int i = 0; i < 4; i++){
                int nX = x + dx[i];
                int nY = y + dy[i];
                if(nX < 0 || nX >= map.length || nY < 0 || nY >= map[0].length){
                    continue;
                }
                if(map[nX][nY] == 1){
                    if(crash < K && isVisited[nX][nY][crash+1] == 0){
                        isVisited[nX][nY][crash+1] = isVisited[x][y][crash] + 1;
                        queue.offer(new int[]{nX,nY,crash+1});
                    }
                }
                else{
                    if(isVisited[nX][nY][crash] == 0){
                        isVisited[nX][nY][crash] = isVisited[x][y][crash] + 1;
                        queue.offer(new int[]{nX,nY,crash});
                    }
                }

            }

            if(x == map.length-1 && y == map[0].length-1){
                return isVisited[x][y][crash];
            }
        }
        return -1;
    }

}
