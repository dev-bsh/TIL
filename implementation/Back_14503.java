package com.company;

import java.util.Scanner;

public class Back_14503 {

    public static int[][] board;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        int answer = 0;
        boolean isPossible;

        while (true) {
            if (board[r][c] == 0) {
                board[r][c] = 2;
                count = 0;
                answer++;
            } else {
                isPossible = checkLeft(r, c, d);
                count++;
                if (isPossible) {
                    d = turnLeft(d);
                    if (d == 0) {
                        r--;
                    } else if (d == 1) {
                        c++;
                    } else if (d == 2) {
                        r++;
                    } else {
                        c--;
                    }
                } else if (count < 5) {
                    d = turnLeft(d);
                } else {
                    if (checkBack(r, c, d)) {
                        if (d == 0) {
                            r++;
                        } else if (d == 1) {
                            c--;
                        } else if (d == 2) {
                            r--;
                        } else {
                            c++;
                        }
                        count = 0;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.print(answer);
    }

    public static boolean checkLeft(int r, int c, int d) {
        int leftR = r;
        int leftC = c;

        if (d == 0) {
            leftC--;
        } else if (d == 1) {
            leftR--;
        } else if (d == 2) {
            leftC++;
        } else {
            leftR++;
        }

        if (leftR < 0 || leftR >= board.length || leftC < 0 || leftC >= board[0].length) {
            return false;
        } else if (board[leftR][leftC] == 1 || board[leftR][leftC] == 2) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean checkBack(int r, int c, int d) {
        int backR = r;
        int backC = c;

        if (d == 0) {
            backR++;
        } else if (d == 1) {
            backC--;
        } else if (d == 2) {
            backR--;
        } else {
            backC++;
        }

        if (backR < 0 || backR >= board.length || backC < 0 || backC >= board[0].length) {
            return false;
        } else if (board[backR][backC] == 1) {
            return false;
        } else {
            return true;
        }
    }

    public static int turnLeft(int d) {
        if (d == 0) {
            return 3;
        } else {
            return d - 1;
        }
    }

}
