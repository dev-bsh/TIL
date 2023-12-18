package 프로그래머스;

import java.util.ArrayList;

public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        long answer = 0;
        for (int i = 0; i < 2; i++) {
            long[] dp_sequence = new long[sequence.length];
            for (int j = 0; j < sequence.length; j++) {
                int target;

                if (i == 0) target = j % 2 == 0 ? sequence[j] : sequence[j] * -1;
                else target = j % 2 != 0 ? sequence[j] : sequence[j] * -1;

                if (j == 0) dp_sequence[j] = target;
                // j-1까지의 수열에 현재값을 더할 것인지 현재값만 가져갈 것인지 dp로 최대값 추정
                else dp_sequence[j] = Math.max(dp_sequence[j-1]+target,  target);

                answer = Math.max(answer, dp_sequence[j]);
            }
        }
        return answer;
    }
}
