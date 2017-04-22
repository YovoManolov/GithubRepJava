/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concatNumbs;

/**
 *
 * @author yovo
 */
public class Main {
    
    public static void main( String [] args){
        StringBuilder result ;
        int[] array = {24 , 18 , 302, 49 ,97};
        Logic l = new Logic();
        
        result =  l.concatNumbers(array);
        
        System.out.println(result);
    }
    
    
}
