package com.company.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        StringTokenizer st = new StringTokenizer(input.readLine());
        ArrayList<Integer> nums = new ArrayList<>();
        while (st.hasMoreTokens()) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nums);

        int m = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        StringBuilder answer = new StringBuilder();
        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());
            int upperBound = upperBound(nums, target);
            int lowerBound = lowerBound(nums, target);

            answer.append(upperBound - lowerBound-1);
            answer.append(" ");
        }
        System.out.println(answer);
    }

    private static int lowerBound(ArrayList<Integer> nums, int target) {
        int start = 0;
        int end = nums.size()-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if(nums.get(mid) >= target) {
                 end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    private static int upperBound(ArrayList<Integer> nums, int target) {
        int start = 0;
        int end = nums.size()-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if(nums.get(mid) <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

}
