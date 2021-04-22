package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Back_13904 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> score = new ArrayList<>();
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 0; i< n; i++){
            int day = sc.nextInt();
            int point = sc.nextInt();
            score.add(day*1000+point);
        }
        Collections.sort(score);
        int lastDay = score.get(score.size()-1)/1000;
        int count = 0;
        while(lastDay>0) {
            Collections.sort(score);
            for (int i = 0; i < score.size(); i++) {
                if (score.get(i) / 1000 >= lastDay) {
                    if (i == score.size() - 1 && count == 0) {
                        sum += score.get(i) - lastDay * 1000;
                        score.remove(i);
                        count++;
                    }
                    else {
                        score.set(i, score.get(i) - 1000);
                    }
                }
            }
            count = 0;
            lastDay--;
        }
        System.out.println(sum);

    }
}
