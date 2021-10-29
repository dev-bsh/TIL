package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] gems = new int[N][2];
        int[] bags = new int[K];
        // 보석 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(input.readLine());
            gems[i][0] = Integer.parseInt(st.nextToken());
            gems[i][1] = Integer.parseInt(st.nextToken());
        }
        // 가방 입력
        for(int i=0; i<K; i++){
            bags[i] = Integer.parseInt(input.readLine());
        }

        // 보석을 오름차순으로 정렬
        Arrays.sort(gems, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] -o2[0];
            }
        });
        // 가방을 오름차순으로 정렬
        Arrays.sort(bags);

        // 최대값을 고려해 long 타입으로 최종값 선언
        long answer = 0;
        int idx = 0;
        // 보석을 담을 우선순위 큐 (내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 정렬되어 사이즈가 작은 가방부터 탐색
        for(int i=0; i<K; i++){
            for(int j=idx; j<N; j++){
                // 가방에 들어갈 수 있는 보석을 모두 우선순위 큐에 넣는다.
                if(gems[j][0] <= bags[i]){
                    pq.add(gems[j][1]);
                    // 한번 넣은 보석에 다시 접근할 필요를 없애 탐색시간을 줄인다.
                    idx++;
                }
                else{
                    break;
                }
            }
            if(!pq.isEmpty()){
                // 해당 가방에 들어갈 수 있는 모든 보석이 들어간 큐에서 가장 가치가 큰 보석을 빼낸다.
                answer += pq.poll();
            }
        }
        System.out.print(answer);
    }
}
