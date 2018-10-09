package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nextString ;
        String[] array = new String [5];
        for( int i = 0 ; i < 5 ; i ++){
            if((nextString = sc.next()) != null){
                array[i] = nextString;
            }
        }

        System.out.println("Printing the array : ");
        for(String s :array){
            System.out.print(s + " || ");
        }

    }
}
