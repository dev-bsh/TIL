package 프로그래머스;

import java.util.ArrayList;

public class 등대 {
    ArrayList<Integer>[] graph;
    int[][] dp;
    public int solution(int n, int[][] lighthouse) {
        graph = new ArrayList[n+1];
        // dp[현재노드] = [불 켜진 자식노드 개수 + 자신의 불빛, 자신의 불빛 상태(1이 켜짐, 0이꺼짐)]
        dp = new int[n+1][2];

        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
            dp[i][0] = 0;
            dp[i][1] = 0;
        }

        for (int[] value:lighthouse) {
            // a->b 와 b->a 간선을 graph에 추가
            graph[value[0]].add(value[1]);
            graph[value[1]].add(value[0]);
        }

        dfs(0,1);
        return dp[1][0];
    }

    private void dfs(int parent, int curNode) {
        for (int child:graph[curNode]) {
            // 부모 노드로 향하는 간선은 pass
            if (child == parent) continue;
            // 자식 노드의 상태 확인을 위해 dfs
            dfs(curNode, child);
            // 탐색한 자식노드의 상태가 불이꺼진상태(0)면 현재 노드의 불을 켜줌
            // 자식 노드가 중 1개라도 불이 꺼져있으면 현재 노드 불을 켜줘야함
            if (dp[child][1] == 0) dp[curNode][1] = 1;
            // 지금까지 불켜진 등대 개수(dp[child][0])를 현재 노드에 추가
            dp[curNode][0] += dp[child][0];
        }
        // 본인도 불 켜진 상태면 개수 추가
        if (dp[curNode][1] == 1) dp[curNode][0]++;
    }
}
