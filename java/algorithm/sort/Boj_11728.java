package com.company.sort;

import java.io.*;
import java.util.*;

public class Boj_11728 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> nums = new ArrayList<>();
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < m; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(nums);

        for (int num: nums) {
            output.write(String.valueOf(num));
            output.append(" ");
        }
        output.close();
    }
}
