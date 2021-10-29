package com.company;

import java.util.Scanner;

public class Back_1919 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder first = new StringBuilder(sc.next());
        StringBuilder second = new StringBuilder(sc.next());

        for (int i = 0; i < first.length(); i++) {
            int equalCnt = 0;
            for (int j = 0; j < second.length(); j++) {
                if (first.charAt(i) == second.charAt(j)) {
                    second.deleteCharAt(j);
                    first.deleteCharAt(i);
                    equalCnt++;
                    break;
                }
            }
            if (equalCnt != 0) {
                i--;
            }
        }
        System.out.println(first.length() + second.length());
    }
}
// 같은 문자를 제거 시킨 뒤 남아 있는 문자들의 합이 지워야 할 문자 최소 개수이다.