package com.company.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_13164 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] kids = new int[n];
        ArrayList<Integer> diff =new ArrayList<>();
        st = new StringTokenizer(input.readLine());

        for(int i = 0; i < n; i++){
            kids[i] = Integer.parseInt(st.nextToken());
            if(i > 0){
                // 바로 옆 아이들 간의 키차이 저장
                diff.add(kids[i] - kids[i-1]);
            }
        }
        Collections.sort(diff);
        int answer = 0;
        // 한명이 1개의 그룹일때 바로옆과 k번 합치면 n-k개의 그룹 생성 -> n-k 번 합치면 k개의 그룹생성
        for(int i = 0; i < n-k; i++){
            answer += diff.get(i);
        }

        System.out.println(answer);


    }
}
