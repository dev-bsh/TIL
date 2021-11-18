package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back_11000 {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(input.readLine());
        int[][] lecture = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(input.readLine());
            lecture[i][0] = Integer.parseInt(st.nextToken());
            lecture[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lecture, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0] == o2[0]) {
                            return o1[1] - o2[1];
                        } else {
                            return o1[0] - o2[0];
                        }
                    }
                }
        );

        PriorityQueue<Integer> classes = new PriorityQueue<>();
        classes.add(lecture[0][1]);

        for(int i=1; i<N; i++){
            if(lecture[i][0] >= classes.peek()){
                classes.poll();
                classes.add(lecture[i][1]);
            }
            else{
                classes.add(lecture[i][1]);
            }
        }

        System.out.print(classes.size());


    }
}
