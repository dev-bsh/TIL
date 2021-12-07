package com.company.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 스타트링크
public class Boj_5014 {

    public static void main(String[] args) throws IOException {
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        // 시작층과 목표층이 같으면 0 출력
        if(S == G){
            System.out.println(0);
            return;
        }
        int[] tower = new int[F+1];
        bfs(tower, F, U, D, G, S);

    }

    public static void bfs(int[] tower, int F, int U, int D, int G, int S){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        // 현재층 방문처리 -> 나중에 결과값에서 -1해줘야함
        tower[S] = 1;
        while (!queue.isEmpty()){
            int current = queue.poll();

            // 목표층이면 출력
            if(current == G){
                System.out.println(tower[current] - 1);
                return;
            }

            // U 만큼 올라가도 최대층이하이며 미방문일때
            if(current + U <= F && tower[current + U] == 0){
                tower[current + U] = tower[current] + 1;
                queue.offer(current+U);
            }

            // D 만큼 내려가도 최저층이상이며 미방문일때
            if(current - D > 0 && tower[current - D] == 0){
                tower[current - D] = tower[current] + 1;
                queue.offer(current-D);
            }
        }
        // 목표층 도달하지 못하면 출력
        System.out.println("use the stairs");
    }

}
