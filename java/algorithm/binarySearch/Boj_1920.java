package com.company.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_1920 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        StringTokenizer st = new StringTokenizer(input.readLine());
        ArrayList<Integer> aNums = new ArrayList<>();
        while (st.hasMoreTokens()) {
            aNums.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(aNums);

        int m = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        while (st.hasMoreTokens()) {
            boolean isExist = binarySearch(aNums, Integer.parseInt(st.nextToken()), 0, n-1);
            if(isExist) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }

    }

    private static boolean binarySearch(ArrayList<Integer> aNums, int target, int start, int end) {
        if(start > end) {
            return false;
        }

        int mid = (start+end)/2;
        if(aNums.get(mid) == target){
            return true;
        }
        else {
            if(target > aNums.get(mid)) {
                return binarySearch(aNums, target, mid+1, end);
            }
            else {
                return binarySearch(aNums, target, start, mid-1);
            }
        }
    }

}
