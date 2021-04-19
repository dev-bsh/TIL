package com.company;

import java.util.Scanner;

//백트래킹 문제
public class Nqueen {

    private static int[] arr;
    private static int count = 0;
    private static int n;

    public static void main(String[] args) {
        int tc;
        Scanner sc = new Scanner(System.in);

        tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            n = sc.nextInt();
            arr = new int[n];
            findPath(0);
            System.out.println("#" + (i + 1) + " " + count);
            count = 0;
        }

    }

    public static void findPath(int col) {

        if (col == n) {
            count++;
        } else {
            for (int i = 0; i < n; i++) {
                arr[col] = i;

                if (checkPossible(col)) {
                    findPath(col + 1);
                }

            }
        }
    }

    public static boolean checkPossible(int col) {

        for (int i = 0; i < col; i++) {

            if (arr[col] == arr[i]) {
                return false;
            } else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }

}
