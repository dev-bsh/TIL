package com.company;


import java.util.*;

public class StringSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc;
        tc = sc.nextInt();
        int n;
        String[] name;
        HashSet<String> hs = new HashSet<>();

        for(int testCase = 1; testCase <= tc; testCase++){
            n = sc.nextInt();
            hs.clear();
            for(int i = 0; i < n; i++){
                hs.add(sc.next());
            }

            name = (String[]) hs.toArray();

            Arrays.sort(name, new Comparator<String>(){
                @Override
                public int compare(String s1, String s2){
                    if(s1.length() == s2.length()){
                        return s1.compareTo(s2);
                    }
                    else
                        return Integer.compare(s1.length(),s2.length());

                }

            });
            System.out.format("# %d",testCase);
            for(String string : name){
                System.out.println(string);
            }


        }




    }
}
