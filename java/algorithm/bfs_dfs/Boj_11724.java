package com.company.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class Boj_11724 {

    //연결여부 확인
    public static boolean isLinked = false;
    //양방향 간선을 위한 그래프 사용
    public static int[][] graph;
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N][N];
        int answer = 0;

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            // 양방향 연결되어있으면 1
            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        // 간선이 없는 경우 자기자신도 연결요소이므로 1 주입
        for(int i = 0; i<N; i++){
            graph[i][i] = 1;
        }
        // dfs로 탐색
        for(int i = 0; i<N; i++){
            dfs(i);
            // 한번이라도 연결되어있으면 ++
            if(isLinked){
                answer++;
                isLinked = false;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int i){
        for (int j = 0; j<graph.length; j++){
            if(graph[i][j] == 1){
                isLinked = true;
                // 나머지 요소 탐색을 위한 연결요소 소거
                graph[i][j] = 0;
                graph[j][i] = 0;
                dfs(j);
            }
        }
    }

}
