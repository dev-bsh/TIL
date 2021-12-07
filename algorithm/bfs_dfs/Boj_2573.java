package com.company.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2573 {

    public static boolean isFind = false;
    public static boolean[][] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while(true){
            // 방문기록 초기화
            isVisited = new boolean[n][m];
            // 빙산조각 초기화
            int iceBerg = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    // 방문한적없고 빙산일 때
                    if(!isVisited[i][j] && map[i][j] != 0){
                        iceBerg++;
                        // 깊이우선탐색
                        dfs(map, i, j);
                    }
                }
            }
            // 빙산이 하나도 없으면 종료
            if(iceBerg == 0){
                year = 0;
                break;
            }

            // 빙산이 두조각 이상되면 종료
            if(iceBerg >= 2){
                break;
            }

            // 이상없으면 1년추가
            year++;
        }
        System.out.println(year);
    }

    public static void dfs(int[][] map, int r, int c){

        // 방문기록 및 범위체크
        if(r < 0 || r >= map.length || c < 0 || c >= map[0].length || isVisited[r][c] || map[r][c] == 0){
            return ;
        }
        else {
            isVisited[r][c] = true;
            // 빙산 발견시 true
            isFind = true;
            // 빙산 녹이기
            meltIce(map,r,c);
        }

        // 상하좌우 계속 탐색
        dfs(map,r+1, c);

        dfs(map,r-1, c);

        dfs(map, r, c+1);

        dfs(map, r, c-1);
    }

    // 빙산 녹이기 : 주변의 바다 개수당 1씩 감소
    public static void meltIce(int[][] map, int r, int c){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        //상하좌우 탐색
        for(int i = 0; i<4; i++){
            int x = r + dx[i];
            int y = c + dy[i];

            if(x < 0 || x >= map.length || y < 0 || y >= map[0].length){
                continue;
            }

            // 같은 해에 녹아 바다가 된 곳이 아니며 해당 지점이 0보다 클때만 감소
            if(!isVisited[x][y] && map[x][y] == 0 && map[r][c] > 0){
                map[r][c]--;
            }
        }
    }


}
