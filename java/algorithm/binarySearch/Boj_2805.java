package com.company.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());
        ArrayList<Integer> trees = new ArrayList<>();
        while (st.hasMoreTokens()) {
            trees.add(Integer.parseInt(st.nextToken()));
        }

        long start = 0;
        long end = Collections.max(trees);
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long result = 0;
            for (int tree : trees) {
                if (tree > mid) {
                    result += tree - mid;
                }
                if(result >= m) {
                    break;
                }
            }

            if(result >= m) {
                start = mid + 1;
                answer = mid;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
