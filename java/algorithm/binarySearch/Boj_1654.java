package com.company.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> cables = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            cables.add(Integer.parseInt(input.readLine()));
        }

        long start = 1;
        long end = Collections.max(cables);
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;
            if(mid != 0) {
                for(int cable : cables) {
                    total += cable / mid;
                    if(total >= n) {
                        break;
                    }
                }
            }

            if(total >= n) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);

    }
}
