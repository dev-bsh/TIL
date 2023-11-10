package com.company.sort;

import java.util.*;

public class Boj_1181 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0 ; i < n; i++){
            hashSet.add(sc.next());
        }

        ArrayList<String> words = new ArrayList<>(hashSet);

        words.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()){
                    return o1.length() - o2.length();
                }
                else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (String word : words) {
            System.out.println(word);
        }

    }
}
