package com.company;

import java.util.Scanner;

public class Back_2606 {

    public static int[][] board;
    public static int count = 0;
    public static boolean[] isVisit;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int node = sc.nextInt()+1;
        int bus = sc.nextInt();
        board = new int[node][node];
        isVisit = new boolean[node];

        for(int i = 0; i<bus; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            board[start][end] = 1;
            board[end][start] = 1;
        }

        Dfs(1);
        System.out.print(count-1);
    }

    public static void Dfs(int v){
        count++;
        isVisit[v] = true;
        for(int i = 0; i < board.length; i++){
            if(!isVisit[i] && board[v][i]==1){
                Dfs(i);
            }
        }
    }

}
