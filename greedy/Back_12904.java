package com.company;

import java.util.Scanner;

public class Back_12904 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        StringBuilder sb;
        int i = t.length()-1;
        while(s.length() < t.length()) {
            sb = new StringBuilder(t);
            if(t.charAt(i) == 'A'){
                sb.deleteCharAt(i);
            }
            else {
                sb.deleteCharAt(i);
                sb.reverse();
            }
            t = sb.toString();
            i--;

        }
        if(s.equals(t)){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}
