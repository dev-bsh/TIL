package com.company;

import java.util.Scanner;

public class Back_14890 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] board = new int[n][n];
        int path = 0;
        boolean isPossible = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            int tmp = 0;
            int count = 1;
            int downCount = 0;
            for(int j = 0; j <= n; j++){
                if(j == n){
                    isPossible = true;
                    break;
                }
                else if(j == 0){
                    tmp = board[i][j];
                }
                else if(tmp == board[i][j]){
                    if(downCount > 0){
                        downCount--;
                    }
                    else {
                        count++;
                    }
                }
                else {
                    if(downCount > 0){
                        isPossible = false;
                        break;
                    }
                    else if(tmp < board[i][j]){
                        if(board[i][j]-tmp > 1|| count < l){
                            isPossible = false;
                            break;
                        }
                        else{
                            tmp = board[i][j];
                            count = 1;
                        }
                    }
                    else{
                        if(tmp-board[i][j]>1){
                            isPossible = false;
                            break;
                        }
                        else{
                            tmp = board[i][j];
                            count = 0;
                            downCount = l-1;
                        }

                    }

                }
            }
            if(isPossible && downCount == 0){
                path++;
            }
        }

        for(int j = 0; j < n; j++){
            int tmp = 0;
            int count = 1;
            int downCount = 0;
            for(int i = 0; i <= n; i++){
                if(i == n){
                    isPossible = true;
                    break;
                }
                else if(i == 0){
                    tmp = board[i][j];
                }
                else if(tmp == board[i][j]){
                    if(downCount > 0){
                        downCount--;
                    }
                    else {
                        count++;
                    }
                }
                else {
                    if(downCount > 0){
                        isPossible = false;
                        break;
                    }
                    else if(tmp < board[i][j]){
                        if(board[i][j]-tmp > 1|| count < l){
                            isPossible = false;
                            break;
                        }
                        else{
                            tmp = board[i][j];
                            count = 1;
                        }
                    }
                    else{
                        if(tmp-board[i][j]>1){
                            isPossible = false;
                            break;
                        }
                        else{
                            tmp = board[i][j];
                            count = 0;
                            downCount = l-1;
                        }

                    }

                }
            }
            if(isPossible && downCount == 0){
                path++;
            }
        }

        System.out.println(path);


    }

}
