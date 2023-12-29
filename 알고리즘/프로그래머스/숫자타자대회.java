package 프로그래머스;

import java.util.Arrays;

public class 숫자타자대회 {
    public int[][] cost = {
            { 1, 7, 6, 7, 5, 4, 5, 3, 2, 3 },
            { 7, 1, 2, 4, 2, 3, 5, 4, 5, 6 },
            { 6, 2, 1, 2, 3, 2, 3, 5, 4, 5 },
            { 7, 4, 2, 1, 5, 3, 2, 6, 5, 4 },
            { 5, 2, 3, 5, 1, 2, 4, 2, 3, 5 },
            { 4, 3, 2, 3, 2, 1, 2, 3, 2, 3 },
            { 5, 5, 3, 2, 4, 2, 1, 5, 3, 2 },
            { 3, 4, 5, 6, 2, 3, 5, 1, 2, 4 },
            { 2, 5, 4, 5, 3, 2, 3, 2, 1, 2 },
            { 3, 6, 5, 4, 5, 3, 2, 4, 2, 1 }
    };
    public int[][][] dp;

    public int solution(String numbers) {
        int answer = 0;
        dp = new int[numbers.length()][10][10];
        for (int i = 0; i < numbers.length(); i++) {
            for (int j = 0; j < 10; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        answer = find(0, 4, 6, numbers);
        return answer;
    }

    public int find(int idx, int L, int R, String numbers) {
        if (idx == numbers.length()) return 0;
        // 이미 도출된 값은 탐색 x
        if (dp[idx][L][R] > -1) return dp[idx][L][R];
        int num = Character.getNumericValue(numbers.charAt(idx));
        int result = Integer.MAX_VALUE;

        // 왼손이 오른손과 겹치지 않을 때만 왼손 움직이기
        if (num != R) {
            result = Math.min(result, find(idx+1, num, R, numbers) + cost[L][num]);
        }

        // 오른손이 왼손과 겹치지 않을 때만 오른손 움직이기
        if (num != L) {
            result = Math.min(result, find(idx+1, L, num, numbers) + cost[num][R]);
        }

        dp[idx][L][R] = result;
        return result;
    }
}
