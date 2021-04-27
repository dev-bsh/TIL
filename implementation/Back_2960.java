package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Back_2960 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        int count = 0;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            nums.add(i);
        }

        while (count < k) {
            int p = nums.get(0);
            for (int i = 0; i < nums.size(); i++) {
                if (count >= k) {
                    break;
                } else if (nums.get(i) % p == 0) {
                    result = nums.get(i);
                    nums.remove(i);
                    count++;
                    i--;
                }
            }
        }

        System.out.println(result);
    }
}
