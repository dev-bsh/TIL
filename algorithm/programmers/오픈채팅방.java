package com.company.programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer = {};

        HashMap<String, String> uidMap = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        // uid 닉네임 map으로 꾸준히 최신화
        for(String log : record) {
            String[] userInfo = log.split(" ");
            if(userInfo[0].equals("Enter") || userInfo[0].equals("Change")) {
                uidMap.put(userInfo[1], userInfo[2]);
            }
        }

        for(String log : record) {
            String[] userInfo = log.split(" ");
            if(userInfo[0].equals("Enter")) {
                result.add(uidMap.get(userInfo[1])+"님이 들어왔습니다.");
            } else if(userInfo[0].equals("Leave")){
                result.add(uidMap.get(userInfo[1])+"님이 나갔습니다.");
            }
        }

        answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }


        return answer;
    }
}
