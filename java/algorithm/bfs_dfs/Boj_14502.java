package com.company.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 연구소 / 벽세우기는 DFS, 바이러스 퍼뜨리기는 BFS
public class Boj_14502 {

    // 상하좌우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    // 바이러스 좌표
    public static ArrayList<int[]> virus = new ArrayList<>();

    public static int[][] lab;
    // 바이러스 퍼뜨리기 위한 복사공간
    public static int[][] copyLab;
    // 벽 세우기를 위한 방문체크
    public static boolean[][] isVisited;
    public static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        lab = new int[n][m];
        copyLab = new int[n][m];
        isVisited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j<m; j++){
                lab[i][j] = Integer.parseInt(st.nextToken());
                // 바이러스 좌표 저장
                if(lab[i][j] == 2){
                    virus.add(new int[]{i,j});
                }
            }
        }

        buildWall(0);
        System.out.println(max);

    }

    public static void buildWall(int cnt){
        int count = cnt;
       // 벽이 3개면
        if(count == 3){
            // 현재 연구소 배열을 복사
            copyArr();
            // 복사된 배열에 바이러스를 퍼뜨리고
            spreadVirus();
            // 안전구역을 카운트
            countSafeArea();
            return ;
        }

        // 벽 3개가 아니면
        for(int i = 0; i<lab.length; i++){
            for(int j = 0; j<lab[0].length; j++){
                // 빈 공간이고 방문하지 않은 노드면
                if(lab[i][j] == 0 && !isVisited[i][j]){
                    // 벽세우고 방문처리후 벽카운트 1증가
                    lab[i][j] = 1;
                    isVisited[i][j] = true;
                    count++;

                    // 추가 벽을 세우기 위해 다시 탐색
                    buildWall(count);

                    // 다음 자리에 벽을 세우기 위해 현재 노드 정리
                    lab[i][j] = 0;
                    isVisited[i][j] = false;
                    count--;
                }
            }
        }
    }

    // 바이러스 퍼뜨리기 BFS
    public static void spreadVirus(){
        Queue<int[]> queue = new LinkedList<>();
        for (int[] ints : virus) {
            // 바이러스 위치를 큐에 저장
            queue.offer(ints);
        }

        //큐가 빌때까지 반복
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int i = 0; i<4; i++){
                int nX = x + dx[i];
                int nY = y + dy[i];

                if(nX < 0 || nX >= copyLab.length || nY < 0 || nY >= copyLab[0].length){
                    continue;
                }

                // 바이러스가 닿는 빈공간을 전부 바이러스로 처리
                if(copyLab[nX][nY] == 0){
                    copyLab[nX][nY] = 2;
                    queue.offer(new int[]{nX,nY});
                }
            }
        }
    }

    // 0인 안전공간 카운트하고 최대값 비교
    public static void countSafeArea(){
        int safeArea = 0;
        for(int i = 0; i < copyLab.length; i++){
            for(int j = 0; j < copyLab[0].length; j++){
                if(copyLab[i][j] == 0){
                    safeArea++;
                }
            }
        }
        max = Math.max(max, safeArea);
    }

    //2차배열 복사를 위한 메서드
    public static void copyArr(){
        for(int i = 0; i<lab.length; i++){
            for(int j = 0; j<lab[0].length; j++){
                copyLab[i][j] = lab[i][j];
            }
        }
    }
}
