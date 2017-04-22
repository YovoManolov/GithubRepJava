/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs_12_12_16.newpackage;

import java.util.Random;

/**
 *
 * @author yovo
 */
public class MainClass {
    public static void main(String[] args) throws InterruptedException {
       Double [] ArrayOfNumbers = new Double [5]; 
       Random r = new Random();
       for(int i = 0 ;i < ArrayOfNumbers.length ;i++){
           ArrayOfNumbers[i] = r.nextInt() + r.nextDouble();
       }
        for(int i = 0 ;i < ArrayOfNumbers.length ;i++){
            System.out.println(" numbers " + ArrayOfNumbers[i] ); 
       }
       AdditionThread at = new AdditionThread (ArrayOfNumbers);
       SubstractionThread st = new SubstractionThread (ArrayOfNumbers);
       
       at.additionThread.start();
       st.substractionThread.start();
    }
}
