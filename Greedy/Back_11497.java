package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Back_11497 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test_case = 0; test_case < t; test_case++) {
            int n = sc.nextInt();
            int[] tree = new int[n];
            int[] sorted_tree = new int[n];
            int[] differ = new int[n];
            for (int i = 0; i < n; i++) {
                tree[i] = sc.nextInt();
            }
            Arrays.sort(tree);
            sorted_tree[n / 2] = tree[0];
            int idx = 1;
            int j = 0;
            while (true) {
                if (j > 0 && j % 2 == 0) {
                    idx++;
                }
                if (j>=n-1) {
                    break;
                }
                if (j % 2 == 0) {
                    sorted_tree[n / 2 - idx] = tree[j+1];
                } else {
                    sorted_tree[n / 2 + idx] = tree[j+1];
                }
                j++;
            }
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    differ[i] = Math.abs(sorted_tree[i] - sorted_tree[0]);
                } else {
                    differ[i] = Math.abs(sorted_tree[i] - sorted_tree[i + 1]);
                }

            }
            Arrays.sort(differ);
            System.out.println(differ[n - 1]);
        }


    }
}