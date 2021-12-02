package com.company.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 부수고 이동하기
public class Boj_2206 {

    //상하좌우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        // 벽을 부수고 나온 루트인지 그냥 루트인지 구분하기 위해 3차원 거리 값도 이 배열에 계산
        int[][][] isVisited = new int[N][M][2];

        for(int i = 0; i < N; i++){
            String tmp = input.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        System.out.println(bfs(map,isVisited));

    }

    public static int bfs(int[][] map, int[][][] isVisited){
        Queue<int[]> queue = new LinkedList<>();
        // 초기값 큐에 삽입
        queue.offer(new int[]{0,0,0});
        // 시작값 1로 지정
        isVisited[0][0][0] = 1;
        isVisited[0][0][1] = 1;

        // 큐가 비워지면 종료
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            // 벽 충돌 여부 확인을 위한 변수
            int crash = current[2];

            for(int i = 0; i < 4; i++){
                int nX = x + dx[i];
                int nY = y + dy[i];

                if(nX < 0 || nX >= map.length || nY < 0 || nY >= map[0].length){
                    continue;
                }

                // 진행할 수 없는 벽일 때
                if(map[nX][nY] == 1){
                    // 아직 벽을 부수지 않은 상태면
                    if(crash == 0){
                        // 이전 노드값 + 1을 현재 방문노드에 저장
                        isVisited[nX][nY][1] = isVisited[x][y][0] + 1;
                        // 이번에 벽을 부수고 방문 했기에 crash에 1을 넣은채로 큐에 삽입
                        queue.offer(new int[]{nX,nY,1});
                    }
                }
                // 진행 가능한 상황일 때
                else{
                    // 한번도 방문하지 않은 노드 일 때
                    if(isVisited[nX][nY][crash] == 0){
                        // 벽을 부순 여부를 그대로 유지한 채 이전 노드 값 + 1 방문 노드에 저장
                        isVisited[nX][nY][crash] = isVisited[x][y][crash] + 1;
                        queue.offer(new int[]{nX,nY,crash});
                    }
                }

            }

            // 마지막에 도달했을 경우 벽 부순 경우 양쪽 다 확인할 필요없이 먼저 도달한 쪽 값 리턴
            if(x == map.length-1 && y == map[0].length-1){
                return isVisited[x][y][crash];
            }
        }
        // 마지막 노드에 못 간 경우 -1 리턴
        return -1;
    }

}
