package com.company;

import java.util.Scanner;

public class Back_17413 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        boolean isTag = false;
        boolean isWord = false;
        StringBuilder word = null;
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) == '<' || isTag){
                if (isWord) {
                    System.out.print(word.reverse());
                    word = null;
                    isWord = false;
                }
                isTag = true;
                System.out.print(input.charAt(i));
                if(input.charAt(i) == '>'){
                    isTag = false;
                }
            }
            else if(input.charAt(i) == ' '&& isWord ){
                System.out.print(word.reverse()+String.valueOf(input.charAt(i)));
                word = null;
                isWord = false;
            }
            else {
                isWord = true;
                if(word == null){
                    word = new StringBuilder(String.valueOf(input.charAt(i)));
                }
                else {
                    word.append(input.charAt(i));
                    if(i == input.length()-1){
                        System.out.println(word.reverse());
                    }
                }

            }
        }
    }
}

//1. 태그인 경우
//2. 공백인 경우
//3. 단어인 경우 -> 공백/태그/문자열의 끝(단어 역전 후 출력)