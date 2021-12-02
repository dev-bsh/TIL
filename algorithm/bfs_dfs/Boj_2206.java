package com.company.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 부수고 이동하기
public class Boj_2206 {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int[][] distance = new int[N][M];
        boolean[][][] isVisited = new boolean[N][M][2];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i<N; i++){
            String tmp = input.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }

        queue.offer(new int[]{0,0,0});

        while(!queue.isEmpty()){
            int[] current = queue.poll();

            for(int i=0; i<4; i++){
                int nowX = current[0] + dx[i];
                int nowY = current[1] + dy[i];

                if(nowX < 0 || nowY < 0 || nowX >= N || nowY >= M){
                    continue;
                }

                if(map[nowX][nowY] == 1){
                    if(current[2] == 0 && !isVisited[nowX][nowY][1]){
                        isVisited[nowX][nowY][current[2]] = true;
                        distance[nowX][nowY] = distance[current[0]][current[1]] + 1;
                        queue.offer(new int[]{nowX, nowY, 1});
                    }
                }
                else {
                    if(!isVisited[nowX][nowY][current[2]]){
                        isVisited[nowX][nowY][current[2]] = true;
                        distance[nowX][nowY] = distance[current[0]][current[1]] + 1;
                        queue.offer(new int[]{nowX, nowY, current[2]});
                    }
                }

                if(nowX == N-1 && nowY == M-1){
                    System.out.print(distance[nowX][nowY] + 1);
                    System.exit(0);
                }
            }
        }
        System.out.println(-1);
    }

}
