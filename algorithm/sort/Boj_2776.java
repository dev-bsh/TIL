package com.company.sort;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_2776 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(input.readLine());

        for(int i = 0; i<tc; i++){
            int n = Integer.parseInt(input.readLine());
            HashMap<Integer, Integer> nums = new HashMap<>();
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                nums.put(Integer.parseInt(st.nextToken()),0);
            }

            int m = Integer.parseInt(input.readLine());
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < m; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(nums.containsKey(tmp)) {
                    output.write("1");
                }
                else {
                    output.write("0");
                }
                output.newLine();
            }
        }
        output.close();

    }
}
