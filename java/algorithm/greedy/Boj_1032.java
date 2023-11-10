package com.company;

import java.util.Scanner;

public class Back_1032 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        String[] fileName = new String[tc];

        for(int test_case = 0; test_case < tc; test_case++){
            fileName[test_case] = sc.next();
        }

        for(int i = 0; i < fileName[0].length(); i++){
            boolean isEx = true;
            for(int j = 0; j < tc-1; j++){
                if(fileName[j].charAt(i) != fileName[j+1].charAt(i)){
                    isEx = false;
                    break;
                }
            }
            if(isEx){
                System.out.print(fileName[0].charAt(i));
            }
            else{
                System.out.print("?");
            }
        }



    }
}





