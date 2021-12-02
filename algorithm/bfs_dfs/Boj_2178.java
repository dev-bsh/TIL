package com.company.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로탐색
public class Boj_2178 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for(int i = 0; i < N; i++){
            String s = input.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        //상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        //BFS를 위한 큐
        Queue<int[]> queue = new LinkedList<>();
        //초기 값 0,0 입력
        queue.offer(new int[]{0,0});

        //큐가 비어지면 (모든 노드 탐색이 끝나면) 종료
        while(!queue.isEmpty()){
            //큐에 들어있는 현재 좌표를 가져옴
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int i = 0; i < 4; i++){
                //dx, dy를 더해 상하좌우를 탐색
                int nX = x + dx[i];
                int nY = y + dy[i];

                // 범위를 벗어나거나 이동불가 혹은 이미 방문한 노드인 경우 패스
                if(nX < 0 || nX >= N || nY < 0 || nY >= M || map[nX][nY] == 0 || map[nX][nY] > 1){
                    continue;
                }

                //방문 가능한 경우 이전 노드 값 + 1 을 방문 노드에 추가 (거리 1칸씩 증가)
                map[nX][nY] = map[x][y] + 1;
                //현재위치에서 다시 너비우선탐색을 위해 현재 좌표를 큐에 저장
                queue.offer(new int[]{nX,nY});
            }
        }

        // 마지막 노드는 가장 가까운 노드끼리 더해진 최단거리가 입력되어 있음
        System.out.println(map[N-1][M-1]);
    }
}
