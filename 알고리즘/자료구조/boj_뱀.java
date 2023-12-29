package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj_뱀 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        // 사과 위치
        int k = Integer.parseInt(input.readLine());
        ArrayList<String> apple = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            apple.add(input.readLine());
        }

        // 방향 전환 명령어
        int c = Integer.parseInt(input.readLine());
        Queue<String> command = new LinkedList<>();
        for (int i = 0; i < c; i++) {
            command.add(input.readLine());
        }

        int time = 0, headX = 1, headY = 1;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int idx = 0;

        Queue<String> snakeQue = new LinkedList<>();
        snakeQue.add("1 1");
        while (true) {
            time++;
            // 뱀 머리 위치 조정
            headX += dx[idx];
            headY += dy[idx];
            String target = headX + " " + headY;
            // 게임 종료 조건
            if (headX <= 0 || headX > n
                    || headY <= 0 || headY > n
                    || snakeQue.contains(target)) break;

            // 뱀 진행
            snakeQue.add(target);

            // 방향 변환 확인
            if (!command.isEmpty()) {
                String cmd = command.peek();
                int cmdTime = Integer.parseInt(cmd.split(" ")[0]);
                if (cmdTime == time) {
                    String direction = cmd.split(" ")[1];
                    if (direction.equals("D")) {
                        idx = idx+1 == 4 ? 0 : idx+1;
                    } else {
                        idx = idx-1 == -1 ? 3 : idx-1;
                    }
                    command.poll();
                }
            }

            // 사과인지 확인하고 꼬리 조절
            if (apple.contains(target)) {
                apple.remove(target);
            } else {
                snakeQue.poll();
            }
        }

        System.out.println(time);
    }
}
