package com.company;

import java.util.Scanner;

public class Back_1913 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        int[][] board = new int[N][N];

        int x = 0;
        int y = 0;
        int answerI = 0;
        int answerJ = 0;
        int firstNum = N*N;
        while(firstNum>0){
            // 아랫방향, 오른쪽방향 숫자입력
            for(int i=y; i<N; i++){
                board[i][x] = firstNum;
                firstNum--;
                //배열 끝이나 다음숫자가 현재숫자보다 큰경우(이미 전에 입력한경우) 오른쪽으로 전환
                if(i==N-1 || board[i+1][x] > board[i][x]){
                    for(int j=x+1; j<N; j++){
                        // 현재값이 이전값보다 크면 종료
                        if(board[i][j-1]<board[i][j]){
                            x = j-1;
                            break;
                        }
                        board[i][j] = firstNum;
                        firstNum--;
                        x = j;
                    }
                    y = i-1;
                    break;
                }
            }

            if( firstNum == 0){
                break;
            }
            // 윗방향, 왼쪽방향 숫자입력
            for(int i=y; i>=0; i--){
                board[i][x] = firstNum;
                firstNum--;
                // 왼쪽으로 전환
                if(i == 0 || board[i-1][x] > board[i][x] ){
                    for(int j=x-1; j>=0; j--){
                        // 현재값이 이전값보다 큰 경우 (입력된 값이 이미 있는경우) 종료
                        if(board[i][j+1] < board[i][j]){
                            x = j+1;
                            break;
                        }
                        board[i][j] = firstNum;
                        firstNum--;
                        x = j;
                    }
                    y = i+1;
                    break;
                }
            }

        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(board[i][j]+" ");
                if(board[i][j] == target){
                    answerI = i+1;
                    answerJ = j+1;
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.out.print(answerI+" "+answerJ);
    }
}
