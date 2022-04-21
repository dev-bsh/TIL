package com.company.programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Report {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, Integer> indexMap = new HashMap<>();
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();

        // Map 초기화
        for(int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
            reportMap.put(id_list[i], new HashSet<>());
        }

        // report 신고자 분리
        for(String repo : report) {
            StringTokenizer st = new StringTokenizer(repo);
            String user = st.nextToken();
            String target = st.nextToken();
            // Set으로 중복제거
            reportMap.get(target).add(user);
        }

        // 신고받은 횟수 k 이상인지 확인
        for(String target : id_list) {
            int reportCount = reportMap.get(target).size();
            if(reportCount >= k){
                // 신고자 Set에서 신고자마다 answer++
                for(String user : reportMap.get(target)) {
                    answer[indexMap.get(user)]++;
                }
            }
        }


        return answer;
    }
}
