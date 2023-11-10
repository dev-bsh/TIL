package com.company.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_10867 {
    public  static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            hashSet.add(Integer.parseInt(st.nextToken()));
        }
        Iterator<Integer> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            arrayList.add(iterator.next());
        }
        Collections.sort(arrayList);

        for (int num:arrayList) {
            System.out.print(num+" ");
        }

    }
}
