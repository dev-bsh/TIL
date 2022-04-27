package com.company.programmers;

public class 신규아이디추천 {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder fix_id = new StringBuilder();

        // 1,2 단계
        for(int i = 0; i < new_id.length(); i++) {
            char check = new_id.charAt(i);
            if(Character.isLetterOrDigit(check) || check == '-' || check == '_' || check == '.') {
                if(Character.isAlphabetic(check)) {
                    check = Character.toLowerCase(check);
                }
                fix_id.append(check);
            }
        }

        // 3단계
        new_id = fix_id.toString();
        fix_id = new StringBuilder();
        int dotCount = 0;
        for(int i = 0; i < new_id.length(); i++) {
            char check = new_id.charAt(i);
            if(check != '.'){
                fix_id.append(check);
                dotCount = 0;
            }
            else {
                if(dotCount == 0){
                    fix_id.append(check);
                    dotCount++;
                }
            }
        }

        // 4단계
        if(fix_id.length() > 0 && fix_id.charAt(0) == '.'){
            fix_id.deleteCharAt(0);
        }
        if(fix_id.length() > 0 && fix_id.charAt(fix_id.length()-1) == '.') {
            fix_id.deleteCharAt(fix_id.length()-1);
        }

        // 5단계 6단계
        if(fix_id.length() == 0) {
            fix_id.append('a');
        }

        if(fix_id.length() > 15) {
            fix_id = new StringBuilder(fix_id.substring(0,15));
            if(fix_id.charAt(fix_id.length()-1) == '.') {
                fix_id.deleteCharAt(fix_id.length()-1);
            }
        }

        // 7단계
        if(fix_id.length() < 3) {
            while(fix_id.length() < 3) {
                fix_id.append(fix_id.charAt(fix_id.length()-1));
            }
        }

        answer = fix_id.toString();

        return answer;
    }
}
