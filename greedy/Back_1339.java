package com.company;


import java.util.*;

public class Back_1339 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        String[] words = new String[n];
        HashMap<Character,Double> dic = new HashMap<>();
        for(int i = 0; i< n; i++){
            words[i] = sc.next();
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });

        for(int i = 0; i < words[0].length(); i++){
            int size = words[0].length() - i;
            for(int j = 0; j< words.length; j++){
                if(words[j].length() < size){
                    break;
                }
                else{
                    char key = words[j].charAt(i-(words[0].length()-words[j].length()));
                    if(dic.get(key) == null){
                        dic.put(key, Math.pow(10,size-1));

                    }
                    else {
                        dic.replace(key, (dic.get(key)+Math.pow(10,size-1)));
                    }
                }

            }
        }

        Collection<Double> tmp = dic.values();
        ArrayList<Double> values = new ArrayList<Double>(tmp);
        Collections.sort(values);
        int point = 9;
        for(int i = values.size()-1; i>=0; i--){
            sum += values.get(i) * point;
            point--;
        }
        System.out.print(sum);
    }
}
