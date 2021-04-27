package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Back_1706 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        String[] puzzle = new String[r];
        ArrayList<String> word = new ArrayList<>();
        String tmp = new String("0");

        for(int i=0; i<r; i++){
            puzzle[i] = sc.next();
        }

        for(int i=0; i<puzzle.length; i++){
            boolean isAdd = false;
            for(int j=0; j<c; j++){
                if(!isAdd && puzzle[i].charAt(j) != '#'){
                    tmp = new String(String.valueOf(puzzle[i].charAt(j)));
                    isAdd = true;
                }
                else if(isAdd && puzzle[i].charAt(j) != '#'){
                    tmp += puzzle[i].charAt(j);
                }
                else if(isAdd && puzzle[i].charAt(j) == '#'){
                    word.add(tmp);
                    tmp = new String("0");
                    isAdd = false;
                }
            }
            word.add(tmp);
            tmp = new String("0");
        }
        for(int j=0; j<c; j++){
            boolean isAdd = false;
            for(int i=0; i<puzzle.length; i++){
                if(!isAdd && puzzle[i].charAt(j) != '#'){
                    tmp = new String(String.valueOf(puzzle[i].charAt(j)));
                    isAdd = true;
                }
                else if(isAdd && puzzle[i].charAt(j) != '#'){
                    tmp += puzzle[i].charAt(j);
                }
                else if(isAdd && puzzle[i].charAt(j) == '#'){
                    word.add(tmp);
                    tmp = new String("0");
                    isAdd = false;
                }
            }
            word.add(tmp);
            tmp = new String("0");
        }

        Collections.sort(word);
        for(int i=0; i<word.size(); i++){
            if(word.get(i).length() == 1){
                word.remove(i);
                i--;
            }
        }

        System.out.println(word.get(0));

    }
}
