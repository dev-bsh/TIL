package com.company;

import java.util.Scanner;

public class Back_1012 {

    public static int[][] field;
    public static boolean[][] isVisit;
    public static int count = 0;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i = 0; i<tc; i++){
            count  = 0;
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            field = new int[n][m];
            isVisit = new boolean[n][m];
            for(int j = 0; j < k; j++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                field[y][x] = 1;
            }
            for(int y = 0; y < n; y++){
                for(int x = 0; x < m; x++){
                   if(Dfs(y,x)) {
                       count++;
                   }
                }
            }
            System.out.println(count);
        }
    }

    public static boolean Dfs(int i,int j){
        if(i<0||j<0||i>=field.length||j>=field[0].length){
            return false;
        }
        if(!isVisit[i][j] && field[i][j] == 1){
            isVisit[i][j] = true;
            Dfs(i+1,j);
            Dfs(i-1,j);
            Dfs(i,j+1);
            Dfs(i,j-1);
            return true;
        }
        return false;
    }


}
