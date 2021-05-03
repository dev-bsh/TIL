package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Back_1260 {

    public static Queue<Integer> que = new LinkedList<>();
    public static int[][] graph;
    public static int count = 0;
    public static boolean[] isVisited;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt()+1;
        int m = sc.nextInt();
        int v = sc.nextInt();
        graph = new int[n][n];
        isVisited = new boolean[n];
        for(int i = 0; i< m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start][end] = 1;
            graph[end][start] = 1;
        }
        Dfs(v);
        isVisited = new boolean[n];
        System.out.println();
        Bfs(v);

    }
    public static void Dfs(int v){
        if(count == graph.length-1){
            return;
        }
        System.out.print(v+" ");
        isVisited[v] = true;
        for(int j = 0; j<graph[v].length; j++){
            if(!isVisited[j] && graph[v][j]==1){
                count++;
                Dfs(j);
            }
        }

    }
    public static void Bfs(int v){
        que.offer(v);
        isVisited[v] = true;
        while(!que.isEmpty()){
            int head = que.poll();
            System.out.println(head+" ");
            for(int j = 0; j<graph[head].length; j++){
                if(!isVisited[j] && graph[head][j] ==1){
                    que.offer(j);
                    isVisited[j] = true;
                }
            }
        }
    }

}

