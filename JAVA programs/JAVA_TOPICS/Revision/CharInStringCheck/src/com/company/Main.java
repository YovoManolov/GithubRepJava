package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        HashMap<Character,Integer> charMapMain;
        charMapMain =  m.checkCharacters("aaattggrrhhhhhh");

        System.out.println(charMapMain);
    }

    public HashMap<Character,Integer> checkCharacters(String str){
        HashMap<Character,Integer> charMap = new HashMap<>() ;
        for(char ch : str.toCharArray()){
            int count;
            if(charMap.get(ch) == null ||charMap.get(ch) == 0 ){
                charMap.put(ch,1);
            }else {
                count = charMap.get(ch);
                charMap.put(ch,++count);
            }
        }

        return charMap;
    }
}
