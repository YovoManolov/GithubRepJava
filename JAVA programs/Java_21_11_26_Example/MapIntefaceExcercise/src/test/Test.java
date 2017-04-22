/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yovo
 */
public class Test {
    public static void main(String[] args){
    HashMap<String, Integer> hm = new HashMap<>();
    hm.put("aaa", 5);
    hm.put("aaa", 6);
    hm.put("bbb", 6);
    for(Map.Entry<String,Integer> es : hm.entrySet()){
       System.out.println(es.getKey()+" "+es.getValue());
    }
 }   
}
