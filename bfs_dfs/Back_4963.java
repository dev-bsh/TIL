package com.company;

import java.util.Scanner;

public class Back_4963 {

    public static int[][] map;
    public static boolean[][] isVisited;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            int w = sc.nextInt();
            int h = sc.nextInt();
            int count = 0;
            if(w ==0 && h == 0){
                break;
            }
            isVisited = new boolean[h][w];
            map = new int[h][w];
            for(int i = 0; i<h; i++){
                for(int j=0; j<w; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i = 0; i<h; i++){
                for(int j = 0; j<w; j++){
                    if(Dfs(i,j)){
                        count++;
                    }
                }
            }
            System.out.println(count);

        }

    }

    public static boolean Dfs(int i,int j){
        if(i<0 || j<0|| i>=map.length || j>=map[0].length){
            return false;
        }
        if(map[i][j] == 1 && !isVisited[i][j]){
            isVisited[i][j] = true;
            Dfs(i-1,j-1);
            Dfs(i-1,j);
            Dfs(i-1,j+1);
            Dfs(i,j-1);
            Dfs(i,j+1);
            Dfs(i+1,j-1);
            Dfs(i+1,j);
            Dfs(i+1,j+1);
            return true;
        }
        return false;
    }


}
