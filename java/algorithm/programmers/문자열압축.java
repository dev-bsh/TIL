package com.company.programmers;

public class 문자열압축 {
    public int solution(String s) {
        int answer = s.length();
        int length = 1;

        while(length <= s.length()/2) {

            int index = 0;
            int count = 1;
            String compareWord = "";
            String compressString = "";
            String sub = "";
            while(index < s.length()) {

                if(index + length >= s.length()) {
                    compareWord = s.substring(index, s.length());
                    break;
                } else {
                    compareWord = s.substring(index, index + length);
                }

                index += length;

                if(index + length >= s.length()) {
                    sub = s.substring(index, s.length());
                } else {
                    sub = s.substring(index, index + length);
                }


                if(compareWord.equals(sub)) {
                    count++;
                } else {
                    if(count > 1) {
                        compressString += (count + compareWord);
                    } else {
                        compressString += compareWord;
                    }
                    compareWord = sub;
                    count = 1;
                }
            }

            if(count > 1) {
                compressString += (count + compareWord);
            } else {
                compressString += compareWord;
            }

            answer = Math.min(answer, compressString.length());
            length++;
        }

        return answer;
    }
}
